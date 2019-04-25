package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PedirDatos {
	public static int pedirDatoEntero(String mensaje) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(mensaje);
		int entero;

		try {
			entero = Integer.parseInt(br.readLine());
			return entero;
		} catch (NumberFormatException e) {
			System.out.println("Error: entrada invalida");
			return -1;
		} catch (IOException e) {
			return -1;
		}
		
		
	}
	
	public static String pedirDato(String mensaje) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(mensaje);
		String s;

		try {
			s = (br.readLine());
			return s;
		}  
		
		 catch (IOException e) {
			System.out.println("Error: entrada invalida");
			return null;
		}
		
		
	}
}
