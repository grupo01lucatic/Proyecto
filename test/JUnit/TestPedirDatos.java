package JUnit;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import excepciones.MovieflixException;
import utilidades.PedirDatos;

public class TestPedirDatos {

	private static byte cont = 1;
	private static Logger logger;

	/** Inicialización */
	static {
		try {
			logger = LogManager.getLogger(TestPedirDatos.class);
		} catch (Throwable e) {
			logger.error("No funciona");
		}
	}

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando las pruebas");
	}

	@Before
	public void executedBeforeEach() {
		System.out.println("");
		logger.info("=== PRUEBA " + (cont++) + " ======");
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		logger.info(">>> Terminado las pruebas");
	}

	// --------
	// TEST
	// --------

	@org.junit.Test
	public void compruebaNulo() throws MovieflixException {
		logger.info("Comprobando si es nulo.");
		assertTrue(PedirDatos.pedirDatoEntero("Prueba") == -1);
	}

}
