package excepciones;

/**
 * Esta excepción controla que el mail del usuario sea válido
 */

public class ExcepcionMailInvalido extends Exception {
	/**
	 * Excepción que controla que el main sea válido
	 */
	private static final long serialVersionUID = 1L;
	private String mail;

	public ExcepcionMailInvalido() {
	}

	public ExcepcionMailInvalido(Throwable cause) {
		super(cause);
	}

	public ExcepcionMailInvalido(String mail, Throwable cause) {
		super(mail, cause);
	}

	public ExcepcionMailInvalido(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "El mail " + mail + " es invalido";
	}
}
