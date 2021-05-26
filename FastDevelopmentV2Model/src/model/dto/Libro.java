package model.dto;

import java.time.LocalDate;
import java.util.List;

public class Libro {

	private String titulo;
	private String editorial;
	private String ISBN;
	private String estado;
	private int numSerie;
	private int numPaginas;
	private LocalDate anioPublicacion;
	private int precioRef;
	
	private List<Autor> autores;
	private List<Distribuidores> distribuidores ;
	private List<Idioma> idiomas;
	private List<Categoria> categorias;
	private Cliente cliente;
	private Biblioteca biblioteca;
	
	

	public List<Distribuidores> getDistribuidores() {
		return distribuidores;
	}
	public void setDistribuidores(List<Distribuidores> distribuidores) {
		this.distribuidores = distribuidores;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Idioma> idiomas) {
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

	public LocalDate getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(LocalDate anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public int getPrecioRef() {
		return precioRef;
	}
	public void setPrecioRef(int precioRef) {
		this.precioRef = precioRef;
	}
	
	
	
}
