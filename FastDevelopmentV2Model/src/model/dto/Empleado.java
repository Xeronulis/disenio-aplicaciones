package model.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Empleado la cual tiene 8 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Empleado {

	private String rutE;
	private LocalDate fechaContrato; 	
	private String nombreE;
	private String apellidoP;
	private String apellidoM;	
	private List<DireccionEmpleado> direccionEmpleado;
	private List<TelefonoEmpleado> telefonoEmpleado;
	private List<EmailEmpleado> emailEmpleado;
	
	/**
	 * Una breve descripcion de cada atributo de la clase Empleado
	 * @param rutE: corresponde al rut del empleador
	 * @param fechaContrato: fecha en la cual el empleado fue contratado
	 * @param nombreE: nombre del empleado
	 * @param apellidoP: apellido paterno del empleado
	 * @param apellidoM: apellido materno del empleado
	 * @param direccionEmpleado: lista de las direcciones fisicas del empleado
	 * @param telefonoEmpleado: lista de los numeros telefonicos del empleado
	 * @param emailEmpleado: lista de los email electronicos del empleado
	 */
	
	public List<DireccionEmpleado> getDireccionEmpleado() {
		return direccionEmpleado;
	}
	public void setDireccionEmpleado(List<DireccionEmpleado> direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}
	public List<TelefonoEmpleado> getTelefonoEmpleado() {
		return telefonoEmpleado;
	}
	public void setTelefonoEmpleado(List<TelefonoEmpleado> telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}
	public List<EmailEmpleado> getEmailEmpleado() {
		return emailEmpleado;
	}
	public void setEmailEmpleado(List<EmailEmpleado> emailEmpleado) {
		this.emailEmpleado = emailEmpleado;
	}
	public String getRutE() {
		return rutE;
	}
	public void setRutE(String rutE) {
		this.rutE = rutE;
	}
	public LocalDate getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public String getNombreE() {
		return nombreE;
	}
	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
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
