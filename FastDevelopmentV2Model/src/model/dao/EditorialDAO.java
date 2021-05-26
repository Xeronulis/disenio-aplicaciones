package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Editorial;
import model.utils.DB;

public class EditorialDAO {

	
	private static DB db = new DB();
	
	public static void save(Editorial editorial) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO editorial(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, editorial.getNombre());
			//st.setDate(2, arriendo.getFechaEntrega()); NI IDEA como agregar la fecha
			//st.setDate(3, arriendo.getFechaDevolucion());
			//st.setDate(4, arriendo.getFechaArriendo());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Editorial> getAll(){
		db.conectar();
		List<Editorial> editoriales = new ArrayList<>();
		try {
			String sql= "SELECT nombre From editorial";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Editorial e = new Editorial();
				e.setNombre(rs.getString(1));
				editoriales.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return editoriales;
	}
	
	
	public static List<Editorial> filteredSearch(String filtro, String target){
		db.conectar();
		List<Editorial> editoriales = new ArrayList<>();
		try {
			String sql= "SELECT nombre From editorial where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Editorial e = new Editorial();
				e.setNombre(rs.getString(1));
				editoriales.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return editoriales;
	}
	
	
	public static void update(Editorial ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE editorial set nombre = ? where nombre LIKE ?";
			
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
			String sql ="DELETE FROM editorial where nombre LIKE ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setString(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	

}
