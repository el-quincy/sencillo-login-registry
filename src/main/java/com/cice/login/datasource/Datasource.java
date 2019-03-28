package com.cice.login.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Datasource {

	//LoggerFactory está creada con el patrón Factory, de ahí el nombre
	private static final Logger log = LoggerFactory.getLogger(Datasource.class);
	
	private static PreparedStatement stm = null;
	private  static Connection conn = null;
	
	//Los métodos de conexión a la BD son privados. Aquí se establece la conexión
	private static void makeJDBCConnection() throws  SQLException {

			try {
				//Cargamos el Driver de la BD
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			//Establecemos la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3360/login-java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			if (conn != null) {
				log.info("Connection Successful! Toma toma toma");
			} else {
				log.error("Failed to make connection!");
			}
	}
	
	//Cerramos la conexión si está abierta
	private static void testConnection(Connection connection){
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				log.error(e.getMessage());
			}
	}

	//Crea un nuevo usuario en la BD
	public static void registro(String nombre, String pass) throws SQLException, ClassNotFoundException {
		makeJDBCConnection();
		
		String insertQueryStatement = "INSERT INTO `users`(`name`, `password`) VALUES  (?,?)";
		stm = conn.prepareStatement(insertQueryStatement);
		stm.setString(1, nombre);
		stm.setString(2, pass);
		stm.executeUpdate();
		log.info(nombre + " added successfully soy el rey del mundo");
		
		testConnection(conn);
	}
	
	//Comprueba si existe un usuario en la BD. Si existe devuelve true y si no false
	public static boolean Loging(String nombre, String pass) throws SQLException {
		boolean response = false;
 		makeJDBCConnection();
		
		String getQueryStatement = "SELECT * FROM `users` WHERE name=? AND password=?";

		stm = conn.prepareStatement(getQueryStatement);
		stm.setString(1, nombre);
		stm.setString(2, pass);
	
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String n = rs.getString("name");
			String pas = rs.getString("password");
			Integer id = rs.getInt("id");
	
			if(id != null) response= true;
			else response = false;
		}

		testConnection(conn);
		return response;
	}
}
