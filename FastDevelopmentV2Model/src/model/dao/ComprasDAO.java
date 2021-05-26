package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Compras;
import model.utils.DB;

public class ComprasDAO {
private DB db= new DB();
	
	public void save (Compras c) {
		try {
			String sql= "INSERT INTO compras(idCompras,libro,precioConiva,folioF) VALUES(?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, c.getIdCompras());
			st.setInt(2, c.getLibro().getNumSerie());//problema al momento del select 
			st.setInt(3, c.getPrecioConIVA());
			st.setString(4, c.getFactura().getFolioF());//mismo problema con el libro
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Compras> getAll(){
		List<Compras> compras = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT idCompras,libro,precioConiva,folioF FROM compras";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Compras c =  new Compras();
				c.setIdCompras(rs.getInt(1));
				//c.setLibro(rs.getString(2)); problema para definir
				c.setPrecioConIVA(rs.getInt(3));
				//c.setFactura(rs.getString(4)); problema para definir
				compras.add(c);	
			}
			rs.close();
			return compras;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return compras;
	}
	
	public void delete(Compras c) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM compras WHERE idCompras=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, c.getIdCompras());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
