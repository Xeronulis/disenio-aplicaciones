package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.dto.Arriendo;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Arriendo. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @author Grupo4
 * @version 11-07-2021
 */

public class ArriendoDAO {

	private DB db= new DB();
	
	
	public void save (Arriendo arriendo) {
		db.conectar();
		try {
			String sql= "INSERT INTO arriendo(idArriendo,fechaEntrega,fechaDevolucion,fechaArriendo) VALUES(?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, arriendo.getIdArriendo());
			//st.setDate(2, arriendo.getFechaEntrega()); NI IDEA como agregar la fecha
			//st.setDate(3, arriendo.getFechaDevolucion());
			//st.setDate(4, arriendo.getFechaArriendo());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Arriendo> getAll(){
		List<Arriendo> arriendo = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT idArriendo,fechaEntrega,fechaDevolucion,fechaArriendo FROM arriendo";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Arriendo a =  new Arriendo();
				a.setIdArriendo(rs.getInt(1));
				//a.setFechaEntrega(rs.getString(2));
				//a.setFechaDevolucion(rs.getString(3));
				//a.setFechaArriendo(rs.getString(4));
				arriendo.add(a);	
			}
			rs.close();
			return arriendo;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return arriendo;
	}
	
	
	public void delete(Arriendo arriendo) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM arriendo WHERE idArriendo=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, arriendo.getIdArriendo());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
