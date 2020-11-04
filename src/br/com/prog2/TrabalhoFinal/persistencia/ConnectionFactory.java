package br.com.prog2.TrabalhoFinal.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "Trabalhofinal123";
		String url = "jdbc:postgresql://127.0.0.1:5433/trabalhofinal";
		Connection con = null;
		try {
		Class.forName(driver);
		con = (Connection) DriverManager.getConnection(url, user,
		senha);
		} catch (ClassNotFoundException ex) {
		System.err.print(ex.getMessage());
		} catch (SQLException e) {
		System.err.print(e.getMessage());
		}
		return con;
		}
		public static void close(Connection con){
		try{
		con.close();
		}catch(SQLException e){
		}
		}
		}




