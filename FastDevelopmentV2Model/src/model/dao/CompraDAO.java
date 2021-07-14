package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Categoria;
import model.dto.Compra;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Compra. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class CompraDAO {
	
	private static DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param c: Objeto de clase Compra.
	 * Este metodo nos permite ingresar un Objeto de tipo Compra, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save (Compra c) {
		db.conectar();
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
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Comrpa que hemos
	 * agregado a la base de datos.
	 */
	
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
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: valor numerico que utilizamos como filtro.
	 * @param target: valor numerico que contiene el id del objeto que se quiere buscar.
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de todas las 
	 * compras que se han ingresado a la base de datos
	 */		
	
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
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param c: Objeto de clase Compra.
	 * @param target: Valor numerico que contiene el nombre del objeto que se quiere modificar
	 * Este metodo nos permite modificar el id de la factura y el numero de serie del libro asociado
	 * a la Compra que se guardo dentro de la base de datos.
	 */
	
	
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
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param c: Objeto de clase Compra .
	 * Este metodo nos permite eliminar un Objeto de tipo Compra, para poder realizar esto 
	 * utilizamos el atributo del parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
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
