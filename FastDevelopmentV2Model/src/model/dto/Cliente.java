package model.dto;

import java.time.LocalDate;
import java.util.List;

public class Cliente {

	private String rutC;
	private LocalDate fechaNacimiento; 	
	private String nombreC;
	private String apellidoP;
	private String apellidoM;
	
	private List<Libro> libros;
	private List<TelefonoCliente> telefonoCliente;
	private List<EmailCliente> emailCliente;
	private List<DireccionCliente> direccionCliente;
	private List<Boleta> boletas;
	private List<Arriendo> arriendos;
	
	public List<Arriendo> getArriendos() {
		return arriendos;
	}
	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}
	public List<Boleta> getBoletas() {
		return boletas;
	}
	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public List<TelefonoCliente> getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(List<TelefonoCliente> telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public List<EmailCliente> getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(List<EmailCliente> emailCliente) {
		this.emailCliente = emailCliente;
	}
	public List<DireccionCliente> getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(List<DireccionCliente> direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getRutC() {
		return rutC;
	}
	public void setRutC(String rutC) {
		this.rutC = rutC;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
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
