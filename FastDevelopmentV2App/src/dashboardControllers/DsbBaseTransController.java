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
import dashboardViews.DsbBaseTransView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;

public class DsbBaseTransController extends DsbBaseController {

	private DsbBaseTransView v;
	
	public DsbBaseTransController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseTransView) v;
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
			for(int i =14; i< rCompCount ;++i) {
				rFields.remove(14);
			}		
			
			
			registerView.getLbl1().getLabel().setText(v.getFolioLbl());
			registerView.getLbl2().getLabel().setText(v.getTrabajadorLbl());
			registerView.getLbl3().getLabel().setText(v.getClienteLbl());
			registerView.getLbl4().getLabel().setText(v.getFechaVentaLbl());
			registerView.getLbl5().getLabel().setText(v.getHoraVentaLbl());
			registerView.getLbl6().getLabel().setText(v.getCostoTotalLbl());
			registerView.getLbl7().getLabel().setText(v.getMetodoPagoLbl());
			
			registerView.getTxt4().getTxt().setEditable(false);
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
			
			modifyView.getLbl1().getLabel().setText(v.getFolioLbl());
			modifyView.getLbl2().getLabel().setText(v.getTrabajadorLbl());
			modifyView.getLbl3().getLabel().setText(v.getClienteLbl());
			//registerView.getLbl4().getLabel().setText(v.getFechaVentaLbl());
			//registerView.getLbl5().getLabel().setText(v.getHoraVentaLbl());
			modifyView.getLbl4().getLabel().setText(v.getCostoTotalLbl());
			modifyView.getLbl5().getLabel().setText(v.getMetodoPagoLbl());
			
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
			searchView.getLbl1().getLabel().setText(v.getFolioLbl());
			
			sCbx.addItem(v.getFolioLbl());       
			sCbx.addItem(v.getTrabajadorLbl());  
			sCbx.addItem(v.getClienteLbl());     
			sCbx.addItem(v.getFechaVentaLbl());  
			sCbx.addItem(v.getHoraVentaLbl());   
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
			deleteView.getLbl1().getLabel().setText(v.getFolioLbl());
			deleteView.getLbl2().getLabel().setText("Seleccionado");
			deleteView.getLbl3().getLabel().setText("ninguno");
			
			dCbx.addItem(v.getFolioLbl());       
			dCbx.addItem(v.getTrabajadorLbl());  
			dCbx.addItem(v.getClienteLbl());     
			dCbx.addItem(v.getFechaVentaLbl());  
			dCbx.addItem(v.getHoraVentaLbl());   
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
		model.addColumn("Folio");
		model.addColumn("Trabajador");
		model.addColumn("Cliente");
		model.addColumn("Fecha de Venta");
		model.addColumn("Hora de Venta");
		model.addColumn("Costo total");
		model.addColumn("Método de pago");
		return model;
	}

}
