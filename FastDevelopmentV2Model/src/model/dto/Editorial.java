package model.dto;

import java.util.ArrayList;
import java.util.List;

public class Editorial {

	private String nombre;
	private List<String> libros = new ArrayList<String>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
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
