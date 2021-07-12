package model.dto;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.InterfaceDTO;

/**
 * En esta clase se revisara la congruencia de la tabla Editorial la cual tiene 3 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Editorial implements InterfaceDTO{

	private int id;
	private String nombre;
	private List<String> libros = new ArrayList<String>();
	
	/**
	 * Una breve descripcion de cada atributo de la clase Editorial
	 * @param id: Clave unica que nos permite ubicar un objeto en especifico dentro de la base de datos
	 * @param nombre: nombre de la editorial
	 * @param libros: lista de los libros que a publicado la editorial
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
	public void setLibros(List<String> libros) {
		this.libros = libros;
	}
	
	public void addToLibros(String libro) {
		libros.add(libro);
	}
	
	public String toString() {	
		return nombre;
	}


}
