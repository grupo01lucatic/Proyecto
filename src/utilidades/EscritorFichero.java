package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.MovieflixException;
import model.Usuario;

/**
 * Clase para escribir en ficheros
 *
 */
public class EscritorFichero implements Serializable {
	private static Logger logger = (Logger) LogManager.getLogger(EscritorFichero.class);

	/*
	 * 
	 * Escribe los datos de usuario en un fichero.
	 */
	public static void escritorUsuario(List<Usuario> usuarios) {
		File fichero = new File("Listado de usuarios.txt");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fi = new FileOutputStream(fichero);
			try {
				ObjectOutputStream oi = new ObjectOutputStream(fi);
				oi.writeObject(usuarios);
				logger.info("Escritura completada");
				oi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("Error de escritura");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Archivo no encontrado");
		}

	}
}
