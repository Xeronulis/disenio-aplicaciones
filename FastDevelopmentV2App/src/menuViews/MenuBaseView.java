package menuViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import customItems.CustomizeMenu;
import utils.ColorsUtils;

/*esta clase es para que todas las otras Views sean Scrollables y ademas es clase padre de todas las demas clases view
estos menus seran tipo vista-controlador donde el controlador se encargara de recibir los datos del usuario 
y las vistas solo seran para mostrar al usuario
@author Grupo 4 
@version 12/07/2021
*/
public class MenuBaseView extends JScrollPane {


	/**
	 * Create the panel.
	 */
	public MenuBaseView() {
		
		// se crea una variable para el scroll del programa
		JScrollPane sp = CustomizeMenu.cutomizeScrollPane(new JScrollPane());
		
		//define una variable de tipo Color para el background
		Color background = ColorsUtils.COLORS.get("background");
		
		//se definen los valores que que tendran distintos componentes
		this.setViewportBorder(null);
		this.setBorder(null);
		this.setPreferredSize(new Dimension(200, 100));
		this.setBackground(background);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.getVerticalScrollBar().setBackground(background);
		this.getHorizontalScrollBar().setBackground(background);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		this.getViewport().setBackground(background);
		this.getVerticalScrollBar().setUI(sp.getVerticalScrollBar().getUI());
		this.getVerticalScrollBar().setUnitIncrement(20);
		
	}

}
