package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.MovieflixException;
import servicios.ConectorDB;

/**
 * 
 * @author grupo01 Clase encargada de la gesti�n de listados de usuarios
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
	 * M�todo para mostrar la lista de usuarios
	 */
	public void mostrarListaUsuarios() {
		// TODO Auto-generated method stub
		try {
			String query = "select id_user, username, email from usuarios;";
			con = conexion.conectar();
			logger.info("Conexi�n creada");
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
	 * Este m�todo muestra las pel�culas que puede ver el usuario
	 */
	@Override
	public void listarPeliculasVer() {
		// TODO Auto-generated method stub
		try {
			String query = "select p.titulo, p.anio, c.nombre_categoria from peliculas p left join categorias c on p.id_categoria = c.id_categoria order by nombre_categoria;  ";
			con = conexion.conectar();
			logger.info("Conexi�n creada");
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
}
