package dashboardViews;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import customItems.CustomDsLabel;
import utils.ColorsUtils;
import utils.SizeUtils;

public class DsbBaseCrudView extends JPanel {

	
	protected DsbBaseView baseView;
	
	

	
	public DsbBaseView getBaseView() {
		return this.baseView;
	}
	/**
	 * Create the panel.
	 */
	public DsbBaseCrudView() {

	}
	
	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
	}

}
