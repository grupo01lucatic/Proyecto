package servicios;

import model.Pelicula;

public interface LectorDeFicheros {

	public Pelicula[] leerFicheros();

	public Pelicula[] almacenarPalabras(String[] texto);

	void almacenarPalabras(Pelicula[] peliculas);

}
