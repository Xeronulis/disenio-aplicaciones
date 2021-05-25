package dashboardViews;

import javax.swing.JPanel;

import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class DsbCardLayout extends JPanel {

	/**
	 * Create the panel.
	 */
	public DsbCardLayout() {

		this.setSize(SizeUtils.DASHBOARDSIZE);
		this.setBackground(ColorsUtils.COLORS.get("background"));
		setLayout(new CardLayout(0, 0));
		
	}

}
