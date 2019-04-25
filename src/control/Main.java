package control;

import java.io.IOException;
import datos.GestionPeliculas;
import excepciones.MovieflixException;

public class Main {

	public static void main(String[] args) throws MovieflixException {
    new GestionPeliculas().modificarPeliculas();
	}

}
