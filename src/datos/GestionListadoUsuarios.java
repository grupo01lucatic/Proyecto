package datos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.MovieflixException;
import model.Usuario;
import servicios.ConectorDB;
import utilidades.EscritorFichero;

/**
 * 
 * @author grupo01 Clase encargada de la gestión de listados de usuarios
 */

public class GestionListadoUsuarios implements IGestionListadoUsuarios {
	private static Logger logger = (Logger) LogManager.getLogger(MovieflixException.class);

	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;

	@Override

	/**
	 * Método para mostrar la lista de usuarios
	 */
	public void mostrarListaUsuarios() {
		// TODO Auto-generated method stub
		try {
			String query = "select id_user, username, email from usuarios;";
			con = conexion.conectar();
			logger.info("Conexión creada");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("");
				System.out.print(rs.getInt(1));
				System.out.print(": ");
				System.out.print(rs.getString(2));
				System.out.print(": ");
				System.out.print(rs.getString(3));
			}

		} catch (SQLException e) {
			logger.error("Ha ocurrido un error");
		} finally {
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
			} catch (Exception e) {
				logger.error("Algo ha salido mal");
			}
		}
	}

	/**
	 * Este método muestra las películas que puede ver el usuario
	 */
	@Override
	public void listarPeliculasVer() {
		// TODO Auto-generated method stub
		try {
			String query = "select p.titulo, p.anio, c.nombre_categoria from peliculas p left join categorias c on p.id_categoria = c.id_categoria order by nombre_categoria;  ";
			con = conexion.conectar();
			logger.info("Conexión creada");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("");
				System.out.print(rs.getString(1));
				System.out.print(": ");
				System.out.print(rs.getInt(2));
				System.out.print(": ");
				System.out.print(rs.getString(3));
			}

		} catch (SQLException e) {
			logger.error("Ha ocurrido un error");
		} finally {
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
			} catch (Exception e) {
				logger.error("Algo ha salido mal");
			}
		}
	}

	public void guardarListaUsuarios() {
		// TODO Auto-generated method stub
		try {
			List<Usuario> userList = new ArrayList<>();
			String query = "select id_user, username, email from usuarios;";
			con = conexion.conectar();
			logger.info("Conexion creada");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			int contador = 0;
			while (rs.next()) {
				int id = rs.getInt(1);
				String usuario = rs.getString(2);
				String mail = rs.getString(3);

				userList.add(new Usuario(usuario, mail));

			}
			EscritorFichero.escritorUsuario(userList);
		} catch (SQLException e) {
			logger.error("Ha ocurrido un error");
		} finally {
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
			} catch (Exception e) {
				logger.error("Algo a salido mal");
			}
		}
	}
}
