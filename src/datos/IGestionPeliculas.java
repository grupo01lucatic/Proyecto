package datos;

/**
 * @author grupo01
 * Interface de gestión de películas
 */
import excepciones.MovieflixException;

public interface IGestionPeliculas {

	public void modificarPeliculas() throws MovieflixException;

	public void eliminarPelicula();

}
