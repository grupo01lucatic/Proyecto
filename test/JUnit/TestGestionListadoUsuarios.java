package JUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import datos.GestionListadoUsuarios;

public class TestGestionListadoUsuarios {

	private static byte cont = 1;
	private static Logger logger;

	/* Inicialización */
	static {
		try {
			logger = LogManager.getLogger(TestPedirDatos.class);
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
	public void comprobarEjecucion() {
		logger.info("Comprobando si puede ejecutarse.");
		try {
			new GestionListadoUsuarios().mostrarListaUsuarios();
			logger.info("Metodo ejecutado correctamente");
		} catch (Exception e) {
			logger.error("Error de ejecucion");
			e.printStackTrace();
		}

	}
}
