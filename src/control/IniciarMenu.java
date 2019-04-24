package control;

import gui.ImprimirMenu;
import utilidades.PedirDatos;

public class IniciarMenu {
	public static void iniciarMenu() {
		boolean continuar = true;
		do {
			ImprimirMenu.imprimirMenu();
			continuar = seleccionarOpcion();

		} while (continuar);
		System.out.println(" --- Sesión cerrada --- ");
	}

	public static boolean seleccionarOpcion() {
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
