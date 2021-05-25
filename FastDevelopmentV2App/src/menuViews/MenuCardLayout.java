package menuViews;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.ColorsUtils;
import utils.SizeUtils;

@SuppressWarnings("serial")
public class MenuCardLayout extends JPanel {

	CardLayout cardLayout;
	/**
	 * Create the panel.
	 */
	public MenuCardLayout() {

		
		this.setPreferredSize(new Dimension((int)SizeUtils.MENUHIDESIZEX, 500));
		
		this.setBackground(ColorsUtils.COLORS.get("alpha"));
		setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout) this.getLayout();

	}

}
