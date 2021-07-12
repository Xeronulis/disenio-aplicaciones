package model.dto;

/**
 * En esta clase se revisara la congruencia de la tabla EmailCliente la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class EmailCliente {
	
	private String emailCliente;
	private Cliente cliente;
	
	/**
	 * Una breve descripcion de cada atributo de la clase EmailCliente
	 * @param emailCliente: correo electronico asociado al cliente
	 * @param cliente: Objeto Cliente con el que asociaremos el correo electronico dentro de la base 
	 * de datos
	 */
	
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
