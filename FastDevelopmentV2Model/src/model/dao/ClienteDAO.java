package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Cliente;
import model.utils.DB;

public class ClienteDAO {
private DB db= new DB();
	
	public void save (Cliente c) {
		try {
			String sql= "INSERT INTO cliente(rutC,fechaNacimiento,nombre,apellidoP,apellidoM) VALUES(?,?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, c.getRutC());
			//st.setString(2, c.getFechaNacimiento()); Fecha
			st.setString(3, c.getNombreC());
			st.setString(4, c.getApellidoP());
			st.setString(5, c.getApellidoM());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Cliente> getAll(){
		List<Cliente> clientes = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT rutC,fechaNacimiento,nombre,apellidoP,apellidoM FROM cliente";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cliente c =  new Cliente();
				c.setRutC(rs.getString(1));
				//c.setFechaNacimiento(rs.getString(2)); FECHA
				c.setNombreC(rs.getString(3));
				c.setApellidoP(rs.getString(4));
				c.setApellidoM(rs.getString(5));
				clientes.add(c);	
			}
			rs.close();
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return clientes;
	}
	
	
	public void delete(Cliente c) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM cliente WHERE rutC=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, c.getRutC());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
