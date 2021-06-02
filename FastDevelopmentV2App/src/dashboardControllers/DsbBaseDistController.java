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
import model.dto.Distribuidor;

public class DsbBaseDistController extends DsbBaseController {

	private DsbBaseDistView v;
	
	private boolean[] registerError = new boolean[5];
	private boolean[] modifyError = new boolean[5];
	private boolean deleteError;
	
	private List<Distribuidor> distribuidores;
	
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
			distribuidor.setNombre(registerView.getTxt2().getText().strip());
			distribuidor.setDireccion(registerView.getTxt3().getText().strip());
			distribuidor.setTelefono(Integer.parseInt(registerView.getTxt4().getText().strip()));
			distribuidor.setAnioInicio(java.sql.Date.valueOf(registerView.getTxt5().getText().strip()));
			
			System.out.println(distribuidor.getAnioInicio());
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
			Distribuidor distSel = distribuidores.stream().filter(i-> i.getNombre().contentEquals((String)mv.getSelectCbx().getSelectedItem())).findFirst().orElse(null);
			
			
			String target= distSel.getRut();
			
			edit.setRut(mv.getTxt1().getText().strip());
			edit.setNombre(mv.getTxt2().getText().strip());
			edit.setDireccion(mv.getTxt3().getText().strip());
			edit.setTelefono(Integer.parseInt(mv.getTxt4().getText().strip()));
			edit.setAnioInicio(java.sql.Date.valueOf(mv.getTxt5().getText().strip()));
			
			DistribuidorDAO.update(edit,target);
			
