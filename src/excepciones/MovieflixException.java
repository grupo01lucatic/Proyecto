package excepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * Contiene metodos que tratan la excepcion NumberFormat usando loggers tanto de
 * info cuando todo va bien como de error si falla
 *
 */

public class MovieflixException extends Exception {
	private static final long serialVersionUID = 1L;
	private static Logger logger = (Logger) LogManager.getLogger(MovieflixException.class);

	public MovieflixException() {
	}

	public MovieflixException(Throwable cause) {
		super(cause);
	}

	public MovieflixException(String mensaje) {
		super(mensaje);
	}

	public MovieflixException(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

	public static int manejoErrorNumberFormat(String br) {
		int num = -1;
		try {
			num = Integer.parseInt(br);
			logger.info("Se ha guardado bien el numero");
			return num;
		} catch (NumberFormatException e) {
			logger.error("Valor incorrecto. No se ha guardado numero");
			return num;
		}
	}

	@Override
	public String toString() {
		return "Imprimiendo error";
	}

}
