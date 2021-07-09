package model.dto;

import java.time.LocalDate;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla arriendo la cual tiene 7 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Arriendo {
	
	private int idArriendo;
	private LocalDate fechaEntrega;
	private LocalDate fechaDevolucion;
	private LocalDate fechaArriendo;	
	private List<LibrosA> librosA;
	private Empleado empleado;
	private List<Cliente> clientes;
	
	/** 
	 * Una breve descripcion del fin de cada atributo de la clase Arriendo.
	 * @param idArriendo: Clave unica para identificar y buscar el arriendo en la tabla
	 * @param fechaEntrega: Fecha en que se entrego lo arrendado
	 * @param fechaDevolucion: Fecha cuando se debiera devolver lo que se arrendo
	 * @param fechaArriendo: Fecha cuando se efectuo el arriendo
	 * @param librosA: lista de los libros arrendados
	 * @param empleado: Objeto emplado que fue participe del arriendo
	 * @param clientes: lista de los clientes que han realizado algun arriendo.
	 * @author Grupo4
	 */	
	
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
