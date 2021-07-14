package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

/*Esta es la vista del menu libros, opciones para ver detalles o registar un libro  
 *aqui se muestra lo que el usuario vera en el software
@author Grupo 4
@Version 14/07/2021*/
@SuppressWarnings("serial")
public class MenuLibrosView extends MenuBaseView {

	//Se definen las variables de las opciones como botones tipo CustomMenuBtn
	private CustomMenuBtn backBtn;
	private CustomMenuBtn libroBtn;
	private CustomMenuBtn detaBtn;


	public CustomMenuBtn getLibroBtn() {
		return libroBtn;
	}

	public CustomMenuBtn getDetaBtn() {
		return detaBtn;
	}
	
	public CustomMenuBtn getBackBtn(){
		return backBtn;
	}



	/**
	 * Create the panel.
	 */
	public MenuLibrosView() {
		this.setName("menuLibros");

		// Se definen los colores a utilizar y se guardan en un arreglo 
		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("itemHover"),
				ColorsUtils.COLORS.get("background")
				};
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));

		// Se define el panel del tipo CustomMenuBtnContainer (clase de customItems).
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();

		//Se define lo que se mostrara al ususario, el panel.
		this.setViewportView(panel);

		//Se crean los botones que le usuario podra ver, junto con sus iconos y color, a los cuales podra acceder mediante un controller 
		//y posteriormente se guardan en el panel que se mostarra al usuario.
		this.backBtn = new CustomMenuBtn(" Atrás");
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosView.class.getResource("/icons/back_32px.png")));
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.libroBtn = new CustomMenuBtn(" Libros");
		libroBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosView.class.getResource("/icons/book_32px.png")));
		libroBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.detaBtn = new CustomMenuBtn(" Detalles");
		detaBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosView.class.getResource("/icons/details_32px.png")));
		detaBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		panel.getBox().add(backBtn);
		panel.getBox().add(libroBtn);
		panel.getBox().add(detaBtn);

		
		panel.setNumberOfBtns(3);
		
		
	}

}
