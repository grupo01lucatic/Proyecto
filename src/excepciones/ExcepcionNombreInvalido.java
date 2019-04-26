package excepciones;

/**
 * Contiene una exception que se lanza si el nombre del usuario es invalido.
 */

public class ExcepcionNombreInvalido extends Exception {
	/**
	 * Controla que el nombre sea válido
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;

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
