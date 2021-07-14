package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

/*Esta es la vista del menu libros, opciones de los detalles de un libro, 
 * para configurar el autor, categoria, editorial, idioma y estado.
 *aqui se muestra lo que el usuario vera en el software
@author Grupo 4
@Version 14/07/2021*/
@SuppressWarnings("serial")
public class MenuLibrosDetaView extends MenuBaseView {

	//Se definen las variables de las opciones como botones tipo CustomMenuBtn
	private CustomMenuBtn backBtn;
	private CustomMenuBtn autorBtn;
	private CustomMenuBtn editBtn;
	private CustomMenuBtn categBtn;
	private CustomMenuBtn idioBtn;
	private CustomMenuBtn estBtn;
	

	
	public CustomMenuBtn getIdioBtn() {
		return idioBtn;
	}

	public CustomMenuBtn getAutorBtn() {
		return autorBtn;
	}

	public CustomMenuBtn getEditBtn() {
		return editBtn;
	}

	public CustomMenuBtn getCategBtn() {
		return categBtn;
	}
	
	public CustomMenuBtn getEstBtn() {
		return estBtn;
	}
	
	public CustomMenuBtn getBackBtn(){
		return backBtn;
	}
	
	
	/**
	 * Create the panel.
	 */
	public MenuLibrosDetaView() {
		this.setName("menuLibrosDeta");
		
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
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaView.class.getResource("/icons/back_32px.png")));
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.autorBtn = new CustomMenuBtn(" Autor");
		autorBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaView.class.getResource("/icons/user_32px.png")));
		autorBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.editBtn = new CustomMenuBtn(" Editorial");
		editBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaView.class.getResource("/icons/book_stack_32px.png")));
		editBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.categBtn = new CustomMenuBtn(" Categoría");
		categBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaView.class.getResource("/icons/category_32px.png")));
		categBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.idioBtn = new CustomMenuBtn(" Idioma");
		idioBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaView.class.getResource("/icons/language_32px.png")));
		idioBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.estBtn = new CustomMenuBtn(" Estado");
		estBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaView.class.getResource("/icons/signal_32px.png")));
		estBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		panel.getBox().add(backBtn);
		panel.getBox().add(autorBtn);
		panel.getBox().add(editBtn);
		panel.getBox().add(categBtn);
		panel.getBox().add(idioBtn);
		panel.getBox().add(estBtn);
		
		panel.setNumberOfBtns(6);
		
	}
}
