package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.DireccionCliente;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase DreccionCliente. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class DireccionClienteDAO {
	private DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param dc: Objeto de clase DireccionCliente.
	 * Este metodo nos permite ingresar un Objeto de tipo DireccionCliente, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public void save (DireccionCliente dc) {
		db.conectar();
		try {
			String sql= "INSERT INTO direccionC(rutC,direccion) VALUES(?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, dc.getCliente().getRutC());//POSIBLE SOLUCION en vez de agregar el objeto cliente simplemente agregar el atributo
			st.setString(2, dc.getDireccionCliente()); // QUE corresponde.
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase DireccionCliente que hemos
	 * agregado a la base de datos.
	 */
	
	public List<DireccionCliente> getAll(){
		List<DireccionCliente> dcs = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT rutC,direccion FROM direccionC";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DireccionCliente de =  new DireccionCliente();
				//c.setCliente(rs.getString(1)); NUEVAMENTE EL ERRO DE NO PODER SETEAR EL ATRIBUTO QUE CORRESPONDE
				de.setDireccionCliente(rs.getString(2));
				dcs.add(de);	
			}
			rs.close();
			return dcs;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		return dcs;
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param dc: Objeto de clase DireccionCliente.
	 * Este metodo nos permite eliminar un Objeto de tipo DireccionCliente, para poder realizar esto 
	 * utilizamos el atributo del parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public void delete(DireccionCliente dc) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM direccionC WHERE rutC=? AND direccion=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, dc.getCliente().getRutC());
			st.setString(2, dc.getDireccionCliente());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
