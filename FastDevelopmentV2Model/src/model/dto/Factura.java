package model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Factura {

	private String folioF;
	private String distribuidor;
	private LocalDate fechaCompra;
	private LocalTime horaCompra;
	private String metodoPago;
	private int totalConIVA;
	
	private List<Distribuidores> distribuidores;
	private List<Compras> compras;
	private Biblioteca biblioteca;
	
	

	public List<Distribuidores> getDistribuidores() {
		return distribuidores;
	}
	public void setDistribuidores(List<Distribuidores> distribuidores) {
		this.distribuidores = distribuidores;
	}
	public List<Compras> getCompras() {
		return compras;
	}
	public void setCompras(List<Compras> compras) {
		this.compras = compras;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public String getFolioF() {
		return folioF;
	}
	public void setFolioF(String folioF) {
		this.folioF = folioF;
	}
	public String getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public LocalTime getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public int getTotalConIVA() {
		return totalConIVA;
	}
	public void setTotalConIVA(int totalConIVA) {
		this.totalConIVA = totalConIVA;
	}
	
	
}
