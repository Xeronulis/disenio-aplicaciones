package model.dto;

import java.util.ArrayList;

import java.util.List;

import model.interfaces.InterfaceDTO;
/**
 * En esta clase se revisara la congruencia de la tabla Autor la cual tiene 5 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado
 * en esta clase 
 * @author Grupo4
 * @version 11-07-2021
 */
public class Autor implements InterfaceDTO{
	
	private int id;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private List<String> libros = new ArrayList<String>();
	
	/** 
	 * Una breve descripcion del fin de cada atributo de la clase autor.
	 * @param id: Clave unica para identificar y buscar el autor dentro de la base de datos
	 * @param nombre: Nombre del autor
	 * @param apellidoP: Apellido paterno del autor
	 * @param apellidoM: Apellido Materno del autor
	 * @param libros: lista de los libros que tiene o ha participado el autor
	 * @author Grupo4
	 */

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
