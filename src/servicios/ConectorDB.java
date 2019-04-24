package servicios;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;;

public class ConectorDB {
	// Conecta con la base de datos.
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.90.36.104:3306/movieflix";
    private static final String USUARIO = "grupo02";
    private static final String CLAVE = "grupo";

    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }
    
    public Connection conectar() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexion establecida con exito");

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }

	public PreparedStatement prepareStatement(String query) {		
		return null;
	}
	
}
