package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Idioma;
import model.dto.Idioma;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Idioma. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */


public class IdiomaDAO {

	private static DB db = new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param idio: Objeto de clase Idioma.
	 * Este metodo nos permite ingresar un Objeto de tipo Idioma, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save(Idioma idio) {

		db.conectar();
		
		try {
			String sql= "INSERT INTO idioma(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, idio.getName());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Idioma que hemos
	 * agregado a la base de datos.
	 */
	
	public static List<Idioma> getAll(){
		db.conectar();
		List<Idioma> idiomas = new ArrayList<>();
		try {
			String sql= "SELECT i.idIdioma, i.nombre, l.titulo FROM idioma i"
					+ " left join libroIdioma li on i.idIdioma = li.idIdioma"
					+ " left join libro l on l.numeroSerie = li.libroNumeroSerie;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Idioma e = new Idioma();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				if(idiomas.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					idiomas.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Idioma();
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					idiomas.add(e);
				}
				
				
				
			}
			
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return idiomas;
	}

	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de los 
	 * idiomas que se han ingresado a la base de datos
	 */	
		
	
	public static List<Idioma> filteredSearch(String filtro, String target){
		db.conectar();
		List<Idioma> idiomas = new ArrayList<>();
		try {
			String sql= "SELECT nombre From idioma where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Idioma e = new Idioma();
				e.setName(rs.getString(1));
				idiomas.add(e);
			}
			
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return idiomas;
	}
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param ed: Objeto de tipo Idioma.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite modificar el nombre del idioma dentro de la base de datos.
	 */
	
	public static void update(Idioma ed, int target) {
		db.conectar();
		try {
			String sql = "UPDATE idioma set nombre = ? where idIdioma = ?";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, ed.getName());
			st.setInt(2, target);
			
			st.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param target: Valor numerico que contiene el id del idioma.
	 * Este metodo nos permite eliminar un Objeto de tipo Idioma, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql ="DELETE FROM idioma where idIdioma = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setInt(1, target);
			
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
}
