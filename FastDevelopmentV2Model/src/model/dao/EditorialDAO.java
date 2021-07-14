package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Editorial;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Editorial. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class EditorialDAO {

	private static DB db = new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param editorial: Objeto de clase Editorial.
	 * Este metodo nos permite ingresar un Objeto de tipo Editorial, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save(Editorial editorial) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO editorial(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, editorial.getName());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}	
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Editorial que hemos
	 * agregado a la base de datos.
	 */
	
	public static List<Editorial> getAll(){
		db.conectar();
		List<Editorial> editoriales = new ArrayList<>();
		try {
			String sql= "SELECT e.idEditorial, e.nombre, l.titulo FROM editorial e"
					+ " LEFT JOIN libro l on l.idEditorial = e.idEditorial;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Editorial e = new Editorial();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				
				if(editoriales.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					editoriales.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Editorial();
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					editoriales.add(e);
				}	
			}
			rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return editoriales;
	}
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de las 
	 * editoriales que se han ingresado a la base de datos
	 */	
	
	public static List<Editorial> filteredSearch(String filtro, String target){
		db.conectar();
		List<Editorial> editoriales = new ArrayList<>();
		try {
			String sql= "SELECT nombre From editorial where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Editorial e = new Editorial();
				e.setName(rs.getString(1));
				editoriales.add(e);
			}
			rs.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return editoriales;
	}
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param ed: Objeto de tipo Editorial.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite modificar el nombre de la editorial dentro de la base de datos.
	 */
	
	public static void update(Editorial ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE editorial set nombre = ? where nombre LIKE ?";
			
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
	 * @param target: Valor numerico que contiene el id de alguna editorial.
	 * Este metodo nos permite eliminar un Objeto de tipo Editorial, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql ="DELETE FROM editorial where idEditorial = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, target);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}	
	}
}
