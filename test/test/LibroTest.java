package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Proyecto.ConexionMySQL;
import Proyecto.Libro;


public class LibroTest {
	
	Libro libro = new Libro();
	ConexionMySQL conexion = new ConexionMySQL("root", "", "biblioteca");


	@Test
	void testBuscarLibroTodo() throws SQLException {
		ResultSet resultado = libro.buscarLibro("Todo", null);
		assertNotNull(resultado); //Comprobar que el resultado no está vacío
		
		int cont= 0;
		while(resultado.next()) {
			cont++;
		}
		
		assertEquals(8, cont, "Comprobar que devuelve todos los libros");
		
		
	}
	
	@Test
	void testBuscarLibroPrestados() throws SQLException {
		ResultSet resultado = libro.buscarLibro("Prestados", null);
		assertNotNull(resultado); //Comprobar que el resultado no está vacío
		
		int cont= 0;
		while(resultado.next()) {
			cont++;
		}
		
		assertEquals(2, cont, "Comprobar que devuelve todos los libros prestados");
		
		
	}
	
	@Test
	void testBuscarLibroTitulo() throws SQLException {
		ResultSet resultado = libro.buscarLibro("Titulo", "El principito");
		assertNotNull(resultado); //Comprobar que el resultado no está vacío
		
		int cont= 0;
		while(resultado.next()) {
			cont++;
		}
		
		assertEquals(1, cont, "Comprobar que devuelve el libro con el título que se indica");
		
		
	}
	
	@Test
	void testBuscarLibroAutor() throws SQLException {
		ResultSet resultado = libro.buscarLibro("Autor", "Stephen King");
		assertNotNull(resultado); //Comprobar que el resultado no está vacío
		
		int cont= 0;
		while(resultado.next()) {
			cont++;
		}
		
		assertEquals(1, cont, "Comprobar que devuelve el libro con el autor que se indica");
		
		
	}
	
	@Test
	void testBuscarLibroISBN() throws SQLException {
		ResultSet resultado = libro.buscarLibro("ISBN", "9788408079545");
		assertNotNull(resultado); //Comprobar que el resultado no está vacío
		
		int cont= 0;
		while(resultado.next()) {
			cont++;
		}
		
		assertEquals(1, cont, "Comprobar que devuelve el libro con el ISBN que se indica");
		
		
	}

	@Test
	void testIsPrestado() {
		
		assertTrue(libro.isPrestado("9788401021356"), "Comprueba si el libro está prestado");
		assertFalse(libro.isPrestado("9780307474728"), "Comprueba si el libro no está prestado");
	}


	@Test
	void testExisteLibro() {
		
		assertTrue(libro.existeLibro("9788420412146"), "Comprueba que un libro existe");
		assertFalse(libro.existeLibro("549545459589676"), "Comprueba que un libro no existe");
	}


}
