package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;
import br.com.crud.model.Destino;
import br.com.crud.model.Viagem;

public class ViagemDAO {

	public void create(Viagem viagem) {
		String sql = "INSERT INTO viagem (valor_Diaria, data_Ida, data_Volta , cliente_id, destino_id) VALUES (?, ?, ?, ? , ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, viagem.getValorDiaria());
			pstm.setDate(2, new java.sql.Date(viagem.getDataIda().getTime()));
			pstm.setDate(3, new java.sql.Date(viagem.getDataVolta().getTime()));
			
			pstm.setInt(4, viagem.getCliente().getId());
			pstm.setInt(5, viagem.getDestino().getId());


			pstm.execute();
			
			System.out.println("Viagem criada com sucesso!");

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

	public void removeById(int id) {
		String sql = "DELETE FROM viagem WHERE id = ?";



		Connection conn = null;
		PreparedStatement pstm = null;


		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Viagem excluída com sucesso!");
			
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

	public void update(Viagem viagem) {
		String sql = "UPDATE viagem SET valor_Diaria = ?, data_Ida = ?, data_Volta = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDouble(1, viagem.getValorDiaria());
			pstm.setDate(2, new java.sql.Date(viagem.getDataIda().getTime()));
			pstm.setDate(3, new java.sql.Date(viagem.getDataVolta().getTime()));
			
			pstm.setInt(4, viagem.getId());

			pstm.execute();

			System.out.println("Viagem atualizada com sucesso!");
			
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



	public List<Viagem> getviagens() {
		String sql = "select "
					+ " cliente.id as clienteId, cliente.nome, cliente.cpf, cliente.telefone,"
					+ "	destino.id as destinoId, destino.cidade, destino.pais, destino.valor_Passagem,"
					+ "	viagem.*"
					+ "	from viagem"
					+ "	left join cliente on viagem.cliente_id = cliente.id"
					+ "	left join destino on viagem.destino_id = destino.id";
					
		List<Viagem> viagens = new ArrayList<Viagem>();



		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;



		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();
				Cliente cliente = new Cliente();
				Destino destino = new Destino();


				viagem.setId(rset.getInt("id"));
				viagem.setValorDiaria(rset.getFloat("valor_Diaria"));
				viagem.setDataIda(rset.getDate("data_ida"));
				viagem.setDataVolta(rset.getDate("data_Volta"));
				
				cliente.setId(rset.getInt("clienteId"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setTelefone(rset.getString("telefone"));
								
				destino.setId(rset.getInt("destinoId"));
				destino.setCidade(rset.getString("cidade"));
				destino.setPais(rset.getString("pais"));
				destino.setValorPassagem(rset.getDouble("valor_Passagem"));
				
				viagem.setCliente(cliente);
				viagem.setDestino(destino);
				
				viagens.add(viagem);
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
		return viagens;
	}
	
	
	public Viagem readById(int id) {
		Viagem viagem = new Viagem();
		String sql = "select "
				+ " cliente.id as clienteId, cliente.nome, cliente.cpf, cliente.telefone,"
				+ "	destino.id as destinoId, destino.cidade, destino.pais, destino.valor_Passagem,"
				+ "	viagem.*"
				+ "	from viagem"
				+ "	left join cliente on viagem.cliente_id = cliente.id"
				+ "	left join destino on viagem.destino_id = destino.id"
				+ " where viagem.id = ? ";
				

		Connection conn = null;
		PreparedStatement pstm = null;	
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
System.out.println(id);
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			rset.next();
			Cliente cliente = new Cliente();
			Destino destino = new Destino();
			
			viagem.setId(rset.getInt("id"));
			viagem.setValorDiaria(rset.getFloat("valor_Diaria"));
			viagem.setDataIda(rset.getDate("data_ida"));
			viagem.setDataVolta(rset.getDate("data_Volta"));
			
			cliente.setId(rset.getInt("clienteId"));
			cliente.setNome(rset.getString("nome"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setTelefone(rset.getString("telefone"));
							
			destino.setId(rset.getInt("destinoId"));
			destino.setCidade(rset.getString("cidade"));
			destino.setPais(rset.getString("pais"));
			destino.setValorPassagem(rset.getDouble("valor_Passagem"));
			
			viagem.setCliente(cliente);
			viagem.setDestino(destino);


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

		return viagem;

	}
}

