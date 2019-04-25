package control;

import java.sql.SQLException;
import datos.GestionPeliculas;
import excepciones.MovieflixException;

public class Main {
	public static void main(String[] args) throws MovieflixException, SQLException {
    new GestionPeliculas().modificarPeliculas();
    new GestionPeliculas().eliminarPelicula();
	}

}
