package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Proyecto.ConexionMySQL;
import Proyecto.Usuario;

class UsuarioTest {
	
	Usuario usuario = new Usuario();
	ConexionMySQL conexion = new ConexionMySQL("root", "", "biblioteca");

		@Test
		void testBuscarUsuarioTodo() throws SQLException {
			ResultSet resultado = usuario.buscarUsuario("Todo", null);
			assertNotNull(resultado); //Comprobar que el resultado no está vacío
			
			int cont= 0;
			while(resultado.next()) {
				cont++;
			}
			
			assertEquals(8, cont, "Comprobar que devuelve todos los usuarios");
			
			
		}
		
		@Test
		void testBuscarUsuarioNombre() throws SQLException {
			ResultSet resultado = usuario.buscarUsuario("Nombre", "Carlos");
			assertNotNull(resultado); //Comprobar que el resultado no está vacío
			
			int cont= 0;
			while(resultado.next()) {
				cont++;
			}
			
			assertEquals(1, cont, "Comprobar que devuelve todos los usuarios con el nombre indicado");
			
			
		}
		
		@Test
		void testBuscarUsuarioApellidos() throws SQLException {
			ResultSet resultado = usuario.buscarUsuario("Apellidos", "Martín Ruiz");
			assertNotNull(resultado);
			
			int cont= 0;
			while(resultado.next()) {
				cont++;
			}
			
			assertEquals(1, cont, "Comprobar que devuelve los usuarios con el apellido indicado");
			
			
		}
		
		@Test
		void testBuscarUsuarioID() throws SQLException {
			ResultSet resultado = usuario.buscarUsuario("ID", "2");
			assertNotNull(resultado); //Comprobar que el resultado no está vacío
			
			int cont= 0;
			while(resultado.next()) {
				cont++;
			}
			
			assertEquals(1, cont, "Comprobar que devuelve el usuario con el ID indicado");
			
			
		}

		@Test
		void testExisteUsuario() {
		assertTrue(usuario.existeUsuario("7"), "Comprueba que un usuario existe");
		assertFalse(usuario.existeUsuario("10"), "Comprueba que un usuario no existe");
		}

		@Test
		void testBuscarLibrosPrestados() throws SQLException { //Caso para un cliente con libros asociados
		ResultSet resultado = usuario.buscarLibrosPrestados("8");
		assertNotNull(resultado); //Comprobar que el resultado no está vacío
		
		int cont= 0;
		while(resultado.next()) {
			cont++;
			assertEquals("8",resultado.getString("id_usuario"), "Comprueba que los libros están asociados al usuario indicado");
		}
		
		assertEquals(1, cont, "Comprobar que el numero de libros prestados al usuario indicado es correcto");
		}
	
		@Test
		void testBuscarLibrosPrestadosNoUsuario() throws SQLException { //Caso para un cliente sin libros asociados
			ResultSet resultado = usuario.buscarLibrosPrestados("2");
			assertNotNull(resultado); //Comprobar que el resultado no está vacío
			
			int cont= 0;
			while(resultado.next()) {
				cont++;
				assertEquals("2",resultado.getString("id_usuario"), "Comprueba que los libros están asociados al usuario indicado");
			}
			
			assertEquals(0, cont, "Comprobar que el numero de libros prestados al usuario indicado es correcto");
		}
	
		@Test
		void testIsPrestado() {		
			assertTrue(usuario.isPrestado("8"), "Comprueba si el usuario tiene libros prestados");
			assertFalse(usuario.isPrestado("6"), "Comprueba si el usuario no tiene libros prestados");
		}

}
