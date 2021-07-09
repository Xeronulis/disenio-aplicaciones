package model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Boleta la cual tiene 8 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class Boleta {
	private String folioB;
	private String metodoPago;
	private LocalTime horaCompra;
	private LocalDate fechaCompra;
	private int totalConIVA;	
	private List<Ventas> ventas;
	private Empleado empleado;
	private Cliente cliente;
	
	/** 
	 * Una breve descripcion del fin de cada atributo de la clase Boleta.
	 * @param folioB: Clave unica para identificar la boleta dentro de la base de datos
	 * @param metodoPago: forma de pago del cliente
	 * @param horaCompra: Hora a la que se genero la boleta 	 
	 * @param fehcaCompra: Fecha en la que se genero la boleta
	 * @param totalConIVA: el total de la compra agregando el impuesto correspondiente
	 * @param ventas: lista de objetos Ventas, esta refleja los libros que se compraron.
	 * @param empleado: empleado que genero la boleta
	 * @param cliente: El cliente que realizo una o varias compras
	 * @author Grupo4
	 */
	
	
	
	public List<Ventas> getVentas() {
		return ventas;
	}
	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getFolioB() {
		return folioB;
	}
	public void setFolioB(String folioB) {
		this.folioB = folioB;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public LocalTime getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public int getTotalConIVA() {
		return totalConIVA;
	}
	public void setTotalConIVA(int totalConIVA) {
		this.totalConIVA = totalConIVA;
	}
	
	
	

}
