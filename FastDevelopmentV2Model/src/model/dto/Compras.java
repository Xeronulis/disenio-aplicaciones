package model.dto;

/**
 * En esta clase se revisara la congruencia de la tabla Compras la cual tiene 4 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class Compras {

	private int idCompras;
	private Libro libro;
	private int precioConIVA;
	private Factura factura;
	
	/**
	 * Una breve descripcion de cada atributo de la clase Compras.
	 * @param idCompras: Clave  unica que nos permite diferenciar los objetos dentro de la base de datos
	 * @param libro: libro relacionado a la compra
	 * @param precioConIVA: valor del libro con su respectivo IVA
	 * @param factura: factura donde se refleja las compras
	 */

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
