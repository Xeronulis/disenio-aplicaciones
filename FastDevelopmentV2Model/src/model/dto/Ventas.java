package model.dto;


public class Ventas {

	private int idVentas;
	
	private Libro libro;
	private int precioConIVA;
	private Boleta boleta;
	
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public int getIdVentas() {
		return idVentas;
	}
	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}
	public int getPrecioConIVA() {
		return precioConIVA;
	}
	public void setPrecioConIVA(int precioConIVA) {
		this.precioConIVA = precioConIVA;
	}
	public Boleta getBoleta() {
		return boleta;
	}
	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	
	
}
