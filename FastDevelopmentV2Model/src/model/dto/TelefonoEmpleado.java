package model.dto;

/**
 * En esta clase se revisara la congruencia de la tabla TelefonoEmpleado la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class TelefonoEmpleado {

	private int telefonoEmpleado;
	private Empleado empleado;
	
	/**
	 * Una breve descripcion de cada atributo de la clase TelefonoEmpleado
	 * @param telefonoEmpleado: numero telefonico del empleado
	 * @param empleado: Objeto empleado al que estamos asociando su numero telefonico
	 */
	
	public int getTelefonoEmpleado() {
		return telefonoEmpleado;
	}
	public void setTelefonoEmpleado(int telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
