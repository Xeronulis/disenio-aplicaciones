package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Categoria;
import model.dto.Compra;
import model.utils.DB;

public class CompraDAO {
	private static DB db= new DB();
	
	public static void save (Compra c) {
		try {
			String sql= "INSERT INTO compra(libroNumeroSerie,idFactura) VALUES(?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, c.getIdLibro());
			st.setInt(2, c.getIdFactura());
			
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Compra> getAll(){
		List<Compra> compras = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT libroNumeroSerie, idFactura, precioNeto, precioConIva, costoIva FROM compra order by idFactura;";
			PreparedStatement st = db.getCon().prepareStatement(sql);	
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				Compra c =  new Compra();
				
				c.setIdLibro(rs.getInt(1));
				c.setIdFactura(rs.getInt(2));
				c.setPrecioNeto(rs.getDouble(3));
				c.setPrecioConIVA(rs.getDouble(4));
				c.setCostoIva(rs.getDouble(5));
				
				compras.add(c);
			}
			rs.close();
			return compras;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return compras;
	}
	
	public static List<Compra> filteredSearch(int filtro, int target){
		List<Compra> compras = getAll();
		
		/*
		db.conectar();
		List<Compra> compras = new ArrayList<Compra>();
		try {
			String sql= "SELECT libroNumeroSerie, idFactura, precioNeto, precioConIva, costoIva From compra where ? = ?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			st.setInt(1, filtro);
			st.setInt(2, target);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Compra c = new Compra();
				c.setIdLibro(rs.getInt(1));
				c.setIdFactura(rs.getInt(2));
				c.setPrecioNeto(rs.getDouble(3));
				c.setPrecioConIVA(rs.getDouble(4));
				c.setCostoIva(rs.getDouble(5));
				
				compras.add(c);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		*/
		return compras;
	}
	
	
	
	
	public static void update(Compra c, int target[]) {
		db.conectar();
		try {
			String sql = "UPDATE compra set "
					+ " idFactura = ?,"
					+ " libroNumeroSerie = ?"
					+ " where idFactura = ? and libroNumeroSerie = ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, c.getIdFactura());
			st.setInt(2, c.getIdLibro());
			
			st.setInt(3, target[0]);
			st.setInt(4, target[1]);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
	
	
	public static void delete(Compra c) {
		db.conectar();
		try {
			String sql= "DELETE FROM compra WHERE libroNumeroSerie = ? and idFactura = ?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, c.getIdLibro());
			st.setInt(2, c.getIdFactura());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
