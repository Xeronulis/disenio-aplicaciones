package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;
/*Esta es la vista del menu de factura (opciones), aqui se muestra lo que el usuario vera en el software
@author Grupo 4
@Version 14/07/2021*/
@SuppressWarnings("serial")
public class MenuFactView extends MenuBaseView {


	//Se definen las variables de las opciones como botones tipo CustomMenuBtn
	private CustomMenuBtn backBtn;
	private CustomMenuBtn regisBtn;
	private CustomMenuBtn modifBtn;
	private CustomMenuBtn buscBtn;
	private CustomMenuBtn borBtn;
	
	
	public CustomMenuBtn getBuscBtn() {
		return buscBtn;
	}

	public CustomMenuBtn getRegisBtn() {
		return regisBtn;
	}

	public CustomMenuBtn getModifBtn() {
		return modifBtn;
	}
	
	public CustomMenuBtn getBorBtn() {
		return borBtn;
	}
	
	public CustomMenuBtn getBackBtn(){
		return backBtn;
	}
	
	
	/**
	 * Create the panel.
	 */
	public MenuFactView() {
		this.setName("menuFact");
		
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
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuFactView.class.getResource("/icons/back_32px.png")));
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.regisBtn = new CustomMenuBtn(" Generar Factura");
		regisBtn.getBtnImg().setIcon(new ImageIcon(MenuFactView.class.getResource("/icons/new_copy_32px.png")));
		regisBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.modifBtn = new CustomMenuBtn(" Modificar / Folio");
		modifBtn.getBtnImg().setIcon(new ImageIcon(MenuFactView.class.getResource("/icons/edit_file_32px.png")));
		modifBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.buscBtn = new CustomMenuBtn(" Buscar / Folio");
		buscBtn.getBtnImg().setIcon(new ImageIcon(MenuFactView.class.getResource("/icons/search_32px.png")));
		buscBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.borBtn = new CustomMenuBtn(" Borrar / Folio");
		borBtn.getBtnImg().setIcon(new ImageIcon(MenuDistView.class.getResource("/icons/delete_document_32px.png")));
		borBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		panel.getBox().add(backBtn);
		panel.getBox().add(regisBtn);
		panel.getBox().add(modifBtn);
		panel.getBox().add(buscBtn);
		panel.getBox().add(borBtn);
		
		panel.setNumberOfBtns(5);
		
		
				
	}

}
