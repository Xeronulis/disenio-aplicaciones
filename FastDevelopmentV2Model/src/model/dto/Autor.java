package model.dto;

import java.util.List;

public class Autor {
	
	private String rutAutor;
	private String nombreAutor;
	private String apellidoP;
	private String apellidoM;
	private List<Libro> libros;
	


	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public String getRutAutor() {
		return rutAutor;
	}
	public void setRutAutor(String rutAutor) {
		this.rutAutor = rutAutor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
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
	
	
}
