package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;

public class DsbBaseEstView extends DsbBaseView {

	//Estado libro
	private String estStatusTxt;
	private String estStatusLbl;
	
	public String getEstStatusTxt() {
		return estStatusTxt;
	}

	public String getEstStatusLbl() {
		return estStatusLbl;
	}

	/**
	 * Create the panel.
	 */
	public DsbBaseEstView() {
		this.setName("stat");
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
		
		
		this.selectLbl = "Estado";
		this.estStatusLbl ="Estado";
		
		
	}
	

}
