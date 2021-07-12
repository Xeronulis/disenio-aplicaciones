package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.DireccionCliente;
import model.utils.DB;

public class DireccionClienteDAO {
private DB db= new DB();
	
	public void save (DireccionCliente dc) {
		db.conectar();
		try {
			String sql= "INSERT INTO direccionC(rutC,direccion) VALUES(?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, dc.getCliente().getRutC());//POSIBLE SOLUCION en vez de agregar el objeto cliente simplemente agregar el atributo
			st.setString(2, dc.getDireccionCliente()); // QUE corresponde.
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<DireccionCliente> getAll(){
		List<DireccionCliente> dcs = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT rutC,direccion FROM direccionC";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DireccionCliente de =  new DireccionCliente();
				//c.setCliente(rs.getString(1)); NUEVAMENTE EL ERRO DE NO PODER SETEAR EL ATRIBUTO QUE CORRESPONDE
				de.setDireccionCliente(rs.getString(2));
				dcs.add(de);	
			}
			rs.close();
			return dcs;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return dcs;
	}
	
	public void delete(DireccionCliente dc) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM direccionC WHERE rutC=? AND direccion=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, dc.getCliente().getRutC());
			st.setString(2, dc.getDireccionCliente());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
