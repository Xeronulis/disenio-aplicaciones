package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import dashboardViews.DsbBaseFactView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.DistribuidorDAO;
import model.dao.FacturaDAO;
import model.dao.MetodoPagoDAO;
import model.dto.Distribuidor;
import model.dto.Factura;
import model.dto.MetodoPago;

public class DsbBaseFactController extends DsbBaseController {

	private DsbBaseFactView v;
	
	private boolean[] registerError = new boolean[5];
	private boolean[] modifyError = new boolean[5];
	private boolean deleteError;
	
	private List<Factura> facturas;
	
	private List<Distribuidor> distribuidores ;
	private List<MetodoPago> metodoPagos;
	
	public DsbBaseFactController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseFactView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	
	private void refreshFacturaList() {
		facturas = FacturaDAO.getAll();
	}
	
	private void refreshDependencyList() {
		distribuidores = DistribuidorDAO.getAll();
		metodoPagos = MetodoPagoDAO.getAll();
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
			Factura fact = new Factura();
			
			Distribuidor dist = distribuidores.stream().filter(d-> d.toString().contentEquals(registerView.getCbx1().getSelectedItem().toString())).findFirst().orElse(null);
			MetodoPago met = metodoPagos.stream().filter(m-> m.toString().contentEquals(registerView.getCbx5().getSelectedItem().toString())).findFirst().orElse(null);
			
			fact.setIdDistribuidor(dist.getId());
			fact.setFolio(Integer.parseInt(registerView.getTxt2().getText()));
			fact.setFechaCompra(java.sql.Date.valueOf(registerView.getTxt3().getText()));
			fact.setHoraCompra(java.sql.Time.valueOf(registerView.getTxt4().getText()));
			fact.setIdMetodoPago(met.getId());
			
			FacturaDAO.save(fact);
			
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
			Factura fact = new Factura();
			
			Distribuidor dist = distribuidores.stream().filter(d-> d.toString().contentEquals(modifyView.getCbx1().getSelectedItem().toString())).findFirst().orElse(null);
			MetodoPago met = metodoPagos.stream().filter(m-> m.toString().contentEquals(modifyView.getCbx5().getSelectedItem().toString())).findFirst().orElse(null);
			
			fact.setIdDistribuidor(dist.getId());
			fact.setFolio(Integer.parseInt(modifyView.getTxt2().getText()));
			fact.setFechaCompra(java.sql.Date.valueOf(modifyView.getTxt3().getText()));
			fact.setHoraCompra(java.sql.Time.valueOf(modifyView.getTxt4().getText()));
			fact.setIdMetodoPago(met.getId());
			
			
			FacturaDAO.update(fact,Integer.parseInt((String) modifyView.getSelectCbx().getSelectedItem().toString()));
			
			resetModify();
		}
		
	}
	
	private void show() {
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		facturas.forEach(e->{
			Distribuidor dist = distribuidores.stream().filter(d-> d.getId() == e.getIdDistribuidor()).findFirst().orElse(null);
			MetodoPago met = metodoPagos.stream().filter(mp -> mp.getId() == e.getIdMetodoPago()).findFirst().orElse(null);
			
			tmodel.addRow(new Object[] {e.getIdFactura(), dist.getName(), e.getFolio(), e.getFechaCompra(), e.getHoraCompra(), met.getNombre(), e.getCostoTotal()});
		});
		
		
	}
	
	private void search() {
		String filtro = searchView.getSelectCbx().getSelectedItem().toString();
		String target = searchView.getTxt1().getText().strip();
		List<Factura> edits = FacturaDAO.filteredSearch(filtro, target);
		
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			Distribuidor dist = distribuidores.stream().filter(d-> d.getId() == e.getIdDistribuidor()).findFirst().orElse(null);
			MetodoPago met = metodoPagos.stream().filter(mp -> mp.getId() == e.getIdMetodoPago()).findFirst().orElse(null);
			
			tmodel.addRow(new Object[] {e.getIdFactura(), dist.getName(), e.getFolio(), e.getFechaCompra(), e.getHoraCompra(), met.getNombre(), e.getCostoTotal()});
		});
		
		
	}
	
	private void delete() {
		
		int target= (int) deleteView.getTable().getValueAt(deleteView.getTable().getSelectedRow(), 0);
		
		
		if(!deleteError) {
			FacturaDAO.delete(target);
			refreshDelete();
			
		}	
	}
	
	
	private void refreshModify() {
		
		List<Factura> edits = FacturaDAO.getAll();
		JComboBox<Object> cbx = modifyView.getSelectCbx();
		cbx.removeAllItems();
		if(edits != null) {
			edits.forEach(e->{
				cbx.addItem(e.toString());
			});
		}
		
	}
	
	private void refreshDelete() {
		
		String filtro = deleteView.getSelectCbx().getSelectedItem().toString();
		
		
		String target = deleteView.getTxt1().getText().strip();
		List<Factura> edits = FacturaDAO.filteredSearch(filtro, target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			Distribuidor dist = distribuidores.stream().filter(d-> d.getId() == e.getIdDistribuidor()).findFirst().orElse(null);
			MetodoPago met = metodoPagos.stream().filter(mp -> mp.getId() == e.getIdMetodoPago()).findFirst().orElse(null);
			
			tmodel.addRow(new Object[] {e.getIdFactura(), dist.getName(), e.getFolio(), e.getFechaCompra(), e.getHoraCompra(), met.getNombre(), e.getCostoTotal()});
		});
		
	}
	

	
	
	public void resetRegister() {
		refreshFacturaList();
		refreshDependencyList();
		
		for(int i =0; i<registerError.length;++i) {
			registerError[i] = true;
		}
		registerError[0] = false;
		registerError[4] = false;
		
		
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
		
		registerView.getCbx1().removeAllItems();
		
		distribuidores.forEach(d->{
			registerView.getCbx1().addItem(d.toString());
		});
		
		
		registerView.getCbx5().removeAllItems();
		
		metodoPagos.forEach(mp->{
			registerView.getCbx5().addItem(mp.toString());
		});
		
	}
	
	public void resetModify() {
		modifyError[0] = false;
		modifyError[4] = false;
		refreshFacturaList();
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
		
		modifyView.getCbx1().removeAllItems();
		
		distribuidores.forEach(d->{
			modifyView.getCbx1().addItem(d.toString());
		});
		
		modifyView.getCbx5().removeAllItems();
		
		metodoPagos.forEach(mp->{
			modifyView.getCbx5().addItem(mp.toString());
		});
		
		
		
		refreshModify();
	}
	
	
	public void resetShow() {
		refreshFacturaList();
		refreshDependencyList();
		show();
	}
	
	
	public void resetSearch() {
		refreshFacturaList();
		refreshDependencyList();
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		tmodel.setRowCount(0);
		
	}
	
	
	public void resetDelete() {
		refreshFacturaList();
		refreshDependencyList();
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
		
		case 2:
			if(rv.getTxt2().getText().isBlank()) {
				rv.getWarning2().setVisible(true);
				rv.getWarning2().setText("Folio vacío");
				registerError[id-1] = true;
			}else {
				
				String txt = rv.getTxt2().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					rv.getTxt2().setText(txt);
				}
				
				rv.getWarning2().setVisible(false);
				rv.getWarning2().setText("");
				registerError[id-1] = false;
			}
			break;
		case 3:
			
			if(rv.getTxt3().getText().isBlank()) {
				rv.getWarning3().setVisible(true);
				rv.getWarning3().setText("Fecha vacía");
				registerError[id-1] = true;
			}else {
				
				String fecha = rv.getTxt3().getText();
				
				if(!Pattern.matches("[0-9[-]]+", fecha)) {
					fecha = fecha.replaceAll("[^0-9[-]]","");
					rv.getTxt3().setText(fecha);
				}
				
				while(fecha.split("-", -2).length>3) {
					fecha = fecha.replaceFirst("--", "-");
					fecha = fecha.replaceFirst("(-\\d+$)|(-$)", "");
					
					rv.getTxt3().setText(fecha);
				}
				
				try {
					java.sql.Date.valueOf(fecha);
					
					registerError[id-1] = false;
					rv.getWarning3().setVisible(false);
					rv.getWarning3().setText("");
					
				}catch (Exception ex) {
					registerError[id-1] = true;
					rv.getWarning3().setVisible(true);
					rv.getWarning3().setText("Fecha inválida");
				}		
			}
			break;
		case 4:
			if(rv.getTxt4().getText().isBlank()) {
				rv.getWarning4().setVisible(true);
				rv.getWarning4().setText("Fecha vacía");
				registerError[id-1] = true;
			}else {
				
				String hora = rv.getTxt4().getText();
				
				if(!Pattern.matches("[0-9[:]]+", hora)) {
					hora = hora.replaceAll("[^0-9[:]]","");
					rv.getTxt4().setText(hora);
				}
				
				while(hora.split(":", -2).length>3) {
					hora = hora.replaceFirst("::", ":");
					hora = hora.replaceFirst("(:\\d+$)|(:$)", "");
					
					rv.getTxt4().setText(hora);
				}
				
				try {
					java.sql.Time.valueOf(hora);
					
					registerError[id-1] = false;
					rv.getWarning4().setVisible(false);
					rv.getWarning4().setText("");
					
				}catch (Exception ex) {
					registerError[id-1] = true;
					rv.getWarning4().setVisible(true);
					rv.getWarning4().setText("Hora inválida");
				}		
			}
			break;
		}
		
	}
	
	private void checkErrorModify(int id) {
		DsbModifyView mv = modifyView;
		
		switch (id) {
		
		case 2:
			if(mv.getTxt2().getText().isBlank()) {
				mv.getWarning2().setVisible(true);
				mv.getWarning2().setText("Folio vacío");
				registerError[id-1] = true;
			}else {
				
				String txt = mv.getTxt2().getText();
				
				if(!Pattern.matches("[0-9]+", txt)) {
					txt = txt.replaceAll("[^0-9]", "");
					mv.getTxt2().setText(txt);
				}
				
				mv.getWarning2().setVisible(false);
				mv.getWarning2().setText("");
				registerError[id-1] = false;
			}
			break;
		case 3:
			
			if(mv.getTxt3().getText().isBlank()) {
				mv.getWarning3().setVisible(true);
				mv.getWarning3().setText("Fecha vacía");
				registerError[id-1] = true;
			}else {
				
				String fecha = mv.getTxt3().getText();
				
				if(!Pattern.matches("[0-9[-]]+", fecha)) {
					fecha = fecha.replaceAll("[^0-9[-]]","");
					mv.getTxt3().setText(fecha);
				}
				
				while(fecha.split("-", -2).length>3) {
					fecha = fecha.replaceFirst("--", "-");
					fecha = fecha.replaceFirst("(-\\d+$)|(-$)", "");
					
					mv.getTxt3().setText(fecha);
				}
				
				try {
					java.sql.Date.valueOf(fecha);
					
					registerError[id-1] = false;
					mv.getWarning3().setVisible(false);
					mv.getWarning3().setText("");
					
				}catch (Exception ex) {
					registerError[id-1] = true;
					mv.getWarning3().setVisible(true);
					mv.getWarning3().setText("Fecha inválida");
				}		
			}
			break;
		case 4:
			if(mv.getTxt4().getText().isBlank()) {
				mv.getWarning4().setVisible(true);
				mv.getWarning4().setText("Fecha vacía");
				registerError[id-1] = true;
			}else {
				
				String hora = mv.getTxt4().getText();
				
				if(!Pattern.matches("[0-9[:]]+", hora)) {
					hora = hora.replaceAll("[^0-9[:]]","");
					mv.getTxt4().setText(hora);
				}
				
				while(hora.split(":", -2).length>3) {
					hora = hora.replaceFirst("::", ":");
					hora = hora.replaceFirst("(:\\d+$)|(:$)", "");
					
					mv.getTxt4().setText(hora);
				}
				
				try {
					java.sql.Time.valueOf(hora);
					
					registerError[id-1] = false;
					mv.getWarning4().setVisible(false);
					mv.getWarning4().setText("");
					
				}catch (Exception ex) {
					registerError[id-1] = true;
					mv.getWarning4().setVisible(true);
					mv.getWarning4().setText("Hora inválida");
				}		
			}
			break;
		}	
	}
	
	private void checkErrorDelete() {
		DsbDeleteView dv = deleteView;
		
		Factura eFound = facturas.stream().filter(e->String.valueOf(e.getIdFactura()).toLowerCase().contentEquals(dv.getLbl3().getText().toLowerCase())).findFirst().orElse(null);
			if(eFound != null && !eFound.getCompras().contains(null)) {
				dv.getWarning1().setVisible(true);
				dv.getWarning1().setText("La factura está vinculada");
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
		
		registerView.getLbl1().setText(v.getDistribuidorLbl());
		registerView.getLbl2().setText(v.getFolioLbl());
		registerView.getLbl3().setText(v.getFechaCompraLbl());
		registerView.getLbl4().setText(v.getHoraCompraLbl());
		registerView.getLbl5().setText(v.getMetodoPagoLbl());
		
		
		int mCompCount = rFields.getComponentCount();
		int rowCount = 0*3;
		
		for(int i =rowCount; i< mCompCount ;++i) {
			rFields.remove(rowCount);
		}		
		
		rFields.add(registerView.getLbl1(), "cell 0 0");
		rFields.add(registerView.getCbx1(), "cell 1 0");
		rFields.add(registerView.getWarning1(), "cell 2 0");
		
		rFields.add(registerView.getLbl2(), "cell 0 1");
		rFields.add(registerView.getTxt2(), "cell 1 1");
		rFields.add(registerView.getWarning2(), "cell 2 1");
		
		rFields.add(registerView.getLbl3(), "cell 0 2");
		rFields.add(registerView.getTxt3(), "cell 1 2");
		rFields.add(registerView.getWarning3(), "cell 2 2");
		
		rFields.add(registerView.getLbl4(), "cell 0 3");
		rFields.add(registerView.getTxt4(), "cell 1 3");
		rFields.add(registerView.getWarning4(), "cell 2 3");
		
		rFields.add(registerView.getLbl5(), "cell 0 4");
		rFields.add(registerView.getCbx5(), "cell 1 4");
		rFields.add(registerView.getWarning5(), "cell 2 4");
	
		
		rFields.add(registerView.getCommitBtn(), "cell 1 "+rFields.getComponentCount()/3);
		
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
		
		modifyView.getLbl1().setText(v.getDistribuidorLbl());
		modifyView.getLbl2().setText(v.getFolioLbl());
		modifyView.getLbl3().setText(v.getFechaCompraLbl());
		modifyView.getLbl4().setText(v.getHoraCompraLbl());
		modifyView.getLbl5().setText(v.getMetodoPagoLbl());
		
		int mCompCount = mFields.getComponentCount();
		int rowCount = 1*3;
		
		for(int i =rowCount; i< mCompCount ;++i) {
			mFields.remove(rowCount);
		}		
		
		mFields.add(modifyView.getLbl1(), "cell 0 1");
		mFields.add(modifyView.getCbx1(), "cell 1 1");
		mFields.add(modifyView.getWarning1(), "cell 2 1");
		
		mFields.add(modifyView.getLbl2(), "cell 0 2");
		mFields.add(modifyView.getTxt2(), "cell 1 2");
		mFields.add(modifyView.getWarning2(), "cell 2 2");
		
		mFields.add(modifyView.getLbl3(), "cell 0 3");
		mFields.add(modifyView.getTxt3(), "cell 1 3");
		mFields.add(modifyView.getWarning3(), "cell 2 3");
		
		mFields.add(modifyView.getLbl4(), "cell 0 4");
		mFields.add(modifyView.getTxt4(), "cell 1 4");
		mFields.add(modifyView.getWarning4(), "cell 2 4");
		
		mFields.add(modifyView.getLbl5(), "cell 0 5");
		mFields.add(modifyView.getCbx5(), "cell 1 5");
		mFields.add(modifyView.getWarning5(), "cell 2 5");
		
		
		
		
		mFields.add(modifyView.getCommitBtn(), "cell 1 "+mFields.getComponentCount()/3);
		
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
					Factura factura = facturas.stream().filter(i -> String.valueOf(i.getIdFactura()).contentEquals(modifyView.getSelectCbx().getSelectedItem().toString())).findFirst().orElse(null);
					if(factura != null) {
						Distribuidor dist = distribuidores.stream().filter(d-> d.getId() == factura.getIdDistribuidor()).findFirst().orElse(null);
						if(dist != null) {
							modifyView.getCbx1().setSelectedItem(dist.toString());;
							
						}
						modifyView.getTxt2().setText(String.valueOf(factura.getFolio()));
						modifyView.getTxt3().setText(String.valueOf(factura.getFechaCompra()));
						modifyView.getTxt4().setText(String.valueOf(factura.getHoraCompra()));
						
						MetodoPago met = metodoPagos.stream().filter(m-> m.getId() == factura.getIdMetodoPago()).findFirst().orElse(null);
						if(met != null) {
							modifyView.getCbx5().setSelectedItem(met.toString());
						}
						
					}
				}
				
			}
			
		});
		
		
		modifyView.getTxt1().addKeyListener(new ModifyTxtKeyListener(1));
		modifyView.getTxt2().addKeyListener(new ModifyTxtKeyListener(2));
		modifyView.getTxt3().addKeyListener(new ModifyTxtKeyListener(3));
		modifyView.getTxt4().addKeyListener(new ModifyTxtKeyListener(4));
		modifyView.getTxt5().addKeyListener(new ModifyTxtKeyListener(5));
		modifyView.getTxt6().addKeyListener(new ModifyTxtKeyListener(6));
		
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
		searchView.getLbl1().setText(v.getDistribuidorLbl());
		sCbx.addItem(v.getDistribuidorLbl());
		sCbx.addItem(v.getFolioLbl());       
		sCbx.addItem(v.getFechaCompraLbl()); 
		sCbx.addItem(v.getMetodoPagoLbl());  
		sCbx.addItem(v.getCostoTotalLbl());  
		
		
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
		deleteView.getLbl1().setText(v.getDistribuidorLbl());
		deleteView.getLbl2().setText("Seleccionado");
		deleteView.getLbl3().setText("ninguno");
		
		dCbx.addItem(v.getDistribuidorLbl());
		dCbx.addItem(v.getFolioLbl());       
		dCbx.addItem(v.getFechaCompraLbl()); 
		dCbx.addItem(v.getMetodoPagoLbl());  
		dCbx.addItem(v.getCostoTotalLbl()); 
		
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
					deleteView.getLbl3().setText( String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
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
		model.addColumn("Id Factura");
		model.addColumn("Distribuidor");
		model.addColumn("Folio");
		model.addColumn("Fecha de Compra");
		model.addColumn("Hora de Compra");
		model.addColumn("Metodo de pago");
		model.addColumn("Costo total");
		
		
		
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
