package control;

import java.io.IOException;
import java.sql.SQLException;

import datos.GestionPeliculas;
import datos.GestionUsuarios;
import excepciones.MovieflixException;
import gui.ImprimirMenu;
import utilidades.PedirDatos;

public class Menu {
	public static void iniciarMenu() throws MovieflixException, IOException, SQLException {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();

		} while (continuar);
		System.out.println(" --- Sesión cerrada --- ");
	}

	public static boolean seleccionarOpcion() throws MovieflixException, IOException, SQLException {
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
		case 0:
			continuar = false;
			break;
		}
		return continuar;
	}
}
