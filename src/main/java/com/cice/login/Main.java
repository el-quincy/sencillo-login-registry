package com.cice.login;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cice.login.dao.UsuarioRegistroDao;
import com.cice.login.services.impl.ControlLoginUsrImpl;


public class Main {	
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {		
		BasicConfigurator.configure();		
		ControlLoginUsrImpl serviceLogin=new ControlLoginUsrImpl();
		Scanner  sc = new Scanner(System.in);
		UsuarioRegistroDao nuevoUsuario= new UsuarioRegistroDao();
		boolean isRegistrado=false;
		
		// Solicitar los datos al usuario
		nuevoUsuario=serviceLogin.userGetData(sc);		
			
		// Comprobamos si esta registrado
		isRegistrado=serviceLogin.isUserRegistred(nuevoUsuario);
		
		
		while (!isRegistrado) { //help me please
			log.warn("Usuario no registrado");
			log.info("========Registro=========");
			nuevoUsuario=serviceLogin.userGetData(sc);	
			isRegistrado= serviceLogin.usersPost(nuevoUsuario);
			}	
		
		
/*
 * Crear un loging desde consola 
 * --1 pedir por consola nombre de usuario y pass
 * --2 si el usuario esta registrado mostrar sus datos por consola con un mensaje 
 * --2 bis si no lo esta pedir que se registre y solicitar los datos. una vez terminado 
 * voler al login e intentar registrarse 
 * 
 * 
 * */
	}
}
