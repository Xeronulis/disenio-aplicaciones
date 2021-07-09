package model.dto;
/**
 * En esta clase se revisara la congruencia de la tabla EmailEmpleado la cual tiene 2 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class EmailEmpleado {

	private String emailEmpleado;
	private Empleado empleado;
	
	/**
	 * Una breve descripcion de cada atributo de la clase EmailEmpleado
	 * @param emailEmpleado: correo electronico asociado al empleado
	 * @param empleado: Objeto Empleado con el que asociaremos el correo electronico dentro 
	 * de la base de datos
	 */
	
	public String getEmailEmpleado() {
		return emailEmpleado;
	}
	public void setEmailEmpleado(String emailEmpleado) {
		this.emailEmpleado = emailEmpleado;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
		 
}
