package model.dto;

public class Compras {

	private int idCompras;
	private Libro libro;
	private int precioConIVA;
	
	private Factura factura;

	public int getIdCompras() {
		return idCompras;
	}

	public void setIdCompras(int idCompras) {
		this.idCompras = idCompras;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getPrecioConIVA() {
		return precioConIVA;
	}

	public void setPrecioConIVA(int precioConIVA) {
		this.precioConIVA = precioConIVA;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	
	
}
