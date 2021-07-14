package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

/*Esta es la vista del menu de compra, aqui se muestra lo que el usuario vera en el software
@author Grupo 4
@Version 13/07/2021*/
@SuppressWarnings("serial")
public class MenuCompView extends MenuBaseView {


	//Se definen las variables de las opciones como botones tipo CustomMenuBtn
	private CustomMenuBtn backBtn;
	private CustomMenuBtn payMetBtn;
	private CustomMenuBtn transBtn;


	public CustomMenuBtn getPayMetBtn() {
		return payMetBtn;
	}

	public CustomMenuBtn getTransBtn() {
		return transBtn;
	}


	public CustomMenuBtn getBackBtn(){
		return backBtn;
	}

	
	/**
	 * Create the panel.
	 */
	public MenuCompView() {
		this.setName("menuComp");
		
		// Se definen los colores a utilizar y se guardan en un arreglo 
		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
								ColorsUtils.COLORS.get("itemHover"),
								ColorsUtils.COLORS.get("background")
								};
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		// Se define el panel del tipo CustomMenuBtnContainer (clase de customItems)
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		//Se define lo que se mostrara al ususario, el panel
		this.setViewportView(panel);
		
		//Se crean los botones que le usuario podra ver, junto con sus iconos y color, a los cuales podra acceder mediante un controller 
		//y posteriormente se guardan en el panel para que el usuario pueda verlos
		this.backBtn = new CustomMenuBtn(" Atrás");
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuCompView.class.getResource("/icons/back_32px.png")));
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.payMetBtn = new CustomMenuBtn(" Método de Pago");
		payMetBtn.getBtnImg().setIcon(new ImageIcon(MenuCompView.class.getResource("/icons/mobile_payment_32px.png")));
		payMetBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.transBtn = new CustomMenuBtn(" Transacción");
		transBtn.getBtnImg().setIcon(new ImageIcon(MenuCompView.class.getResource("/icons/transaction_32px.png")));
		transBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		

		
		panel.getBox().add(backBtn);
		panel.getBox().add(payMetBtn);
		panel.getBox().add(transBtn);

		
		panel.setNumberOfBtns(3);
		
	}

}
