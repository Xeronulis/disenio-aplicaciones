package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Distribuidor;
import model.utils.DB;

public class DistribuidorDAO {

	private static DB db = new DB();
	
	public static void save(Distribuidor distribuidor) {

		db.conectar();
		
		try {
			String sql= "INSERT distribuidor(rut,nombreEmpresa,direccion,telefono,inicioDistribuidor)"
					+ " values(?,?,?,?,?);";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, distribuidor.getRut());
			st.setString(2, distribuidor.getNombre());
			st.setString(3, distribuidor.getDireccion());
			st.setInt(4, distribuidor.getTelefono());
			st.setDate(5, distribuidor.getAnioInicio());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	public static List<Distribuidor> getAll(){
		db.conectar();
		List<Distribuidor> distribuidores = new ArrayList<>();
		try {
			String sql= "SELECT d.iddistribuidor, rut,nombreEmpresa,direccion,telefono,inicioDistribuidor, idFactura from distribuidor d"
					+ "	left join Factura f on d.idDistribuidor = f.idDistribuidor;";
			
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Distribuidor e = new Distribuidor();
			while(rs.next()) {
				int iddistribuidor = rs.getInt(1);
				String rut = rs.getString(2);
				String nombre = rs.getString(3);
				String direccion = rs.getString(4);
				int telefono = rs.getInt(5);
				Date inicioD = rs.getDate(6);
				int idF = rs.getInt(7);
				
				
				if(distribuidores.isEmpty()) {
					e.setId(iddistribuidor);
					e.setRut(rut);
					e.setNombre(nombre);
					e.setDireccion(direccion);
					e.setTelefono(telefono);
					e.setAnioInicio(inicioD);
					e.addToIdFacturas(idF);
					distribuidores.add(e);
					
				}else if(e.getNombre().contentEquals(nombre)) {
					e.addToIdFacturas(idF);
					
				}else {
					e = new Distribuidor();
					e.setId(iddistribuidor);
					e.setRut(rut);
					e.setNombre(nombre);
					e.setDireccion(direccion);
					e.setTelefono(telefono);
					e.setAnioInicio(inicioD);
					e.addToIdFacturas(idF);
					distribuidores.add(e);
				}		
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return distribuidores;
	}
	
	
	
	
	public static List<Distribuidor> filteredSearch(String filtro, String target){
		db.conectar();
		List<Distribuidor> distribuidores = new ArrayList<>();
		try {
			String sql= "SELECT rut,nombreEmpresa,direccion,telefono,inicioDistribuidor from distribuidor"
					+ "	where LOWER("+filtro+") like '%"+target+"%';";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Distribuidor e = new Distribuidor();
				e.setRut(String.valueOf(rs.getInt(1)));
				e.setNombre(rs.getString(2));
				e.setDireccion(rs.getString(3));
				e.setTelefono(rs.getInt(4));
				e.setAnioInicio(rs.getDate(5));
				distribuidores.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return distribuidores;
	}
	
	
	public static void update(Distribuidor ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE distribuidor set"
					+ "	rut = ?,"
					+ " nombreEmpresa = '"+ed.getNombre()+"',"
					+ " direccion = '"+ed.getDireccion()+"',"
					+ " telefono = ?,"
					+ " inicioDistribuidor = ?"
					+ " where rut LIKE ? ";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getRut());
			st.setInt(2, ed.getTelefono());
			st.setDate(3, ed.getAnioInicio());
			st.setString(4, target);
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql ="DELETE from distribuidor"
					+ "	where rut = ?;";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			db.desconectar();
		}
		
		
	}
}
