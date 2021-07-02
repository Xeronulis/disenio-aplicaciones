package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.dto.Autor;
import model.dto.Autor;
import model.utils.DB;

public class AutorDAO {
	private static DB db = new DB();
	
	public static void save(Autor autor) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO autor(nombre, apellidoPaterno, apellidoMaterno) VALUES(?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, autor.getName());
			st.setString(2, autor.getApellidoP());
			st.setString(3, autor.getApellidoM());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Autor> getAll(){
		db.conectar();
		List<Autor> autores = new ArrayList<>();
		try {
			String sql= "SELECT a.idAutor, a.nombre, a.apellidoPaterno, a.apellidoMaterno, l.titulo from autor a"
					+ " left join autorLibro al on a.idAutor = al.idAutor"
					+ " left join libro l on l.numeroSerie = al.libroNumeroSerie;";
			
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Autor e = new Autor();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidoP = rs.getString(3);
				String apellidoM = rs.getString(4);
				String titulo = rs.getString(5);
				
				if(autores.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.setApellidoP(apellidoP);
					e.setApellidoM(apellidoM);
					e.addToLibros(titulo);
					autores.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Autor();
					e.setId(id);
					e.setName(nombre);
					e.setApellidoP(apellidoP);
					e.setApellidoM(apellidoM);
					e.addToLibros(titulo);
					autores.add(e);
				}		
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return autores;
	}
	
	
	
	
	public static List<Autor> filteredSearch(String filtro, String target){
		db.conectar();
		List<Autor> autores = new ArrayList<>();
		try {
			String sql= "SELECT nombre, apellidoPaterno, apellidoMaterno from autor where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Autor e = new Autor();
				e.setName(rs.getString(1));
				e.setApellidoP(rs.getString(2));
				e.setApellidoM(rs.getString(3));
				autores.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return autores;
	}
	
	
	public static void update(Autor ed, int target) {
		db.conectar();
		try {
			String sql = "UPDATE autor set"
					+ " nombre = '"+ed.getName()+"',"
					+ " apellidoPaterno = '"+ed.getApellidoP()+"',"
					+ " apellidoMaterno = '"+ed.getApellidoM()+"' "
					+ " where idAutor = ?;";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql ="DELETE FROM autor"
					+ "WHERE idAutor = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setInt(1, target);
			
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
}
