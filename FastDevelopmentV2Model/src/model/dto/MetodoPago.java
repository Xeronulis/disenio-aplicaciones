package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

public class MetodoPago implements InterfaceDTO{

	private int id;
	private	String nombre;
	private	List<Integer> idFacturas = new ArrayList<Integer>();
	
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
