package controlador;

import java.sql.*;

public class ConexionBD {

	//private final String url = "jdbc:mysql://192.168.1.10/facturacion";
	private final String url = "jdbc:mysql://localhost:3306/facturacion";
	
	PreparedStatement psPrepararSentencia;
	Connection con = null;

	public ConexionBD() {

	}

	public Connection conectarBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection(url, "jspt", "jspt");
			
			System.out.println("ABRIENDO CONEXION !!!");
			return this.con != null ? this.con : null;
		} catch (SQLException e) {
			System.out.println("ERROR:" + e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}

	public void desconectarBD() {
		try {
			con.close();
			System.out.println("CONEXION FINALIZADA!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
