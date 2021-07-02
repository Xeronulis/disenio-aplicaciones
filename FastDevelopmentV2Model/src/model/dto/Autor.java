package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.InterfaceDTO;

public class Autor implements InterfaceDTO{
	
	private int id;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private List<String> libros = new ArrayList<String>();
	

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getNameConcat() {
		return nombre.replace(" ", "")+apellidoP.replace(" ", "")+apellidoM.replace(" ", "");
	}
	
	
	public List<String> getLibros() {
		return libros;
	}
	public void setLibros(List<String> libros) {
		this.libros = libros;
	}

	@Override
	public String getName() {
		return nombre;
	}
	
	@Override
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	
	public void addToLibros(String libro) {
		libros.add(libro);
	}
	
	public String toString() {
		return nombre+" "+apellidoP+" "+apellidoM;
	}
	
	public String[] getAllNames() {
		String[] names= {nombre,apellidoP,apellidoM};
		return names;
	}
	
	
}
