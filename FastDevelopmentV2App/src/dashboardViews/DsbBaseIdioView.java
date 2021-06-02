package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;

public class DsbBaseIdioView extends DsbBaseView {

	//Idioma
	private String idioLangTxt;
	private String idioLangLbl;
	
	public String getIdioLangTxt() {
		return idioLangTxt;
	}
	public String getIdioLangLbl() {
		return idioLangLbl;
	}
	/**
	 * Create the panel.
	 */
	public DsbBaseIdioView() {
		this.setName("lang");
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
		
		
		this.selectLbl = "Idioma";
		this.idioLangLbl ="Nombre";
		
		
	}
	
	

}
