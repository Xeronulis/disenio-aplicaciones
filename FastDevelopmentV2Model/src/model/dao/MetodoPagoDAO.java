package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.MetodoPago;
import model.utils.DB;

public class MetodoPagoDAO {
	private static DB db= new DB();
	
	public static void save(MetodoPago metodoPago) {
	
		db.conectar();
		
		try {
			String sql= "INSERT INTO metodoPago(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, metodoPago.getNombre());
	
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<MetodoPago> getAll(){
		db.conectar();
		List<MetodoPago> metodoPagos = new ArrayList<>();
		try {
			String sql= "SELECT mp.idmetodopago,nombre, idFactura from metodoPago mp"
					+ "	left join factura f on mp.idMetodoPago = f.idMetodoPago;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			MetodoPago mp = new MetodoPago();
			while(rs.next()) {
				int idMetodoPago = rs.getInt(1);
				String nombre = rs.getString(2);
				int idFactura = rs.getInt(3);
				
				if(metodoPagos.isEmpty()) {
					mp.setId(idMetodoPago);
					mp.setNombre(nombre);
					mp.addToFacturas(idFactura);;
					metodoPagos.add(mp);
					
				}else if(mp.getNombre().contentEquals(nombre)) {
					mp.addToFacturas(idFactura);
					
				}else {
					mp = new MetodoPago();
					mp.setId(idMetodoPago);
					mp.setNombre(nombre);
					mp.addToFacturas(idFactura);;
					metodoPagos.add(mp);
				}
				
				
				
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}

		return metodoPagos;
	}
	
	
	
	
	public static List<MetodoPago> filteredSearch(String filtro, String target){
		db.conectar();
		List<MetodoPago> metodoPagos = new ArrayList<>();
		try {
			String sql= "SELECT nombre From metodoPago where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				MetodoPago mp = new MetodoPago();
				mp.setNombre(rs.getString(1));
				metodoPagos.add(mp);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return metodoPagos;
	}
	
	
	public static void update(MetodoPago metodoPago, String target) {
		db.conectar();
		try {
			String sql = "UPDATE metodoPago set nombre = ? where nombre LIKE ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, metodoPago.getNombre());
			st.setString(2, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(String target) {
		db.conectar();
		try {
			String sql ="DELETE FROM metodoPago where nombre LIKE ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setString(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
}
