package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import customItems.CustomizeDs;
import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbBaseFactView;
import dashboardViews.DsbBaseLibroView;
import dashboardViews.DsbBaseTransView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbDoubleTableView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.AutorDAO;
import model.dao.CategoriaDAO;
import model.dao.EditorialDAO;
import model.dao.EstadoDAO;
import model.dao.IdiomaDAO;
import model.dao.LibroDAO;
import model.dto.Autor;
import model.dto.Categoria;
import model.dto.Editorial;
import model.dto.Estado;
import model.dto.Idioma;
import model.dto.Libro;

public class DsbBaseLibroController extends DsbBaseController {

	private DsbBaseLibroView v;
	
	private boolean[] registerError = new boolean[11];
	private boolean[] modifyError = new boolean[11];
	private boolean deleteError;
	
	private List<Libro> libros;
	private List<Editorial> editoriales;
	private List<Autor> autores;
	private List<Categoria> categorias;
	private List<Idioma> idiomas;
	private List<Estado> estados;
	
	private DsbDoubleTableView registerLinkAutor;
	private DsbDoubleTableView registerLinkCategoria;
	private DsbDoubleTableView registerLinkIdioma;
	
	private DsbDoubleTableView modifyLinkAutor;
	private DsbDoubleTableView modifyLinkCategoria;
	private DsbDoubleTableView modifyLinkIdioma;
	
	
	public DsbBaseLibroController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseLibroView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	
	
	private void refreshDependencyList() {
		editoriales = EditorialDAO.getAll();
		autores = AutorDAO.getAll();
		categorias = CategoriaDAO.getAll();
		idiomas = IdiomaDAO.getAll();
		estados = EstadoDAO.getAll();
		
	}
	
	private void refreshLibroList() {
		libros = LibroDAO.getAll();
	}
	
	
	private void register() {
		
		
		boolean error = false;
		for(int i=0; i<registerError.length;++i) {
			if(registerError[i]) {
				error = true;
				break;
			}
		}
		
		if(!error) {
			DsbRegisterView rv = registerView; 
			
			DsbDoubleTableView rla = registerLinkAutor;
			DsbDoubleTableView rlc = registerLinkCategoria;
			DsbDoubleTableView rli = registerLinkIdioma;
			
			Libro libro = new Libro();
			
			//añadiendo autores seleccionados al libro
			int rows = rla.getTableA().getRowCount();
			
			for(int i =0; i< rows ;++i) {
				int e = i;
				Autor autor = autores.stream().filter(a-> a.toString().contentEquals((String) rla.getTableA().getValueAt(e, 0))).findFirst().orElse(null);
				if(autor != null) {
					libro.addToAutores(autor);
				}		
			}
			
			//añadiendo categorias seleccionadas al libro
			rows = rlc.getTableA().getRowCount();
			
			for(int i =0; i< rows ;++i ) {
				int e = i;
				Categoria categ = categorias.stream().filter(c-> c.toString().contentEquals((String) rlc.getTableA().getValueAt(e, 0))).findFirst().orElse(null);
				if(categ != null) {
					libro.addToCategorias(categ.toString());
				}
			}
			
			//añadiendo idiomas seleccionados al libro
			rows = rli.getTableA().getRowCount();
			
			for(int i =0; i< rows ;++i ) {
				int e = i;
				Idioma idio = idiomas.stream().filter(c-> c.toString().contentEquals((String) rli.getTableA().getValueAt(e, 0))).findFirst().orElse(null);
				if(idio != null) {
					libro.addToIdiomas(idio.toString());
				}
			}
			
			//añadiendo la editorial y el estado al libro
			libro.setEditorial((String) rv.getCbx8().getSelectedItem());
			libro.setEstado((String) rv.getCbx9().getSelectedItem());
			
			//añadiendo los datos restantes
			libro.setNumSerie(Integer.parseInt(rv.getTxt1().getText()));
			libro.setISBN(rv.getTxt2().getText());
			libro.setTitulo(rv.getTxt3().getText());
			libro.setNumPaginas(Integer.parseInt(rv.getTxt4().getText()));
			libro.setPrecioRef(Double.parseDouble(rv.getTxt10().getText()));
			libro.setAnioPublicacion(java.sql.Date.valueOf(rv.getTxt11().getText()));
			
			LibroDAO.save(libro);
			
			resetRegister();
		}
		
		
		
		
		
	}
		
	private void modify() {
		boolean error = false;
		for(int i=0; i<modifyError.length;++i) {
			if(modifyError[i]) {
				error = true;
				break;
			}
		}
		
		if(!error) {
			DsbModifyView mv = modifyView; 
			
			DsbDoubleTableView mla = modifyLinkAutor;
			DsbDoubleTableView mlc = modifyLinkCategoria;
			DsbDoubleTableView mli = modifyLinkIdioma;
			
			Libro libro = new Libro();
			
			//añadiendo autores seleccionados al libro
			int rows = mla.getTableA().getRowCount();
			
			for(int i =0; i< rows ;++i) {
				int e = i;
				Autor autor = autores.stream().filter(a-> a.toString().contentEquals((String) mla.getTableA().getValueAt(e, 0))).findFirst().orElse(null);
				if(autor != null) {
					libro.addToAutores(autor);
				}		
			}
			
			//añadiendo categorias seleccionadas al libro
			rows = mlc.getTableA().getRowCount();
			
			for(int i =0; i< rows ;++i ) {
				int e = i;
				Categoria categ = categorias.stream().filter(c-> c.toString().contentEquals((String) mlc.getTableA().getValueAt(e, 0))).findFirst().orElse(null);
				if(categ != null) {
					libro.addToCategorias(categ.toString());
				}
			}
			
			//añadiendo idiomas seleccionados al libro
			rows = mli.getTableA().getRowCount();
			
			for(int i =0; i< rows ;++i ) {
				int e = i;
				Idioma idio = idiomas.stream().filter(c-> c.toString().contentEquals((String) mli.getTableA().getValueAt(e, 0))).findFirst().orElse(null);
				if(idio != null) {
					libro.addToIdiomas(idio.toString());
				}
			}
			
			//añadiendo la editorial y el estado al libro
			libro.setEditorial(mv.getCbx8().getSelectedItem().toString());
			libro.setEstado(mv.getCbx9().getSelectedItem().toString());
			
			//añadiendo los datos restantes
			libro.setNumSerie(Integer.parseInt(mv.getTxt1().getText()));
			libro.setISBN(mv.getTxt2().getText());
			libro.setTitulo(mv.getTxt3().getText());
			libro.setNumPaginas(Integer.parseInt(mv.getTxt4().getText()));
			libro.setPrecioRef(Double.parseDouble(mv.getTxt10().getText()));
			libro.setAnioPublicacion(java.sql.Date.valueOf(mv.getTxt11().getText()));
			
			Libro libroDelete = libros.stream().filter(l-> l.getTitulo().contentEquals(mv.getSelectCbx().getSelectedItem().toString())).findFirst().orElse(null);
			
			LibroDAO.update(libro, libroDelete);
			
			resetModify();
		}
		
	}
	
	private void show() {
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		libros.forEach(e->{
			tmodel.addRow(new Object[] {e.getNumSerie(), e.getISBN(),e.getTitulo(),e.getNumPaginas(),e.getAutores(),e.getCategorias()
										,e.getIdiomas(),e.getEditorial(),e.getEstado(),e.getPrecioRef(),e.getAnioPublicacion()});
		});
		
		
	}
	
