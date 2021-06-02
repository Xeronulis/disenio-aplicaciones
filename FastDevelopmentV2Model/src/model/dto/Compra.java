package model.dto;

public class Compra {

	private int idLibro;
	private int idFactura;
	
	
	private double precioConIVA;
	private double precioNeto;
	private double costoIva;
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public double getPrecioConIVA() {
		return precioConIVA;
	}
	public void setPrecioConIVA(double precioConIVA) {
		this.precioConIVA = precioConIVA;
	}
	public double getPrecioNeto() {
		return precioNeto;
	}
	public void setPrecioNeto(double precioNeto) {
		this.precioNeto = precioNeto;
	}
	public double getCostoIva() {
		return costoIva;
	}
	public void setCostoIva(double costoIva) {
		this.costoIva = costoIva;
	}
}
