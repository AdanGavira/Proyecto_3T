package Proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Libro {
	
	ConexionMySQL conexion = new ConexionMySQL("root","","biblioteca");
	
	String ISBN;
	String nombre;
	String autor;
	String categoria;
	boolean prestado;
	int id_cliente;
	
	//Constructor
	
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
	
	public void anadirLibro(String ISBN, String nombre, String autor, String categoria, int dia_publicacion, int mes_publicacion, int ano_publicacion) { // Añadir un libro nuevo a la base de datos
		
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("INSERT INTO libro (Titulo, Autor, ISBN, `Fecha_de_publicacion`, Categoria) VALUES ('"+nombre+"','"+autor+"','"+ISBN+"','"+ano_publicacion+"-"+mes_publicacion+"-"+dia_publicacion+"','"+categoria+"')");
			conexion.desconectar();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL INSERTAR LIBRO");
			e.printStackTrace();
		}
		
	}
	
	public void eliminarLibro(String ISBN) { // Eliminar un libro de la base de datos
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("DELETE FROM libro WHERE ISBN = '"+ISBN+"';");
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println("ERROR AL ELIMINAR LIBRO");
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarLibro (String filtro, String valor) { // Buscar libros en la base de datos a través de un filtro y un valor
		try {
			conexion.conectar();
			if (filtro.equals("Todo")) {
				return conexion.ejecutarSelect("SELECT * FROM libro");
			} else if (filtro.equals("Prestados")) {
				return conexion.ejecutarSelect("SELECT * FROM libro WHERE id_usuario IS NOT NULL;");
			} else {
				return conexion.ejecutarSelect("SELECT * FROM libro WHERE "+filtro+" = '"+valor+"';");
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isPrestado(String ISBN) { // Comprobar si el libro está prestado
		boolean isPrestado = false;
		try {
			conexion.conectar();
			ResultSet resultado = conexion.ejecutarSelect("SELECT * FROM libro WHERE ISBN = '"+ISBN+"'");
			while(resultado.next()) {
				int tem_cliente = resultado.getInt("id_usuario");
				if (tem_cliente != 0) {
					isPrestado = true;
				}
			}
			
			
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR");
			e.printStackTrace();
		}
		return isPrestado;
	}
	
	public void prestarLibro(int ID_Usuario, String ISBN) { // Prestar un libro actualizando su campo de id_cliente en la base de datos a través de su ISBN
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("UPDATE `libro` SET `id_usuario` = '"+ID_Usuario+"' WHERE ISBN = '"+ISBN+"'");
		} catch (Exception e) {
			System.out.println("ERROR EN EL PRÉSTAMO");
			e.printStackTrace();
		}
	}
	
	public boolean existeLibro(String ISBN) { // Comprobar si existe el libro en la base de datos
		try {
			conexion.conectar();
			ResultSet resultado = conexion.ejecutarSelect("SELECT * FROM libro WHERE ISBN = '"+ISBN+"'");
			while(resultado.next()) {
				String tem_ISBN = resultado.getString("ISBN");
				if (!tem_ISBN.isEmpty()) {
					return true;
				} else return false;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL BUSCAR");
			e.printStackTrace();
		}
		return false;
	}
	
	public void devolverLibro(String ISBN) { // Actualizar el id_cliente del libro a NULL para "devolverlo"
		try {
			conexion.conectar();
			conexion.ejecutarInsertDeleteUpdate("UPDATE `libro` SET `id_usuario` = NULL WHERE `libro`.`ISBN` = '"+ISBN+"'");
		} catch (SQLException e) {
			System.out.println("ERROR AL DEVOLVER LIBRO");
			e.printStackTrace();
		}
	}

}
