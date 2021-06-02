package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DsbBasePayView extends DsbBaseView {
	
	private String metodoLbl;
	private String metodoTxt;
	
	public String getMetodoLbl() {
		return metodoLbl;
	}

	public String getMetodoTxt() {
		return metodoTxt;
	}

	/**
	 * Create the panel.
	 */
	public DsbBasePayView() {
		this.setName("pay");
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
		
		
		this.selectLbl = "Método de pago";
		this.metodoLbl ="Nombre";
		
		
	}
}
