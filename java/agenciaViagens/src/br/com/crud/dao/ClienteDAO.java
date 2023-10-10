package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;



public class ClienteDAO {

	public void create(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// cria uma conexao com banco
			conn = ConnectionFactory.createConnectionToMySQL();

			// cria um preparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor do primeiro parametro da sql
			pstm.setString(1, cliente.getNome());

			// adiciona o valor do segundo parametro da sql
			pstm.setString(2, cliente.getCpf());

			// adiciona o valor do terceiro parametro da sql
			pstm.setString(3, cliente.getTelefone());

			// executa a sql para inserção os dados
			pstm.execute();

			System.out.println("Cliente adicionado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fecha as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	// Exclusão
	public void removeById(int id) {
		String sql = "DELETE FROM cliente WHERE id = ?";



		Connection conn = null;
		PreparedStatement pstm = null;



		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Cliente excluido com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	// Alteração
	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ? " + " WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getTelefone());
			pstm.setInt(4, cliente.getId());	

			System.out.println("Cliente atualizado com sucesso!");

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	public List<Cliente> getClientes() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();



		Connection conn = null;
		PreparedStatement pstm = null;

		//Classe que vai recuperar os dados do bando de dados
		ResultSet rset = null;



		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			//Enquanto existir dados no banco de dados, faca:
			while (rset.next()) {
				Cliente cliente = new Cliente();

				//Recupera o id do banco de atribui ele ao objeto	                       
				cliente.setId(rset.getInt("id"));

				//recupera o nome do banco e atribui ele ao objeto
				cliente.setNome(rset.getString("nome"));

				//recupera a idade do banco e atribui ele ao objeto
				cliente.setCpf(rset.getString("cpf"));

				//recupera a data do banco e atribui ela ao objeto
				cliente.setTelefone(rset.getString("telefone"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clientes;
	}
	
	public Cliente readById(int id) {
		Cliente cliente = new Cliente();
		String sql = "SELECT * from cliente WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;	
		ResultSet rset = null;
		
	try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();
			cliente.setId(rset.getInt("id"));
			cliente.setNome(rset.getString("nome"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setTelefone(rset.getString("telefone"));
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		return cliente;
		
	}

}


