package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Distribuidor;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Distribuidor. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class DistribuidorDAO {

	private static DB db = new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param distribuidor: Objeto de clase Distribuidor.
	 * Este metodo nos permite ingresar un Objeto de tipo Distribuidor, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
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
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Distribuidor que hemos
	 * agregado a la base de datos.
	 */
	
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
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de todos los 
	 * distribuidores que se han ingresado a la base de datos
	 */	
	
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
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param ed: Objeto de tipo Distribuidor.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite modificar el rut,nombre de la empresa, direccion, telefono y 
	 * desde cuando vende libros a la biblioteca dentro de la base de datos.
	 */
	
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
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param target: Cadena de caracteres que contiene el rut de algun Distribuidor.
	 * Este metodo nos permite eliminar un Objeto de tipo Distribuidor, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
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
