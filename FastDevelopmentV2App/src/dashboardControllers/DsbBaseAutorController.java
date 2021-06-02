package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import customItems.CustomizeDs;
import dashboardViews.DsbBaseAutorView;
import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.AutorDAO;
import model.dao.AutorDAO;
import model.dto.Autor;

public class DsbBaseAutorController extends DsbBaseController {

	private DsbBaseAutorView v;
	
	private boolean[] registerError = new boolean[1];
	private boolean[] modifyError = new boolean[1];
	private boolean deleteError;
	
	private List<Autor> autores;
	
	public DsbBaseAutorController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseAutorView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	private void refreshAutorList() {
		autores = AutorDAO.getAll();
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
			Autor autor = new Autor();
			
			autor.setNombre(registerView.getTxt1().getText());
			autor.setApellidoP(registerView.getTxt2().getText());
			autor.setApellidoM(registerView.getTxt3().getText());
			
			AutorDAO.save(autor);
			
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
			
			Autor edit = new Autor();
			String concatName = ((String) mv.getSelectCbx().getSelectedItem()).replace(" ", "");
			Autor autorSel = autores.stream().filter(i-> i.getNameConcat().replace(" ", "").contentEquals(concatName)).findFirst().orElse(null);
			
			
			String[] target= autorSel.getAllNames();
			
			edit.setNombre(mv.getTxt1().getText().strip());
			edit.setApellidoP(mv.getTxt2().getText().strip());
			edit.setApellidoM(mv.getTxt3().getText().strip());
			
			AutorDAO.update(edit,target);
			
			resetModify();
		}
		
	}
	
	private void show() {
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		autores.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre(), e.getApellidoP(), e.getApellidoM()});
		});
		
		
	}
	
	private void search() {
		String filtro =((String) searchView.getSelectCbx().getSelectedItem()).replace(" ", "");
		String target = searchView.getTxt1().getText().strip();
		List<Autor> edits = AutorDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre(), e.getApellidoP(), e.getApellidoM()});
		});
		
		
	}
	
	private void delete() {
		
		String nameConcat = deleteView.getLbl3().getText().strip().replace(" ", "").toLowerCase();
		Autor autorSel = autores.stream().filter(a-> a.getNameConcat().toLowerCase().contentEquals(nameConcat)).findFirst().orElse(null);
		
		if(autorSel.getLibros().contains(null)) {
			JTable table = deleteView.getTable();
			String[] target= new String[3];
			
			for(int i =0; i<target.length;++i) {
				target[i] = (String) table.getValueAt(table.getSelectedRow(), i);
			}
			
			
			if(!deleteError) {
				AutorDAO.delete(target);
				refreshDelete();
				
			}	
		}
		
		
	}
	
	
	private void refreshModify() {
		
		List<Autor> edits = AutorDAO.getAll();
		JComboBox<Object> cbx = modifyView.getSelectCbx();
		cbx.removeAllItems();
		if(edits != null) {
			edits.forEach(e->{
				cbx.addItem(e.toString());
			});
		}
		
	}
	
	private void refreshDelete() {
		
		String filtro =((String) deleteView.getSelectCbx().getSelectedItem()).replace(" ", "");
		String target = deleteView.getTxt1().getText().strip();
		List<Autor> edits = AutorDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
				
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre(), e.getApellidoP(), e.getApellidoM()});
		});
		
	}
	

	
	
	public void resetRegister() {
		registerError[0] = true;
		refreshAutorList();
		
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
		
	}
	
	public void resetModify() {
		modifyError[0] = true;
		refreshAutorList();
		
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
		refreshAutorList();
		show();
	}
	
	
	public void resetSearch() {
		refreshAutorList();
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		tmodel.setRowCount(0);
		
	}
	
	
	public void resetDelete() {
		refreshAutorList();
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
		tmodel.setRowCount(0);
		
		deleteError = true;
		deleteView.getAllWarnLabels().forEach(w->{
			if(w != null) {
				w.setVisible(false);
			}
		});
			
	}
	
	private void checkErrorRegister(int id) {
		
		
		switch (id) {
		
		case 1:
			checkErrorRegisterFunc();
			break;
			
		case 2:
			checkErrorRegisterFunc();
			break;
		
		case 3:
			checkErrorRegisterFunc();
			break;
		}	
		
	}
	
	private void checkErrorRegisterFunc() {
		DsbRegisterView rv = registerView;
		
		if(rv.getTxt1().getText().isBlank()) {
			rv.getWarning1().setVisible(true);
			rv.getWarning1().setText("Nombre vacío");
			registerError[0] = true;
		}else {
			String nameConcat =rv.getTxt1().getText()+rv.getTxt2().getText()+rv.getTxt3().getText() ;
			Autor autor = autores.stream().filter(e->e.getNameConcat().toLowerCase().contentEquals(nameConcat.toLowerCase())).findFirst().orElse(null);
			if(autor != null) {
					rv.getWarning1().setVisible(true);
					rv.getWarning1().setText("Autor ya registrado");
					registerError[0] = true;
				}else {
					rv.getWarning1().setVisible(false);
					rv.getWarning1().setText("");
					registerError[0] = false;
				}
		}
	}
	
	
	private void checkErrorModify(int id) {
		switch (id) {
		
		case 1:
			checkErrorModifyFunc();		
			break;
			
		case 2:
			checkErrorModifyFunc();
			break;
		
		case 3:
			checkErrorModifyFunc();
			break;
		}	
	}
	
	private void checkErrorModifyFunc() {
		DsbModifyView mv = modifyView;
		String concatName = ((String) modifyView.getSelectCbx().getSelectedItem()).replace(" ", "");
		Autor autorSel = autores.stream().filter(i-> i.getNameConcat().replace(" ", "").contentEquals(concatName)).findFirst().orElse(null);
		
		
		if(mv.getTxt1().getText().isBlank()) {
			mv.getWarning1().setVisible(true);
			mv.getWarning1().setText("Nombre vacío");
			modifyError[0] = true;
		}else {
			
			String nameConcat = mv.getTxt1().getText().strip().replace(" ", "")
								+mv.getTxt2().getText().strip().replace(" ", "")
								+mv.getTxt3().getText().strip().replace(" ", "");
			Autor autor = autores.stream().filter(e->e.getNameConcat().toLowerCase().contentEquals(nameConcat.toLowerCase())).findFirst().orElse(null);
			
			
			if(autor != null && autorSel.getNameConcat().contentEquals(autor.getNameConcat())) {
				autor = null;
			}
			if(autor != null) {
				mv.getWarning1().setVisible(true);
				mv.getWarning1().setText("Autor ya registrado");
				modifyError[0] = true;
			}else {
				mv.getWarning1().setVisible(false);
				mv.getWarning1().setText("");
				modifyError[0] = false;
			}
		}
	}
	
	private void checkErrorDelete() {
		DsbDeleteView dv = deleteView;
		
		String nameConcat = deleteView.getLbl3().getText().strip().replace(" ", "").toLowerCase();
		Autor eFound = autores.stream().filter(a-> a.getNameConcat().toLowerCase().contentEquals(nameConcat)).findFirst().orElse(null);
		
		if(eFound != null && !eFound.getLibros().contains(null)) {
			dv.getWarning1().setVisible(true);
			dv.getWarning1().setText("El autor está vinculado");
			deleteError = true;
		}else {
			dv.getWarning1().setVisible(false);
			dv.getWarning1().setText("");
			deleteError = false;
		}
		
		
		
	}
	private void initRegister(DsbRegisterView crudView) {
		registerView = crudView;
		JPanel rFields = registerView.getFields();
		
		registerView.getLbl1().setText(v.getNombreLbl());
		registerView.getLbl2().setText(v.getApellido1Lbl());
		registerView.getLbl3().setText(v.getApellido2Lbl());
		
		int rCompCount = rFields.getComponentCount();
		/*cantidad de filas a establecer, (x * a) donde x es el numero de filas, y A es cuantos elementos hay en cada fila
		 * 
		 * 
		 */
		int rowCount = (3 * 3); 
		
		for(int i =rowCount; i< rCompCount ;++i) {
			rFields.remove(rowCount);
		}		
		rFields.add(registerView.getCommitBtn(), "cell 1 "+rowCount/3);
		
		registerView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				register();
			}
		});
		
		registerView.getTxt1().addKeyListener(new RegisterTxtKeyListener(1));
		registerView.getTxt2().addKeyListener(new RegisterTxtKeyListener(2));
		registerView.getTxt3().addKeyListener(new RegisterTxtKeyListener(3));
		
	}
	
	
	
	private void initModify(DsbModifyView mv) {
		modifyView = mv;
		
		modifyView.getSelectLbl().setText(v.getSelectLbl());
		
		JPanel mFields = modifyView.getFields();
		
		modifyView.getLbl1().setText(v.getNombreLbl());
		modifyView.getLbl2().setText(v.getApellido1Lbl());
		modifyView.getLbl3().setText(v.getApellido2Lbl());
		
		int mCompCount = mFields.getComponentCount();

		int rowCount = 4*3;
		
		for(int i =rowCount; i< mCompCount ;++i) {
			mFields.remove(rowCount);
		}	

		mFields.add(modifyView.getCommitBtn(), "cell 1 "+rowCount/3);
		
		modifyView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e){
				modify();
			}
		});
		
		modifyView.getSelectCbx().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(modifyView.getSelectCbx().getSelectedItem() != null) {
					Autor autor = autores.stream().filter(a->a.getNameConcat().toLowerCase()
							.contentEquals(((String) modifyView.getSelectCbx().getSelectedItem())
									.toLowerCase().replace(" ",""))).findFirst().orElse(null);
					
					if(autor != null) {
						modifyView.getTxt1().setText(autor.getNombre());
						modifyView.getTxt2().setText(autor.getApellidoP());
						modifyView.getTxt3().setText(autor.getApellidoM());
						checkErrorModifyFunc();
					}
					
					
				}
				
			}
			
		});
		
		
		modifyView.getTxt1().addKeyListener(new ModifyTxtKeyListener(1));
		modifyView.getTxt2().addKeyListener(new ModifyTxtKeyListener(2));
		modifyView.getTxt3().addKeyListener(new ModifyTxtKeyListener(3));
		
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
		searchView.getLbl1().setText(v.getNombreLbl());
		sCbx.addItem(v.getNombreLbl());
		sCbx.addItem(v.getApellido1Lbl());
		sCbx.addItem(v.getApellido2Lbl());
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
	}
	
	private void initDelete(DsbDeleteView dv) {
		deleteView = dv;
		
		JComboBox<Object> dCbx = deleteView.getSelectCbx();
		deleteView.getSelectLbl().setText("Buscar por");
		deleteView.getLbl1().setText(v.getApellido1Lbl());
		deleteView.getLbl2().setText("Seleccionado");
		deleteView.getLbl3().setText("ninguno");
		
		dCbx.addItem(v.getNombreLbl());
		dCbx.addItem(v.getApellido1Lbl());
		dCbx.addItem(v.getApellido2Lbl());
		
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
					String lbl3Text="";
					for(int i=0; i<table.getModel().getColumnCount();++i) {
						lbl3Text = lbl3Text.concat((String) table.getValueAt(table.getSelectedRow(), i)+ " ");

					}
					deleteView.getLbl3().setText(lbl3Text);
					checkErrorDelete();
				}else {
					deleteView.getLbl3().setText("ninguno");
					checkErrorDelete();
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
		
	private DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Nombre");
		model.addColumn("Apellido Paterno");
		model.addColumn("Apellido Materno");
		
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
