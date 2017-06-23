package database;

import java.sql.*;

public class Conexao {
	
	static Connection con;
	static PreparedStatement pstmt;
	static Statement stmt;
	static ResultSet rs;
	
	public static void getConnection() {

		try {
			if(Conexao.con == null) {
				Conexao.con = DriverManager.getConnection("jdbc:mysql://localhost/banco","root","root");
				Conexao.stmt = Conexao.con.createStatement();
			}
			
		} catch(Exception e ) {
			System.out.print("Erro na conexao!!!!Lascou");
		}
		
	}
	
	public static void closeConnection() {
		try {
			Conexao.con.close();
			Conexao.stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		con = null;
	}
	
}