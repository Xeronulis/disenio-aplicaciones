package model.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Factura la cual tiene 9 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Factura {

	private int idFactura;
	private int idDistribuidor;
	private int idMetodoPago;	
	private int folio;
	private Date fechaCompra;
	private Time horaCompra;
	private boolean locked;
	private double costoTotal;	
	private List<Compra> compras = new ArrayList<Compra>();
	
	/**
	 * Una breve descripcion de cada atributo de la clase Factura
	 * @param idFactura: Clave unica que nos permite ubicar los distintos objetos en la base de datos
	 * @param idDistribuidor: Clave unica que nos permite encontrar al distribuidor en la base de datos
	 * @param idMetodoPago: Clave unica que nos permite encontrar el metodo de pago en la base de datos
	 * @param folio: 
	 * @param fechaCompra: Fecha en la que se realizo la compra de libros
	 * @param horaCompra: Hora en la que se realizo la comrpa de libros
	 * @param locked:
	 * @param costoTotal: el costo total de la compra
	 * @param compras: lista de todo lo que se compro
	 */

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public int getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Time getHoraCompra() {
		return horaCompra;
	}

	public void setHoraCompra(Time horaCompra) {
		this.horaCompra = horaCompra;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	public void addToCompras(Compra compra) {
		compras.add(compra);
	}
	
	public String toString() {
		return String.valueOf(idFactura);
	}
}
