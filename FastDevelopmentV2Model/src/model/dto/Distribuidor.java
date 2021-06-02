package model.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Distribuidor {

	private int id;
	
	private String rut;
	private String nombre;
	private Date anioInicio;
	private int telefono;
	private String direccion;
	
	private List<Integer> idFacturas = new ArrayList<Integer>();

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(Date anioInicio) {
		this.anioInicio = anioInicio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Integer> getIdFacturas() {
		return idFacturas;
	}

	public void setIdFacturas(List<Integer> idFactura) {
		this.idFacturas = idFactura;
	}
	
	public void addToIdFacturas(int id) {
		idFacturas.add(id);
	}
	
	public String toString() {
		return this.nombre;
	}
}
