package model.dto;

import java.time.LocalDate;
import java.util.List;

public class Arriendo {

	private int idArriendo;
	private LocalDate fechaEntrega;
	private LocalDate fechaDevolucion;
	private LocalDate fechaArriendo;
	
	private List<LibrosA> librosA;
	private Empleado empleado;
	private List<Cliente> clientes;
	
	
	
	public LocalDate getFechaArriendo() {
		return fechaArriendo;
	}
	public void setFechaArriendo(LocalDate fechaArriendo) {
		this.fechaArriendo = fechaArriendo;
	}
	public int getIdArriendo() {
		return idArriendo;
	}
	public void setIdArriendo(int idArriendo) {
		this.idArriendo = idArriendo;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public List<LibrosA> getLibrosA() {
		return librosA;
	}
	public void setLibrosA(List<LibrosA> librosA) {
		this.librosA = librosA;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	
}
