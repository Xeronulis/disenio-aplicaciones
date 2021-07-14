package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Estado;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Estado. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class EstadoDAO {
	
	private static DB db = new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param estado: Objeto de clase Estado.
	 * Este metodo nos permite ingresar un Objeto de tipo Estado, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save(Estado estado) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO estadoLibro(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, estado.getName());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Estado que hemos
	 * agregado a la base de datos.
	 */
	
	public static List<Estado> getAll(){
		db.conectar();
		List<Estado> estados = new ArrayList<>();
		try {
			String sql= "SELECT e.idEstadoLibro, e.nombre, l.titulo FROM estadoLibro e"
				    + " LEFT JOIN libro l on l.idestadoLibro = e.idEstadoLibro;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Estado e = new Estado();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				if(estados.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					estados.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Estado();
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					estados.add(e);
				}	
			}	
			rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return estados;
	}
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de los 
	 * estados que se han ingresado a la base de datos
	 */	
	
	public static List<Estado> filteredSearch(String filtro, String target){
		db.conectar();
		List<Estado> estados = new ArrayList<>();
		try {
			String sql= "SELECT nombre From estadoLibro where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Estado e = new Estado();
				e.setName(rs.getString(1));
				estados.add(e);
			}
			rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return estados;
	}
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param ed: Objeto de tipo Estado.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite modificar el nombre del estado dentro de la base de datos.
	 */
	
	public static void update(Estado ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE estadoLibro set nombre = ? where nombre = ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getName());
			st.setString(2, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}	
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param target: Cadena de caracteres que contiene el nombre del estado.
	 * Este metodo nos permite eliminar un Objeto de tipo Estado, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public static void delete(String target) {
		db.conectar();
		try {
			String sql ="DELETE FROM estadoLibro where nombre = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, target);
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}	
	}
}
