package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Categoria;
import model.dto.Categoria;
import model.utils.DB;

public class CategoriaDAO {
	
	private static DB db= new DB();
	
	public static void save(Categoria categ) {
	
		db.conectar();
		
		try {
			String sql= "INSERT INTO categoria(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, categ.getName());
	
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Categoria> getAll(){
		db.conectar();
		List<Categoria> categorias = new ArrayList<>();
		try {
			String sql= "SELECT c.idcategoria, c.nombre, l.titulo FROM categoria c"
					+ " left join libroCategoria ci on c.idcategoria = ci.idcategoria"
					+ " left join libro l on l.numeroSerie = ci.libroNumeroSerie;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Categoria e = new Categoria();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				if(categorias.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					categorias.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Categoria();
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					categorias.add(e);
				}
				
				
				
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return categorias;
	}
	
	
	
	
	public static List<Categoria> filteredSearch(String filtro, String target){
		db.conectar();
		List<Categoria> categorias = new ArrayList<>();
		try {
			String sql= "SELECT nombre From categoria where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Categoria e = new Categoria();
				e.setName(rs.getString(1));
				categorias.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return categorias;
	}
	
	
	public static void update(Categoria ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE categoria set nombre = ? where nombre = ?";
			
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
			String sql ="DELETE FROM categoria where nombre = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setString(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
}
