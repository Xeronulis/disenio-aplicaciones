package model.dto;
/**
 * En esta clase se revisara la congruencia de la tabla DireccionEmpleado la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class DireccionEmpleado {
	private String direccionEmpleado;
	private Empleado empleado;
	
	/**
	 * Una breve descripcion de cada atributo de la clase DireccionEmpleado
	 * @param direccionEmpleado: direccion fisica del empleado
	 * @param empleado: Es el empleado al cual estamos asociando la direccion
	 */
	
	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}
	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
