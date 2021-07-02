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
			st.setString(1, idio.getName());

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
			String sql= "SELECT i.idIdioma, i.nombre, l.titulo FROM idioma i"
					+ " left join libroIdioma li on i.idIdioma = li.idIdioma"
					+ " left join libro l on l.numeroSerie = li.libroNumeroSerie;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Idioma e = new Idioma();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				if(idiomas.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					idiomas.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Idioma();
					e.setId(id);
					e.setName(nombre);
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
				e.setName(rs.getString(1));
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
	
	
	public static void update(Idioma ed, int target) {
		db.conectar();
		try {
			String sql = "UPDATE idioma set nombre = ? where idIdioma = ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getName());
			st.setInt(2, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql ="DELETE FROM idioma where idIdioma = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setInt(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
}
