package datos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.MovieflixException;
import servicios.ConectorDB;
import utilidades.PedirDatos;

public class GestionPeliculas implements IGestionPeliculas {
	private static Logger logger = LogManager.getLogger(GestionPeliculas.class);
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;

	/** Este m�todo se encarga de modificar las pel�culas. */
	@Override
	public void modificarPeliculas() throws MovieflixException {
		try {
			String query = " UPDATE peliculas SET titulo = ?, anio = ?, id_categoria = ? WHERE id_pelicula = ?";
			con = conexion.conectar();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(4, PedirDatos.pedirDatoEntero("Introduce la id de la pel�cula que deseas actualizar"));
			preparedStmt.setInt(3, PedirDatos.pedirDatoEntero("Introduce la categor�a de la pel�cula"));
			preparedStmt.setInt(2, PedirDatos.pedirDatoEntero("Introduce el a�o de la pel�cula"));
			preparedStmt.setString(1, PedirDatos.pedirDato("Introduce el titulo de la pel�cula"));
			preparedStmt.execute();
			System.out.println("Los datos se han actualizado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConectorDB.desconexion();
		}
	}

	/** M�todo que lee el fichero l�nea a l�nea y lo inserta en la base de datos */
	public void insertarPeliculas() throws IOException {
		con = conexion.conectar();

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("peliculas_numCat.txt"), "UTF8"));

			int c = 1;
			String line = null;
			while ((line = br.readLine()) != null) {
				String tmp[] = line.split(",");
				String titulo = tmp[0].trim();
				String anio = tmp[1].trim();
				String id_categoria = tmp[2].trim();
				int id_pelicula = c++;
				String query = "INSERT INTO peliculas (id_pelicula,titulo,anio,id_categoria) values (?,?,?,?)";
				try {
					pst = con.prepareStatement(query);
					pst.setInt(1, id_pelicula);
					pst.setString(2, titulo);
					pst.setInt(3, Integer.parseInt(anio));
					pst.setInt(4, Integer.parseInt(id_categoria));
					pst.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(id_pelicula + "\t" + titulo + "\t" + anio + "\t" + id_categoria);
			}
			br.close();
		} finally {
			ConectorDB.desconexion();
		}

	}

	/**
	 * M�todo que lee los id que introduce el usuario de las pel�culas y a
	 * continuaci�n borra de la base de datos esa id
	 */

	public void eliminarPelicula() {
		try {
			con = conexion.conectar();
			String query = " DELETE FROM peliculas WHERE id_pelicula = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			int id_pelicula = PedirDatos.pedirDatoEntero("Introduce el id de la pel�cula que quieres eliminar");
			preparedStmt.setInt(1, id_pelicula);
			int filasBorradas = preparedStmt.executeUpdate();
			if (filasBorradas > 0) {
				System.out.println("Los campos se han eliminado correctamente");
			} else {
				System.out.println("No se han encontrado coincidencias");
				logger.info("No coincide ninguna pel�cula");
			}

		} catch (SQLException | MovieflixException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();
		}
	}
}
