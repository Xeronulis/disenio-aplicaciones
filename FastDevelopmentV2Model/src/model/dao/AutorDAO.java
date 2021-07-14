package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.dto.Autor;
import model.dto.Autor;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Autor. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class AutorDAO {
		
	private static DB db = new DB();	
	
	/**
	 * El metodo save recibe un parametro.
	 * @param autor: Objeto de clase Autor.
	 * Este metodo nos permite ingresar un Objeto de tipo Autor, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save(Autor autor) {
	
		db.conectar();
		
		try {
			String sql= "INSERT INTO autor(nombre, apellidoPaterno, apellidoMaterno) VALUES(?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, autor.getName());
			st.setString(2, autor.getApellidoP());
			st.setString(3, autor.getApellidoM());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Autor que hemos
	 * agregado a la base de datos.
	 */
	public static List<Autor> getAll(){
		db.conectar();
		List<Autor> autores = new ArrayList<>();
		try {
			String sql= "SELECT a.idAutor, a.nombre, a.apellidoPaterno, a.apellidoMaterno, l.titulo from autor a"
					+ " left join autorLibro al on a.idAutor = al.idAutor"
					+ " left join libro l on l.numeroSerie = al.libroNumeroSerie;";
			
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Autor e = new Autor();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidoP = rs.getString(3);
				String apellidoM = rs.getString(4);
				String titulo = rs.getString(5);
				
				if(autores.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.setApellidoP(apellidoP);
					e.setApellidoM(apellidoM);
					e.addToLibros(titulo);
					autores.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Autor();
					e.setId(id);
					e.setName(nombre);
					e.setApellidoP(apellidoP);
					e.setApellidoM(apellidoM);
					e.addToLibros(titulo);
					autores.add(e);
				}		
			}
			rs.close();					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return autores;
	}
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de todos los 
	 * autores que se han ingresado a la base de datos
	 */	
	
	public static List<Autor> filteredSearch(String filtro, String target){
		db.conectar();
		List<Autor> autores = new ArrayList<>();
		try {
			String sql= "SELECT nombre, apellidoPaterno, apellidoMaterno from autor where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);	
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Autor e = new Autor();
				e.setName(rs.getString(1));
				e.setApellidoP(rs.getString(2));
				e.setApellidoM(rs.getString(3));
				autores.add(e);
			}		
			rs.close();				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return autores;
	}
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param ed: Objeto de clase Autor.
	 * @param target: Clave unica del objeto que se quiere modificar
	 * Este metodo nos permite modificar el nombre, apellido paterno y apellido materno del autor
	 * dentro de la base de datos.
	 */
	
	public static void update(Autor ed, int target) {
		db.conectar();
		try {
			String sql = "UPDATE autor set"
					+ " nombre = '"+ed.getName()+"',"
					+ " apellidoPaterno = '"+ed.getApellidoP()+"',"
					+ " apellidoMaterno = '"+ed.getApellidoM()+"' "
					+ " where idAutor = ?;";
			
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1, target);			
			st.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}				
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param target: Valor numerico que contiene el id de algun autor..
	 * Este metodo nos permite eliminar un Objeto de tipo Autor, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public static void delete(int target) {
		db.conectar();
		try {
			String sql ="DELETE FROM autor"
					+ "WHERE idAutor = ?";
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
