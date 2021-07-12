package model.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Distribuidores la cual tiene 7 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase.
 * @author Grupo4
 * @version 11-07-2021
 */
public class Distribuidores {

	private String rutD;
	private String nombreD;
	private LocalDate anioAntiguedad;
	private int telefonoD;
	private String direccionD;	
	private List<Factura> facturas;
	private List<Libro> libros;	
	
	/**
	 * Una breve descripcion de cada atributo de la clase Distribuidores
	 * @param rutD: rut del distribuidor
	 * @param nombreD: nombre del distribuidor
	 * @param anioAntiguedad: año desde que vende libros a la biblioteca
	 * @param telefonoD: numero telefonico del distribuido
	 * @param direccionD: direccion fisica del distribuidor
	 * @param facturas: lista de todas las facturas que mantiene con la biblioteca
	 * @param libros: lista de todos los libros que ha entregado a la biblioteca
	 */
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public String getRutD() {
		return rutD;
	}
	public void setRutD(String rutD) {
		this.rutD = rutD;
	}
	public String getNombreD() {
		return nombreD;
	}
	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}
	public LocalDate getAnioAntiguedad() {
		return anioAntiguedad;
	}
	public void setAnioAntiguedad(LocalDate anioAntiguedad) {
		this.anioAntiguedad = anioAntiguedad;
	}
	public int getTelefonoD() {
		return telefonoD;
	}
	public void setTelefonoD(int telefonoD) {
		this.telefonoD = telefonoD;
	}
	public String getDireccionD() {
		return direccionD;
	}
	public void setDireccionD(String direccionD) {
		this.direccionD = direccionD;
	}
	
	
	
}
