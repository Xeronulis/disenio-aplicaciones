package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

/**
 * En esta clase se revisara la congruencia de la tabla MetodoPago la cual tiene 3 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class MetodoPago implements InterfaceDTO{

	private int id;
	private	String nombre;
	private	List<Integer> idFacturas = new ArrayList<Integer>();
	
	/**
	 * Una breve descripcion de cada atributo de la clase MetodoPago
	 * @param id: Identificador unico de cada objeto
	 * @param nombre: Nombre del tipo de pago
	 * @param idFacturas: Lista de las facturas que se han realizado en cada metodo de pago 
	 */
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return nombre;
	}
	
	@Override
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public List<Integer> getIdFacturas() {
		return idFacturas;
	}
	public void setIdFactura(List<Integer> idFacturas) {
		this.idFacturas = idFacturas;
	}
	
	public void addToFacturas(int idFactura) {
		idFacturas.add(idFactura);
	}
	
	public String toString() {
		return nombre;
	}
}
