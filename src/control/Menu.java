package control;

import datos.GestionListadoPeliculas;
import datos.GestionListadoUsuarios;
import datos.GestionPeliculas;
import datos.GestionUsuarios;
import excepciones.MovieflixException;
import gui.ImprimirMenu;
import utilidades.PedirDatos;

/**
 * Menú de la aplicación
 */
public class Menu {
	/**
	 * Método que inicia el menú llamando a imprimirMenu
	 */
	public static void iniciarMenu() {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();

		} while (continuar);
		System.out.println(" --- Sesión cerrada --- ");
	}

	/**
	 * Método que pide un entero para poder seleccionar una opción del menú
	 * 
	 * @return boolean
	 */

	public static boolean seleccionarOpcion() {
		boolean continuar = true;
		try {
			switch (PedirDatos.pedirDatoEntero("Introduce opción")) {
			case -1:
				System.out.println("Introduce opción valida");
				break;
			case 1:
				new GestionPeliculas().modificarPeliculas();
				break;
			case 2:
				new GestionPeliculas().eliminarPelicula();
				break;
			case 3:
				new GestionUsuarios().modificarUsuario();
				break;
			case 4:
				new GestionUsuarios().altaUsuarios();
				break;
			case 5:
				new GestionListadoUsuarios().mostrarListaUsuarios();
				break;
			case 6:
				new GestionListadoPeliculas().listarPeliculas();
				break;
			case 7:
				new GestionListadoUsuarios().listarPeliculasVer();
				break;
			case 8:
				new GestionListadoUsuarios().guardarListaUsuarios();
				break;
			case 9:
				new GestionListadoPeliculas().listarPeliculasCategorias();
				break;
			case 10:
				new GestionListadoPeliculas().listarPeliculasMasVistas();
				break;
			case 11:
				new GestionListadoPeliculas().listarPeliculasMejorValoradas();
				break;
			case 0:
				continuar = false;
				break;
			}
			return continuar;
		} catch (MovieflixException e) {
			System.out.print(e);
			iniciarMenu();
		}
		return continuar;
	}
}
