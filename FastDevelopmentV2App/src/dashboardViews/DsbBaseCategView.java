package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;

public class DsbBaseCategView extends DsbBaseView {
	
	private String categCategoryTxt;
	private String categCategoryLbl;
	
	public String getCategCategoryTxt() {
		return categCategoryTxt;
	}

	public String getCategCategoryLbl() {
		return categCategoryLbl;
	}
	/**
	 * Create the panel.
	 */
	public DsbBaseCategView() {
		this.setName("categ");
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
		this.selectLbl = "Categoría";
		this.categCategoryLbl ="Categoría";
	
	
	}
}
