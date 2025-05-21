package Proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
	
	ConexionMySQL conexion = new ConexionMySQL("root","","biblioteca");
	
	String nombre;
	String apellidos;
	int dia;
	int mes;
	int anno;
	String correo;
	ArrayList<Libro> librosPrestados = new ArrayList<>();
	
	//Constructor
	
	public Usuario() {
		this.nombre = "";
		this.apellidos = "";
		this.dia = 0;
		this.mes = 0;
		this.anno = 0;
		this.correo = "";
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
	
public void anadirUsuario(String nombre, String apellidos, int dia, int mes, int ano, String correo) { //Añadir un cliente a la base de datos
		
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("INSERT INTO usuario (Nombre, Apellidos, Fecha_de_nacimiento, Email) VALUES ('"+nombre+"','"+apellidos+"','"+ano+"-"+mes+"-"+dia+"','"+correo+"')");
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL AÑADIR USUARIO");
			e.printStackTrace();
		}
		
	}
	
	public void eliminarUsuario(String ID) { //Eliminar un cliente de la base de datos
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("DELETE FROM usuario WHERE ID = '"+ID+"';");
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("ERROR AL ELIMINAR USUARIO");
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarUsuario (String filtro, String valor) { //Buscar un cliente en la base de datos a través de un filtro y un valor
		try {
			conexion.conectar();
			if (filtro.equals("Todo")) {
				return conexion.ejecutarSelect("SELECT * FROM usuario");
			}
			else {
				return conexion.ejecutarSelect("SELECT * FROM usuario WHERE "+filtro+" = '"+valor+"';");
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR USUARIO");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean existeUsuario(String ID) { //Comprobar si existe el usuario dentro de la base de datos
		try {
			conexion.conectar();
			ResultSet resultado = conexion.ejecutarSelect("SELECT * FROM usuario WHERE ID = '"+ID+"'");
			while(resultado.next()) {
				String tem_ID = resultado.getString("ID");
				if (!tem_ID.isEmpty()) {
					return true;
				} else return false;
			}
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR USUARIO");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isPrestado(String ID) { // Comprobar si el usuario tiene libros prestados
		boolean isPrestado = false;
		try {
			conexion.conectar();
			ResultSet resultado = conexion.ejecutarSelect("SELECT * FROM libro WHERE id_usuario = '"+ID+"'");	
			while(resultado.next()) {
				String tem_cliente = resultado.getString("id_usuario");
				if (tem_cliente.equals(ID)) {
					isPrestado = true;
				}
			}
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR");
			e.printStackTrace();
		}
		return isPrestado;
	}
	
	public ResultSet buscarLibrosPrestados (String ID) { //Buscar los libros prestados a un cliente específico
		try {
			conexion.conectar();
			return conexion.ejecutarSelect("SELECT * FROM libro WHERE id_usuario = '"+ID+"'");
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR LIBROS");
			e.printStackTrace();
		}
		return null;
	}
	
	
}
