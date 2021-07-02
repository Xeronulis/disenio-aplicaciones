package dashboardControllers;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.DistribuidorDAO;
import model.dto.Distribuidor;
import utils.Validador;
import model.dto.Distribuidor;

public class DsbBaseDistController extends DsbBaseController {

	private DsbBaseDistView v;
	
	private boolean[] registerError = new boolean[5];
	private boolean[] modifyError = new boolean[5];
	private boolean deleteError;
	
	private List<Distribuidor> distribuidores;
	
	private Validador<Distribuidor> validador = new Validador<>();
	
	public DsbBaseDistController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseDistView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	
	private void refreshAutorList() {
		distribuidores = DistribuidorDAO.getAll();
		validador.setList(distribuidores);
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
			Distribuidor distribuidor = new Distribuidor();
			
			
			
			distribuidor.setRut(registerView.getTxt1().getText().strip());
			distribuidor.setName(registerView.getTxt2().getText().strip());
			distribuidor.setDir(registerView.getTxt3().getText().strip());
			distribuidor.setTel(Integer.parseInt(registerView.getTxt4().getText().strip()));
			distribuidor.setStartYear(Integer.parseInt(registerView.getTxt5().getText().strip()));
			
			DistribuidorDAO.save(distribuidor);
			
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
			
			Distribuidor edit = new Distribuidor();
			Distribuidor distSel = distribuidores.stream().filter(i-> i.getName().contentEquals((String)mv.getSelectCbx().getSelectedItem())).findFirst().orElse(null);
			
			
			String target= distSel.getRut();
			
			edit.setRut(mv.getTxt1().getText().strip());
			edit.setName(mv.getTxt2().getText().strip());
			edit.setDir(mv.getTxt3().getText().strip());
			edit.setTel(Integer.parseInt(mv.getTxt4().getText().strip()));
			edit.setStartYear(Integer.parseInt(mv.getTxt5().getText().strip()));
			
			DistribuidorDAO.update(edit,target);
			
			resetModify();
		}
		
	}
	
	private void show() {
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		distribuidores.forEach(e->{
			tmodel.addRow(new Object[] {e.getRut(), e.getName(), e.getDir(), e.getTel(), e.getStartYear()});
		});
		
		
	}
	
	private void search() {
		String filtro =((String) searchView.getSelectCbx().getSelectedItem());
		
		switch(filtro) {
		
		case "Nombre": filtro = "nombreEmpresa";
			break;
		case "Dirección": filtro = "direccion";
			break;
		case "Teléfono": filtro ="telefono";
			break;
		case "Fecha de inicio": filtro ="inicioDistribuidor";
			break;
		}
		
		
		String target = searchView.getTxt1().getText().strip();
		List<Distribuidor> edits = DistribuidorDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getRut(), e.getName(), e.getDir(), e.getTel(), e.getStartYear()});
		});
		
		
	}
	
	private void delete() {
		
		Distribuidor distSel = distribuidores.stream().filter(a-> a.getName().contentEquals(deleteView.getLbl3().getText())).findFirst().orElse(null);
		
		if(distSel.getIdFacturas().contains(0)) {
			JTable table = deleteView.getTable();
			String target = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));

						
			if(!deleteError) {
				DistribuidorDAO.delete(target);
				refreshDelete();
				
			}	
		}
		
		
	}
	
	
	private void refreshModify() {
		
		List<Distribuidor> edits = DistribuidorDAO.getAll();
		JComboBox<Object> cbx = modifyView.getSelectCbx();
		cbx.removeAllItems();
		if(edits != null) {
			edits.forEach(e->{
				cbx.addItem(e.toString());
			});
		}
		
	}
	
	private void refreshDelete() {
		
		String filtro =((String) deleteView.getSelectCbx().getSelectedItem());

		switch(filtro) {
		
		case "Nombre": filtro = "nombreEmpresa";
			break;
		case "Dirección": filtro = "direccion";
			break;
		case "Teléfono": filtro ="telefono";
			break;
		case "Fecha de inicio": filtro ="inicioDistribuidor";
			break;
		}
		
		
		String target = deleteView.getTxt1().getText().strip();
		List<Distribuidor> edits = DistribuidorDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
				
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getRut(), e.getName(), e.getDir(), e.getTel(), e.getStartYear()});
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
		DsbRegisterView rv = registerView;
		
		
		switch (id) {
		
		case 1:
			registerError[id-1] = validador.checkRutRepeated(rv.getTxt1(), rv.getWarning1());
			break;
			
		case 2:
			registerError[id-1] = validador.checkStringRepeated(rv.getTxt2(), rv.getWarning2(), validador.NOMBRE);
			break;
		
		case 3:
			registerError[id-1] = validador.checkStringRepeated(rv.getTxt3(), rv.getWarning3(), validador.DIRECCION);
			break;
			
		case 4:
			registerError[id-1] = validador.checkNumberRepeated(rv.getTxt4(), rv.getWarning4(), validador.TELEFONO);
			break;
			
		case 5:
			registerError[id-1] = validador.checkNumber(rv.getTxt5(), rv.getWarning5(), validador.ANIO_INICIO);
			break;
			
		}	
		
	}
	
	private void checkErrorModify(int id) {
		
		DsbModifyView mv = modifyView;
		
		Distribuidor distSel = distribuidores.stream().filter(i-> i.getName().contentEquals((String)mv.getSelectCbx().getSelectedItem())).findFirst().orElse(null);
		
		
		switch (id) {
		
		case 0:
			for(int i=1;i<=5;++i) {
				checkErrorModify(i);
			}
			break;
		
		
		case 1:
			modifyError[id-1] = validador.checkRutRepeated(mv.getTxt1(), mv.getWarning1(), distSel);
			break;
			
		case 2:
			modifyError[id-1] = validador.checkStringRepeated(mv.getTxt2(), mv.getWarning2(), distSel, validador.NOMBRE);
			break;
		
		case 3:
			modifyError[id-1] = validador.checkStringRepeated(mv.getTxt3(), mv.getWarning3(), distSel, validador.DIRECCION);
			break;
			
		case 4:
			modifyError[id-1] = validador.checkNumberRepeated(mv.getTxt4(), mv.getWarning4(), distSel, validador.TELEFONO);
			break;
			
		case 5:
			modifyError[id-1] = validador.checkNumber(mv.getTxt5(), mv.getWarning5(), validador.ANIO_INICIO);
			break;
		}	
	}
	
	

	
	private void checkErrorDelete() {
		DsbDeleteView dv = deleteView;
		
		Distribuidor eFound = distribuidores.stream().filter(a-> a.getName().contentEquals(dv.getLbl3().getText())).findFirst().orElse(null);
		
		
		if(eFound != null && !eFound.getIdFacturas().contains(0)) {
			dv.getWarning1().setVisible(true);
			dv.getWarning1().setText("El distribuidor está vinculado");
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
		
		registerView.getLbl1().setText(v.getDistRutLbl());
		registerView.getLbl2().setText(v.getDistNameLbl());
		registerView.getLbl3().setText(v.getDistAddressLbl());
		registerView.getLbl4().setText(v.getDistPhoneLbl());
		registerView.getLbl5().setText(v.getDistStartDateLbl());

		
		int rCompCount = rFields.getComponentCount();
		/*cantidad de filas a establecer, (x * a) donde x es el numero de filas, y A es cuantos elementos hay en esa fila
		 * 
		 * 
		 */
		int rowCount = (5 * 3); 
		
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
		registerView.getTxt4().addKeyListener(new RegisterTxtKeyListener(4));
		registerView.getTxt5().addKeyListener(new RegisterTxtKeyListener(5));
		
	}
	
	

	
	
	
	
	private void initModify(DsbModifyView mv) {
		modifyView = mv;
		
		modifyView.getSelectLbl().setText(v.getSelectLbl());
		
		JPanel mFields = modifyView.getFields();
		
		modifyView.getLbl1().setText(v.getDistRutLbl());
		modifyView.getLbl2().setText(v.getDistNameLbl());
		modifyView.getLbl3().setText(v.getDistAddressLbl());
		modifyView.getLbl4().setText(v.getDistPhoneLbl());
		modifyView.getLbl5().setText(v.getDistStartDateLbl());
		
		int mCompCount = mFields.getComponentCount();

		int rowCount = (6*3);
		
		for(int i =rowCount; i< mCompCount ;++i) {
			mFields.remove(rowCount);
		}	
		
		
		
		
		mFields.add(modifyView.getCommitBtn(), "cell 1 "+Math.round((double)rowCount/3));
		
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
					Distribuidor distribuidor = distribuidores.stream().filter(a->a.getName()
							.contentEquals(((String) modifyView.getSelectCbx().getSelectedItem()))).findFirst().orElse(null);
					
					if(distribuidor != null) {
						modifyView.getTxt1().setText(distribuidor.getRut());
						modifyView.getTxt2().setText(distribuidor.getName());
						modifyView.getTxt3().setText(distribuidor.getDir());
						modifyView.getTxt4().setText(String.valueOf(distribuidor.getTel()));
						modifyView.getTxt5().setText(String.valueOf(distribuidor.getStartYear()));
						checkErrorModify(0);
					}
					
					
				}
				
			}
			
		});
		
		
		modifyView.getTxt1().addKeyListener(new ModifyTxtKeyListener(1));
		modifyView.getTxt2().addKeyListener(new ModifyTxtKeyListener(2));
		modifyView.getTxt3().addKeyListener(new ModifyTxtKeyListener(3));
		modifyView.getTxt4().addKeyListener(new ModifyTxtKeyListener(4));
		modifyView.getTxt5().addKeyListener(new ModifyTxtKeyListener(5));
		
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
		searchView.getLbl1().setText(v.getDistRutLbl());
		sCbx.addItem(v.getDistRutLbl());      
		sCbx.addItem(v.getDistNameLbl());     
		sCbx.addItem(v.getDistAddressLbl());  
		sCbx.addItem(v.getDistPhoneLbl());    
		sCbx.addItem(v.getDistStartDateLbl());
		
		
		
		
		
		
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
		deleteView.getLbl1().setText(v.getDistRutLbl());
		deleteView.getLbl2().setText("Seleccionado");
		deleteView.getLbl3().setText("ninguno");
		
		dCbx.addItem(v.getDistRutLbl());      
		dCbx.addItem(v.getDistNameLbl());     
		dCbx.addItem(v.getDistAddressLbl());  
		dCbx.addItem(v.getDistPhoneLbl());    
		dCbx.addItem(v.getDistStartDateLbl());
		
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

					deleteView.getLbl3().setText((String) table.getValueAt(table.getSelectedRow(), 1));
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
		model.addColumn("Rut");
		model.addColumn("Nombre de empresa");
		model.addColumn("Dirección");
		model.addColumn("Teléfono");
		model.addColumn("Fecha de inicio");
		
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
