package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	//nome usuario do mysql
	private static final String USERNAME = "root";
	
	//senha do mysql
	private static final String PASSWORD = "root";
	
	//dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	private static final String URL = "jdbc:mysql://localhost:3306/crud";
	
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); //faz com que a classe seja carregada pela JVM
		
		//cria uma conexao com o banco de dados
		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return connection;
	}
//	public static void main(String[] args) throws Exception{
//		
//		//recupera uma conexao com o bando de dados
//		Connection con = createConnectionToMySQL();
//		
//		//testa se a conexao é nula
//		if(con != null) {
//			System.out.println("Conexao obtida com sucesso! " + con);
//			con.close();
//		}
//	}

}