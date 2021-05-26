package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;

public class DsbBaseEditView extends DsbBaseView {

	//Editorial
	protected String editEditorialTxt;
	protected String editEditorialLbl;
	
	
	public String getEditEditorialTxt() {
		return editEditorialTxt;
	}

	public String getEditEditorialLbl() {
		return editEditorialLbl;
	}

	/**
	 * Create the panel.
	 */
	public DsbBaseEditView() {
		this.setName("edit");
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
	
	
	this.selectLbl = "Editorial";
	this.editEditorialLbl ="Editorial";
	
	
	}
}
