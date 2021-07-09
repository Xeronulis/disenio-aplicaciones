package model.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * En esta clase se revisara la congruencia de la tabla Libro la cual tiene 11 campos
 * y se mostraran los metodos escenciales necesarios para trabajar con el objeto creado en 
 * esta clase
 * @author Grupo4
 * @version 11-07-2021
 */

public class Libro {

	private String titulo;
	private String ISBN;
	private int numSerie;
	private int numPaginas;
	private Date anioPublicacion;
	private double precioRef;	
	private List<Autor> autores = new ArrayList<Autor>();
	private List<String> idiomas = new ArrayList<String>();
	private List<String> categorias = new ArrayList<String>();
	private String estado;
	private String editorial;

	/**
	 * Una breve descripcion de cada atributo de la clase Libro
	 * @param titulo: Nombre del libro  
	 * @param iSBN: Identificador unico para libros, sirve para diferenciar los distintons libros dentro 
	 * de la base de datos
	 * @param numSerie: Numero que sirve para identificar los libros
	 * @param numPaginas: Cantidad de paginas que posee el libro
	 * @param anioPublicacion: Año en que se publico el libro
	 * @param precioRef: Precio de referencia del libro
	 * @param autores: Lista que contiene a los autores del libro
	 * @param idiomas: Lista de los idiomas en que esta el libro
	 * @param categorias: Lista con todas las categorias que posee el libro
	 * @param estado: Estado en que se encuentra el libro
	 * @param editorial: Nombre de la editorial que publico el libro
	 */
	
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
		
		
	public List<String> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<String> idiomas) {
		this.idiomas = idiomas;
	}
	public int getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Date getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(Date anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public double getPrecioRef() {
		return precioRef;
	}
	public void setPrecioRef(double precioRef) {
		this.precioRef = precioRef;
	}
	
	public void addToAutores(Autor autor) {
		autores.add(autor);
	}
	
	public void addToCategorias(String categ) {
		categorias.add(categ);
	}
	
	public void addToIdiomas(String idioma) {
		idiomas.add(idioma);
	}
	
	public String toString() {
		return this.titulo;
	}
	
}
