package control;

import java.io.IOException;
import java.sql.SQLException;

import datos.GestionPeliculas;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		new GestionPeliculas().eliminarPelicula();
	}

}
