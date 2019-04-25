package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import excepciones.MovieflixException;

public class PedirDatos {
	public static int pedirDatoEntero(String mensaje) throws MovieflixException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(mensaje);
	    try {
			return excepciones.MovieflixException.manejoErrorNumberFormat(br.readLine());
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error");
			return -1;
		}
	}
}
