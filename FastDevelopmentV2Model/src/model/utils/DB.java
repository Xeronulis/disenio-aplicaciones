package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * En esta clase podemos ver los metodos necesarios para poder conectar nuestra aplicacion
 * a la base de datos donde mantenemos toda la informacion necesaria para la mantencion y funcionalidad
 * de la aplicacion
 * @author Grupo4
 * @version 11-07-2021
 */

public class DB {

		private Connection con;		
		/**
		 * El metodo conectar no recibe parametros. Este metodo nos permite realizar la 
		 * conexion con la base de datos a travez de la libreria de conexion SQL que nos facilita 
		 * java, el metodo realiza un return de booleano, es decir si la conexion se hizo con exito
		 * returna un true, caso contrario un false.
		 */
		public boolean conectar() {
			try {				
			//1. decirle a java que motor de base de datos estoy usando
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Generar un URL de conexion
			String url = "jdbc:mysql://localhost/fastdevelopmentdb?serverTimezone=UTC";			
			//3. conectar a la base de datos
			con= DriverManager.getConnection(url,"root","");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;				
			}
		} 
		/**
		 * El metodo desconectar no recibe parametros. Este metodo no retorna nada.
		 * Este metodo nos permite cerrar la conexion entre la base de datos y la aplicacion 
		 */
		public void desconectar() {
			try {
				con.close();
			} catch (Exception e) {
				
			}
		}
		/**
		 * El metodo getCon no recibe parametros. Este metodo nos permite obtener la conexion que 
		 * hay entre la base de datos y la aplicacion con su retorno 
		 */
		public Connection getCon() {
			return con;
		} 
}