package model.dto;

import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Biblioteca la cual tiene 5 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class Biblioteca {
	
	private int idBiblio;
	private String direccion;
	private int telefono;	
	private List<Libro> libros;
	private List<Factura> facturas;
	
	/** 
	 * Una breve descripcion del fin de cada atributo de la clase Biblioteca.
	 * @param idBiblio: Clave unica para identificar y buscar la biblioteca dentro de la base de datos
	 * @param direccion: direccion fisica de la biblioteca
	 * @param telefono: telefono para contactar a la biblioteca	 
	 * @param libros: lista de los libros que tiene la biblioteca a disposicion
	 * @param facturas: lista de las facturas entregadas por los proveedores
	 * @author Grupo4
	 */
	
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
