package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import customItems.CustomizeDs;
import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbMainView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;

public class DsbBaseController {

	
	protected DsbRegisterView registerView;
	protected DsbModifyView modifyView;
	protected DsbShowView showView;
	protected DsbSearchView searchView;
	protected DsbDeleteView deleteView;
	
	public DsbBaseController(DsbBaseView v) {
		
		
	}
	
	
	public void changeView(String name) {
		//v.getcLayout().show(v, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		//this.v.add(v, name);
	}

	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			/*
			registerView = (DsbRegisterView) crudView;
			registerView.getLbl1().getLabel().setText(v.getDistRutLbl());
			registerView.getLbl2().getLabel().setText(v.getDistNameLbl());
			registerView.getLbl3().getLabel().setText(v.getDistAddressLbl());
			registerView.getLbl4().getLabel().setText(v.getDistPhoneLbl());
			registerView.getLbl5().getLabel().setText(v.getDistStartDateLbl());
			registerView.getTxt5().getTxt().setText(v.getDistStartDateTxt());
			registerView.getTxt5().getTxt().setEditable(false);
			*/
			break;
			
		case "modify":
			/*
			modifyView = (DsbModifyView) crudView;
			modifyView.getSelectLbl().getLabel().setText(v.getSelectLbl());
			modifyView.getLbl1().getLabel().setText(v.getDistRutLbl());
			modifyView.getLbl2().getLabel().setText(v.getDistNameLbl());
			modifyView.getLbl3().getLabel().setText(v.getDistAddressLbl());
			modifyView.getLbl4().getLabel().setText(v.getDistPhoneLbl());
			modifyView.getLbl5().getLabel().setText(v.getDistStartDateLbl());
			modifyView.getTxt5().getTxt().setEditable(false);
			*/
			
			
			break;
		case "show":
			/*
			showView = (DsbShowView) crudView;
			DefaultTableModel shTModel = initTableModel(new DefaultTableModel());

			showView.getTable().setModel(shTModel);
			CustomizeDs.customizeJTable(showView.getTable());
			*/
			break;
		case "search":
			/*
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
			
			*/
			break;
		case "delete":
			/*
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
			*/
			break;
		}
		
		
	}
	
	private DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Rut");
		model.addColumn("Nombre de la Empresa");
		model.addColumn("Direccion");
		model.addColumn("Teléfono");
		model.addColumn("inicioDistribuidor");
		return model;
	}
	
}
