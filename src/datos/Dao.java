package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pelicula;
import servicios.ConectorDB;

public class Dao {
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;
	public static void insertarPeliculas(Pelicula[] peliculas) {
		con = conexion.conectar();
		try {
			
			for(int i = 0;i<peliculas.length;i++) {
				int id_pelicula = peliculas[i].getId_pelicula();
				String titulo = peliculas[i].getNombre();
				int anio = peliculas[i].getAnio();
				int id_categoria = peliculas[i].getId_categoria();
				String query =
	                    "INSERT INTO peliculas (id_pelicula,titulo,anio,id_categoria) values ('"
	                            + id_pelicula + "','" + titulo + "','" + anio + "','" + id_categoria +
	                            "')";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, id_pelicula);
				pst.setString(2, titulo);
				pst.setInt(3, anio);
				pst.setInt(4, id_categoria);
				pst.execute();
			}
			System.out.println("Datos insertados");
		}  catch (SQLException e) {
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