	private void search() {
		String filtro =((String) searchView.getSelectCbx().getSelectedItem());
		String target = searchView.getTxt1().getText().strip();
		List<Libro> edits = LibroDAO.filteredSearch(filtro, target);
		
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNumSerie(), e.getISBN(),e.getTitulo(),e.getNumPaginas(),e.getAutores(),e.getCategorias()
										,e.getIdiomas(),e.getEditorial(),e.getEstado(),e.getPrecioRef(),e.getAnioPublicacion()});
		});
		
		
	}
	
	private void delete() {
		
			
		if(!deleteError) {
			int target = (int) deleteView.getTable().getValueAt(deleteView.getTable().getSelectedRow(), 0);
			LibroDAO.delete(target);
			refreshDelete();
			
		}	
		
		
	}
	
	
	private void refreshModify() {
		
		List<Libro> libs = LibroDAO.getAll();
		JComboBox<Object> selCbx = modifyView.getSelectCbx();
		JComboBox<Object> editCbx = modifyView.getCbx8();
		JComboBox<Object> estCbx = modifyView.getCbx9();
		
		selCbx.removeAllItems();
		if(libs != null) {
			libs.forEach(e->{
				selCbx.addItem(e.toString());
			});
		}
		
		editCbx.removeAllItems();
		editoriales.forEach(e->{
			editCbx.addItem(e);
		});
		
		estCbx.removeAllItems();
		estados.forEach(e->{
			estCbx.addItem(e);
		});
		
		
		
	}
	
	private void refreshDelete() {
		
		String filtro =((String) deleteView.getSelectCbx().getSelectedItem());
		String target = deleteView.getTxt1().getText().strip();
		List<Libro> edits = LibroDAO.filteredSearch(filtro, target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
				
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNumSerie(), e.getISBN(),e.getTitulo(),e.getNumPaginas(),e.getAutores(),e.getCategorias()
										,e.getIdiomas(),e.getEditorial(),e.getEstado(),e.getPrecioRef(),e.getAnioPublicacion()});
		});
		
	}
	

	
	
	public void resetRegister() {
		registerError[0] = true;
		refreshLibroList();
		refreshDependencyList();
		
		DsbRegisterView rv = registerView;
		
		rv.getCardLayout().show(rv.getCardPanel(), "main");
		
		
		//actualizar la tabla de vinculos Autor
		DefaultTableModel autorAmodel = (DefaultTableModel) this.registerLinkAutor.getTableA().getModel();
		DefaultTableModel autorBmodel = (DefaultTableModel) this.registerLinkAutor.getTableB().getModel();
		
		autorAmodel.setRowCount(0);
		autorBmodel.setRowCount(0);
		
		autores.forEach(a->{
			autorBmodel.addRow(new Object[] {a.toString()});
		});
		
		
		//actualizar la tabla de vinculos Categoria
		DefaultTableModel categAmodel = (DefaultTableModel) this.registerLinkCategoria.getTableA().getModel();
		DefaultTableModel categBmodel = (DefaultTableModel) this.registerLinkCategoria.getTableB().getModel();
		
		categAmodel.setRowCount(0);
		categBmodel.setRowCount(0);
		
		categorias.forEach(c->{
			categBmodel.addRow(new Object[] {c.toString()});
		});
		
		
		//actualizar la tabla de vinculos Idioma
		DefaultTableModel idioAmodel = (DefaultTableModel) this.registerLinkIdioma.getTableA().getModel();
		DefaultTableModel idioBmodel = (DefaultTableModel) this.registerLinkIdioma.getTableB().getModel();
		
		idioAmodel.setRowCount(0);
		idioBmodel.setRowCount(0);
		
		
		idiomas.forEach(i->{
			idioBmodel.addRow(new Object[] {i.toString()});
		});
		
		
		
		rv.getCbx8().removeAllItems();
		rv.getCbx9().removeAllItems();
		
		editoriales.forEach(e->{
			rv.getCbx8().addItem(e.getName());
		});
		
		estados.forEach(e->{
			rv.getCbx9().addItem(e.getNombre());
		});
		
		
		registerView.getAllTxt().forEach(t->{
			if(t != null) {
				t.setText("");
			}
			
		});
		
		registerView.getAllWarnLabels().forEach(w->{
			if(w != null) {
				w.setVisible(false);
			}
		});
		
		String warnText= "Nada seleccionado";
		rv.getWarning5().setText(warnText);
		rv.getWarning6().setText(warnText);
		rv.getWarning7().setText(warnText);
		
		rv.getWarning5().setVisible(true);
		rv.getWarning6().setVisible(true);
		rv.getWarning7().setVisible(true);
		
		
		
	}
	
	public void resetModify() {
		refreshLibroList();
		refreshDependencyList();
		
		modifyView.getAllTxt().forEach(t->{
			if(t != null) {
				t.setText("");
			}
		});
		
		modifyView.getAllWarnLabels().forEach(w->{
			if(w != null) {
				w.setVisible(false);
			}
			
		});
		refreshModify();
	}
	
	
	public void resetShow() {
		refreshLibroList();
		show();
	}
	
	
	public void resetSearch() {
		refreshLibroList();
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		tmodel.setRowCount(0);
		
	}
	
	
	public void resetDelete() {
		refreshLibroList();
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
		tmodel.setRowCount(0);
		
		deleteError = false;
		deleteView.getAllWarnLabels().forEach(w->{
			if(w != null) {
				w.setVisible(false);
			}
		});
			
	}
	
	private void checkErrorRegister(int id) {
		DsbRegisterView rv = registerView;
		
		switch (id) {
		
		case 1:
			if(rv.getTxt1().getText().isBlank()) {
				registerError[id-1] = true;
				rv.getWarning1().setVisible(registerError[id-1]);
				rv.getWarning1().setText("Numero de serie vacío");		
			}else {
				
				String txt = rv.getTxt1().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					rv.getTxt1().setText(txt);
				}
				
				
				Libro libro = libros.stream().filter(l-> String.valueOf(l.getNumSerie()).contentEquals(rv.getTxt1().getText())).findFirst().orElse(null);
				
				if(libro != null) {
					registerError[id-1] = true;
					rv.getWarning1().setVisible(registerError[id-1]);
					rv.getWarning1().setText("Numero de serie ya registrado");
				}else {
					registerError[id-1] = false;
					rv.getWarning1().setVisible(registerError[id-1]);
					rv.getWarning1().setText("");
					
				}	
			}
			
			break;
		case 2:
			if(rv.getTxt2().getText().isBlank()) {
				registerError[id-1] = true;
				rv.getWarning2().setVisible(registerError[id-1]);
				rv.getWarning2().setText("ISBN vacío");		
			}else {
				
				String txt = rv.getTxt2().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					rv.getTxt2().setText(txt);
				}
				
				registerError[id-1] = false;
				rv.getWarning2().setVisible(registerError[id-1]);
				rv.getWarning2().setText("");	
				
			}
			break;
		
		case 3:
			if(rv.getTxt3().getText().isBlank()) {
				registerError[id-1] = true;
				rv.getWarning3().setVisible(true);
				rv.getWarning3().setText("Titulo vacío");		
			}else {
				
				
				
				Libro libro = libros.stream().filter(l-> String.valueOf(l.getTitulo()).contentEquals(rv.getTxt3().getText().strip())).findFirst().orElse(null);
				
				if(libro != null) {
					registerError[id-1] = true;
					rv.getWarning3().setVisible(true);
					rv.getWarning3().setText("Titulo ya registrado");
				}else {
					registerError[id-1] = false;
					rv.getWarning3().setVisible(false);
					rv.getWarning3().setText("");
					
				}	
			}
			break;
		case 4:
			if(rv.getTxt4().getText().isBlank()) {
				registerError[id-1] = true;
				rv.getWarning4().setVisible(registerError[id-1]);
				rv.getWarning4().setText("Numero de paginas vacío");		
			}else {
				
				String txt = rv.getTxt4().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					rv.getTxt4().setText(txt);
				}
				
				registerError[id-1] = false;
				rv.getWarning4().setVisible(registerError[id-1]);
				rv.getWarning4().setText("");	
				
			}
			break;
		case 10 :
			
			if(rv.getTxt10().getText().isBlank()) {
				registerError[id-1] = true;
				rv.getWarning10().setVisible(registerError[id-1]);
				rv.getWarning10().setText("Precio vacío");		
			}else {
				
				String txt = rv.getTxt10().getText();
				
				if(!Pattern.matches("[0-9[.]]+", txt)) {
					txt = txt.replaceAll("[^0-9[.]]", "");
					rv.getTxt10().setText(txt);
				}
				
				
				while(txt.split("\\.", -2).length>2){
					txt = txt.replaceFirst("\\.\\d+$|\\.$", "");
					rv.getTxt10().setText(txt);
				}
				
				registerError[id-1] = false;
				rv.getWarning10().setVisible(registerError[id-1]);
				rv.getWarning10().setText("");	
				
				
			}
			break;
		case 11:
			if(rv.getTxt11().getText().isBlank()) {
				registerError[id-1] = true;
				rv.getWarning11().setVisible(registerError[id-1]);
				rv.getWarning11().setText("Fecha vacía");
				
			}else {
				
				String fecha = rv.getTxt11().getText();
				
				if(!Pattern.matches("[0-9[-]]+", fecha)) {
					fecha = fecha.replaceAll("[^0-9[-]]","");
					rv.getTxt11().setText(fecha);
				}
				
				while(fecha.split("-", -2).length>3) {
					fecha = fecha.replaceFirst("--", "-");
					fecha = fecha.replaceFirst("(-\\d+$)|(-$)", "");
					
					rv.getTxt11().setText(fecha);
				}
				
				try {
					java.sql.Date.valueOf(fecha);
					registerError[id-1] = false;
					rv.getWarning11().setVisible(registerError[id-1]);
					rv.getWarning11().setText("");
					
				}catch (Exception ex) {
					registerError[id-1] = true;
					rv.getWarning11().setVisible(registerError[id-1]);
					rv.getWarning11().setText("Fecha inválida");
				}		
			}
			break;
			
		}
		
	}
	
	
	
	private void checkErrorAutorRegister() {
		DsbRegisterView rv = registerView;
		DsbDoubleTableView rla = registerLinkAutor;
		if(rla.getTableA().getRowCount() == 0) {
			registerError[4] = true;
			rv.getWarning5().setVisible(true);
			rv.getWarning5().setText("Nada seleccionado");
		}else {
			registerError[4] = false;
			rv.getWarning5().setVisible(false);
			rv.getWarning5().setText("");
		}
		
	}
	
	private void checkErrorCategRegister() {
		DsbRegisterView rv = registerView;
		DsbDoubleTableView rlc = registerLinkCategoria;
		if(rlc.getTableA().getRowCount() == 0) {
			registerError[5] = true;
			rv.getWarning6().setVisible(true);
			rv.getWarning6().setText("Nada seleccionado");
		}else {
			registerError[5] = false;
			rv.getWarning6().setVisible(false);
			rv.getWarning6().setText("");
		}
	}
	
	private void checkErrorIdiomaRegister() {
		DsbRegisterView rv = registerView;
		DsbDoubleTableView rli = registerLinkIdioma;
		if(rli.getTableA().getRowCount() == 0) {
			registerError[6] = true;
			rv.getWarning7().setVisible(true);
			rv.getWarning7().setText("Nada seleccionado");
		}else {
			registerError[6] = false;
			rv.getWarning7().setVisible(false);
			rv.getWarning7().setText("");
		}
	}
	
	
	
	
	private void checkErrorModify(int id) {
		DsbModifyView mv = modifyView;
		
		Libro libroSel = libros.stream().filter(l-> l.getTitulo().contentEquals((String) mv.getSelectCbx().getSelectedItem())).findFirst().orElse(null);
		
		switch (id) {
		
		case 1:
			if(mv.getTxt1().getText().isBlank()) {
				modifyError[id-1] = true;
				mv.getWarning1().setVisible(modifyError[id-1]);
				mv.getWarning1().setText("Numero de serie vacío");		
			}else {
				
				String txt = mv.getTxt1().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					mv.getTxt1().setText(txt);
				}
				
				
				Libro libro = libros.stream().filter(l-> String.valueOf(l.getNumSerie()).contentEquals(mv.getTxt1().getText())).findFirst().orElse(null);
				
				if(libro != null && libroSel.getNumSerie() == libro.getNumSerie()) {
					libro = null;
				}
				
				if(libro != null) {
					modifyError[id-1] = true;
					mv.getWarning1().setVisible(modifyError[id-1]);
					mv.getWarning1().setText("Numero de serie ya registrado");
				}else {
					modifyError[id-1] = false;
					mv.getWarning1().setVisible(modifyError[id-1]);
					mv.getWarning1().setText("");
					
				}	
			}
			
			break;
		case 2:
			if(mv.getTxt2().getText().isBlank()) {
				modifyError[id-1] = true;
				mv.getWarning2().setVisible(modifyError[id-1]);
				mv.getWarning2().setText("ISBN vacío");		
			}else {
				
				String txt = mv.getTxt2().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					mv.getTxt2().setText(txt);
				}
				
				modifyError[id-1] = false;
				mv.getWarning2().setVisible(modifyError[id-1]);
				mv.getWarning2().setText("");	
				
			}
			break;
		
		case 3:
			if(mv.getTxt3().getText().isBlank()) {
				modifyError[id-1] = true;
				mv.getWarning3().setVisible(true);
				mv.getWarning3().setText("Titulo vacío");		
			}else {
				
				
				
				Libro libro = libros.stream().filter(l-> String.valueOf(l.getTitulo()).contentEquals(mv.getTxt3().getText().strip())).findFirst().orElse(null);
				
				if(libro != null && libroSel.getNumSerie() == libro.getNumSerie()) {
					libro = null;
				}
				
				if(libro != null) {
					modifyError[id-1] = true;
					mv.getWarning3().setVisible(true);
					mv.getWarning3().setText("Titulo ya registrado");
				}else {
					modifyError[id-1] = false;
					mv.getWarning3().setVisible(false);
					mv.getWarning3().setText("");
					
				}	
			}
			break;
		case 4:
			if(mv.getTxt4().getText().isBlank()) {
				modifyError[id-1] = true;
				mv.getWarning4().setVisible(modifyError[id-1]);
				mv.getWarning4().setText("Numero de paginas vacío");		
			}else {
				
				String txt = mv.getTxt4().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					mv.getTxt4().setText(txt);
				}
				
				modifyError[id-1] = false;
				mv.getWarning4().setVisible(modifyError[id-1]);
				mv.getWarning4().setText("");	
				
			}
			break;
		case 10 :
			
			if(mv.getTxt10().getText().isBlank()) {
				modifyError[id-1] = true;
				mv.getWarning10().setVisible(modifyError[id-1]);
				mv.getWarning10().setText("Precio vacío");		
			}else {
				
				String txt = mv.getTxt10().getText();
				
				if(!Pattern.matches("[0-9[.]]+", txt)) {
					txt = txt.replaceAll("[^0-9[.]]", "");
					mv.getTxt10().setText(txt);
				}
				
				
				while(txt.split("\\.", -2).length>2){
					txt = txt.replaceFirst("\\.\\d+$|\\.$", "");
					mv.getTxt10().setText(txt);
				}
				
				modifyError[id-1] = false;
				mv.getWarning10().setVisible(modifyError[id-1]);
				mv.getWarning10().setText("");	
				
				
			}
			break;
		case 11:
			if(mv.getTxt11().getText().isBlank()) {
				modifyError[id-1] = true;
				mv.getWarning11().setVisible(modifyError[id-1]);
				mv.getWarning11().setText("Fecha vacía");
				
			}else {
				
				String fecha = mv.getTxt11().getText();
				
				if(!Pattern.matches("[0-9[-]]+", fecha)) {
					fecha = fecha.replaceAll("[^0-9[-]]","");
					mv.getTxt11().setText(fecha);
				}
				
				while(fecha.split("-", -2).length>3) {
					fecha = fecha.replaceFirst("--", "-");
					fecha = fecha.replaceFirst("(-\\d+$)|(-$)", "");
					
					mv.getTxt11().setText(fecha);
				}
				
				try {
					java.sql.Date.valueOf(fecha);
					modifyError[id-1] = false;
					mv.getWarning11().setVisible(modifyError[id-1]);
					mv.getWarning11().setText("");
					
				}catch (Exception ex) {
					modifyError[id-1] = true;
					mv.getWarning11().setVisible(modifyError[id-1]);
					mv.getWarning11().setText("Fecha inválida");
				}		
			}
			break;
			
		}	
	}
	
	
	private void checkErrorAutorModify() {
		DsbModifyView mv = modifyView;
		DsbDoubleTableView mli = modifyLinkAutor;
		if(mli.getTableA().getRowCount() == 0) {
			modifyError[4] = true;
			mv.getWarning5().setVisible(true);
			mv.getWarning5().setText("Nada seleccionado");
		}else {
			modifyError[4] = false;
			mv.getWarning5().setVisible(false);
			mv.getWarning5().setText("");
		}
	}
	
	private void checkErrorCategModify() {
		DsbModifyView mv = modifyView;
		DsbDoubleTableView mli = modifyLinkCategoria;
		if(mli.getTableA().getRowCount() == 0) {
			modifyError[5] = true;
			mv.getWarning6().setVisible(true);
			mv.getWarning6().setText("Nada seleccionado");
		}else {
			modifyError[5] = false;
			mv.getWarning6().setVisible(false);
			mv.getWarning6().setText("");
		}
	}
	
	private void checkErrorIdiomaModify() {
		DsbModifyView mv = modifyView;
		DsbDoubleTableView mli = modifyLinkIdioma;
		if(mli.getTableA().getRowCount() == 0) {
			modifyError[6] = true;
			mv.getWarning7().setVisible(true);
			mv.getWarning7().setText("Nada seleccionado");
		}else {
			modifyError[6] = false;
			mv.getWarning7().setVisible(false);
			mv.getWarning7().setText("");
		}
	}
	
	
	
	
	private void initRegister(DsbRegisterView crudView) {
		
		registerView = crudView;
		DsbRegisterView rv = registerView;
		JPanel rFields = registerView.getFields();
		
		rv.getLbl1().setText(v.getNumeroSerieLbl());
		rv.getLbl2().setText(v.getIsbnLbl());
		rv.getLbl3().setText(v.getTituloLbl());
		rv.getLbl4().setText(v.getNumeroPaginasLbl());
		rv.getLbl5().setText(v.getAutorLbl());
		rv.getLbl6().setText(v.getCategoriaLbl());
		rv.getLbl7().setText(v.getIdiomaLbl());
		rv.getLbl8().setText(v.getEditorialLbl());
		rv.getLbl9().setText(v.getEstadoLbl());
		rv.getLbl10().setText(v.getPrecioReferenciaLbl());
		rv.getLbl11().setText(v.getFechaPublicacionLbl());
		
		
		
		int rCompCount = rFields.getComponentCount();
		
		int rowCount = (4 * 3); 
		
		for(int i =rowCount; i< rCompCount ;++i) {
			rFields.remove(rowCount);
		}	
		
		rFields.add(rv.getLbl5(), "cell 0 4");
		rFields.add(rv.getBtn5(), "cell 1 4");
		rFields.add(rv.getWarning5(), "cell 2 4");
		
		rFields.add(rv.getLbl6(), "cell 0 5");
		rFields.add(rv.getBtn6(), "cell 1 5");
		rFields.add(rv.getWarning6(), "cell 2 5");
		
		rFields.add(rv.getLbl7(), "cell 0 6");
		rFields.add(rv.getBtn7(), "cell 1 6");
		rFields.add(rv.getWarning7(), "cell 2 6");
		
		rFields.add(rv.getLbl8(), "cell 0 7");
		rFields.add(rv.getCbx8(), "cell 1 7");
		rFields.add(rv.getWarning8(), "cell 2 7");
		
		rFields.add(rv.getLbl9(), "cell 0 8");
		rFields.add(rv.getCbx9(), "cell 1 8");
		rFields.add(rv.getWarning9(), "cell 2 8");
		
		rFields.add(rv.getLbl10(), "cell 0 9");
		rFields.add(rv.getTxt10(), "cell 1 9");
		rFields.add(rv.getWarning10(), "cell 2 9");
		
		rFields.add(rv.getLbl11(), "cell 0 10");
		rFields.add(rv.getTxt11(), "cell 1 10");
		rFields.add(rv.getWarning11(), "cell 2 10");
		
		
		rFields.add(registerView.getCommitBtn(), "cell 1 "+rFields.getComponentCount()/3);
		
		registerView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				register();
			}
		});
		
		// tabla de seleccion de autores
		registerLinkAutor = new DsbDoubleTableView(v, "autor", registerView);
		
		rv.getCardPanel().add(registerLinkAutor, registerLinkAutor.getName());
		
		
		registerLinkAutor.getBackBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rv.getCardLayout().show(rv.getCardPanel(), "main");
			}
		});
		
		rv.getBtn5().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				rv.getCardLayout().show(rv.getCardPanel(), registerLinkAutor.getName());
			}
		});
		
		DefaultTableModel rvAutorAMod = new DefaultTableModel();
		DefaultTableModel rvAutorBMod = new DefaultTableModel();
		
		JTable rvAutorATabl = this.registerLinkAutor.getTableA();
		JTable rvAutorBTabl = this.registerLinkAutor.getTableB();
		
		rvAutorATabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rvAutorBTabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rvAutorAMod.addColumn("Nombre");

		rvAutorBMod.addColumn("Nombre");

		rvAutorATabl.setModel(rvAutorAMod);
		rvAutorBTabl.setModel(rvAutorBMod);
		
		CustomizeDs.customizeJTable(rvAutorATabl);
		CustomizeDs.customizeJTable(rvAutorBTabl);
		
		
		this.registerLinkAutor.getLinkBtnAtoB().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rla = registerLinkAutor;
			DefaultTableModel bModel = (DefaultTableModel) registerLinkAutor.getTableB().getModel();
			DefaultTableModel aModel = (DefaultTableModel) registerLinkAutor.getTableA().getModel();
			JTable aTable = rla.getTableA();
			@Override
			public void mousePressed(MouseEvent e) {
				if(registerLinkAutor.getTableA().getSelectedRow() != -1) {	
					int selRow = rla.getTableA().getSelectedRow();			
					bModel.addRow(new Object[] {aTable.getValueAt(selRow, 0)});
					aModel.removeRow(selRow);
					aTable.clearSelection();
					checkErrorAutorRegister();
				}
				
			}
		});
		
		this.registerLinkAutor.getLinkBtnBtoA().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rla = registerLinkAutor;
			DefaultTableModel aModel = (DefaultTableModel) registerLinkAutor.getTableA().getModel();
			DefaultTableModel bModel = (DefaultTableModel) registerLinkAutor.getTableB().getModel();
			JTable bTable = rla.getTableB();
			@Override
			public void mousePressed(MouseEvent e) {
				if(registerLinkAutor.getTableB().getSelectedRow() != -1) {	
					int selRow = rla.getTableB().getSelectedRow();			
					aModel.addRow(new Object[] {bTable.getValueAt(selRow, 0)});
					bModel.removeRow(selRow);
					bTable.clearSelection();
					checkErrorAutorRegister();
				}
				
			}
		});
		
		//tabla de seleccion de categorias
		registerLinkCategoria = new DsbDoubleTableView(v, "categoria", registerView);
		
		rv.getCardPanel().add(registerLinkCategoria, registerLinkCategoria.getName());
		
		
		registerLinkCategoria.getBackBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rv.getCardLayout().show(rv.getCardPanel(), "main");
			}
		});
		
		rv.getBtn6().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rv.getCardLayout().show(rv.getCardPanel(), registerLinkCategoria.getName());
			}
		});
		
		DefaultTableModel rvCategAMod = new DefaultTableModel();
		DefaultTableModel rvCategBMod = new DefaultTableModel();
		
		JTable rvCategATabl = this.registerLinkCategoria.getTableA();
		JTable rvCategBTabl = this.registerLinkCategoria.getTableB();
		
		rvCategATabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rvCategBTabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rvCategAMod.addColumn("Nombre");

		rvCategBMod.addColumn("Nombre");

		rvCategATabl.setModel(rvCategAMod);
		rvCategBTabl.setModel(rvCategBMod);
		
		CustomizeDs.customizeJTable(rvCategATabl);
		CustomizeDs.customizeJTable(rvCategBTabl);
		
		
		this.registerLinkCategoria.getLinkBtnAtoB().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rlc = registerLinkCategoria;
			DefaultTableModel bModel = (DefaultTableModel) registerLinkCategoria.getTableB().getModel();
			DefaultTableModel aModel = (DefaultTableModel) registerLinkCategoria.getTableA().getModel();
			JTable aTable = rlc.getTableA();
			@Override
			public void mousePressed(MouseEvent e) {
				if(registerLinkCategoria.getTableA().getSelectedRow() != -1) {	
					int selRow = rlc.getTableA().getSelectedRow();			
					bModel.addRow(new Object[] {aTable.getValueAt(selRow, 0)});
					aTable.clearSelection();
					aModel.removeRow(selRow);
					checkErrorCategRegister();
					
				}
				
			}
		});
		
		this.registerLinkCategoria.getLinkBtnBtoA().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rlc = registerLinkCategoria;
			DefaultTableModel aModel = (DefaultTableModel) registerLinkCategoria.getTableA().getModel();
			DefaultTableModel bModel = (DefaultTableModel) registerLinkCategoria.getTableB().getModel();
			JTable bTable = rlc.getTableB();
			@Override
			public void mousePressed(MouseEvent e) {
				if(registerLinkCategoria.getTableB().getSelectedRow() != -1) {	
					int selRow = rlc.getTableB().getSelectedRow();			
					aModel.addRow(new Object[] {bTable.getValueAt(selRow, 0)});
					bTable.clearSelection();
					bModel.removeRow(selRow);
					checkErrorCategRegister();
				}
				
			}
		});
		
		//tabla de seleccion de idiomas
		registerLinkIdioma = new DsbDoubleTableView(v, "idioma", registerView);
		
		rv.getCardPanel().add(registerLinkIdioma, registerLinkIdioma.getName());
		
		
		registerLinkIdioma.getBackBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rv.getCardLayout().show(rv.getCardPanel(), "main");
			}
		});
		
		rv.getBtn7().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rv.getCardLayout().show(rv.getCardPanel(), registerLinkIdioma.getName());
			}
		});
		
		DefaultTableModel rvIdioAMod = new DefaultTableModel();
		DefaultTableModel rvIdioBMod = new DefaultTableModel();
		
		JTable rvIdioATabl = this.registerLinkIdioma.getTableA();
		JTable rvIdioBTabl = this.registerLinkIdioma.getTableB();
		
		rvIdioATabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rvIdioBTabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rvIdioAMod.addColumn("Nombre");

		rvIdioBMod.addColumn("Nombre");

		rvIdioATabl.setModel(rvIdioAMod);
		rvIdioBTabl.setModel(rvIdioBMod);
		
		CustomizeDs.customizeJTable(rvIdioATabl);
		CustomizeDs.customizeJTable(rvIdioBTabl);
		
		
		this.registerLinkIdioma.getLinkBtnAtoB().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rli = registerLinkIdioma;
			DefaultTableModel bModel = (DefaultTableModel) registerLinkIdioma.getTableB().getModel();
			DefaultTableModel aModel = (DefaultTableModel) registerLinkIdioma.getTableA().getModel();
			JTable aTable = rli.getTableA();
			@Override
			public void mousePressed(MouseEvent e) {
				if(registerLinkIdioma.getTableA().getSelectedRow() != -1) {	
					int selRow = rli.getTableA().getSelectedRow();			
					bModel.addRow(new Object[] {aTable.getValueAt(selRow, 0)});
					aTable.clearSelection();
					aModel.removeRow(selRow);
					
					checkErrorIdiomaRegister();
					
				}
				
			}
		});
		
		this.registerLinkIdioma.getLinkBtnBtoA().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rli = registerLinkIdioma;
			DefaultTableModel aModel = (DefaultTableModel) registerLinkIdioma.getTableA().getModel();
			DefaultTableModel bModel = (DefaultTableModel) registerLinkIdioma.getTableB().getModel();
			JTable bTable = rli.getTableB();
			@Override
			public void mousePressed(MouseEvent e) {
				if(registerLinkIdioma.getTableB().getSelectedRow() != -1) {	
					int selRow = rli.getTableB().getSelectedRow();			
					aModel.addRow(new Object[] {bTable.getValueAt(selRow, 0)});
					bTable.clearSelection();
					bModel.removeRow(selRow);
					
					checkErrorIdiomaRegister();
				}
				
			}
		});
		
		
		registerView.getTxt1().addKeyListener(new RegisterTxtKeyListener(1));
		registerView.getTxt2().addKeyListener(new RegisterTxtKeyListener(2));
		registerView.getTxt3().addKeyListener(new RegisterTxtKeyListener(3));
		registerView.getTxt4().addKeyListener(new RegisterTxtKeyListener(4));
		registerView.getTxt5().addKeyListener(new RegisterTxtKeyListener(5));
		registerView.getTxt6().addKeyListener(new RegisterTxtKeyListener(6));
		registerView.getTxt7().addKeyListener(new RegisterTxtKeyListener(7));
		registerView.getTxt8().addKeyListener(new RegisterTxtKeyListener(8));
		registerView.getTxt9().addKeyListener(new RegisterTxtKeyListener(9));
		registerView.getTxt10().addKeyListener(new RegisterTxtKeyListener(10));
		registerView.getTxt11().addKeyListener(new RegisterTxtKeyListener(11));
		
		
	}
	
	
	
	private void initModify(DsbModifyView crudView) {
		
		modifyView = crudView;
		DsbModifyView mv = modifyView;
		JPanel rFields = modifyView.getFields();
		
		mv.getSelectLbl().setText(v.getSelectLbl());
		mv.getLbl1().setText(v.getNumeroSerieLbl());
		mv.getLbl2().setText(v.getIsbnLbl());
		mv.getLbl3().setText(v.getTituloLbl());
		mv.getLbl4().setText(v.getNumeroPaginasLbl());
		mv.getLbl5().setText(v.getAutorLbl());
		mv.getLbl6().setText(v.getCategoriaLbl());
		mv.getLbl7().setText(v.getIdiomaLbl());
		mv.getLbl8().setText(v.getEditorialLbl());
		mv.getLbl9().setText(v.getEstadoLbl());
		mv.getLbl10().setText(v.getPrecioReferenciaLbl());
		mv.getLbl11().setText(v.getFechaPublicacionLbl());
		
		
		
		int rCompCount = rFields.getComponentCount();
		
		int rowCount = (5 * 3); 
		
		for(int i =rowCount; i< rCompCount ;++i) {
			rFields.remove(rowCount);
		}	
		
		rFields.add(mv.getLbl5(), "cell 0 5");
		rFields.add(mv.getBtn5(), "cell 1 5");
		rFields.add(mv.getWarning5(), "cell 2 5");
		
		rFields.add(mv.getLbl6(), "cell 0 6");
		rFields.add(mv.getBtn6(), "cell 1 6");
		rFields.add(mv.getWarning6(), "cell 2 6");
		
		rFields.add(mv.getLbl7(), "cell 0 7");
		rFields.add(mv.getBtn7(), "cell 1 7");
		rFields.add(mv.getWarning7(), "cell 2 7");
		
		rFields.add(mv.getLbl8(), "cell 0 8");
		rFields.add(mv.getCbx8(), "cell 1 8");
		rFields.add(mv.getWarning8(), "cell 2 8");
		
		rFields.add(mv.getLbl9(), "cell 0 9");
		rFields.add(mv.getCbx9(), "cell 1 9");
		rFields.add(mv.getWarning9(), "cell 2 9");
		
		rFields.add(mv.getLbl10(), "cell 0 10");
		rFields.add(mv.getTxt10(), "cell 1 10");
		rFields.add(mv.getWarning10(), "cell 2 10");
		
		rFields.add(mv.getLbl11(), "cell 0 11");
		rFields.add(mv.getTxt11(), "cell 1 11");
		rFields.add(mv.getWarning11(), "cell 2 11");
		
		
		rFields.add(modifyView.getCommitBtn(), "cell 1 "+rFields.getComponentCount()/3);
		
		modifyView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				modify();
			}
		});
		
		// tabla de seleccion de autores
		modifyLinkAutor = new DsbDoubleTableView(v, "autor", modifyView);
		
		mv.getCardPanel().add(modifyLinkAutor, modifyLinkAutor.getName());
		
		
		modifyLinkAutor.getBackBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mv.getCardLayout().show(mv.getCardPanel(), "main");
			}
		});
		
		mv.getBtn5().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				mv.getCardLayout().show(mv.getCardPanel(), modifyLinkAutor.getName());
			}
		});
		
		DefaultTableModel mvAutorAMod = new DefaultTableModel();
		DefaultTableModel mvAutorBMod = new DefaultTableModel();
		
		JTable mvAutorATabl = this.modifyLinkAutor.getTableA();
		JTable mvAutorBTabl = this.modifyLinkAutor.getTableB();
		
		mvAutorATabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mvAutorBTabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		mvAutorAMod.addColumn("Nombre");

		mvAutorBMod.addColumn("Nombre");

		mvAutorATabl.setModel(mvAutorAMod);
		mvAutorBTabl.setModel(mvAutorBMod);
		
		CustomizeDs.customizeJTable(mvAutorATabl);
		CustomizeDs.customizeJTable(mvAutorBTabl);
		
		
		this.modifyLinkAutor.getLinkBtnAtoB().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rla = modifyLinkAutor;
			DefaultTableModel bModel = (DefaultTableModel) modifyLinkAutor.getTableB().getModel();
			DefaultTableModel aModel = (DefaultTableModel) modifyLinkAutor.getTableA().getModel();
			JTable aTable = rla.getTableA();
			@Override
			public void mousePressed(MouseEvent e) {
				if(modifyLinkAutor.getTableA().getSelectedRow() != -1) {	
					int selRow = rla.getTableA().getSelectedRow();			
					bModel.addRow(new Object[] {aTable.getValueAt(selRow, 0)});
					aModel.removeRow(selRow);
					aTable.clearSelection();
					checkErrorAutorModify();
				}
				
			}
		});
		
		this.modifyLinkAutor.getLinkBtnBtoA().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rla = modifyLinkAutor;
			DefaultTableModel aModel = (DefaultTableModel) modifyLinkAutor.getTableA().getModel();
			DefaultTableModel bModel = (DefaultTableModel) modifyLinkAutor.getTableB().getModel();
			JTable bTable = rla.getTableB();
			@Override
			public void mousePressed(MouseEvent e) {
				if(modifyLinkAutor.getTableB().getSelectedRow() != -1) {	
					int selRow = rla.getTableB().getSelectedRow();			
					aModel.addRow(new Object[] {bTable.getValueAt(selRow, 0)});
					bModel.removeRow(selRow);
					bTable.clearSelection();
					checkErrorAutorModify();
				}
				
			}
		});
		
		//tabla de seleccion de categorias
		modifyLinkCategoria = new DsbDoubleTableView(v, "categoria", modifyView);
		
		mv.getCardPanel().add(modifyLinkCategoria, modifyLinkCategoria.getName());
		
		
		modifyLinkCategoria.getBackBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mv.getCardLayout().show(mv.getCardPanel(), "main");
			}
		});
		
		mv.getBtn6().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mv.getCardLayout().show(mv.getCardPanel(), modifyLinkCategoria.getName());
			}
		});
		
		DefaultTableModel mvCategAMod = new DefaultTableModel();
		DefaultTableModel mvCategBMod = new DefaultTableModel();
		
		JTable mvCategATabl = this.modifyLinkCategoria.getTableA();
		JTable mvCategBTabl = this.modifyLinkCategoria.getTableB();
		
		mvCategATabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mvCategBTabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		mvCategAMod.addColumn("Nombre");

		mvCategBMod.addColumn("Nombre");

		mvCategATabl.setModel(mvCategAMod);
		mvCategBTabl.setModel(mvCategBMod);
		
		CustomizeDs.customizeJTable(mvCategATabl);
		CustomizeDs.customizeJTable(mvCategBTabl);
		
		
		this.modifyLinkCategoria.getLinkBtnAtoB().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rlc = modifyLinkCategoria;
			DefaultTableModel bModel = (DefaultTableModel) modifyLinkCategoria.getTableB().getModel();
			DefaultTableModel aModel = (DefaultTableModel) modifyLinkCategoria.getTableA().getModel();
			JTable aTable = rlc.getTableA();
			@Override
			public void mousePressed(MouseEvent e) {
				if(modifyLinkCategoria.getTableA().getSelectedRow() != -1) {	
					int selRow = rlc.getTableA().getSelectedRow();			
					bModel.addRow(new Object[] {aTable.getValueAt(selRow, 0)});
					aTable.clearSelection();
					aModel.removeRow(selRow);
					checkErrorCategModify();
					
				}
				
			}
		});
		
		this.modifyLinkCategoria.getLinkBtnBtoA().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rlc = modifyLinkCategoria;
			DefaultTableModel aModel = (DefaultTableModel) modifyLinkCategoria.getTableA().getModel();
			DefaultTableModel bModel = (DefaultTableModel) modifyLinkCategoria.getTableB().getModel();
			JTable bTable = rlc.getTableB();
			@Override
			public void mousePressed(MouseEvent e) {
				if(modifyLinkCategoria.getTableB().getSelectedRow() != -1) {	
					int selRow = rlc.getTableB().getSelectedRow();			
					aModel.addRow(new Object[] {bTable.getValueAt(selRow, 0)});
					bTable.clearSelection();
					bModel.removeRow(selRow);
					checkErrorCategModify();
				}
				
			}
		});
		
		//tabla de seleccion de idiomas
		modifyLinkIdioma = new DsbDoubleTableView(v, "idioma", modifyView);
		
		mv.getCardPanel().add(modifyLinkIdioma, modifyLinkIdioma.getName());
		
		
		modifyLinkIdioma.getBackBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mv.getCardLayout().show(mv.getCardPanel(), "main");
			}
		});
		
		mv.getBtn7().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mv.getCardLayout().show(mv.getCardPanel(), modifyLinkIdioma.getName());
			}
		});
		
		DefaultTableModel mvIdioAMod = new DefaultTableModel();
		DefaultTableModel mvIdioBMod = new DefaultTableModel();
		
		JTable mvIdioATabl = this.modifyLinkIdioma.getTableA();
		JTable mvIdioBTabl = this.modifyLinkIdioma.getTableB();
		
		mvIdioATabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mvIdioBTabl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		mvIdioAMod.addColumn("Nombre");

		mvIdioBMod.addColumn("Nombre");

		mvIdioATabl.setModel(mvIdioAMod);
		mvIdioBTabl.setModel(mvIdioBMod);
		
		CustomizeDs.customizeJTable(mvIdioATabl);
		CustomizeDs.customizeJTable(mvIdioBTabl);
		
		
		this.modifyLinkIdioma.getLinkBtnAtoB().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rli = modifyLinkIdioma;
			DefaultTableModel bModel = (DefaultTableModel) modifyLinkIdioma.getTableB().getModel();
			DefaultTableModel aModel = (DefaultTableModel) modifyLinkIdioma.getTableA().getModel();
			JTable aTable = rli.getTableA();
			@Override
			public void mousePressed(MouseEvent e) {
				if(modifyLinkIdioma.getTableA().getSelectedRow() != -1) {	
					int selRow = rli.getTableA().getSelectedRow();			
					bModel.addRow(new Object[] {aTable.getValueAt(selRow, 0)});
					aTable.clearSelection();
					aModel.removeRow(selRow);
					
					checkErrorIdiomaModify();
					
				}
				
			}
		});
		
		this.modifyLinkIdioma.getLinkBtnBtoA().getBtn().addMouseListener(new MouseAdapter() {
			DsbDoubleTableView rli = modifyLinkIdioma;
			DefaultTableModel aModel = (DefaultTableModel) modifyLinkIdioma.getTableA().getModel();
			DefaultTableModel bModel = (DefaultTableModel) modifyLinkIdioma.getTableB().getModel();
			JTable bTable = rli.getTableB();
			@Override
			public void mousePressed(MouseEvent e) {
				if(modifyLinkIdioma.getTableB().getSelectedRow() != -1) {	
					int selRow = rli.getTableB().getSelectedRow();			
					aModel.addRow(new Object[] {bTable.getValueAt(selRow, 0)});
					bTable.clearSelection();
					bModel.removeRow(selRow);
					
					checkErrorIdiomaModify();
				}
				
			}
		});
		
		modifyView.getTxt1().addKeyListener(new ModifyTxtKeyListener(1));
		modifyView.getTxt2().addKeyListener(new ModifyTxtKeyListener(2));
		modifyView.getTxt3().addKeyListener(new ModifyTxtKeyListener(3));
		modifyView.getTxt4().addKeyListener(new ModifyTxtKeyListener(4));
		modifyView.getTxt5().addKeyListener(new ModifyTxtKeyListener(5));
		modifyView.getTxt6().addKeyListener(new ModifyTxtKeyListener(6));
		modifyView.getTxt7().addKeyListener(new ModifyTxtKeyListener(7));
		modifyView.getTxt8().addKeyListener(new ModifyTxtKeyListener(8));
		modifyView.getTxt9().addKeyListener(new ModifyTxtKeyListener(9));
		modifyView.getTxt10().addKeyListener(new ModifyTxtKeyListener(10));
		modifyView.getTxt11().addKeyListener(new ModifyTxtKeyListener(11));
		
		
		modifyView.getSelectCbx().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(modifyView.getSelectCbx().getSelectedItem() != null) {
					Libro libro = libros.stream().filter(l-> l.getTitulo().contentEquals((String) modifyView.getSelectCbx().getSelectedItem())).findFirst().orElse(null); 
					if(libro != null) {
						DsbModifyView mv = modifyView;
						DsbDoubleTableView mla = modifyLinkAutor;
						DsbDoubleTableView mlc = modifyLinkCategoria;
						DsbDoubleTableView mli = modifyLinkIdioma;
						
						DefaultTableModel mlaModelA = (DefaultTableModel) mla.getTableA().getModel();
						DefaultTableModel mlaModelB = (DefaultTableModel) mla.getTableB().getModel();
						List<Autor> autoresB = new ArrayList<Autor>();
						autores.forEach(a->{
							autoresB.add(a);
						});
						libro.getAutores().forEach(au->{
							Autor autor = autores.stream().filter(a-> a.toString().contentEquals(au.toString())).findFirst().orElse(null);
							if(autor != null) {
								autoresB.remove(autor);
							}
						});
						
						DefaultTableModel mlcModelA = (DefaultTableModel) mlc.getTableA().getModel();
						DefaultTableModel mlcModelB = (DefaultTableModel) mlc.getTableB().getModel();
						List<Categoria> categoriasB = new ArrayList<Categoria>();
						categorias.forEach(c->{
							categoriasB.add(c);
						});
						libro.getCategorias().forEach(ca->{
							Categoria categ = categorias.stream().filter(c-> c.toString().contentEquals(ca.toString())).findFirst().orElse(null);
							if(categ != null) {
								categoriasB.remove(categ);
							}
						});
						
						
						DefaultTableModel mliModelA = (DefaultTableModel) mli.getTableA().getModel();
						DefaultTableModel mliModelB = (DefaultTableModel) mli.getTableB().getModel();
						List<Idioma> idiomasB = new ArrayList<Idioma>();
						idiomas.forEach(i->{
							idiomasB.add(i);
						});
						libro.getIdiomas().forEach(id->{
							Idioma idio = idiomas.stream().filter(i-> i.toString().contentEquals(id.toString())).findFirst().orElse(null);
							if(idio != null) {
								idiomasB.remove(idio);
							}
						});
						
						
						mlaModelA.setRowCount(0);
						mlaModelB.setRowCount(0);
						
						mlcModelA.setRowCount(0);
						mlcModelB.setRowCount(0);
						
						mliModelA.setRowCount(0);
						mliModelB.setRowCount(0);
						
						
						mv.getTxt1().setText(String.valueOf(libro.getNumSerie()));
						mv.getTxt2().setText(String.valueOf(libro.getISBN()));
						mv.getTxt3().setText(String.valueOf(libro.getTitulo()));
						mv.getTxt4().setText(String.valueOf(libro.getNumPaginas()));
						
						libro.getAutores().forEach(la->{
							mlaModelA.addRow(new Object[] {la.toString()});
						});
						
						autoresB.forEach(a->{
							mlaModelB.addRow(new Object[] {a.toString()});
						});
						
						
						libro.getCategorias().forEach(lc->{
							mlcModelA.addRow(new Object[] {lc.toString()});
						});
						
						categoriasB.forEach(c->{
							mlcModelB.addRow(new Object[] {c.toString()});
						});
						
						
						libro.getIdiomas().forEach(li->{
							mliModelA.addRow(new Object[] {li.toString()});
						});
						
						idiomasB.forEach(i->{
							mliModelB.addRow(new Object[] {i.toString()});
						});
						
						JComboBox<Object> editCbx = mv.getCbx8();
						JComboBox<Object> estCbx = mv.getCbx9();
						
						Editorial editTarget=null;
						
						for(int i = 0 ; i < editCbx.getItemCount(); ++i) {
							if(editCbx.getItemAt(i).toString().contentEquals(libro.getEditorial().toString())) {
								editTarget = (Editorial) editCbx.getItemAt(i);
								break;
							}
						}
						
						Estado estTarget =null;
						
						for(int i = 0; i< estCbx.getItemCount(); ++i) {
							if(estCbx.getItemAt(i).toString().contentEquals(libro.getEstado().toString())) {
								estTarget = (Estado) estCbx.getItemAt(i);
								break;
							}
						}
						
						
						
						mv.getCbx8().setSelectedItem(editTarget);
						mv.getCbx9().setSelectedItem(estTarget);
						
						
						mv.getTxt10().setText(String.valueOf(libro.getPrecioRef()));
						mv.getTxt11().setText(String.valueOf(libro.getAnioPublicacion()));
						
					}
				}
				
				
			}
			
		});
		
		
		
	}
	
	private void initShow(DsbShowView sv) {
		showView = sv;
		
		DefaultTableModel shTModel = initTableModel(new DefaultTableModel());

		showView.getTable().setModel(shTModel);
		CustomizeDs.customizeJTable(showView.getTable());
		
	}
	
	private void initSearch(DsbSearchView sv) {
		searchView = sv;
		
		JComboBox<Object> sCbx = searchView.getSelectCbx();
		searchView.getSelectLbl().setText("Buscar por");
		searchView.getLbl1().setText(v.getNumeroSerieLbl());
		sCbx.addItem(v.getNumeroSerieLbl());
		sCbx.addItem(v.getIsbnLbl());
		sCbx.addItem(v.getTituloLbl());
		sCbx.addItem(v.getNumeroPaginasLbl());
		sCbx.addItem(v.getAutorLbl());
		sCbx.addItem(v.getCategoriaLbl());
		sCbx.addItem(v.getIdiomaLbl());
		sCbx.addItem(v.getEstadoLbl());
		sCbx.addItem(v.getEditorialLbl());
		sCbx.addItem(v.getPrecioReferenciaLbl());
		sCbx.addItem(v.getFechaPublicacionLbl());
		
		JPanel sFields = sv.getFields();
		
		
		searchView.getLbl3().setAlignmentX(JLabel.CENTER_ALIGNMENT);
		searchView.getLbl3().setHorizontalAlignment(JLabel.CENTER);
		searchView.getLbl3().setText("");
		
		sFields.add(searchView.getLbl3(), "cell 1 2");
		
		
		sCbx.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				searchView.getLbl1().setText((String)sCbx.getSelectedItem());
				
			}
			
		});
		DefaultTableModel seTModel = initTableModel(new DefaultTableModel());
		
		
		searchView.getTable().setModel(seTModel);
		CustomizeDs.customizeJTable(searchView.getTable());
		
		searchView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				search();
			}
			
		});
		
		JTable table = searchView.getTable();
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRow() != -1) {
					searchView.getLbl3().setText(String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())));
				}else {
					deleteView.getLbl3().setText("");
				}
			}
		});
		
		
	}
	
	private void initDelete(DsbDeleteView dv) {
		deleteView = dv;
		
		JComboBox<Object> dCbx = deleteView.getSelectCbx();
		deleteView.getSelectLbl().setText("Buscar por");
		deleteView.getLbl1().setText(v.getNumeroSerieLbl());
		deleteView.getLbl2().setText("Seleccionado");
		deleteView.getLbl3().setText("ninguno");
		
		dCbx.addItem(v.getNumeroSerieLbl());
		dCbx.addItem(v.getIsbnLbl());
		dCbx.addItem(v.getTituloLbl());
		dCbx.addItem(v.getNumeroPaginasLbl());
		dCbx.addItem(v.getAutorLbl());
		dCbx.addItem(v.getCategoriaLbl());
		dCbx.addItem(v.getIdiomaLbl());
		dCbx.addItem(v.getEstadoLbl());
		dCbx.addItem(v.getEditorialLbl());
		dCbx.addItem(v.getPrecioReferenciaLbl());
		dCbx.addItem(v.getFechaPublicacionLbl());
		
		dCbx.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				deleteView.getLbl1().setText((String)dCbx.getSelectedItem());
				
			}
			
		});
		DefaultTableModel dTModel = initTableModel(new DefaultTableModel());

		JTable table = deleteView.getTable();
		
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRow() != -1) {
					deleteView.getLbl3().setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
				}
				
				
			}
			
		});
		
		
		table.setModel(dTModel);
		CustomizeDs.customizeJTable(deleteView.getTable());
		
		deleteView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				refreshDelete();
			}
			
		});
		
		deleteView.getDeleteBtn().getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				delete();
			}
		});
		
	}
	
	
	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			initRegister((DsbRegisterView) crudView);
			break;
			
		case "modify":
			initModify((DsbModifyView) crudView);
			break;
			
		case "show":
			initShow((DsbShowView) crudView);
			break;
			
		case "search":
			initSearch((DsbSearchView) crudView);
			break;
			
		case "delete":
			initDelete((DsbDeleteView) crudView);
			break;
		}	
	}
		
	protected DefaultTableModel initTableModel(DefaultTableModel model ) {

		model.addColumn("Num. Serie");
		model.addColumn("ISBN");
		model.addColumn("Titulo");
		model.addColumn("Num. Pág");
		model.addColumn("Autor/es");
		model.addColumn("Categoría/s");
		model.addColumn("Idioma/s");
		model.addColumn("Editorial");
		model.addColumn("Estado");
		model.addColumn("Precio ref.");
		model.addColumn("Fecha publi.");
		
		
		
		
		return model;
	}
	
	
	
	
	
	private class ModifyTxtKeyListener extends KeyAdapter{
		int id;
		
		public ModifyTxtKeyListener(int id) {
			this.id = id;
		}
		
		
		@Override
		public void keyReleased(KeyEvent e) {
			checkErrorModify(id);
			
		}
	}
	
	
	private class RegisterTxtKeyListener  extends KeyAdapter{

		int id;
		
		public RegisterTxtKeyListener(int id) {
			this.id = id;
		}
		

		@Override
		public void keyReleased(KeyEvent e) {
			checkErrorRegister(id);
			
		}
		
	}
}
