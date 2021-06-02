package model.dto;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private List<String> libros = new ArrayList<String>();
	


	public List<String> getLibros() {
		return libros;
	}
	public void setLibros(List<String> libros) {
		this.libros = libros;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	
	public void addToLibros(String libro) {
		libros.add(libro);
	}
	
	public String toString() {
		return nombre+" "+apellidoP+" "+apellidoM;
	}
	
	public String getNameConcat() {
		return nombre.replace(" ", "")+apellidoP.replace(" ", "")+apellidoM.replace(" ", "");
	}
	
	public String[] getAllNames() {
		String[] names= {nombre,apellidoP,apellidoM};
		return names;
	}
	
	
}
