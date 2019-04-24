package servicios;

import datos.GestionPeliculas;

public class ServiciosImpl implements IServicios {

	public ServiciosImpl() {
	}

	// Este metodo se encagar de obtener los datos del fichero.
	@Override
	public void iniciarLectura() {
		new GestionPeliculas().insertarPeliculas(new LectorDeFicherosImpl().leerFicheros());
	}

}
