package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

/**
 * En esta clase se revisara la congruencia de la tabla Categoria la cual tiene 3 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class Categoria implements InterfaceDTO {
	private int id;
	private String nombre;
	private List<String> libros = new ArrayList<String>();	

	/** 
	 * Una breve descripcion del fin de cada atributo de la clase Boleta.
	 * @param id: Clave unica para identificar la categoria dentro de la base de datos
	 * @param nombre: nombre de la categoria
	 * @param libros: lista de libros asociadas a una categoria 	 
	 * @author Grupo4
	 */
	
	@Override
	public int getId() {
		return 0;
	}
	@Override
	public void setId(int id) {		
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
	/**
	 * Metodo para agregar libros a alguna categoria que recibe como parametro el nombre 
	 * del libro a agregar
	 * @param libro: nombre del libro que se quiere agregar a alguna categoria en especifico.
	 */
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
