package servicios;

import model.Pelicula;

public interface LectorDeFicheros {

	public void leerFicheros();

	public void almacenarPalabras(String texto);

	void almacenarPalabras(Pelicula[] peliculas);

}
