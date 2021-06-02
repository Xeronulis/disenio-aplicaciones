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
			st.setString(1, autor.getNombre());
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
			String sql= "SELECT a.nombre, a.apellidoPaterno, a.apellidoMaterno, l.titulo from autor a"
					+ " left join autorLibro al on a.idAutor = al.idAutor"
					+ " left join libro l on l.numeroSerie = al.libroNumeroSerie;";
			
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Autor e = new Autor();
			while(rs.next()) {
				String nombre = rs.getString(1);
				String apellidoP = rs.getString(2);
				String apellidoM = rs.getString(3);
				String titulo = rs.getString(4);
				
				if(autores.isEmpty()) {
					e.setNombre(nombre);
					e.setApellidoP(apellidoP);
					e.setApellidoM(apellidoM);
					e.addToLibros(titulo);
					autores.add(e);
					
				}else if(e.getNombre().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Autor();
					e.setNombre(nombre);
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
				e.setNombre(rs.getString(1));
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
	
	
	public static void update(Autor ed, String[] target) {
		db.conectar();
		try {
			String sql = "UPDATE autor set"
					+ " nombre = '"+ed.getNombre()+"',"
					+ " apellidoPaterno = '"+ed.getApellidoP()+"',"
					+ " apellidoMaterno = '"+ed.getApellidoM()+"' "
					+ " where nombre Like '"+target[0]+"' and apellidoPaterno like '"+target[1]+"' and apellidoMaterno like '"+target[2]+"';";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);

			
			st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(String[] target) {
		db.conectar();
		try {
			String sql ="DELETE FROM autor WHERE"
					+" nombre Like '"+target[0]+"' and apellidoPaterno like '"+target[1]
							+"' and apellidoMaterno like '"+target[2]+"'";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
}
