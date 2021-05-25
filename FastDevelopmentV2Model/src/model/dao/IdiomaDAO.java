package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Idioma;

public class IdiomaDAO {

	private static List<Idioma> idiomas = new ArrayList<>();
	
	public void add(Idioma idioma) {
		idiomas.add(idioma);
	}
	
	public List<Idioma> getAll(){
		return this.idiomas;
	}
	
	public void delete(Idioma idioma) {
		idiomas.remove(idioma);
	}
	
	public List<Idioma> filterByName(String nombre){
		
		return idiomas.stream().filter(i -> i.getNombre().toLowerCase().contentEquals(nombre.toLowerCase())).collect(Collectors.toList());
	}
}
