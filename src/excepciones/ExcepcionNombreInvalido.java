package excepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Contiene una exception que se lanza si el nombre del usuario es invalido.
 */

public class ExcepcionNombreInvalido extends Exception {
	private String nombre;
	private static Logger logger = (Logger) LogManager.getLogger(MovieflixException.class);

	public ExcepcionNombreInvalido() {
	}

	public ExcepcionNombreInvalido(Throwable cause) {
		super(cause);
	}

	public ExcepcionNombreInvalido(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

	public ExcepcionNombreInvalido(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "El nombre " + nombre + " es invalido";
	}

}
