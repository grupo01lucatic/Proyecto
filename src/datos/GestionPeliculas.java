package datos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.MovieflixException;
import servicios.ConectorDB;
import utilidades.PedirDatos;

public class GestionPeliculas implements IGestionPeliculas {

	/*
	 * @param logger necesario para utilzar los logs
	 * 
	 * @param conexion Realiza la conexion a la base de datos
	 * 
	 * @param con realiza la conexion a la direccion indicada en URL
	 * 
	 * @param stmt prepara los datos que se van a insertar a la base de datos
	 */
	private static Logger logger = LogManager.getLogger(GestionPeliculas.class);
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement stmt = null;

	/** Este mÃ©todo se encarga de modificar las pelÃ­culas. */
	@Override
	public void modificarPeliculas() throws MovieflixException {
		try {
			String query = " UPDATE peliculas SET titulo = ?, anio = ?, id_categoria = ? WHERE id_pelicula = ?";
			con = conexion.conectar();
			PreparedStatement preparedStmt = con.prepareStatement(query);
			stmt.setInt(4, PedirDatos.pedirDatoEntero("Introduce la id de la pelicula que deseas actualizar"));
			stmt.setInt(3, PedirDatos.pedirDatoEntero("Introduce la categoria de la pelicula"));
			stmt.setInt(2, PedirDatos.pedirDatoEntero("Introduce el aÃ±o de la pelicula"));
			stmt.setString(1, PedirDatos.pedirDato("Introduce el titulo de la pelicula"));
			stmt.execute();
			System.out.println("Los datos se han actualizado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();

		}
	}

	/** metodo que lee el fichero linea a linea y lo inserta en la base de datos */
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
					stmt = con.prepareStatement(query);
					stmt.setInt(1, id_pelicula);
					stmt.setString(2, titulo);
					stmt.setInt(3, Integer.parseInt(anio));
					stmt.setInt(4, Integer.parseInt(id_categoria));
					stmt.execute();
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
	 * lee los id que introduce el usuario de las peliculas y a continuacion borra
	 * de la base de datos esa id
	 */

	@SuppressWarnings("unused")
	public void eliminarPelicula() throws MovieflixException {
		try {

			con = conexion.conectar();
			String query = " DELETE FROM peliculas WHERE id_pelicula = ?";
			stmt = con.prepareStatement(query);
			int id_pelicula = PedirDatos.pedirDatoEntero("Introduce el id de la pelicula que quieres eliminar");
			stmt.setInt(1, id_pelicula);
			int filasBorradas = stmt.executeUpdate();
			if (filasBorradas > 0) {
				System.out.println("Los campos se han eliminado correctamente");
			} else {
				System.out.println("No se han encontrado coincidencias");
				logger.info("No coincide ninguna pelicula");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();
		}

	}
	/** Metodo para incluir una nueva pelicula en el catalogo*/
	public void peliculaNueva() {
		try {
			String query = "INSERT INTO peliculas (titulo, anio, id_categoria) values (?,?,?)";
			con = conexion.conectar();
			stmt = con.prepareStatement(query);
			try {
				stmt.setString(1, PedirDatos.pedirDato("Introduce el titulo de la pelicula nueva"));
				stmt.setInt(2, PedirDatos.pedirDatoEntero("Introduce el año"));
				stmt.setInt(3, PedirDatos.pedirDatoEntero("Introduce el numero de la categoria.\n 1.policiaca 2.romantica 3.aventuras 4.comedia 5.animacion 6.thriller"));
			} catch (MovieflixException e) {
				e.printStackTrace();
			}

			int insertada = stmt.executeUpdate();
			if (insertada > 0) {
				System.out.println("Pelicula nueva insertada");
			} else {
				System.out.println("No se ha podido añadir la pelicula al catalogo");
				logger.info("No se ha podido añadir la pelicula");

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();

		}

	}

}
