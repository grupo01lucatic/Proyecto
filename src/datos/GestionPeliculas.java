package datos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pelicula;
import servicios.ConectorDB;

public class GestionPeliculas implements IGestionPeliculas {
	
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;
	

	// Este método se encarga de modificar las películas.
	@Override
	public void modificarPeliculas() {
		// TODO Auto-generated method stub

	}

	
	public void insertarPeliculas() throws IOException {
		con = conexion.conectar();
			
			 try
			    {
			        BufferedReader br = new BufferedReader(new FileReader("peliculas_numCat.txt"));
			       

			        int c= 1;
			        String line = null;
			        while ((line = br.readLine()) != null)
			        {
			            String tmp[] = line.split(","); 
			            String titulo = tmp[0].trim();
			            String anio = tmp[1].trim();
			            String id_categoria = tmp[2].trim();
			            int id_pelicula = c++;
			            String query =
			                    "INSERT INTO peliculas (id_pelicula,titulo,anio,id_categoria) values (?,?,?,?)";
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
						
			            System.out.println(id_pelicula + "\t" + titulo + "\t" + anio + "\t" + id_categoria );
			           
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


}
