package Prueba_Pryecto;

public class Libro {
	
	int id_libro;
	String nombre;
	String autor;
	String categoria;
	boolean prestado;
	int id_cliente;
	
	public Libro (int id_libro, String nombre, String autor, String categoria, int id_cliente) {
		this.id_libro = id_libro;
		this.nombre = nombre;
		this.autor = autor;
		this.categoria = categoria;
		this.id_cliente = id_cliente;
		prestado = false;
	}
	
	//Getters

	public int getId() {
		return this.id_libro;
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

	public void setId(int id_libro) {
		this.id_libro = id_libro;
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

}
