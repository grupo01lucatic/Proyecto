package servicios;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;;

public class ConectorDB {
	// Conecta con la base de datos.
	Connection con = null;
	String driverUrl = "jdbc:mysql://10.90.36.104:3306/movieflix";
	String user = "grupo02";
	String password = "grupo";

	public void conectorDB() {
		try {
			con = DriverManager.getConnection(driverUrl, user, password);
			System.out.println("Conectado");

			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				System.out.println("Error al cerrar DB");
			}

		} catch (SQLException e) {
			System.out.println("Error");
			System.exit(-1);
		}
	}
}
