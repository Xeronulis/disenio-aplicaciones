package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Biblioteca;
import model.utils.DB;

/**
 * En esta clase podemos revisar el funcionamiento de las sentencias DML, las cuales 
 * son necesarias para poder hacer funcionar el CRUD de la clase Biblioteca. Tambien podemos ver
 * como se definen las sentencias SQL necesarias para poder interactuar con la base de datos y los
 * datos que ella almacena.
 * @param db: Es el objeto que nos permite realizar la conexion con la base de datos. 
 * @author Grupo4
 * @version 11-07-2021
 */

public class BibliotecaDAO {

	private DB db= new DB();
	
	/**
	 * El metodo save recibe un parametro.
	 * @param b: Objeto de clase Biblioteca.
	 * Este metodo nos permite ingresar un Objeto de tipo Biblioteca, para poder realizar esto 
	 * utilizamos los getters del objeto para asi poder ingresar los datos correspondientes del
	 * objeto en la sentencia SQL que es enviada a la base de datos.
	 */
	
	public void save (Biblioteca b) {		
		db.conectar();
		try {
			String sql= "INSERT INTO biblioteca(idBiblio,direccion,telefono) VALUES(?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, b.getIdBiblio());
			st.setString(2, b.getDireccion());
			st.setInt(3, b.getTelefono());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
	}
	
	/**
	 * El metodo getAll no recibe parametros.
	 * Este metodo nos retorna una lista con todos los objetos de la clase Biblioteca que hemos
	 * agregado a la base de datos.
	 */
	public List<Biblioteca> getAll(){
		List<Biblioteca> biblios = new ArrayList<>();
		db.conectar();
		try {
			String sql= "SELECT idBiblio,direccion,telefono FROM biblioteca";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			//AQUI TENDRIAN QUE AGREGAR LOS CAMPO PARA EL WHERE, SI LO HUBIESE
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Biblioteca b =  new Biblioteca();
				b.setIdBiblio(rs.getInt(1));
				b.setDireccion(rs.getString(2));
				b.setTelefono(rs.getInt(3));
				biblios.add(b);	
			}
			rs.close();
			return biblios;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.desconectar();
		}
		
		return biblios;
	}
	
	/**
	 * El metodo delete recibe un parametro.
	 * @param b: Objeto de clase biblioteca .
	 * Este metodo nos permite eliminar un Objeto de tipo Biblioteca, para poder realizar esto 
	 * utilizamos el atributo del parametro entregado que contiene la clave unica para poder 
	 * idetificar el objeto dentro de la base de datos, una vez esto ocurre se agrega la clave unica
	 * a la sentencia SQL para eliminar los datos del objeto en la base de datos
	 */
	
	public void delete(Biblioteca b) {
		try {
			db.conectar();
			//Proceso de inserccion
			String sql= "DELETE FROM biblioteca WHERE idBiblio=?";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			st.setInt(1, b.getIdBiblio());
			st.executeUpdate();
		} catch (Exception e) {
			
		}finally {
			db.desconectar();
		}
	}
}
