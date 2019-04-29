package datos;

/**
 * @author grupo01
 * Interface de gesti�n de pel�culas
 */
import excepciones.MovieflixException;

public interface IGestionPeliculas {

	public void modificarPeliculas() throws MovieflixException;


	public void eliminarPelicula();


}
