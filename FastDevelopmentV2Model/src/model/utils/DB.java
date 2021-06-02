package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

		private Connection con;
		
		
		public boolean conectar() {
			try {
				
			//1. decirle a java que motor de base de datos estoy usando
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Generar un URL de conexion
			String url = "jdbc:mysql://localhost/fastdevelopmentdb?serverTimezone=UTC";
			
			//3. conectar a la base de datos
			con= DriverManager.getConnection(url,"root","mysql");
			return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
		} 
		
		public void desconectar() {
			try {
				con.close();
			} catch (Exception e) {
				
			}
		} 
		
		
		public Connection getCon() {
			return con;
		} 
}