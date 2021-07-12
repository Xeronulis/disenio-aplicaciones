package model.dto;
/**
 * En esta clase se revisara la congruencia de la tabla DireccionCliente la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class DireccionCliente {

	private String direccionCliente;
	private Cliente cliente;
	
	/**
	 * Una breve descripcion de cada atributo de la clase DireccionCliente.
	 * @param direccionCliente: direccion fisica del cliente
	 * @param cliente: Es el cliente al cual estamos asociando la direccion
	 */
	
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
