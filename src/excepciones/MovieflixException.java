package excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MovieflixException extends Exception {
	private static final long serialVersionUID = 1L;
	private Level level;
	
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
	public MovieflixException(String mensaje, int tipo) {
		super(mensaje);
		setLevel(tipo);
	}
	public static int manejoErrorNumberFormat(String br) {
		int num=-1;
		try {
			num = Integer.parseInt(br);
			return num;
		} catch (NumberFormatException e) {
			System.out.println("Error: entrada invalida");
			return num;
		}
	}

	public void setLevel(int tipo) {
		switch(tipo) {
		case 1: 
			level = Level.SEVERE;
			break;
		case 2:
			level = Level.WARNING;
			break;
		case 3:
			level = Level.INFO;
			break;
		default:
			level= Level.INFO;
			break;
		}
	}
	@Override
	public String toString() {
		Logger.getLogger(MovieflixException.class.getName()).log(level, null, super.getMessage());
		return super.getMessage();
	}
}
