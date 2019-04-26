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

/*Menú de la aplicación*/
public class Menu {
	public static void iniciarMenu() throws MovieflixException {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();

		} while (continuar);
		System.out.println(" --- Sesion cerrada --- ");
	}

	public static boolean seleccionarOpcion() throws MovieflixException {
		boolean continuar = true;

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
		case 9:
			new GestionListadoPeliculas().listarPeliculasCategorias();
			break;
		case 10:
			new GestionListadoPeliculas().listarPeliculasMasVistas();
			break;
		case 0:
			continuar = false;
			break;
		}
		return continuar;
	}
}
