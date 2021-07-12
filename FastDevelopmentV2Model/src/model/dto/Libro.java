package model.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libro {

	private String titulo;
	private String ISBN;
	private int stock;
	private int librosArrendados;
	private int numSerie;
	private int numPaginas;
	private Date anioPublicacion;
	private double precioRef;
	
	private List<Autor> autores = new ArrayList<Autor>();
	private List<String> idiomas = new ArrayList<String>();
	private List<String> categorias = new ArrayList<String>();
	private String estado;
	private String editorial;

	

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
	
	public void getStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}
	public String toString() {
		return this.titulo;
	}
	
}
