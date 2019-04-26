package control;

import java.io.IOException;
import java.sql.SQLException;

import datos.GestionListadoPeliculas;
import datos.GestionListadoUsuarios;
import datos.GestionPeliculas;
import datos.GestionUsuarios;
import excepciones.MovieflixException;
import gui.ImprimirMenu;
import utilidades.PedirDatos;

/**
 * Menu de la aplicacion*/
public class Menu {
	/**
	 * 
	 */
	public static void iniciarMenu() {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();
			
		} while (continuar);
		System.out.println(" --- Sesion cerrada --- ");
	}

	/**
	 * @return
	 */
	public static boolean seleccionarOpcion() {
		boolean continuar = true;
		try {
			
		
		switch (PedirDatos.pedirDatoEntero("Introduce opcion")) {
		case -1:
			System.out.println("Introduce opcion valida");
			break;
		case 1:
			new GestionPeliculas().modificarPeliculas();
			break;
		case 2:
			new GestionPeliculas().eliminarPelicula();
			break;
		case 3:
			new GestionPeliculas().peliculaNueva();
			break;
		case 4:
			new GestionUsuarios().modificarUsuario();
			break;
		case 5:
			new GestionUsuarios().altaUsuario();
			break;
		case 6:
			new GestionListadoUsuarios().mostrarListaUsuarios();
			break;
		case 7:
			new GestionListadoPeliculas().listarPeliculas();
			break;
		case 8:
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
		}catch(MovieflixException e) {
			System.out.print(e);
			iniciarMenu();
		}
		return continuar;
	}
}
