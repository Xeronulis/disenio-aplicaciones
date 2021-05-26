package model.dto;

import java.util.List;

public class Biblioteca {

	private int idBiblio;
	private String direccion;
	private int telefono;
	
	List<Libro> libros;
	List<Factura> facturas;
	
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public int getIdBiblio() {
		return idBiblio;
	}
	public void setIdBiblio(int idBiblio) {
		this.idBiblio = idBiblio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}
