package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Pelicula;

public class LectorDeFicherosImpl implements LectorDeFicheros {
	/*
	 * Lee el fichero de películas y manda el texto al método almacenarPalabras.
	 */
	@Override
	public Pelicula[] leerFicheros() {
		// TODO Auto-generated method stub
		File file = new File("peliculas_numCat.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			try {
				int contador = 0;
				String[] arrayTexto = new String[81];
				while (bf.readLine() != null) {
					if (bf.readLine() != null) {
						String texto = bf.readLine();
						arrayTexto[contador] = texto;
						contador++;
					}
					return almacenarPalabras(arrayTexto);
				}
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// Método que recibe el texto y almacena sus atributos.
	@Override
	public Pelicula[] almacenarPalabras(String[] texto) {
		// TODO Auto-generated method stub
		Pelicula[] peliculaArray = new Pelicula[81];
		for (int i = 0; i < texto.length; i++) {
			String[] palabras = texto[i].split(",");
			String pelicula = palabras[0];
			int ano = Integer.parseInt(palabras[1]);
			int categoria = palabras[2];
			peliculaArray[i].setId_pelicula(i);
			peliculaArray[i].setNombre(pelicula);
			peliculaArray[i].setAnio(ano);
			peliculaArray[i].setId_categoria(categoria);
			return peliculaArray;
		}
		return null;

	}

}
