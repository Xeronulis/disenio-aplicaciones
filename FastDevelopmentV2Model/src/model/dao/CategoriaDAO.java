package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Categoria;
import model.utils.DB;

public class CategoriaDAO {
private DB db= new DB();
	
	public void save (Categoria c) {
		try {
			String sql= "INSERT INTO categoria(numSerie,categoria) VALUES(?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, c.getLibro().getNumSerie());
			st.setString(2, c.getCategoria());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Categoria> getAll(){
		List<Categoria> categorias = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT numSerie,categoria FROM categoria";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Categoria c =  new Categoria();
				//c.setLibro(rs.getString(1)); no deja hacer setLibro.setNumSeire()
				c.setCategoria(rs.getString(2));
				categorias.add(c);	
			}
			rs.close();
			return categorias;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return categorias;
	}
	
	
	public void delete(Categoria c) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM boleta WHERE numSerie=? AND categoria=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, c.getLibro().getNumSerie());
			st.setString(2, c.getCategoria());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
