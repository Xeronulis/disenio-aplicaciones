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
import dashboardViews.DsbBasePayView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.MetodoPagoDAO;
import model.dto.MetodoPago;
import model.dto.MetodoPago;

public class DsbBasePayController extends DsbBaseController {

	private DsbBasePayView v;
	
	private boolean[] registerError = new boolean[1];
	private boolean[] modifyError = new boolean[1];
	private boolean deleteError;
	
	private List<MetodoPago> metodoPagos;
	
	public DsbBasePayController(DsbBaseView v) {
		super(v);
		this.v =(DsbBasePayView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	
	private void refreshMetodoPagoList() {
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
			MetodoPago editorial = new MetodoPago();
			
			editorial.setNombre(registerView.getTxt1().getText().strip());
			
			MetodoPagoDAO.save(editorial);
			
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
			MetodoPago edit = new MetodoPago();
			
			edit.setNombre(modifyView.getTxt1().getText());
			
			MetodoPagoDAO.update(edit,(String) modifyView.getSelectCbx().getSelectedItem());
			
			resetModify();
		}
		
	}
	
	
	private void delete() {
		
		String target= deleteView.getLbl3().getText();
		
		
		if(!deleteError) {
			MetodoPagoDAO.delete(target);
			refreshDelete();
			
		}	
	}
	
	
	private void refreshModify() {
		
		List<MetodoPago> edits = MetodoPagoDAO.getAll();
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
		List<MetodoPago> edits = MetodoPagoDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
				
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre()});
		});
		
	}
	

	
	
	public void resetRegister() {
		registerError[0] = true;
		refreshMetodoPagoList();
		
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
		refreshMetodoPagoList();
		
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
	
	
	
	public void resetDelete() {
		refreshMetodoPagoList();
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
				rv.getWarning1().setText("Nombre vacío");
				registerError[id-1] = true;
			}else {
				MetodoPago editorial = metodoPagos.stream().filter(e->e.getNombre().toLowerCase().contentEquals(rv.getTxt1().getText().toLowerCase())).findFirst().orElse(null);
					if(editorial != null) {
						rv.getWarning1().setVisible(true);
						rv.getWarning1().setText("Nombre en uso");
						registerError[id-1] = true;
					}else {
						rv.getWarning1().setVisible(false);
						rv.getWarning1().setText("");
						registerError[id-1] = false;
					}
			}
			
			
			break;
		}
		
	}
	
	private void checkErrorModify(int id) {
		DsbModifyView mv = modifyView;
		MetodoPago idiomaSel = metodoPagos.stream().filter(i-> i.getNombre().contentEquals(modifyView.getSelectCbx().getSelectedItem().toString())).findFirst().orElse(null);
		
		switch (id) {
		
		case 1:
				
			if(mv.getTxt1().getText().isBlank()) {
				mv.getWarning1().setVisible(true);
				mv.getWarning1().setText("Nombre vacío");
				modifyError[id-1] = true;
			}else {
				MetodoPago metodoPago = metodoPagos.stream().filter(e->e.getNombre().toLowerCase().contentEquals(mv.getTxt1().getText().toLowerCase())).findFirst().orElse(null);
				if(metodoPago != null && idiomaSel.getNombre().contentEquals(metodoPago.getNombre())) {
					metodoPago = null;
				}
				if(metodoPago != null) {
					mv.getWarning1().setVisible(true);
					mv.getWarning1().setText("Nombre en uso");
					modifyError[id-1] = true;
				}else {
					mv.getWarning1().setVisible(false);
					mv.getWarning1().setText("");
					modifyError[id-1] = false;
				}
			}		
			break;
		}	
	}
	
	private void checkErrorDelete() {
		DsbDeleteView dv = deleteView;
		
		MetodoPago eFound = metodoPagos.stream().filter(e->e.getNombre().toLowerCase().contentEquals(dv.getLbl3().getText().toLowerCase())).findFirst().orElse(null);
			if(eFound != null && !eFound.getIdFacturas().contains(0)) {
				dv.getWarning1().setVisible(true);
				dv.getWarning1().setText("el metodo de pago está vinculado");
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
		
		registerView.getLbl1().setText(v.getMetodoLbl());
		
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
		
		modifyView.getLbl1().setText(v.getMetodoLbl());
		
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
					MetodoPago metodoPago = metodoPagos.stream().filter(i -> i.getNombre().contentEquals(modifyView.getSelectCbx().getSelectedItem().toString())).findFirst().orElse(null);
					if(metodoPago != null) {
						modifyView.getTxt1().setText(metodoPago.getNombre());
						checkErrorModify(1);
					}
				}
				
			}
			
		});
		
		
		modifyView.getTxt1().addKeyListener(new ModifyTxtKeyListener(1));
		
	}
	
	
	private void initDelete(DsbDeleteView dv) {
		deleteView = dv;
		
		JComboBox<Object> dCbx = deleteView.getSelectCbx();
		deleteView.getSelectLbl().setText("Buscar por");
		deleteView.getLbl1().setText(v.getMetodoLbl());
		deleteView.getLbl2().setText("Seleccionado");
		deleteView.getLbl3().setText("ninguno");
		
		dCbx.addItem(v.getMetodoLbl());
		
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
			
		case "delete":
			initDelete((DsbDeleteView) crudView);
			break;
		}	
	}
		
	protected DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Categoría");
		
		
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
