package model.dto;

import java.time.LocalDate;
import java.util.List;

public class Empleado {

	private String rutE;
	private LocalDate fechaContrato; 	
	private String nombreE;
	private String apellidoP;
	private String apellidoM;
	
	private List<DireccionEmpleado> direccionEmpleado;
	private List<TelefonoEmpleado> telefonoEmpleado;
	private List<EmailEmpleado> emailEmpleado;
	
	
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
