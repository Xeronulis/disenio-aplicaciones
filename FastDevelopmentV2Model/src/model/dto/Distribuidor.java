package model.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.interfaces.*;

public class Distribuidor implements InterfaceDTO{

	private int id;
	
	private String rut;
	private String nombre;
	private int anioInicio;
	private int telefono;
	private String direccion;
	
	private List<Integer> idFacturas = new ArrayList<Integer>();

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getRut() {
		return rut;
	}

	@Override
	public void setRut(String rut) {
		this.rut = rut;
	}

	@Override
	public String getName() {
		return nombre;
	}

	@Override
	public void setName(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int getStartYear() {
		return anioInicio;
	}

	@Override
	public void setStartYear(int i) {
		this.anioInicio = i;
	}

	@Override
	public int getTel() {
		return telefono;
	}

	@Override
	public void setTel(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String getDir() {
		return direccion;
	}

	@Override
	public void setDir(String direccion) {
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
