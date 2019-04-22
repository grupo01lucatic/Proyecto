package servicios;

import java.sql.*;

public class ConectorDB {
	// Conecta con la base de datos y lista la tabla platos.
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String driverUrl = "jdbc:mysql://localhost:3306/sakila";
	String user = "root";
	String password = "root";

	public void conectorDB() {
		try {
			con = DriverManager.getConnection(driverUrl, user, password);
			System.out.println("Conectado");
			pst = con.prepareStatement("SELECT * FROM platos");
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(": ");
				System.out.print(rs.getString(2));
				System.out.print(": ");
				System.out.print(rs.getInt(3)+" calorías");
				System.out.print(": ");
				System.out.println(rs.getInt(4)+" cucharas");
			}

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
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
