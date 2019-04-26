package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.MovieflixException;
import servicios.ConectorDB;
import utilidades.PedirDatos;

public class GestionUsuarios implements IGestionUsuarios {
	/*
	 * @param logger necesario para utilzar los logs
	 * 
	 * @param conexion Realiza la conexion a la base de datos
	 * 
	 * @param con realiza la conexion a la direccion indicada en URL
	 * 
	 * @param stmt prepara los datos que se van a insertar a la base de datos
	 */
	private static Logger logger = LogManager.getLogger(GestionUsuarios.class);
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement stmt = null;

	@Override

	/** Metodo para dar de alta usuarios */

	public void altaUsuario() {
		try {
			String query = "INSERT INTO usuarios (username, email, password) values (?,?,?)";
			con = conexion.conectar();
			stmt = con.prepareStatement(query);
			try {
				stmt.setString(1, PedirDatos.pedirDato("Introduce un nombre de usuario"));
				stmt.setString(2, PedirDatos.pedirDato("Introduce un email"));
				stmt.setString(3, PedirDatos.pedirDato("Intruce el password"));
			} catch (MovieflixException e) {
				e.printStackTrace();
			}

			int insertada = stmt.executeUpdate();
			if (insertada > 0) {
				System.out.println("Se ha aÃ±adido el registro correctamente");
			} else {
				System.out.println("No se ha podido añadir el nuevo Usuario");
				logger.info("No se ha añadido ningun usuario nuevo");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();
		}
	}

	/** M�todo para eliminar usuario introduciendo la id del usuario */
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
				logger.info("No se ha eliminado porque no hay coincidencias");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();
		}
	}


	/** Este metodo se encarga de modificar el usuario */

	@Override
	public void modificarUsuario() {
		try {
			String query = " UPDATE usuarios SET username = ?, email = ?, password = ? WHERE id_user = ?";
			con = conexion.conectar();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			try {
				preparedStmt.setString(4, PedirDatos.pedirDato("Introduce la id del usuario que deseas actualizar"));

				preparedStmt.setString(3, PedirDatos.pedirDato("Introduce la contraseÃ±a"));
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
			ConectorDB.desconexion();
		}
	}
}
