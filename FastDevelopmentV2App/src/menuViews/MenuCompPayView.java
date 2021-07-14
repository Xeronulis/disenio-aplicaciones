package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

/*Esta es la vista del menu de pago, aqui se muestra lo que el usuario vera en el software
@author Grupo 4
@Version 13/07/2021*/
@SuppressWarnings("serial")
public class MenuCompPayView extends MenuBaseView {

	//Se definen las variables de las opciones como botones tipo CustomMenuBtn
	private CustomMenuBtn regisBtn;
	private CustomMenuBtn modifBtn;
	private CustomMenuBtn borBtn;
	private CustomMenuBtn backBtn;


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
	public MenuCompPayView() {
		this.setName("menuCompPay");
		//Se define una lista de colores a utilizar 
		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("itemHover"),
				ColorsUtils.COLORS.get("background")
				};
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		// Se define una variable panel del tipo CustomMenuBtnContainer (clase de customItems)
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		this.setViewportView(panel);
		
		//Se crean los botones que le usuario podra ver y a las cuales podra acceder mediante un controller y posteriormente se guardan
		//en el panel para que el usuario pueda verlos
		this.backBtn = new CustomMenuBtn(" Atrás");
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuCompPayView.class.getResource("/icons/back_32px.png")));
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.regisBtn = new CustomMenuBtn(" Registrar");
		regisBtn.getBtnImg().setIcon(new ImageIcon(MenuCompPayView.class.getResource("/icons/new_copy_32px.png")));
		regisBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.modifBtn = new CustomMenuBtn(" Modificar");
		modifBtn.getBtnImg().setIcon(new ImageIcon(MenuCompPayView.class.getResource("/icons/edit_file_32px.png")));
		modifBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.borBtn = new CustomMenuBtn(" Borrar");
		borBtn.getBtnImg().setIcon(new ImageIcon(MenuCompPayView.class.getResource("/icons/delete_document_32px.png")));
		borBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		panel.getBox().add(backBtn);
		panel.getBox().add(regisBtn);
		panel.getBox().add(modifBtn);
		panel.getBox().add(borBtn);
		
		panel.setNumberOfBtns(4);
		
	}

}
