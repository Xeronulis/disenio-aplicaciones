package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.dto.Autor;
import model.dto.Libro;
import model.utils.DB;

public class LibroDAO {

private static DB db = new DB();
	
	public static void save(Libro libro) {

		db.conectar();
		
		try {
			
			List<Integer> idAutores = new ArrayList<Integer>(); 
			List<Integer> idCategorias = new ArrayList<Integer>();
			List<Integer> idIdiomas = new ArrayList<Integer>();
			
			int idEditorial = 0;
			int idEstado = 0;
			
			
			//buscando el id de los autores seleccionados
			libro.getAutores().forEach(a->{
				String sql= "SELECT idautor from autor where nombre  like '"+a.getNombre()+"'"
						+ " and apellidopaterno like '"+a.getApellidoP()+"' and apellidomaterno like '"+a.getApellidoM()+"'";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					
					while(rs.next()) {
						idAutores.add(rs.getInt(1));				
					}
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			});
			
			//buscando el id de las categorias seleccionadas
			libro.getCategorias().forEach(c->{
				String sql="SELECT idcategoria from categoria where nombre LIKE '"+c.toString()+"'";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					
					while(rs.next()) {
						idCategorias.add(rs.getInt(1));
					}
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
			});
			
			//buscando el id de los idiomas seleccionados
			libro.getIdiomas().forEach(i->{
				String sql="SELECT ididioma from idioma where nombre LIKE '"+i.toString()+"'";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					
					while(rs.next()) {
						idIdiomas.add(rs.getInt(1));
					}
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			});
			
			//buscando el id de la editorial seleccionada
			//se usa if true  para poder crear variables locales
			if(true) {
				String sql ="SELECT ideditorial from editorial where nombre LIKE '"+libro.getEditorial().toString()+"'";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					
					while(rs.next()) {
						idEditorial = rs.getInt(1);
					}
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}
			
			//buscando el id del estado seleccionado
			if(true) {
				String sql ="SELECT idestadoLibro from estadoLibro where nombre LIKE '"+libro.getEstado().toString()+"'";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					
					while(rs.next()) {
						idEstado = rs.getInt(1);
					}
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}

						
			//Se hace el primer insert en la tabla libro
			
			if(true) {
				String sql= "INSERT libro values(?,?,'"+libro.getTitulo()+"',?,?,?,?,?);";
				PreparedStatement st= db.getCon().prepareStatement(sql);
				
				st.setInt(1, libro.getNumSerie());
				st.setString(2, libro.getISBN());
				st.setInt(3, libro.getNumPaginas());
				st.setDouble(4, libro.getPrecioRef());
				st.setDate(5, libro.getAnioPublicacion());
				st.setInt(6, idEstado);
				st.setInt(7, idEditorial);

				st.executeUpdate();
			}
			
			//Se hacen los demas inserts en las tablas de relacion
			
			idAutores.forEach(ia->{		  //(idautor, libroNumeroSerie)
				String sql ="INSERT autorlibro values(?,?);";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					
					st.setInt(1, ia);
					st.setInt(2, libro.getNumSerie());
					
					st.executeUpdate();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			});
			
			idCategorias.forEach(ic->{		//(libroNumeroSerie, idcategoria)
				String sql ="INSERT librocategoria values(?,?);";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					
					st.setInt(1, libro.getNumSerie());
					st.setInt(2, ic);
					
					st.executeUpdate();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			});
			
			
			idIdiomas.forEach(ii->{			//(libroNumeroSerie, idIdioma)
				String sql ="INSERT libroidioma values(?,?);";
				
				try {
					PreparedStatement st = db.getCon().prepareStatement(sql);
					
					st.setInt(1, libro.getNumSerie());
					st.setInt(2, ii);
					
					st.executeUpdate();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			});
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		
	}
	public static List<Libro> getAll(){
		db.conectar();
		List<Libro> libros = new ArrayList<>();
		try {
			String sql= "SELECT numeroSerie,ISBN,titulo,numeroPaginas,precioReferencia,fechaPublicacion from libro";
			PreparedStatement st= db.getCon().prepareStatement(sql);
			ResultSet rs =  st.executeQuery();
			
			Libro l = new Libro();
			while(rs.next()) {
				l = new Libro();
				int numeroSerie = rs.getInt(1);
				String isbn = rs.getString(2);
				String titulo = rs.getString(3);
				int numeroPaginas = rs.getInt(4);
				double precioRef = rs.getDouble(5);
				Date fechaPubli = rs.getDate(6);
				
				l.setNumSerie(numeroSerie);
				l.setISBN(isbn);
				l.setTitulo(titulo);
				l.setNumPaginas(numeroPaginas);
				l.setPrecioRef(precioRef);
				l.setAnioPublicacion(fechaPubli);
				
				libros.add(l);
				
			}
			
			rs.close();
			
			sql= "SELECT l.titulo, e.nombre from libro l"
					+ "	left join editorial e on l.idEditorial = e.idEditorial;";
			
			st= db.getCon().prepareStatement(sql);
			rs =  st.executeQuery();
			
			while(rs.next()) {
				String titulo = rs.getString(1);
				String eNombre = rs.getString(2);
				
				Libro tempLibro = libros.stream().filter(x-> x.getTitulo().contentEquals(titulo)).findFirst().orElse(null);
				if(tempLibro != null) {
					tempLibro.setEditorial(eNombre);
				}
					
			}
			rs.close();
			
			sql= "SELECT l.titulo, i.nombre from libro l"
					+ "	left join libroIdioma li on l.numeroSerie = li.libroNumeroSerie"
					+ " left join idioma i on li.idIdioma = i.idIdioma;";
			
			st= db.getCon().prepareStatement(sql);
			rs =  st.executeQuery();
			
			while(rs.next()) {
				String titulo = rs.getString(1);
				String iNombre = rs.getString(2);
				
				Libro tempLibro = libros.stream().filter(x-> x.getTitulo().contentEquals(titulo)).findFirst().orElse(null);
				if(tempLibro != null) {
					tempLibro.addToIdiomas(iNombre);
				}
					
			}
			rs.close();
			
			sql= "SELECT l.titulo, c.nombre from libro l"
					+ "	left join librocategoria lc on l.numeroSerie = lc.libroNumeroSerie"
					+ " left join categoria c on lc.idCategoria = c.idCategoria;";
			
			st= db.getCon().prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				String titulo = rs.getString(1);
				String cNombre = rs.getString(2);
				
				Libro tempLibro = libros.stream().filter(x-> x.getTitulo().contentEquals(titulo)).findFirst().orElse(null);
				if(tempLibro != null) {
					tempLibro.addToCategorias(cNombre);
				}
					
			}
			rs.close();
			
			
			
			sql= "SELECT l.titulo, e.nombre from libro l"
					+ " left join estadolibro e on l.idestadoLibro = e.idestadoLibro;";
			
			st= db.getCon().prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				String titulo = rs.getString(1);
				String eNombre = rs.getString(2);
				
				Libro tempLibro = libros.stream().filter(x-> x.getTitulo().contentEquals(titulo)).findFirst().orElse(null);
				if(tempLibro != null) {
					tempLibro.setEstado(eNombre);
				}
					
			}
			
			rs.close();
			
			sql= "SELECT l.titulo, a.nombre, a.apellidoPaterno, a.apellidoMaterno from libro l"
					+ "	left join autorlibro al on l.numeroSerie = al.LibroNumeroSerie"
					+ " left join autor a on al.idAutor = a.idAutor;";
			
			st= db.getCon().prepareStatement(sql);
			rs = st.executeQuery();
			
			
			while(rs.next()) {
				Autor autor = new Autor();
				String titulo = rs.getString(1);
				String aNombre = rs.getString(2);
				String aApPat = rs.getString(3);
				String aApMat = rs.getString(4);
				
				Libro tempLibro = libros.stream().filter(x-> x.getTitulo().contentEquals(titulo)).findFirst().orElse(null);
				if(tempLibro != null) {
					autor.setNombre(aNombre);
					autor.setApellidoP(aApPat);
					autor.setApellidoM(aApMat);
					tempLibro.addToAutores(autor);
				}
					
			}
			rs.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.desconectar();
		}
		
		return libros;
	}
	
	
	
	
	public static List<Libro> filteredSearch(String filtro, String target){
		db.conectar();
		List<Libro> libros = getAll();
		
		switch(filtro) {
		
		case "Num. serie":
			return libros.stream().filter(l->String.valueOf(l.getNumSerie()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "ISBN":
			return libros.stream().filter(l->String.valueOf(l.getISBN()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "Título":
			return libros.stream().filter(l->String.valueOf(l.getTitulo()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "Num. páginas":
			return libros.stream().filter(l->String.valueOf(l.getNumPaginas()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());	
		case "Autor":
			return libros.stream().filter(l->String.valueOf(l.getAutores()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "Categoría":
			return libros.stream().filter(l->String.valueOf(l.getCategorias()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "Idioma":
			return libros.stream().filter(l->String.valueOf(l.getIdiomas()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());	
		case "Editorial":
			return libros.stream().filter(l->String.valueOf(l.getEditorial()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());	
		case "Estado del libro":
			return libros.stream().filter(l->String.valueOf(l.getEstado()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "Precio de referencia":
			return libros.stream().filter(l->String.valueOf(l.getPrecioRef()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		case "Fecha de publicacion":
			return libros.stream().filter(l->String.valueOf(l.getAnioPublicacion()).toLowerCase().contains(target.toLowerCase())).collect(Collectors.toList());
		default:
			System.out.println("filtro no reconocido: "+filtro);
		}
		
		
		return libros;
	}
	
	
	public static void update(Libro libroInsert, Libro libroDelete) {
		db.conectar();
		try {
			
			delete(libroDelete.getNumSerie());
			
			save(libroInsert);
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
	
	
	public static void delete(int target) {
		db.conectar();
		try {
			
			
			String sql ="DELETE l , al , lc, li from libro l"
					+ "	inner join autorLibro al on l.numeroSerie = al.libroNumeroSerie"
					+ "    inner join librocategoria lc on l.numeroSerie = lc.libroNumeroSerie"
					+ "    inner join libroidioma li on l.numeroSerie = li.libroNumeroSerie"
					+ "    where l.numeroSerie = ?";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			
			st.setInt(1, target);
			
			st.executeUpdate();
			
			
			
			
			
			
		}catch(Exception e) {
			
		}finally {
			db.desconectar();
		}
		
		
	}
}
