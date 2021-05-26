package model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Boleta {
	private String folioB;
	private String metodoPago;
	private LocalTime horaCompra;
	private LocalDate fechaCompra;
	private int totalConIVA;
	
	private List<Ventas> ventas;
	private Empleado empleado;
	private Cliente cliente;
	
	
	
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
