package model.dto;

import java.util.ArrayList;
import java.util.List;

public class MetodoPago {

	private int id;
	private	String nombre;
	private	List<Integer> idFacturas = new ArrayList<Integer>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
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
