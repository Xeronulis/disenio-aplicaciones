package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Idioma;
import model.dto.Idioma;
import model.utils.DB;

public class IdiomaDAO {

	private static DB db = new DB();
	
	public static void save(Idioma idio) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO idioma(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, idio.getNombre());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Idioma> getAll(){
		db.conectar();
		List<Idioma> idiomas = new ArrayList<>();
		try {
			String sql= "SELECT i.nombre, l.titulo FROM idioma i"
					+ " left join libroIdioma li on i.idIdioma = li.idIdioma"
					+ " left join libro l on l.numeroSerie = li.libroNumeroSerie;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Idioma e = new Idioma();
			while(rs.next()) {
				String nombre = rs.getString(1);
				String titulo = rs.getString(2);
				
				if(idiomas.isEmpty()) {
					e.setNombre(nombre);
					e.addToLibros(titulo);
					idiomas.add(e);
					
				}else if(e.getNombre().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Idioma();
					e.setNombre(nombre);
					e.addToLibros(titulo);
					idiomas.add(e);
				}
				
				
				
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return idiomas;
	}
	
	
	
	
	public static List<Idioma> filteredSearch(String filtro, String target){
		db.conectar();
		List<Idioma> idiomas = new ArrayList<>();
		try {
			String sql= "SELECT nombre From idioma where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Idioma e = new Idioma();
				e.setNombre(rs.getString(1));
				idiomas.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return idiomas;
	}
	
	
	public static void update(Idioma ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE idioma set nombre = ? where nombre LIKE ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getNombre());
			st.setString(2, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(String target) {
		db.conectar();
		try {
			String sql ="DELETE FROM idioma where nombre LIKE ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setString(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
}
