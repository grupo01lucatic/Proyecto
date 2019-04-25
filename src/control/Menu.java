package control;

import java.io.IOException;

import excepciones.MovieflixException;
import gui.ImprimirMenu;
import utilidades.PedirDatos;

public class Menu {
	public static void iniciarMenu() throws MovieflixException, IOException {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();

		} while (continuar);
		System.out.println(" --- Sesión cerrada --- ");
	}

	public static boolean seleccionarOpcion() throws MovieflixException, IOException {
		boolean continuar = true;

		switch (PedirDatos.pedirDatoEntero("Introduce opcion")) {
		case -1:
			System.out.println("Introduce opción valida");
			break;
		case 1:
			System.out.println("Modificar datos de una pelicula");
			break;
		case 0:
			continuar = false;
			break;
		}
		return continuar;
	}
}
