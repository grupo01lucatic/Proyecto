package datos;

import excepciones.MovieflixException;

public interface IGestionPeliculas {

	public void modificarPeliculas() throws MovieflixException;

	public void eliminarPelicula() throws MovieflixException;

}
