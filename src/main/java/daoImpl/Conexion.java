package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection conexion = null;	
	private final String DB = "apis";
	private final String USER = "root";
	private final String PASS = "1234";
	private final String DB_URL = "jdbc:mysql://localhost:3306/" + DB;

	public void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void desconectar() throws SQLException {
		if(conexion!= null && !conexion.isClosed()) {
			conexion.close();
			conexion = null;
		}
	}
}
