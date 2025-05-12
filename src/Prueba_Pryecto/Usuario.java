package Prueba_Pryecto;

import java.util.ArrayList;

public class Usuario {
	
	String nombre;
	String apellidos;
	int dia;
	int mes;
	int anno;
	String correo;
	ArrayList<Libro> librosPrestados = new ArrayList<>();
	
	public Usuario(String nombre, String apellidos, int dia, int mes, int anno, String correo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dia = dia;
		this.mes = mes;
		this.anno = anno;
		this.correo = correo;
	}
	
	//Getters

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAnno() {
		return this.anno;
	}

	public String getCorreo() {
		return this.correo;
	}
	
	//Setters

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
