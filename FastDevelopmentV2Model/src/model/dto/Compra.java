package model.dto;


/**
 * En esta clase se revisara la congruencia de la tabla Compra la cual tiene 5 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Compra {

	private int idLibro;
	private int idFactura;
	private double precioConIVA;
	private double precioNeto;
	private double costoIva;
	
	/**
	 * Una breve descripcion del fin de cada atributo de la clase Compra.
	 * @param idLibro: Parte de la clave unica que sirve para identificar los distintos objetos de 
	 * compra
	 * @param idFactura: Parte de la clave unica que sirvre para poder identificar los distintos 
	 * objetos de la tabla compra
	 * @param precioConIVA: precio de la compra mas su IVA correspondiente
	 * @param precioNeto: valor neto de la compra
	 * @param costoIva: valor del IVA
	 */

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
