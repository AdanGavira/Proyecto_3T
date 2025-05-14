package Prueba_Pryecto;

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
	
	public Usuario(String nombre, String apellidos, int dia, int mes, int anno, String correo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dia = dia;
		this.mes = mes;
		this.anno = anno;
		this.correo = correo;
	}
	
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
	
public void anadirUsuario(String nombre, String apellidos, int dia, int mes, int ano, String correo) {
		
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("INSERT INTO cliente (Nombre, Apellidos, Fecha_de_nacimiento, Email) VALUES ('"+nombre+"','"+apellidos+"','"+ano+"-"+mes+"-"+dia+"','"+correo+"')");
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL INSERTAR LIBRO");
			e.printStackTrace();
		}
		
	}
	
	public void eliminarUsuario(String ID) {
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("DELETE FROM cliente WHERE ID = '"+ID+"';");
			conexion.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarUsuario (String filtro, String valor) {
		try {
			conexion.conectar();
			if (filtro.equals("Todo")) {
				return conexion.ejecutarSelect("SELECT * FROM cliente");
			}
			else {
				return conexion.ejecutarSelect("SELECT * FROM cliente WHERE "+filtro+" = '"+valor+"';");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet buscarLibrosPrestados (int ID) {
		try {
			conexion.conectar();
			conexion.ejecutarSelect("SELECT * FROM libro WHERE id_cliente = "+ID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean existeCliente(String ID) {
		try {
			conexion.conectar();
			ResultSet resultado = conexion.ejecutarSelect("SELECT * FROM cliente WHERE ID = '"+ID+"'");
			while(resultado.next()) {
				String tem_ID = resultado.getString("ID");
				if (!tem_ID.isEmpty()) {
					return true;
				} else return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
