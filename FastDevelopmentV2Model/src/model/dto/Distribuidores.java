package model.dto;

import java.time.LocalDate;
import java.util.List;

public class Distribuidores {

	private String rutD;
	private String nombreD;
	private LocalDate anioAntiguedad;
	private int telefonoD;
	private String direccionD;
	
	private List<Factura> facturas;
	private List<Libro> libros;
	
	
	

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
