package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;

public class DsbBaseAutorView extends DsbBaseView {
	
	
	private String  nombreTxt;
	private String  apellido1Txt;
	private String  apellido2Txt;
	
	private String  nombreLbl;
	private String  apellido1Lbl;
	private String  apellido2Lbl;
	
	public String getNombreTxt() {
		return nombreTxt;
	}
	public String getApellido1Txt() {
		return apellido1Txt;
	}
	public String getApellido2Txt() {
		return apellido2Txt;
	}
	public String getNombreLbl() {
		return nombreLbl;
	}
	public String getApellido1Lbl() {
		return apellido1Lbl;
	}
	public String getApellido2Lbl() {
		return apellido2Lbl;
	}
	/**
	 * Create the panel.
	 */
	public DsbBaseAutorView() {
		this.setName("autor");
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
	
	
	this.selectLbl = "Autor";
	this.nombreLbl ="Nombre";
	this.apellido1Lbl ="Apellido paterno";
	this.apellido2Lbl ="Apellido materno";
	
	
	}
}
