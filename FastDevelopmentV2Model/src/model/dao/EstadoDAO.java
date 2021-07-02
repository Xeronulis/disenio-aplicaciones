package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Estado;
import model.utils.DB;

public class EstadoDAO {

	
	private static DB db = new DB();
	
	public static void save(Estado estado) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO estadoLibro(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, estado.getName());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Estado> getAll(){
		db.conectar();
		List<Estado> estados = new ArrayList<>();
		try {
			String sql= "SELECT e.idEstadoLibro, e.nombre, l.titulo FROM estadoLibro e"
				    + " LEFT JOIN libro l on l.idestadoLibro = e.idEstadoLibro;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Estado e = new Estado();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				if(estados.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					estados.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Estado();
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					estados.add(e);
				}
				
				
				
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return estados;
	}
	
	
	
	
	public static List<Estado> filteredSearch(String filtro, String target){
		db.conectar();
		List<Estado> estados = new ArrayList<>();
		try {
			String sql= "SELECT nombre From estadoLibro where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Estado e = new Estado();
				e.setName(rs.getString(1));
				estados.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return estados;
	}
	
	
	public static void update(Estado ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE estadoLibro set nombre = ? where nombre = ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getName());
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
			String sql ="DELETE FROM estadoLibro where nombre = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setString(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	

}
