package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.MovieflixException;

/**
 * 
 * @author grupo01
 * @param Clase que se ocupa de pedir datos tanto enteros como string
 *
 */
public class PedirDatos {
	private static Logger logger = (Logger) LogManager.getLogger(PedirDatos.class);

	/**
	 * 
	 * @param mensaje
	 * @return entero
	 * @throws MovieflixException Método que recibe un string como parámetro, pide
	 *                            un entero, comprueba que sea un valor válido y lo
	 *                            devuelve
	 */
	public static int pedirDatoEntero(String mensaje) throws MovieflixException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(mensaje);
		try {
			return excepciones.MovieflixException.manejoErrorNumberFormat(br.readLine());
		} catch (IOException e) {
			logger.error("Ha ocurrido un error");
			return -1;
		}
	}

	/**
	 * 
	 * @param mensaje
	 * @return string
	 * @throws MovieflixException
	 *                            <p>
	 *                            Método que recibe un string como parámetro, pide
	 *                            un string y lo devuelve
	 *                            </p>
	 */
	public static String pedirDato(String mensaje) throws MovieflixException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(mensaje);
		String s;

		try {
			s = (br.readLine());
			logger.info("Dato correcto");
			return s;
		}

		catch (IOException e) {
			logger.error("Error: entrada invalida");
			return null;
		}
	}
}
