package dashboardControllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
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

			deleteView.getTable().setModel(dTModel);
			CustomizeDs.customizeJTable(deleteView.getTable());
			
			break;
		}
		
		
	}
	
	private DefaultTableModel initTableModel(DefaultTableModel model ) {
		model.addColumn("Editorial");
		return model;
	}

}