			resetModify();
		}
		
	}
	
	private void show() {
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		distribuidores.forEach(e->{
			tmodel.addRow(new Object[] {e.getRut(), e.getNombre(), e.getDireccion(), e.getTelefono(), e.getAnioInicio()});
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
			tmodel.addRow(new Object[] {e.getRut(), e.getNombre(), e.getDireccion(), e.getTelefono(), e.getAnioInicio()});
		});
		
		
	}
	
	private void delete() {
		
		Distribuidor distSel = distribuidores.stream().filter(a-> a.getNombre().contentEquals(deleteView.getLbl3().getText())).findFirst().orElse(null);
		
		if(distSel.getIdFacturas().contains(0)) {
			JTable table = deleteView.getTable();
			int target = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));

						
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
			tmodel.addRow(new Object[] {e.getRut(), e.getNombre(), e.getDireccion(), e.getTelefono(), e.getAnioInicio()});
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
			if(rv.getTxt1().getText().isBlank()) {
				rv.getWarning1().setVisible(true);
				rv.getWarning1().setText("Rut vacío");
				registerError[id-1] = true;
			}else {
				
				String txt1 = rv.getTxt1().getText();
				
				
				if(!Pattern.matches("[0-9[k]]+", txt1)) {
					txt1 = txt1.replaceAll("[^0-9[k]]", "");
					rv.getTxt1().setText(txt1);
					
					
				}else {
					while(txt1.split("k", -2).length >2) {
						txt1 = txt1.replaceFirst("k", "");
						rv.getTxt1().setText(txt1);
					}
					if(Pattern.matches("\\S+k\\S+", txt1)) {
						txt1 = txt1.replaceFirst("k", "");
						rv.getTxt1().setText(txt1);
					}
				}
				Distribuidor distribuidor = distribuidores.stream().filter(e->e.getRut().toLowerCase().contentEquals(rv.getTxt1().getText())).findFirst().orElse(null);
				
				if(distribuidor != null) {
					rv.getWarning1().setVisible(true);
					rv.getWarning1().setText("Rut ya registrado");
					registerError[id-1] = true;
				}else {
					rv.getWarning1().setVisible(false);
					rv.getWarning1().setText("");
					registerError[id-1] = false;
				}
			}
			break;
			
		case 2:
			if(rv.getTxt2().getText().isBlank()) {
				rv.getWarning2().setVisible(true);
				rv.getWarning2().setText("Nombre vacío");
				registerError[id-1] = true;
			}else {
				
				Distribuidor distribuidor = distribuidores.stream().filter(e->e.getNombre().toLowerCase().contentEquals(rv.getTxt2().getText().toLowerCase())).findFirst().orElse(null);

				if(distribuidor != null) {
					rv.getWarning2().setVisible(true);
					rv.getWarning2().setText("Nombre ya registrado");
					registerError[id-1] = true;
				}else {
					rv.getWarning2().setVisible(false);
					rv.getWarning2().setText("");
					registerError[id-1] = false;
				}
			}
			break;
		
		case 3:
			if(rv.getTxt3().getText().isBlank()) {
				rv.getWarning3().setVisible(true);
				rv.getWarning3().setText("Dirección vacía");
				registerError[id-1] = true;
			}else {
				
				Distribuidor distribuidor = distribuidores.stream().filter(e->e.getDireccion().toLowerCase().contentEquals(rv.getTxt3().getText().toLowerCase())).findFirst().orElse(null);

				if(distribuidor != null) {
					rv.getWarning3().setVisible(true);
					rv.getWarning3().setText("Dirección ya registrada");
					registerError[id-1] = true;
				}else {
					rv.getWarning3().setVisible(false);
					rv.getWarning3().setText("");
					registerError[id-1] = false;
				}
			}
			break;
			
		case 4:
			if(rv.getTxt4().getText().isBlank()) {
				rv.getWarning4().setVisible(true);
				rv.getWarning4().setText("Teléfono vacío");
				registerError[id-1] = true;
			}else {
				String telefono = rv.getTxt4().getText().strip();
				
				if(!Pattern.matches("[0-9]+", telefono)) {
					telefono = telefono.replaceAll("[^0-9]", "");
					rv.getTxt4().setText(telefono);
				}	
				Distribuidor distribuidor = distribuidores.stream().filter(e->String.valueOf(e.getTelefono()).contentEquals(rv.getTxt4().getText())).findFirst().orElse(null);
				
				if(distribuidor != null) {
					rv.getWarning4().setVisible(true);
					rv.getWarning4().setText("Teléfono ya registrado");
					registerError[id-1] = true;
				}else {
					rv.getWarning4().setVisible(false);
					rv.getWarning4().setText("");
					registerError[id-1] = false;
				}
			}
			break;
			
		case 5:
			
			
			if(rv.getTxt5().getText().isBlank()) {
				rv.getWarning5().setVisible(true);
				rv.getWarning5().setText("Fecha vacía");
				registerError[id-1] = true;
			}else {
				
				String fecha = rv.getTxt5().getText();
				
				if(!Pattern.matches("[0-9[-]]+", fecha)) {
					fecha = fecha.replaceAll("[^0-9[-]]","");
					rv.getTxt5().setText(fecha);
				}
				
				while(fecha.split("-", -2).length>3) {
					fecha = fecha.replaceFirst("--", "-");
					fecha = fecha.replaceFirst("(-\\d+$)|(-$)", "");
					
					rv.getTxt5().setText(fecha);
				}
				
				try {
					java.sql.Date.valueOf(fecha);
					
					registerError[id-1] = false;
					rv.getWarning5().setVisible(false);
					rv.getWarning5().setText("");
					
				}catch (Exception ex) {
					registerError[id-1] = true;
					rv.getWarning5().setVisible(true);
					rv.getWarning5().setText("Fecha inválida");
				}		
			}
			break;
		}	
		
	}
	
	private void checkErrorModify(int id) {
		
		DsbModifyView mv = modifyView;
		
		Distribuidor distSel = distribuidores.stream().filter(i-> i.getNombre().contentEquals((String)mv.getSelectCbx().getSelectedItem())).findFirst().orElse(null);
		
		
		switch (id) {
		
		case 0:
			for(int i=1;i<=5;++i) {
				checkErrorModify(i);
			}
			break;
		
		
		case 1:
			if(mv.getTxt1().getText().isBlank()) {
				mv.getWarning1().setVisible(true);
				mv.getWarning1().setText("Rut vacío");
				modifyError[id-1] = true;
			}else {
				
				String txt1 = mv.getTxt1().getText();
				
				
				if(!Pattern.matches("[0-9[k]]+", txt1)) {
					txt1 = txt1.replaceAll("[^0-9[k]]", "");
					mv.getTxt1().setText(txt1);
					
					
				}else {
					while(txt1.split("k", -2).length >2) {
						txt1 = txt1.replaceFirst("k", "");
						mv.getTxt1().setText(txt1);
					}
					if(Pattern.matches("\\S+k\\S+", txt1)) {
						txt1 = txt1.replaceFirst("k", "");
						mv.getTxt1().setText(txt1);
					}
				
				}
				Distribuidor distribuidor = distribuidores.stream().filter(e->e.getRut().toLowerCase().contentEquals(mv.getTxt1().getText().toLowerCase())).findFirst().orElse(null);
				
				
				if(distribuidor != null && distSel.getNombre().contentEquals(distribuidor.getNombre())) {
					distribuidor = null;
				}
				if(distribuidor != null) {
					mv.getWarning1().setVisible(true);
					mv.getWarning1().setText("Rut ya registrado");
					modifyError[id-1] = true;
				}else {
					mv.getWarning1().setVisible(false);
					mv.getWarning1().setText("");
					modifyError[id-1] = false;
				}
			}	
			break;
			
		case 2:
			if(mv.getTxt2().getText().isBlank()) {
				mv.getWarning2().setVisible(true);
				mv.getWarning2().setText("Nombre vacío");
				modifyError[id-1] = true;
			}else {
				
				Distribuidor distribuidor = distribuidores.stream().filter(e->e.getNombre().toLowerCase().contentEquals(mv.getTxt2().getText().toLowerCase())).findFirst().orElse(null);
				
				
				if(distribuidor != null && distSel.getNombre().contentEquals(distribuidor.getNombre())) {
					distribuidor = null;
				}
				if(distribuidor != null) {
					mv.getWarning2().setVisible(true);
					mv.getWarning2().setText("Nombre ya registrado");
					modifyError[id-1] = true;
				}else {
					mv.getWarning2().setVisible(false);
					mv.getWarning2().setText("");
					modifyError[id-1] = false;
				}
			}
			break;
		
		case 3:
			if(mv.getTxt3().getText().isBlank()) {
				mv.getWarning3().setVisible(true);
				mv.getWarning3().setText("Dirección vacía");
				modifyError[id-1] = true;
			}else {
				
				Distribuidor distribuidor = distribuidores.stream().filter(e->e.getDireccion().toLowerCase().contentEquals(mv.getTxt3().getText().toLowerCase())).findFirst().orElse(null);
				
				
				if(distribuidor != null && distSel.getNombre().contentEquals(distribuidor.getNombre())) {
					distribuidor = null;
				}
				if(distribuidor != null) {
					mv.getWarning3().setVisible(true);
					mv.getWarning3().setText("Dirección ya registrada");
					modifyError[id-1] = true;
				}else {
					mv.getWarning3().setVisible(false);
					mv.getWarning3().setText("");
					modifyError[id-1] = false;
				}
			}
			break;
			
		case 4:
			if(mv.getTxt4().getText().isBlank()) {
				mv.getWarning4().setVisible(true);
				mv.getWarning4().setText("Teléfono vacío");
				modifyError[id-1] = true;
			}else {
				String telefono = mv.getTxt4().getText().strip();
				
				if(!Pattern.matches("[0-9]+", telefono)) {
					telefono = telefono.replaceAll("[^0-9]", "");
					mv.getTxt4().setText(telefono);
				}
				
				
				Distribuidor distribuidor = distribuidores.stream().filter(e->String.valueOf(e.getTelefono()).contentEquals(mv.getTxt4().getText())).findFirst().orElse(null);
				
				
				if(distribuidor != null && distSel.getNombre().contentEquals(distribuidor.getNombre())) {
					distribuidor = null;
				}
				if(distribuidor != null) {
					mv.getWarning4().setVisible(true);
					mv.getWarning4().setText("Teléfono ya registrado");
					modifyError[id-1] = true;
				}else {
					mv.getWarning4().setVisible(false);
					mv.getWarning4().setText("");
					modifyError[id-1] = false;
				}
			}
			break;
			
		case 5:
			
			
			if(mv.getTxt5().getText().isBlank()) {
				mv.getWarning5().setVisible(true);
				mv.getWarning5().setText("Fecha vacía");
				modifyError[id-1] = true;
			}else {
				
				String fecha = mv.getTxt5().getText();
				
				if(!Pattern.matches("[0-9[-]]+", fecha)) {
					fecha = fecha.replaceAll("[^0-9[-]]","");
					mv.getTxt5().setText(fecha);
				}
				
				while(fecha.split("-", -2).length>3) {
					fecha = fecha.replaceFirst("--", "-");
					fecha = fecha.replaceFirst("(-\\d+$)|(-$)", "");
					
					mv.getTxt5().setText(fecha);
				}
				
				try {
					java.sql.Date.valueOf(fecha);
					
					modifyError[id-1] = false;
					mv.getWarning5().setVisible(false);
					mv.getWarning5().setText("");
					
				}catch (Exception ex) {
					modifyError[id-1] = true;
					mv.getWarning5().setVisible(true);
					mv.getWarning5().setText("Fecha inválida");
				}		
			}
			break;
		}	
	}
	
	

	
	private void checkErrorDelete() {
		DsbDeleteView dv = deleteView;
		
		String nameConcat = deleteView.getLbl3().getText().strip().replace(" ", "").toLowerCase();
		Distribuidor eFound = distribuidores.stream().filter(a-> a.getNombre().contentEquals(dv.getLbl3().getText())).findFirst().orElse(null);
		
		
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
					Distribuidor distribuidor = distribuidores.stream().filter(a->a.getNombre()
							.contentEquals(((String) modifyView.getSelectCbx().getSelectedItem()))).findFirst().orElse(null);
					
					if(distribuidor != null) {
						modifyView.getTxt1().setText(distribuidor.getRut());
						modifyView.getTxt2().setText(distribuidor.getNombre());
						modifyView.getTxt3().setText(distribuidor.getDireccion());
						modifyView.getTxt4().setText(String.valueOf(distribuidor.getTelefono()));
						modifyView.getTxt5().setText(distribuidor.getAnioInicio().toString());
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
		
	private DefaultTableModel initTableModel(DefaultTableModel model ) {
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
