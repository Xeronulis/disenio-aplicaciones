package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Categoria;
import model.dto.Categoria;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Categoria. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class CategoriaDAO {
	
	private static DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param categ: Objeto de clase Categoria.
	 * Este metodo nos permite ingresar un Objeto de tipo Categoria, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public static void save(Categoria categ) {
	
		db.conectar();
		
		try {
			String sql= "INSERT INTO categoria(nombre) VALUES(?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setString(1, categ.getName());	
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Boleta que hemos
	 * agregado a la base de datos.
	 */
	
	public static List<Categoria> getAll(){
		db.conectar();
		List<Categoria> categorias = new ArrayList<>();
		try {
			String sql= "SELECT c.idcategoria, c.nombre, l.titulo FROM categoria c"
					+ " left join libroCategoria ci on c.idcategoria = ci.idcategoria"
					+ " left join libro l on l.numeroSerie = ci.libroNumeroSerie;";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Categoria e = new Categoria();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String titulo = rs.getString(3);
				
				if(categorias.isEmpty()) {
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					categorias.add(e);
					
				}else if(e.getName().contentEquals(nombre)) {
					e.addToLibros(titulo);
					
				}else {
					e = new Categoria();
					e.setId(id);
					e.setName(nombre);
					e.addToLibros(titulo);
					categorias.add(e);
				}					
			}			
			rs.close();						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return categorias;
	}
	
	/**
	 * El metodo filteredSearch recibe 2 parametros.
	 * @param filtro: Cadena de caracteres que utilizamos como filtro.
	 * @param target: Cadena de caracteres que contiene el nombre del objeto que se quiere buscar.
	 * Este metodo nos permite realizar un busqueda mas especifica dentro de todas las 
	 * categorias que se han ingresado a la base de datos
	 */		
	
	public static List<Categoria> filteredSearch(String filtro, String target){
		db.conectar();
		List<Categoria> categorias = new ArrayList<>();
		try {
			String sql= "SELECT nombre From categoria where LOWER("+filtro+")  like '%"+target+"%'";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Categoria e = new Categoria();
				e.setName(rs.getString(1));
				categorias.add(e);
			}
			rs.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		return categorias;
	}
	
	/**
	 * El metodo update recibe 2 parametros.
	 * @param ed: Objeto de clase Categoria.
	 * @param target: Cadena de caracteres que contiene el nombre del objeto que se quiere modificar
	 * Este metodo nos permite modificar el nombre de la categoria dentro de la base de datos.
	 */
	
	public static void update(Categoria ed, String target) {
		db.conectar();
		try {
			String sql = "UPDATE categoria set nombre = ? where nombre = ?";
			
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
	 * @param taregt: Cadena de caracteres de alguna categoria.
	 * Este metodo nos permite eliminar un Objeto de tipo Categoria, para poder realizar esto 
	 * utilizamos el parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public static void delete(String target) {
		db.conectar();
		try {
			String sql ="DELETE FROM categoria where nombre = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, target);
			st.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}				
	}
}
