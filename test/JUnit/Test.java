package JUnit;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import utilidades.PedirDatos;

public class Test {

	private static byte cont = 1;
	private static Logger logger;

	/* Inicialización */
	static {
		try {
			logger = LogManager.getLogger(Test.class);
		} catch (Throwable e) {
			System.out.println("No funciona");
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
	public void sumaPositivoNegativo() {
		logger.info("Comprobando si es nulo.");
		assertTrue(PedirDatos.pedirDatoEntero("Prueba") == -1);
	}

}
