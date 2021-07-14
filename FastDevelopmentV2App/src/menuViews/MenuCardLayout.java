package menuViews;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import customItems.CustomizeDs;
import utils.ColorsUtils;
import utils.SizeUtils;

/*En esta clase se define el tama�o del menu y el color que tendra el mismo
@author Grupo 4
@Version 13/07/2021 */
@SuppressWarnings("serial")
public class MenuCardLayout extends JPanel {

	CardLayout cardLayout;
	
	/**
	 * Create the panel.
	 */
	public MenuCardLayout() {

		//Define el tama�o del menu
		this.setPreferredSize(new Dimension((int)SizeUtils.MENUHIDESIZEX, 500));
		
		//Establece los colores del menu y los guarda en el cardLayout
		this.setBackground(ColorsUtils.COLORS.get("alpha"));
		setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout) getLayout();
		
		

	}

}
