package control;

import java.io.IOException;
import java.sql.SQLException;

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
		System.out.println(" --- Sesión cerrada --- ");
	}

	public static boolean seleccionarOpcion() throws MovieflixException {
		boolean continuar = true;

		switch (PedirDatos.pedirDatoEntero("Introduce opcion")) {
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
			new GestionUsuarios().altaUsuario();
			break;
		case 5:
			new GestionListadoUsuarios().mostrarListaUsuarios();
			break;
		case 0:
			continuar = false;
			break;
		}
		return continuar;
	}
}
