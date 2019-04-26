package excepciones;

/**
 * Esta exception controla que el mail del usuario sea valido
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExcepcionMailInvalido extends Exception {
	private String mail;
	private static Logger logger = (Logger) LogManager.getLogger(MovieflixException.class);

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
