package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
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

public class DsbBaseAutorController extends DsbBaseController {

	private DsbBaseAutorView v;
	
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
	
	
	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			registerView = (DsbRegisterView) crudView;
			JPanel rFields = registerView.getFields();
			
			int rCompCount = rFields.getComponentCount();
			for(int i =6; i< rCompCount ;++i) {
				rFields.remove(6);
			}		
			
			
			registerView.getLbl1().getLabel().setText(v.getNombreLbl());
			registerView.getLbl2().getLabel().setText(v.getApellido1Lbl());
			registerView.getLbl3().getLabel().setText(v.getApellido2Lbl());
			
			rFields.add(registerView.getCommitBtn(), "cell 1 "+rFields.getComponentCount()/2);
			break;
			
		case "modify":
			modifyView = (DsbModifyView) crudView;
			JPanel mFields = modifyView.getFields();
			
			int mCompCount = mFields.getComponentCount();
			for(int i =8; i< mCompCount ;++i) {
				mFields.remove(8);
			}	
			
			modifyView.getSelectLbl().getLabel().setText(v.getSelectLbl());
			modifyView.getLbl1().getLabel().setText(v.getNombreLbl());
			modifyView.getLbl2().getLabel().setText(v.getApellido1Lbl());
			modifyView.getLbl3().getLabel().setText(v.getApellido2Lbl());
			
			mFields.add(modifyView.getCommitBtn(), "cell 1 "+mFields.getComponentCount()/2);
			
			
			
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
			searchView.getLbl1().getLabel().setText(v.getNombreLbl());
			sCbx.addItem(v.getNombreLbl());    
			sCbx.addItem(v.getApellido1Lbl()); 
			sCbx.addItem(v.getApellido2Lbl()); 

			
			sCbx.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					searchView.getLbl1().getLabel().setText((String)sCbx.getSelectedItem());
					
				}
				
			});
			DefaultTableModel seTModel = initTableModel(new DefaultTableModel());

			searchView.getTable().setModel(seTModel);
			CustomizeDs.customizeJTable(searchView.getTable());
			
			
			break;
		case "delete":
			deleteView = (DsbDeleteView) crudView;
			JComboBox<Object> dCbx = deleteView.getSelectCbx().getComboBox();
			deleteView.getSelectLbl().getLabel().setText("Buscar por");
			deleteView.getLbl1().getLabel().setText(v.getNombreLbl());
			deleteView.getLbl2().getLabel().setText("Seleccionado");
			deleteView.getLbl3().getLabel().setText("ninguno");
			
			dCbx.addItem(v.getNombreLbl());        
			dCbx.addItem(v.getApellido1Lbl());     
			dCbx.addItem(v.getApellido2Lbl());     
			
			dCbx.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					deleteView.getLbl1().getLabel().setText((String)dCbx.getSelectedItem());
					
				}
				
			});
			DefaultTableModel dTModel = initTableModel(new DefaultTableModel());

			deleteView.getTable().setModel(dTModel);
			CustomizeDs.customizeJTable(deleteView.getTable());
			
			break;
		}
		
		
	}
	
	private DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Nombre");
		model.addColumn("Apellido paterno");
		model.addColumn("Apellido materno");

		return model;
	}

}
