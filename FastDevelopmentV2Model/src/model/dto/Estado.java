package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

/**
 * En esta clase se revisara la congruencia de la tabla Estado la cual tiene 3 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Estado implements InterfaceDTO {

	private int id;
	private String nombre;
	private List<String> libros = new ArrayList<String>();
	
	/**
	 * Una breve descripcion de cada atributo de la clase Estado
	 * @param id: Clave unica para poder identificar los objetos creados en la base de datos
	 * @param nombre: nombre del estado
	 * @param libros: lista de los libros que pertenecen a un estado en especifico
	 */
	
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
		
	}
	
	public String getName() {
		return nombre;
	}
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getLibros() {
		return libros;
	}
	public void setLibros(List<String> libros) {
		this.libros = libros;
	}
	/**
	 * Este metodo nos sirve para poder agregar mas libros a un estado
	 * @param libro: Nombre del libro que queremos agregar o cambiar de estado
	 */
	public void addToLibros(String libro) {
		libros.add(libro);
	}
	
	public String toString() {
		
		return nombre;
	}
	
}
