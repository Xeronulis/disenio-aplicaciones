package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.MetodoPago;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase MetodoPago. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class MetodoPagoDAO {
	private static DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param metodoPago: Objeto de clase MetodoPago.
	 * Este metodo nos permite ingresar un Objeto de tipo metodoPago, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */	
	
	public static void save(MetodoPago metodoPago) {
	
		db.conectar();
		
		try {
			String sql= "INSERT INTO metodoPago(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, metodoPago.getName());
	
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase MetodoPago que hemos
	 * agregado a la base de datos.
	 */
	
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
					mp.setName(nombre);
					mp.addToFacturas(idFactura);;
					metodoPagos.add(mp);
					
				}else if(mp.getName().contentEquals(nombre)) {
					mp.addToFacturas(idFactura);
					
				}else {
					mp = new MetodoPago();
					mp.setId(idMetodoPago);
					mp.setName(nombre);
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
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de los 
	 * metodos de pago que se han ingresado a la base de datos
	 */	
	
	public static List<MetodoPago> filteredSearch(String filtro, String target){
		db.conectar();
		List<MetodoPago> metodoPagos = new ArrayList<>();
		try {
			String sql= "SELECT nombre From metodoPago where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				MetodoPago mp = new MetodoPago();
				mp.setName(rs.getString(1));
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
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param metodoPago: Objeto de tipo MetodoPago.
	 * @param target: Clave unica del objeto.
	 * Modifica el nombre del metodo de pago donde el valor ingresado en el parametro target sea
	 * igual a la clave unica dentro de la base de datos
	 */
	
	public static void update(MetodoPago metodoPago, String target) {
		db.conectar();
		try {
			String sql = "UPDATE metodoPago set nombre = ? where nombre LIKE ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, metodoPago.getName());
			st.setString(2, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
			
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param target: Cadena de caracteres que contiene el id del libro.
	 * Este metodo nos permite eliminar un Objeto de tipo MetodoPago, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
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
