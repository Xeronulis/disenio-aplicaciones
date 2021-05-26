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
import dashboardViews.DsbBaseLibroView;
import dashboardViews.DsbBaseTransView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;

public class DsbBaseLibroController extends DsbBaseController {

	private DsbBaseLibroView v;
	
	public DsbBaseLibroController(DsbBaseView v) {
		super(v);
		this.v =(DsbBaseLibroView) v;
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
			for(int i =16; i< rCompCount ;++i) {
				rFields.remove(16);
			}		
			
			
			registerView.getLbl1().getLabel().setText(v.getNumeroSerieLbl());
			registerView.getLbl2().getLabel().setText(v.getIsbnLbl());
			registerView.getLbl3().getLabel().setText(v.getTituloLbl());
			registerView.getLbl4().getLabel().setText(v.getNumeroPaginasLbl());
			registerView.getLbl5().getLabel().setText(v.getPrecioReferenciaLbl());
			registerView.getLbl6().getLabel().setText(v.getFechaPublicacionLbl());
			registerView.getLbl7().getLabel().setText(v.getEstadoLibroLbl());
			registerView.getLbl8().getLabel().setText(v.getEditorialLbl());
			
			
			rFields.add(registerView.getCommitBtn(), "cell 1 "+rFields.getComponentCount()/2);
			break;
			
		case "modify":
			modifyView = (DsbModifyView) crudView;
			JPanel mFields = modifyView.getFields();
			
			int mCompCount = mFields.getComponentCount();
			for(int i =16; i< mCompCount ;++i) {
				mFields.remove(16);
			}	
			
			modifyView.getSelectLbl().getLabel().setText(v.getSelectLbl());
			
			modifyView.getLbl1().getLabel().setText(v.getNumeroSerieLbl());
			modifyView.getLbl2().getLabel().setText(v.getIsbnLbl());
			modifyView.getLbl3().getLabel().setText(v.getTituloLbl());
			modifyView.getLbl4().getLabel().setText(v.getNumeroPaginasLbl());
			modifyView.getLbl5().getLabel().setText(v.getPrecioReferenciaLbl());
			modifyView.getLbl6().getLabel().setText(v.getFechaPublicacionLbl());
			modifyView.getLbl7().getLabel().setText(v.getEstadoLibroLbl());
			modifyView.getLbl8().getLabel().setText(v.getEditorialLbl());
			
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
			searchView.getLbl1().getLabel().setText(v.getNumeroSerieLbl());
			
			sCbx.addItem(v.getNumeroSerieLbl());       
			sCbx.addItem(v.getIsbnLbl());              
			sCbx.addItem(v.getTituloLbl());            
			sCbx.addItem(v.getNumeroPaginasLbl());     
			sCbx.addItem(v.getPrecioReferenciaLbl());  
			sCbx.addItem(v.getFechaPublicacionLbl());  
			sCbx.addItem(v.getEstadoLibroLbl());     
			sCbx.addItem(v.getEditorialLbl());       
			
			
			             
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
			deleteView.getLbl1().getLabel().setText(v.getNumeroSerieLbl());
			deleteView.getLbl2().getLabel().setText("Seleccionado");
			deleteView.getLbl3().getLabel().setText("ninguno");
			
			dCbx.addItem(v.getNumeroSerieLbl());       
			dCbx.addItem(v.getIsbnLbl());              
			dCbx.addItem(v.getTituloLbl());            
			dCbx.addItem(v.getNumeroPaginasLbl());     
			dCbx.addItem(v.getPrecioReferenciaLbl());  
			dCbx.addItem(v.getFechaPublicacionLbl());  
			dCbx.addItem(v.getEstadoLibroLbl());     
			dCbx.addItem(v.getEditorialLbl());       
			
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
		model.addColumn("Libro");               
		model.addColumn("Num. serie");          
		model.addColumn("ISBN");                
		model.addColumn("Título");              
		model.addColumn("Num. páginas");        
		model.addColumn("Precio de referencia");
		model.addColumn("Fecha de publicación");
		model.addColumn("Estado del libro");    
		model.addColumn("Editorial");           
		return model;
	}

}
