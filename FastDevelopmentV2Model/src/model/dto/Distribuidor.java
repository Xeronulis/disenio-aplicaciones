package model.dto;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.*;

/**
 * En esta clase se revisara la congruencia de la tabla Distribuidor la cual tiene 5 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */
public class Distribuidor implements InterfaceDTO{

	private int id;	
	private String rut;
	private String nombre;
	private int anioInicio;
	private int telefono;
	private String direccion;	
	private List<Integer> idFacturas = new ArrayList<Integer>();
	
	/**
	 * Una breve descripcion de cada atributo de la clase Distribuidor
	 * @param id: Clave unica que nos permite ubicar a un distribuidor especifico dentro de la 
	 * base de datos
	 * @param rut: rut del distribuidor
	 * @param nombre: nombre del distribuidor																														
	 * @param anioInicio: año desde que vende libros a la biblioteca
	 * @param telefono: numero telefonico del distribuidor
	 * @param direccion: direccion fisica del distribuidor 
	 * @param idFacturas: contienes los indices de todas las facturas donde el distribuidor este implicado
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
