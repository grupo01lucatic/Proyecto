package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.MovieflixException;
import servicios.ConectorDB;
import utilidades.PedirDatos;

public class GestionUsuarios implements IGestionUsuarios {
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;

	@Override
	/* Método para dar de alta usuarios */
	public void altaUsuario() {
		try {
			String query = "INSERT INTO usuarios (username, email, password) values (?,?,?)";
			con = conexion.conectar();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			try {
				preparedStmt.setString(1, PedirDatos.pedirDato("Introduce un nombre de usuario"));
				preparedStmt.setString(2, PedirDatos.pedirDato("Introduce un email"));
				preparedStmt.setString(3, PedirDatos.pedirDato("Intruce el password"));
			} catch (MovieflixException e) {
				e.printStackTrace();
			}

			int insertada = preparedStmt.executeUpdate();
			if (insertada > 0) {
				System.out.println("Se ha añadido el registro correctamente");
			} else {
				System.out.println("No se ha podido añadir el nuevo Usuario");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}
	/* Método para eliminar usuario introduciendo la id del usuario */
	public void eliminarUsuario() {
		try {

			con = conexion.conectar();
			String query = " DELETE FROM usuarios WHERE id_user = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			int id_pelicula;
			try {
				id_pelicula = PedirDatos.pedirDatoEntero("Introduce el id de tu usuario que quieres eliminar");
				preparedStmt.setInt(1, id_pelicula);
			} catch (MovieflixException e) {

				e.printStackTrace();
			}
			int borradas = preparedStmt.executeUpdate();
			if (borradas > 0) {
				System.out.println("Los campos se han eliminado correctamente");
			} else {
				System.out.println("No se ha encontrado el usuario");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
