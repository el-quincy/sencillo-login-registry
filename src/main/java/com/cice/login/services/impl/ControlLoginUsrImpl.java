package com.cice.login.services.impl;

import java.sql.SQLException;
import java.util.Scanner;

//Librerías de log
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Referencias del proyecto
import com.cice.login.Main;
import com.cice.login.dao.UsuarioRegistroDao;
import com.cice.login.datasource.Datasource;
import com.cice.login.services.ControlLoginUsr;


public class ControlLoginUsrImpl implements ControlLoginUsr {
	
	//Constante de clase
	private static final Logger log = LoggerFactory.getLogger(ControlLoginUsrImpl.class);
	
	
	public UsuarioRegistroDao userGetData(Scanner sc) {

		UsuarioRegistroDao newUsr= new UsuarioRegistroDao();
		
		log.info("Introduce tu usuario");
		newUsr.setNombre(sc.next());
		//String user = sc.next();

		log.info("introduce el pass");
		newUsr.setPass(sc.next());
		//String pass = sc.next();
	
	return newUsr;
	}
	
	public boolean isUserRegistred(UsuarioRegistroDao usr) {
		boolean result = false;

		
		try {
			result =Datasource.Loging(usr.getNombre(), usr.getPass());
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		if(result) {
			log.info("Estás registrado "+usr.getNombre()+" Tu id es: "+usr.getId()
			+" y, aunque no se debe, tu pwd es: "+ usr.getPass());
		}
		else {
			log.info("No te lies no estas registrado");	
		}
	return result;	
	}
	
	public boolean usersPost(UsuarioRegistroDao nuevoUsuario) {

		boolean result = false;
		try {
			Datasource.registro(nuevoUsuario.getNombre(), nuevoUsuario.getPass());
			result = true;
			log.info("Usuario creado");
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage());
			result = false;
		} catch (SQLException e) {
			log.error(e.getMessage());
			result = false;
		}
	
		
		return result;
	}
	
}
