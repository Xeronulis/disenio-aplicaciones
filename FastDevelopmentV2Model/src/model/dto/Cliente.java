package model.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Cliente la cual tiene 5 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
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
	
	/** 
	 * Una breve descripcion del fin de cada atributo de la clase Cliente.
	 * @param rutC: rut del cliente que nos sirve para poder buscarlo dentro de la base de datos
	 * @param fechaNacimiento: fecha de nacimiento del cliente
	 * @param nombreC: nombre del cliente
	 * @param apellidoP: apellido paterno del cliente
	 * @param apellidoM: apellido materno del cliente
	 * @param libros: libros que el cliente desea llevar
	 * @param telefonoCliente: uno o varios numeros telefonicos que posee el cliente
	 * @param emailCliente: uno o varios emails que posee el cliente
	 * @param direccionCliente: una o varias direcciones que posee el cliente
	 * @param boletas: boletas historicas que el cliente posee
	 * @param arriendos: arriendos historicos del cliente
	 */
		
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
