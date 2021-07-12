package model.dto;

/**
 * En esta clase se revisara la congruencia de la tabla Ventas la cual tiene 3campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Ventas {

	private int idVentas;
	private Libro libro;
	private int precioConIVA;
	private Boleta boleta;
	
	/**
	 * Una breve descripcion de cada atributo de la clase TelefonoEmpleado
	 * @param idVentas: Identificador unico de cada objeto creado
	 * @param libro: Libro relacionado a la Venta
	 * @param precioConIVA: Valor de la venta con el impuesto correspondiente
	 * @param boleta: Objeto boleta al que estamos asociando la venta de un libro 
	 */
	
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
