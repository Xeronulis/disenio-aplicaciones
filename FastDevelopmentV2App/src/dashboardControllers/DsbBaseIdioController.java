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
import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbBaseIdioView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.IdiomaDAO;
import model.dto.Editorial;
import model.dto.Idioma;
import utils.Validador;
import model.dto.Idioma;

public class DsbBaseIdioController extends DsbBaseController {

	private DsbBaseIdioView v;
	
	private boolean[] registerError = new boolean[1];
	private boolean[] modifyError = new boolean[1];
	private boolean deleteError;
	
	private Validador<Idioma> validador = new Validador<>();
	private List<Idioma> idiomas;
	
	public DsbBaseIdioController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseIdioView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	private void refreshIdiomaList() {
		idiomas = IdiomaDAO.getAll();
		validador.setList(idiomas);
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
			Idioma idio = new Idioma();
			
			idio.setName(registerView.getTxt1().getText());
			
			IdiomaDAO.save(idio);
			
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
			
			String selStr = (String) modifyView.getSelectCbx().getItemAt(modifyView.getSelectCbx().getSelectedIndex());
			
			Idioma sel = idiomas.stream().filter(e-> e.getName().contentEquals(selStr)).findFirst().orElse(null);
			int target = sel.getId();
			Idioma idio = new Idioma();
			
			idio.setName(modifyView.getTxt1().getText());
			
			IdiomaDAO.update(idio,target);
			
			resetModify();
		}
		
	}
	
	private void show() {
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		idiomas.forEach(e->{
			tmodel.addRow(new Object[] {e.getName()});
		});
		
		
	}
	
	private void search() {
		String filtro =(String)searchView.getSelectCbx().getSelectedItem();
		String target = searchView.getTxt1().getText().strip();
		List<Idioma> edits = IdiomaDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getName()});
		});
		
		
	}
	
	private void delete() {
		
		Idioma sel= idiomas.stream().filter(e-> e.getName().contentEquals(deleteView.getLbl3().getText())).findFirst().orElse(null);
		
		int target = sel.getId();
		
		if(!deleteError) {
			IdiomaDAO.delete(target);
			refreshDelete();
			
		}	
	}
	
	
	private void refreshModify() {
		
		List<Idioma> edits = IdiomaDAO.getAll();
		JComboBox<Object> cbx = modifyView.getSelectCbx();
		cbx.removeAllItems();
		if(edits != null) {
			edits.forEach(e->{
				cbx.addItem(e.toString());
			});
		}
		
	}
	
	private void refreshDelete() {
		
		String filtro =(String)deleteView.getSelectCbx().getSelectedItem();
		String target = deleteView.getTxt1().getText().strip();
		List<Idioma> edits = IdiomaDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
				
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getName()});
		});
		
	}
	

	
	
	public void resetRegister() {
		registerError[0] = true;
		refreshIdiomaList();
		
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
		refreshIdiomaList();
		
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
		refreshIdiomaList();
		show();
	}
	
	
	public void resetSearch() {
		refreshIdiomaList();
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		tmodel.setRowCount(0);
		
	}
	
	
	public void resetDelete() {
		refreshIdiomaList();
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
		DsbRegisterView rv = registerView;
		
		switch (id) {
		
		case 1:
			registerError[id-1] = validador.checkStringRepeated(rv.getTxt1(), rv.getWarning1(), validador.NOMBRE);
			break;
		}
		
	}
	
	private void checkErrorModify(int id) {
		DsbModifyView mv = modifyView;
		Idioma idiomaSel = idiomas.stream().filter(i-> i.getName().contentEquals(modifyView.getSelectCbx().getSelectedItem().toString())).findFirst().orElse(null);
		
		switch (id) {
		
		case 1:
			modifyError[id-1] = validador.checkStringRepeated(mv.getTxt1(), mv.getWarning1(), idiomaSel, validador.NOMBRE);
			break;
		}	
	}
	
	private void checkErrorDelete() {
		DsbDeleteView dv = deleteView;
		
		Idioma eFound = idiomas.stream().filter(e->e.getName().toLowerCase().contentEquals(dv.getLbl3().getText().toLowerCase())).findFirst().orElse(null);
			if(eFound != null && !eFound.getLibros().contains(null)) {
				dv.getWarning1().setVisible(true);
				dv.getWarning1().setText("El idioma est� vinculado");
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
		
		registerView.getLbl1().setText(v.getIdioLangLbl());
		
		int rCompCount = rFields.getComponentCount();
		/*cantidad de filas a establecer, (x * a) donde x es el numero de filas, y A es cuantos elementos hay en esa fila
		 * 
		 * 
		 */
		int rowCount = (1 * 3); 
		
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
	}
	
	

	
	
	
	
	private void initModify(DsbModifyView mv) {
		modifyView = mv;
		
		modifyView.getSelectLbl().setText(v.getSelectLbl());
		
		JPanel mFields = modifyView.getFields();
		
		modifyView.getLbl1().setText(v.getIdioLangLbl());
		
		int mCompCount = mFields.getComponentCount();
		int rowCount = 2*3;
		
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
					Idioma idioma = idiomas.stream().filter(i -> i.getName().contentEquals(modifyView.getSelectCbx().getSelectedItem().toString())).findFirst().orElse(null);
					if(idioma != null) {
						modifyView.getTxt1().setText(idioma.getName());
						checkErrorModify(1);
					}
				}
				
			}
			
		});
		
		
		modifyView.getTxt1().addKeyListener(new ModifyTxtKeyListener(1));
		
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
		searchView.getLbl1().setText(v.getIdioLangLbl());
		sCbx.addItem(v.getIdioLangLbl());
		
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
		deleteView.getLbl1().setText(v.getIdioLangLbl());
		deleteView.getLbl2().setText("Seleccionado");
		deleteView.getLbl3().setText("ninguno");
		
		dCbx.addItem(v.getIdioLangLbl());
		
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
					deleteView.getLbl3().setText((String) table.getValueAt(table.getSelectedRow(), 0));
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
		
	protected DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Idioma");
		
		
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
