package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.dto.Boleta;
import model.utils.DB;

public class BoletaDAO {
private DB db= new DB();
	
	public void save (Boleta b) {
		db.conectar();
		try {
			String sql= "INSERT INTO biblioteca(folioB,metodoPago,horaCompra,fechaCompra,totalConIva) VALUES(?,?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, b.getFolioB());
			st.setString(2, b.getMetodoPago());
			//st.setString(3, b.getHoraCompra()); en modelo sale como VARCHAR deberia ser date??
			//st.setString(4, b.getFechaCompra());sigo sin saber como pasarle la fecha
			st.setInt(5, b.getTotalConIVA());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	public List<Boleta> getAll(){
		List<Boleta> boletas = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT folioB,metodoPago,horaCompra,fechaCompra,totalConIva FROM boleta";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Boleta b =  new Boleta();
				b.setFolioB(rs.getString(1));
				b.setMetodoPago(rs.getString(2));
				//b.setHoraCompra(rs.getInt(3)); HORA
				//b.setFechaCompra(rs.getString(4)); FECHA
				b.setTotalConIVA(5);
				boletas.add(b);	
			}
			rs.close();
			return boletas;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return boletas;
	}
	
	
	public void delete(Boleta b) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM boleta WHERE folioB=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, b.getFolioB());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
