package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import servicios.ConectorDB;
import utilidades.PedirDatos;

public class GestionPeliculas implements IGestionPeliculas {

	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;

	/* Este método se encarga de modificar las películas. */
	@Override
	public void modificarPeliculas() {
		try {
	    	 String query = " UPDATE peliculas SET titulo = ?, anio = ?, id_categoria = ? WHERE id_pelicula = ?";
	    	 con = conexion.conectar();
	    	 PreparedStatement preparedStmt = con.prepareStatement(query);
	    	 preparedStmt.setInt (4, PedirDatos.pedirDatoEntero("Introduce la id de la pelicula que deseas actualizar"));
	         preparedStmt.setInt (3, PedirDatos.pedirDatoEntero("Introduce la categoria de la pelicula"));
	         preparedStmt.setInt (2, PedirDatos.pedirDatoEntero("Introduce el año de la pelicula"));
	         preparedStmt.setString (1, PedirDatos.pedirDato("Introduce el titulo de la pelicula"));
	         preparedStmt.execute();
	         System.out.println("Los datos se han actualizado correctamente");
	     } catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {

					if (con != null) {
						con.close();
					}
				}
				catch (Exception e2){
						e2.printStackTrace();
					}

			}
} 

	public void insertarPeliculas() throws IOException {
		con = conexion.conectar();

		try {
			BufferedReader br = new BufferedReader(new FileReader("peliculas_numCat.txt"));

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
			try {

				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	
	@SuppressWarnings("unused")
	public void eliminarPelicula() throws SQLException {
		try {

			con = conexion.conectar();
			String query = " DELETE FROM peliculas WHERE id_pelicula = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			int id_pelicula = PedirDatos.pedirDatoEntero("Introduce el id de la pelicula que quieres eliminar");
			preparedStmt.setInt(1, id_pelicula);
			int filasBorradas = preparedStmt.executeUpdate();
			if (filasBorradas > 0) {
			    System.out.println("Los campos se han eliminado correctamente");
			}
			else {
				System.out.println("No se han encontrado coincidencias");
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

	@Override
	public void eliminarPeliculas() {
		// TODO Auto-generated method stub
		
	}

	
}
