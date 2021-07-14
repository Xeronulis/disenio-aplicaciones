package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Compras;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Compras. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class ComprasDAO {
	
	private DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param c: Objeto de clase Compras.
	 * Este metodo nos permite ingresar un Objeto de tipo Compras, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public void save (Compras c) {
		db.conectar();
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
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Compras que hemos
	 * agregado a la base de datos.
	 */
	
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
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param c: Objeto de clase Compras.
	 * Este metodo nos permite eliminar un Objeto de tipo Compras, para poder realizar esto 
	 * utilizamos el atributo del parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
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
