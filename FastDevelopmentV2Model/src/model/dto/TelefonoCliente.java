package model.dto;

/**
 * En esta clase se revisara la congruencia de la tabla TelefonoCliente la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class TelefonoCliente {
	private Cliente cleinte;
	private int telefono;
	
	/**
	 * Una breve descripcion de cada atributo de la clase TelefonoCliente
	 * @param cleinte: El cliente con el que estamos asociando el numero telefonico
	 * @param telefono: numero telefonico del cliente
	 */
	
	public Cliente getCleinte() {
		return cleinte;
	}
	public void setCleinte(Cliente cleinte) {
		this.cleinte = cleinte;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
}
