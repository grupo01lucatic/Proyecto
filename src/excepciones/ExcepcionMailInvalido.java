package excepciones;

/**
 * Esta excepci�n controla que el mail del usuario sea v�lido
 */

public class ExcepcionMailInvalido extends Exception {
	/**
	 * Excepci�n que controla que el main sea v�lido
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
