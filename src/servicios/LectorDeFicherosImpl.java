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
	public void leerFicheros() {
		// TODO Auto-generated method stub
		File file = new File("peliculas_cat.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			try {
				while (bf.readLine() != null) {
					if (bf.readLine() != null) {
						String texto = bf.readLine();
						almacenarPalabras(texto);
					}
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

	}

	// Método que recibe el texto y almacena sus atributos.
	@Override
	public void almacenarPalabras(String texto) {
		// TODO Auto-generated method stub
		String[] palabras = texto.split(",");
		String pelicula = palabras[0];
		int ano = Integer.parseInt(palabras[1]);
		String categoria = palabras[2];
		System.out.print(pelicula);
		System.out.print(" : ");
		System.out.print(ano);
		System.out.print(" : ");
		System.out.println(categoria);

	}

	@Override
	public void almacenarPalabras(Pelicula[] peliculas) {
		// TODO Auto-generated method stub
		
	}

}
