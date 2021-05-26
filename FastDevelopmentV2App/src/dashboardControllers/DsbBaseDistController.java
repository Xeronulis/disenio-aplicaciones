package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
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

public class DsbBaseDistController extends DsbBaseController {

	private DsbBaseDistView v;
	
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
	
	
	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			registerView = (DsbRegisterView) crudView;
			JPanel rFields = registerView.getFields();
			
			int rCompCount = rFields.getComponentCount();
			for(int i =10; i< rCompCount ;++i) {
				rFields.remove(10);
			}		
			
			
			registerView.getLbl1().getLabel().setText(v.getDistRutLbl());
			registerView.getLbl2().getLabel().setText(v.getDistNameLbl());
			registerView.getLbl3().getLabel().setText(v.getDistAddressLbl());
			registerView.getLbl4().getLabel().setText(v.getDistPhoneLbl());
			registerView.getLbl5().getLabel().setText(v.getDistStartDateLbl());
			registerView.getTxt5().getTxt().setText(v.getDistStartDateTxt());
			registerView.getTxt5().getTxt().setEditable(false);
			
			rFields.add(registerView.getCommitBtn(), "cell 1 "+rFields.getComponentCount()/2);
			break;
			
		case "modify":
			modifyView = (DsbModifyView) crudView;
			JPanel mFields = modifyView.getFields();
			
			int mCompCount = mFields.getComponentCount();
			for(int i =10; i< mCompCount ;++i) {
				mFields.remove(10);
			}	
			
			modifyView.getSelectLbl().getLabel().setText(v.getSelectLbl());
			modifyView.getLbl1().getLabel().setText(v.getDistRutLbl());
			modifyView.getLbl2().getLabel().setText(v.getDistNameLbl());
			modifyView.getLbl3().getLabel().setText(v.getDistAddressLbl());
			modifyView.getLbl4().getLabel().setText(v.getDistPhoneLbl());
			modifyView.getLbl5().getLabel().setText(v.getDistStartDateLbl());
			modifyView.getTxt5().getTxt().setEditable(false);
			
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
			searchView.getLbl1().getLabel().setText(v.getDistRutLbl());
			sCbx.addItem(v.getDistRutLbl());
			sCbx.addItem(v.getDistNameLbl());
			sCbx.addItem(v.getDistAddressLbl());
			sCbx.addItem(v.getDistPhoneLbl());
			sCbx.addItem(v.getDistStartDateLbl());
			
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
			deleteView.getLbl1().getLabel().setText(v.getDistRutLbl());
			deleteView.getLbl2().getLabel().setText("Seleccionado");
			deleteView.getLbl3().getLabel().setText("ninguno");
			
			dCbx.addItem(v.getDistRutLbl());        
			dCbx.addItem(v.getDistNameLbl());       
			dCbx.addItem(v.getDistAddressLbl());    
			dCbx.addItem(v.getDistPhoneLbl());      
			dCbx.addItem(v.getDistStartDateLbl());  
			
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
		model.addColumn("Rut");
		model.addColumn("Nombre de la Empresa");
		model.addColumn("Direccion");
		model.addColumn("Tel�fono");
		model.addColumn("inicio como distribuidor");
		return model;
	}

}
