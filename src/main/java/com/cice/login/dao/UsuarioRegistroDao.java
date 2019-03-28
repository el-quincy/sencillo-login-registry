package com.cice.login.dao;

public class UsuarioRegistroDao {

	private Integer id;
	private String nombre , pass;
	public UsuarioRegistroDao(Integer id, String nombre, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
	}
	public UsuarioRegistroDao(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
	}	
	public UsuarioRegistroDao() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UsuarioRegistro [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
