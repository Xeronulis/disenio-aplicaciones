package model.dto;

import java.util.List;

public class LibrosA {

	private List<Libro> librosArrendados;
	private Arriendo arriendo;
	
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
