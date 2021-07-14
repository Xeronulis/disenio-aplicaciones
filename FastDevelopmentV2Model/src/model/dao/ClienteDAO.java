package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Cliente;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Cliente. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class ClienteDAO {
	private DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param c: Objeto de clase Cliente.
	 * Este metodo nos permite ingresar un Objeto de tipo Cliente, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public void save (Cliente c) {
		db.conectar();
		try {
			String sql= "INSERT INTO cliente(rutC,fechaNacimiento,nombre,apellidoP,apellidoM) VALUES(?,?,?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, c.getRutC());
			//st.setString(2, c.getFechaNacimiento()); Fecha
			st.setString(3, c.getNombreC());
			st.setString(4, c.getApellidoP());
			st.setString(5, c.getApellidoM());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}		
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Cliente que hemos
	 * agregado a la base de datos.
	 */
	
	public List<Cliente> getAll(){
		List<Cliente> clientes = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT rutC,fechaNacimiento,nombre,apellidoP,apellidoM FROM cliente";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cliente c =  new Cliente();
				c.setRutC(rs.getString(1));
				//c.setFechaNacimiento(rs.getString(2)); FECHA
				c.setNombreC(rs.getString(3));
				c.setApellidoP(rs.getString(4));
				c.setApellidoM(rs.getString(5));
				clientes.add(c);	
			}
			rs.close();
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}		
		return clientes;
	}	
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param c: Objeto de clase Cliente.
	 * Este metodo nos permite eliminar un Objeto de tipo Cliente, para poder realizar esto 
	 * utilizamos el atributo del parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public void delete(Cliente c) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM cliente WHERE rutC=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, c.getRutC());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
