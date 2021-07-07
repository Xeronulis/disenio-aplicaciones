package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.DireccionEmpleado;
import model.utils.DB;

public class DireccionEmpleadoDAO {
private DB db= new DB();
	
	public void save (DireccionEmpleado de) {
		db.conectar();
		try {
			String sql= "INSERT INTO direccionC(rutE,direccion) VALUES(?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, de.getEmpleado().getRutE());//POSIBLE SOLUCION en vez de agregar el objeto cliente simplemente agregar el atributo
			st.setString(2, de.getDireccionEmpleado()); // QUE corresponde.
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<DireccionEmpleado> getAll(){
		List<DireccionEmpleado> des = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT rutE,direccion FROM direccionE";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DireccionEmpleado de =  new DireccionEmpleado();
				//de.setEmpleado(rs.getString(1)); NUEVAMENTE EL ERROr DE NO PODER SETEAR EL ATRIBUTO QUE CORRESPONDE
				de.setDireccionEmpleado(rs.getString(2));
				des.add(de);	
			}
			rs.close();
			return des;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return des;
	}
	
	public void delete(DireccionEmpleado de) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM direccionC WHERE rutE=? AND direccion=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, de.getEmpleado().getRutE());
			st.setString(2, de.getDireccionEmpleado());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
