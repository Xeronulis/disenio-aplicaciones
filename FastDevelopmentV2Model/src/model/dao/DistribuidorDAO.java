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
			st.setString(2, distribuidor.getName());
			st.setString(3, distribuidor.getDir());
			st.setInt(4, distribuidor.getTel());
			st.setInt(5, distribuidor.getStartYear());

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
				int inicioD = rs.getInt(6);
				int idF = rs.getInt(7);
				
				
				if(distribuidores.isEmpty()) {
					e.setId(iddistribuidor);
					e.setRut(rut);
					e.setName(nombre);
					e.setDir(direccion);
					e.setTel(telefono);
					e.setStartYear(inicioD);
					e.addToIdFacturas(idF);
					distribuidores.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToIdFacturas(idF);
					
				}else {
					e = new Distribuidor();
					e.setId(iddistribuidor);
					e.setRut(rut);
					e.setName(nombre);
					e.setDir(direccion);
					e.setTel(telefono);
					e.setStartYear(inicioD);
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
				e.setRut(rs.getString(1));
				e.setName(rs.getString(2));
				e.setDir(rs.getString(3));
				e.setTel(rs.getInt(4));
				e.setStartYear(rs.getInt(5));
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
					+ " nombreEmpresa = '"+ed.getName()+"',"
					+ " direccion = '"+ed.getDir()+"',"
					+ " telefono = ?,"
					+ " inicioDistribuidor = ?"
					+ " where rut LIKE ? ";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getRut());
			st.setInt(2, ed.getTel());
			st.setInt(3, ed.getStartYear());
			st.setString(4, target);
			
			
			st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(String target) {
		db.conectar();
		try {
			String sql ="DELETE from distribuidor"
					+ "	where rut = ?;";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			db.desconectar();
		}
		
		
	}
}
