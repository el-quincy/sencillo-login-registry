package com.cice.login.services;

import java.util.Scanner;

import com.cice.login.dao.UsuarioRegistroDao;

public interface ControlLoginUsr {
	
	public  UsuarioRegistroDao userGetData(Scanner sc);
	public  boolean isUserRegistred(UsuarioRegistroDao usr);
	public  boolean usersPost(UsuarioRegistroDao nuevoUsuario);
}
