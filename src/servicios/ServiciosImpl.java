package servicios;

import java.io.IOException;

import datos.GestionPeliculas;

public class ServiciosImpl implements IServicios {

	public ServiciosImpl() {
	}

	/* Este metodo se encagar de obtener los datos del fichero. */
	@Override
	public void iniciarLectura() {

		try {
			new GestionPeliculas().insertarPeliculas();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
