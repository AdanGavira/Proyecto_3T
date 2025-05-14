package Prueba_Pryecto;

import java.sql.SQLException;

public class Libro {
	
	ConexionMySQL conexion = new ConexionMySQL("root","","biblioteca");
	
	String ISBN;
	String nombre;
	String autor;
	String categoria;
	boolean prestado;
	int id_cliente;
	
	public Libro () {
		this.ISBN = "";
		this.nombre = "";
		this.autor = "";
		this.categoria = "";
		this.id_cliente = 0;
		prestado = false;
	}
	
	//Getters

	public String getId() {
		return this.ISBN;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getCategoria() {
		return this.categoria;
	}
	
	//Setters

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setPrestado (boolean prestado) {
		this.prestado = prestado;
	}
	
public void anadirLibro(String ISBN, String nombre, String autor, String categoria, int dia_publicacion, int mes_publicacion, int ano_publicacion) {
		
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("INSERT INTO libro (Titulo, Autor, ISBN, `Fecha_de_publicacion`, Categoria) VALUES ('"+nombre+"','"+autor+"','"+ISBN+"','"+ano_publicacion+"-"+mes_publicacion+"-"+dia_publicacion+"','"+categoria+"')");
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL INSERTAR LIBRO");
			e.printStackTrace();
		}
		
	}
	
	public void eliminarLibro(String ISBN) {
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("DELETE FROM libro WHERE ISBN = '"+ISBN+"';");
			conexion.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarLibro (String filtro, String valor) {
		try {
			conexion.conectar();
			if (filtro.equals("Todo")) {
				conexion.ejecutarSelect("SELECT * FROM libro");
			} else {
				conexion.ejecutarSelect("SELECT * FROM libro WHERE '"+filtro+"' = '"+valor+"';");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prestarLibro(int ID_Cliente, String ISBN) {
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("UPDATE `libro` SET `id_cliente` = '"+ID_Cliente+"' WHERE ISBN = '"+ISBN+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void devolverLibro(String ISBN) {
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("UPDATE `libro` SET `id_cliente` = '"+null+"' WHERE `libro`.`ISBN` = '"+ISBN+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
