package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Biblioteca;
import model.utils.DB;

public class BibliotecaDAO {

private DB db= new DB();
	
	public void save (Biblioteca b) {
		try {
			String sql= "INSERT INTO biblioteca(idBiblio,direccion,telefono) VALUES(?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, b.getIdBiblio());
			st.setString(2, b.getDireccion());
			st.setInt(3, b.getTelefono());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Biblioteca> getAll(){
		List<Biblioteca> biblios = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT idBiblio,direccion,telefono FROM biblioteca";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Biblioteca b =  new Biblioteca();
				b.setIdBiblio(rs.getInt(1));
				b.setDireccion(rs.getString(2));
				b.setTelefono(rs.getInt(3));
				biblios.add(b);	
			}
			rs.close();
			return biblios;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return biblios;
	}
	
	
	public void delete(Biblioteca b) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM biblioteca WHERE idBiblio=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, b.getIdBiblio());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
