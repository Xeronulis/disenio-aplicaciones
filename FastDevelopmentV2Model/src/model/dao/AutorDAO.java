package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.dto.Autor;
import model.utils.DB;

public class AutorDAO {
private DB db= new DB();
	
	public void save (Autor a) {
		try {
			String sql= "INSERT INTO autores(rutA,nombre,apellidoP,apellidoM) VALUES(?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, a.getRutAutor());
			st.setString(2, a.getNombreAutor());
			st.setString(3, a.getApellidoP());
			st.setString(4, a.getApellidoM());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Autor> getAll(){
		List<Autor> autores = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT rutA,nombre,apellidoP,apellidoM FROM autores";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Autor a =  new Autor();
				a.setRutAutor(rs.getString(1));
				a.setNombreAutor(rs.getString(2));
				a.setApellidoP(rs.getString(3));
				a.setApellidoM(rs.getString(4));
				autores.add(a);	
			}
			rs.close();
			return autores;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return autores;
	}
	
	
	public void delete(Autor a) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM autores WHERE rutA=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, a.getRutAutor());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
