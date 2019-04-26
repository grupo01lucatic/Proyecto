package control;

import datos.GestionListadoPeliculas;
import datos.GestionListadoUsuarios;
import datos.GestionPeliculas;
import datos.GestionUsuarios;
import excepciones.MovieflixException;
import gui.ImprimirMenu;
import utilidades.PedirDatos;

/**
 * Men� de la aplicaci�n
 */
public class Menu {
	/**
	 * M�todo que inicia el men� llamando a imprimirMenu
	 */
	public static void iniciarMenu() {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();

		} while (continuar);
		System.out.println(" --- Sesi�n cerrada --- ");
	}

	/**
	 * M�todo que pide un entero para poder seleccionar una opci�n del men�
	 * 
	 * @return boolean
	 */

	public static boolean seleccionarOpcion() {
		boolean continuar = true;
		try {

			switch (PedirDatos.pedirDatoEntero("Introduce opci�n")) {
			case -1:
				System.out.println("Introduce opci�n valida");
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
				new GestionUsuarios().altaUsuario();
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
