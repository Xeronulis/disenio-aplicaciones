package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
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

public class DsbBaseFactController extends DsbBaseController {

	private DsbBaseFactView v;
	
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
	
	
	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			registerView = (DsbRegisterView) crudView;
			JPanel rFields = registerView.getFields();
			
			int rCompCount = rFields.getComponentCount();
			for(int i =12; i< rCompCount ;++i) {
				rFields.remove(12);
			}		
			
			
			registerView.getLbl1().getLabel().setText(v.getDistribuidorLbl());
			registerView.getLbl2().getLabel().setText(v.getFolioLbl());
			registerView.getLbl3().getLabel().setText(v.getFechaCompraLbl());
			registerView.getLbl4().getLabel().setText(v.getHoraCompraLbl());
			registerView.getLbl5().getLabel().setText(v.getCostoTotalLbl());
			registerView.getLbl6().getLabel().setText(v.getMetodoPagoLbl());
			
			registerView.getTxt4().getTxt().setEditable(false);
			registerView.getTxt3().getTxt().setEditable(false);
			
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
			
			modifyView.getLbl1().getLabel().setText(v.getDistribuidorLbl());
			modifyView.getLbl2().getLabel().setText(v.getFolioLbl());
			//modifyView.getLbl3().getLabel().setText(v.getFechaCompraLbl());
			//modifyView.getLbl4().getLabel().setText(v.getHoraCompraLbl());
			modifyView.getLbl3().getLabel().setText(v.getCostoTotalLbl());
			modifyView.getLbl4().getLabel().setText(v.getMetodoPagoLbl());
			
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
			searchView.getLbl1().getLabel().setText(v.getDistribuidorLbl());
			sCbx.addItem(v.getDistribuidorLbl());
			sCbx.addItem(v.getFolioLbl());      
			sCbx.addItem(v.getFechaCompraLbl());
			sCbx.addItem(v.getHoraCompraLbl()); 
			sCbx.addItem(v.getCostoTotalLbl()); 
			sCbx.addItem(v.getMetodoPagoLbl()); 
			             
			             
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
			deleteView.getLbl1().getLabel().setText(v.getDistribuidorLbl());
			deleteView.getLbl2().getLabel().setText("Seleccionado");
			deleteView.getLbl3().getLabel().setText("ninguno");
			
			dCbx.addItem(v.getDistribuidorLbl()); 
			dCbx.addItem(v.getFolioLbl());        
			dCbx.addItem(v.getFechaCompraLbl());  
			dCbx.addItem(v.getHoraCompraLbl());   
			dCbx.addItem(v.getCostoTotalLbl());   
			dCbx.addItem(v.getMetodoPagoLbl());  
			
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
		model.addColumn("Distribuidor");
		model.addColumn("Folio");
		model.addColumn("Fecha de Compra");
		model.addColumn("Hora de Compra");
		model.addColumn("Costo total");
		model.addColumn("Método de pago");
		return model;
	}

}
