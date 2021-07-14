package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.dto.Boleta;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Boleta. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class BoletaDAO {
	private DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param b: Objeto de clase Boleta.
	 * Este metodo nos permite ingresar un Objeto de tipo Boleta, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */

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
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Boleta que hemos
	 * agregado a la base de datos.
	 */
	
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
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param b: Objeto de clase Boleta.
	 * Este metodo nos permite eliminar un Objeto de tipo Boleta, para poder realizar esto 
	 * utilizamos el atributo del parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
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
