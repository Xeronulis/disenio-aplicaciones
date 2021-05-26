package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import customItems.CustomizeDs;
import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbBaseEditView;
import dashboardViews.DsbBaseEstView;
import dashboardViews.DsbBaseIdioView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import model.dao.EditorialDAO;
import model.dto.Editorial;

public class DsbBaseEditController extends DsbBaseController {

	private DsbBaseEditView v;
	
	public DsbBaseEditController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseEditView) v;
	}
	
	
	public void changeView(String name) {
		v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.v.add(v, name);
	}
	
	private void register() {
		Editorial editorial = new Editorial();
		
		editorial.setNombre(registerView.getTxt1().getTxt().getText());
		
		EditorialDAO.save(editorial);
		
	}
	
	
	private void modify() {
		Editorial edit = new Editorial();
		
		
		edit.setNombre(modifyView.getTxt1().getTxt().getText());
		
		EditorialDAO.update(edit,(String) modifyView.getSelectCbx().getComboBox().getSelectedItem());
		
		refreshModify();
	}
	
	
	public void show() {
		List<Editorial> edits = EditorialDAO.getAll();
		DefaultTableModel tmodel = (DefaultTableModel) showView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre()});
		});
		
		
	}
	
	public void search() {
		String filtro =(String)searchView.getSelectCbx().getComboBox().getSelectedItem();
		String target = searchView.getTxt1().getTxt().getText().trim();
		List<Editorial> edits = EditorialDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) searchView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre()});
		});
		
	}
	
	public void delete() {
		String target= deleteView.getLbl3().getLabel().getText();
		
		EditorialDAO.delete(target);
		
	}
	
	public void refreshDelete() {
		String filtro =(String)deleteView.getSelectCbx().getComboBox().getSelectedItem();
		String target = deleteView.getTxt1().getTxt().getText().trim();
		List<Editorial> edits = EditorialDAO.filteredSearch(filtro.toLowerCase(), target);
		
		DefaultTableModel tmodel = (DefaultTableModel) deleteView.getTable().getModel();
		
		tmodel.setRowCount(0);
		edits.forEach(e->{
			tmodel.addRow(new Object[] {e.getNombre()});
		});
		
	}
	
	public void refreshModify() {
		
		modifyView.getTxt1().getTxt().setText("");
		
		List<Editorial> edits = EditorialDAO.getAll();
		JComboBox<Object> cbx = modifyView.getSelectCbx().getComboBox();
		cbx.removeAllItems();
		if(edits != null) {
			edits.forEach(e->{
				cbx.addItem(e.toString());
			});
		}
		
	}
	

	
	
	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			registerView = (DsbRegisterView) crudView;
			JPanel rFields = registerView.getFields();
			
			registerView.getLbl1().getLabel().setText(v.getEditEditorialLbl());
			
			
			int rCompCount = rFields.getComponentCount();
			for(int i =2; i< rCompCount ;++i) {
				rFields.remove(2);
			}		
			rFields.add(registerView.getCommitBtn(), "cell 1 1");
			
			registerView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e){
					register();
				}
			});


			break;
			
		case "modify":
			modifyView = (DsbModifyView) crudView;
			modifyView.getSelectLbl().getLabel().setText(v.getSelectLbl());
			
			JPanel mFields = modifyView.getFields();
			
			modifyView.getLbl1().getLabel().setText(v.getEditEditorialLbl());
			
			int mCompCount = mFields.getComponentCount();
			for(int i =4; i< mCompCount ;++i) {
				mFields.remove(4);
			}		
			mFields.add(modifyView.getCommitBtn(), "cell 1 2");
			
			modifyView.getCommitBtn().getBtn().addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e){
					modify();
				}
			});
			
			
			
			break;
		case "show":
			showView = (DsbShowView) crudView;
			DefaultTableModel shTModel = initTableModel(new DefaultTableModel());

			showView.getTable().setModel(shTModel);
			CustomizeDs.customizeJTable(showView.getTable());
			
			break;
		case "search":
			searchView = (DsbSearchView) crudView;
			JComboBox<Object> sCbx = searchView.getSelectCbx().getComboBox();
			searchView.getSelectLbl().getLabel().setText("Buscar por");
			searchView.getLbl1().getLabel().setText(v.getEditEditorialLbl());
			sCbx.addItem(v.getEditEditorialLbl());
			
			sCbx.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					searchView.getLbl1().getLabel().setText((String)sCbx.getSelectedItem());
					
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
			
			
			
			
			break;
		case "delete":
			deleteView = (DsbDeleteView) crudView;
			JComboBox<Object> dCbx = deleteView.getSelectCbx().getComboBox();
			deleteView.getSelectLbl().getLabel().setText("Buscar por");
			deleteView.getLbl1().getLabel().setText(v.getEditEditorialLbl());
			deleteView.getLbl2().getLabel().setText("Seleccionado");
			deleteView.getLbl3().getLabel().setText("ninguno");
			
			dCbx.addItem(v.getEditEditorialLbl());
			
			dCbx.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					deleteView.getLbl1().getLabel().setText((String)dCbx.getSelectedItem());
					
				}
				
			});
			DefaultTableModel dTModel = initTableModel(new DefaultTableModel());

			JTable table = deleteView.getTable();
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					deleteView.getLbl3().getLabel().setText((String) table.getValueAt(table.getSelectedRow(), 0));
					
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
			
			break;
		}
		
		
	}
	
	private DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Editorial");
		return model;
	}

}
