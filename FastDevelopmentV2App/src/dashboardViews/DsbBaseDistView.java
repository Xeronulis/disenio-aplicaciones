package dashboardViews;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import customItems.CustomizeDs;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class DsbBaseDistView extends DsbBaseView{
	//distribuidor
	
	
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
	

	
	
	
	

}
