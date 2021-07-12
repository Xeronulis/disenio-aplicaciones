package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

/**
 * En esta clase se revisara la congruencia de la tabla Idioma la cual tiene 3 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Idioma implements InterfaceDTO{

	private int id;
	private String nombre;
	private List<String> libros = new ArrayList<String>();
	
	/**
	 * Una breve descripcion de cada atributo de la clase Idioma
	 * @param id: Clave unica que nos permite ubicar los distintos objetos en la base de datos
	 * @param nombre: el nombre del idioma que estamos generando
	 * @param libros: lista de libros que estan escritos en el mismo idioma
	 */
	
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return nombre;
	}
	
	@Override
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getLibros() {
		return libros;
	}
	public void addToLibros(String libro) {
		libros.add(libro);
	}
	public void setLibros(List<String> libros) {
		this.libros = libros;
	}
	
	public String toString() {
		return nombre;
	}
	
}
