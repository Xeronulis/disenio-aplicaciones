package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

public class Estado implements InterfaceDTO {

	private int id;
	private String nombre;
	private List<String> libros = new ArrayList<String>();
	
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
	
	public void addToLibros(String libro) {
		libros.add(libro);
	}
	
	public String toString() {
		
		return nombre;
	}
	
}
