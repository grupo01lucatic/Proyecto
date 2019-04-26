package model;

/**
 * Pel�cula que contiene los campos que aparecen en la BD de la tabla pel�culas
 *
 */
public class Pelicula {

	private String nombre;
	private int anio, id_categoria, id_pelicula;

	public Pelicula() {
		super();
	}

	public Pelicula(int id_pelicula, String nombre, int anio, int id_categoria) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.anio = anio;
		this.id_categoria = id_categoria;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	@Override
	public String toString() {
		return "Pel�cula [id_pelicula=" + id_pelicula + ", nombre=" + nombre + ", a�o=" + anio + ", id_categoria="
				+ id_categoria + "]";
	}

}
