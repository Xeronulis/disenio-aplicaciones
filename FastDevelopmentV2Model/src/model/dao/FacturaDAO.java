package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.dto.Compra;
import model.dto.Factura;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Factura. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */


public class FacturaDAO {
	
	private static DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param f: Objeto de clase Factura.
	 * Este metodo nos permite ingresar un Objeto de tipo Factura, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save (Factura f) {
		db.conectar();
		try {
			String sql= "INSERT INTO factura(folio,iddistribuidor,fechaCompra,horaCompra,idMetodoPago) VALUES(?,?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, f.getFolio());
			st.setInt(2, f.getIdDistribuidor());
			st.setDate(3, f.getFechaCompra());
			st.setTime(4, f.getHoraCompra());
			st.setInt(5, f.getIdMetodoPago());
			
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Factura que hemos
	 * agregado a la base de datos.
	 */
	
	public static List<Factura> getAll(){
		List<Factura> facturas = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT f.idFactura, iddistribuidor, folio, fechaCompra, horaCompra, idMetodoPago, costoTotal, libroNumeroSerie FROM factura f"
					+ " left join compra c on f.idFactura = c.idFactura;";
			PreparedStatement st = db.getCon().prepareStatement(sql);	
			ResultSet rs = st.executeQuery();
		
			
			Factura f =  new Factura();
			while(rs.next()) {
				int idFactura = rs.getInt(1);
				int idDistribuidor = rs.getInt(2);
				int folio = rs.getInt(3);
				Date fechaCompra = rs.getDate(4);
				Time horaCompra = rs.getTime(5);
				int idMetodoPago = rs.getInt(6);
				double costoTotal = rs.getDouble(7);
				int libroNumeroSerie = rs.getInt(8);
				
				if(facturas.isEmpty()) {
					Compra c = new Compra();
					c.setIdFactura(idFactura);
					c.setIdLibro(libroNumeroSerie);
					f.setIdFactura(idFactura);
					f.setFolio(folio);
					f.setIdDistribuidor(idDistribuidor);
					f.setFechaCompra(fechaCompra);
					f.setHoraCompra(horaCompra);
					f.setIdMetodoPago(idMetodoPago);
					f.setCostoTotal(costoTotal);
					f.addToCompras(c);
					facturas.add(f);
				}else if(f.getIdFactura() == idFactura) {
					Compra c = new Compra();
					c.setIdFactura(idFactura);
					c.setIdLibro(libroNumeroSerie);
					f.addToCompras(c);
					
				}else {
					f = new Factura();
					Compra c = new Compra();
					c.setIdFactura(idFactura);
					c.setIdLibro(libroNumeroSerie);
					f.setIdFactura(idFactura);
					f.setFolio(folio);
					f.setIdDistribuidor(idDistribuidor);
					f.setFechaCompra(fechaCompra);
					f.setHoraCompra(horaCompra);
					f.setIdMetodoPago(idMetodoPago);
					f.setCostoTotal(costoTotal);
					f.addToCompras(c);
					facturas.add(f);
				}		
			}
			rs.close();
			return facturas;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return facturas;
	}
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de las 
	 * facturas que se han ingresado a la base de datos
	 */	
	
	public static List<Factura> filteredSearch(String filtro, String target){
		db.conectar();
		List<Factura> facturas = getAll();
		return facturas;
	}
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param f: Objeto de tipo Factura.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite modificar el id del distribuidor, el folio, la fecha de compra,
	 * la hora de la compra y el metodo de pago dentro de la base de datos.
	 */
	
	public static void update(Factura f, int target) {
		db.conectar();
		try {
			String sql = "UPDATE factura set "
					+ " iddistribuidor = ?,"
					+ "	folio = ?,"
					+ "	fechaCompra = ?,"
					+ "	horaCompra = ?,"
					+ "	idMetodoPago = ?"
					+ " where idFactura = ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, f.getIdDistribuidor());
			st.setInt(2, f.getFolio());
			st.setDate(3, f.getFechaCompra());
			st.setTime(4, f.getHoraCompra());
			st.setInt(5, f.getIdMetodoPago());
			
			st.setInt(6, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param target: Valor numerico que contiene el id de la factura.
	 * Este metodo nos permite eliminar un Objeto de tipo Factura, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql= "DELETE FROM factura WHERE idFactura = ?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, target);
			
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
