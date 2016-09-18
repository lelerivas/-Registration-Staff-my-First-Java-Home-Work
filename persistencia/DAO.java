package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	Connection conn;
		
	public void abrirConexao() throws Exception {			
	  Class.forName("com.mysql.jdbc.Driver");		  
	  conn = DriverManager.getConnection("jdbc:mysql://localhost/cadastroFuncionariosCoti?autoReconnect=true&useSSL=false", "root", "");
	}
		
	public void fecharConexao() throws Exception {
		if (conn != null) {
			conn.close();
		}
	}
		
	public static void main(String[] args) {
	   DAO dao = new DAO();
	   try {
			dao.abrirConexao();
			dao.fecharConexao();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
		
}
	
	
	
	
	
	
	



