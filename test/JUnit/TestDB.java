package JUnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import servicios.ConectorDB;


public class TestDB {
	/* 
	*@param logger necesario para utilzar los logs
	*@param CONNECTION contiene la url de la tabla de datos
	*@param con realiza la conexion a la direccion indicada en URL
	*/
	
	private static Logger logger = LogManager.getLogger(TestDB.class);	
	public static final String CONNECTION = "jdbc:mysql://10.90.36.104:3306/movieflix";
	public static Connection con;
	
	/** Prueba de la conexion a la base de datos */
	public static boolean probarConexion() {
		try {
			con = DriverManager.getConnection(CONNECTION, "grupo02", "grupo");
			logger.info("Prueba de conexion realizada con exito");
			return true;

		} catch (SQLException e) {
			logger.error("No se ha podido conectar con la base de datos");
			return false;
		}
	}

	/** Prueba que realiza una insercion de prueba en la tabla usuarios */
	public static boolean probarInserccionUsuario() {
		try {
			con = DriverManager.getConnection(CONNECTION, "grupo02", "grupo");
			String query = "INSERT INTO usuarios (username, email, password) values (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "TestUser");
			stmt.setString(2, "TestEmail");
			stmt.setString(3, "Testpassword");
			int result = stmt.executeUpdate();
			if (result == 1) {
				logger.info("Se ha insertado el usuario de prueba");
				return true;
			} else {
				logger.error("No se ha podido insertar el usuario de prueba");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConectorDB.desconexion();
		}
	}

}
