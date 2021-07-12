package model.dto;

import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla LibrosA la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class LibrosA {

	private List<Libro> librosArrendados;
	private Arriendo arriendo;
	
	/**
	 * Una breve descripcion de cada atributo de la clase LibrosA
	 * @param librosArrendados: lista de los libros arrendados  
	 * @param arriendo: Objeto arriendo en la vemos los detalles del arriendo realizado 
	 */
	
	public List<Libro> getLibrosArrendados() {
		return librosArrendados;
	}
	public void setLibrosArrendados(List<Libro> librosArrendados) {
		this.librosArrendados = librosArrendados;
	}
	public Arriendo getArriendo() {
		return arriendo;
	}
	public void setArriendo(Arriendo arriendo) {
		this.arriendo = arriendo;
	}
	
	
}
