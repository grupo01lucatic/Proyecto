package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import excepciones.MovieflixException;
import servicios.ConectorDB;
import utilidades.PedirDatos;

public class GestionUsuarios implements IGestionUsuarios {
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;

	/** Método para dar de alta usuarios */
	@Override
	public void altaUsuarios() {

	}

	/** Este método se encarga de modificar el usuario */
	@Override
	public void modificarUsuario() {
		try {
			String query = " UPDATE usuarios SET username = ?, email = ?, password = ? WHERE id_user = ?";
			con = conexion.conectar();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			try {
				preparedStmt.setString(4, PedirDatos.pedirDato("Introduce la id del usuario que deseas actualizar"));
				preparedStmt.setString(3, PedirDatos.pedirDato("Introduce la contraseña"));
				preparedStmt.setString(2, PedirDatos.pedirDato("Introduce el email"));
				preparedStmt.setString(1, PedirDatos.pedirDato("Introduce el nombre de usuario nuevo"));
				preparedStmt.execute();
				System.out.println("Los datos se han actualizado correctamente");
			} catch (MovieflixException e) {
				e.printStackTrace();
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
