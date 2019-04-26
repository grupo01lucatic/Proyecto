package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.ConectorDB;

public class GestionListadoPeliculas implements IGestionListadoPeliculas {
	
	private static Logger logger = (Logger) LogManager.getLogger(GestionListadoPeliculas.class);
	static ConectorDB conexion = new ConectorDB();
	static Connection con = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet rs = null;

	/** Metodo para mostrar la lista de las peliculas */
	@Override
	public void listarPeliculas() {
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM peliculas");
			System.out.println("Titulo - Año - Categoria" + "\n");
			while (rs.next()) {
				String titulo = rs.getString(2);
				int year = rs.getInt(3);
				int cat = rs.getInt(4);
				String nomCat = "";
				if(cat == 1 ) {
					nomCat = "Policiaca";
				}
				else if(cat == 2) {
					nomCat = "Romantica";
				}
				else if(cat == 3) {
					nomCat = "Aventuras";
				}
				else if(cat == 4) {
					nomCat = "Comedia";
				}
				else if(cat == 5) {
					nomCat = "Animacion";
				}
				else if(cat == 6) {
					nomCat = "Thriller";
				}
				System.out.println(titulo + " - " + year + " , " + nomCat );
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConectorDB.desconexion();
		}
	}

	/**
	 * Metodo que muestra las peliculas ordenadas por categoria
	 */
	@Override
	public void listarPeliculasCategorias() {
		try {
			String query = "select p.titulo, p.anio, c.nombre_categoria from peliculas p left join categorias c on p.id_categoria = c.id_categoria order by nombre_categoria;  ";
			con = conexion.conectar();
			logger.info("Conexion creada");
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
			ConectorDB.desconexion();
		}
	}

	/**
	 * Este metodo muestra las 10 peliculas mas vistas
	 */

	@Override
	public void listarPeliculasMasVistas() {
		try {
			String query = "select p.titulo, p.anio, c.nombre_categoria, p.numeroVecesVista from peliculas p left join categorias c on p.id_categoria = c.id_categoria order by p.numeroVecesVista desc limit 10;";
			con = conexion.conectar();
			logger.info("Conexion creada");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			System.out.println("--Las 10 peliculas más vistas--");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(": ");
				System.out.print(rs.getInt(2));
				System.out.print(": ");
				System.out.print(rs.getString(3));
				System.out.print(": ");
				System.out.print(rs.getString(4));
				System.out.println("");
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
	 * Este metodo muestra las 15 peliculas mejor valoradas
	 */

	@Override
	public void listarPeliculasMejorValoradas() {
		try {
			String query = "select p.titulo, p.anio, c.nombre_categoria, p.valoracion from peliculas p left join categorias c on p.id_categoria order by p.Valoracion desc limit 15;";
			con = conexion.conectar();
			logger.info("Conexion creada");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			System.out.println("--Las 15 peliculas mejor valoradas--");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(": ");
				System.out.print(rs.getInt(2));
				System.out.print(": ");
				System.out.println(rs.getString(3));

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
