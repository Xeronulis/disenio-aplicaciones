package dashboardViews;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class DsbBaseDistView extends DsbBaseView{
	//distribuidor
	protected DsbRegisterView registerView;
	protected DsbModifyView modifyView;
	protected DsbShowView showView;
	protected DsbSearchView searchView;
	
	protected String distRutTxt;
	protected String distNameTxt;
	protected String distAddressTxt;
	protected String distPhoneTxt;
	
	protected String distRutLbl;
	protected String distNameLbl;
	protected String distAddressLbl;
	protected String distPhoneLbl;
	
	//automatico (no se puede cambiar)
	protected String distStartDateTxt;
	protected String distStartDateLbl;
	
	public DsbRegisterView getRegisterView() {
		return registerView;
	}
	
	public DsbModifyView getModifyView() {
		return this.modifyView;
	}

	public String getDistRutTxt() {
		return distRutTxt;
	}

	public String getDistNameTxt() {
		return distNameTxt;
	}

	public String getDistAddressTxt() {
		return distAddressTxt;
	}

	public String getDistPhoneTxt() {
		return distPhoneTxt;
	}

	public String getDistRutLbl() {
		return distRutLbl;
	}

	public String getDistNameLbl() {
		return distNameLbl;
	}

	public String getDistAddressLbl() {
		return distAddressLbl;
	}

	public String getDistPhoneLbl() {
		return distPhoneLbl;
	}

	public String getDistStartDateTxt() {
		return distStartDateTxt;
	}

	public String getDistStartDateLbl() {
		return distStartDateLbl;
	}

	public DsbBaseDistView() {
		this.setName("dist");
		this.setCustomStuff();
		this.cLayout = (CardLayout) this.getLayout();
		
		JLabel lblNewLabel = new JLabel("testing...");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, "name_1634406629890300");
		
		
		initItems();
		
		
	}
	
	private void initItems() {
		
		
		this.selectLbl = "Distribuidor";
		this.distRutLbl = "Rut";
		this.distNameLbl = "Nombre";
		this.distAddressLbl = "Dirección";
		this.distPhoneLbl = "Teléfono";
		this.distStartDateLbl = "Fecha de Inicio";
		
		this.distStartDateTxt = java.time.LocalDate.now().toString();
		
		
	}
	
	public void changeView(String name) {
		this.cLayout.show(this, name);
	}
	
	public void addToLayout(DsbBaseCrudView v, String name) {
		this.add(v, name);
	}
	
	@Override
	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		
		switch (layout) {
		
		case "register":
			registerView = (DsbRegisterView) crudView;
			registerView.getLbl1().getLabel().setText(distRutLbl);
			registerView.getLbl2().getLabel().setText(distNameLbl);
			registerView.getLbl3().getLabel().setText(distAddressLbl);
			registerView.getLbl4().getLabel().setText(distPhoneLbl);
			registerView.getLbl5().getLabel().setText(distStartDateLbl);
			registerView.getTxt5().getTxt().setText(distStartDateTxt);
			registerView.getTxt5().getTxt().setEditable(false);
			break;
			
		case "modify":
			modifyView = (DsbModifyView) crudView;
			modifyView.getSelectLbl().getLabel().setText(selectLbl);
			modifyView.getLbl1().getLabel().setText(distRutLbl);
			modifyView.getLbl2().getLabel().setText(distNameLbl);
			modifyView.getLbl3().getLabel().setText(distAddressLbl);
			modifyView.getLbl4().getLabel().setText(distPhoneLbl);
			modifyView.getLbl5().getLabel().setText(distStartDateLbl);
			modifyView.getTxt5().getTxt().setText(distStartDateTxt);
			modifyView.getTxt5().getTxt().setEditable(false);
			
			
			
			break;
		case "show":
			showView = (DsbShowView) crudView;
			
			break;
		case "search":
			searchView = (DsbSearchView) crudView;
			JComboBox<Object> cbx = searchView.getSelectCbx().getComboBox();
			searchView.getSelectLbl().getLabel().setText("Buscar por");
			searchView.getLbl1().getLabel().setText(distRutLbl);
			cbx.addItem(distRutLbl);
			cbx.addItem(distNameLbl);
			cbx.addItem(distAddressLbl);
			cbx.addItem(distPhoneLbl);
			cbx.addItem(distStartDateLbl);
			
			cbx.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					searchView.getLbl1().getLabel().setText((String)cbx.getSelectedItem());
					
				}
				
			});
			
			
			
			break;
		case "delete":
			
			break;
		}
		
		
	}

	
	

}
