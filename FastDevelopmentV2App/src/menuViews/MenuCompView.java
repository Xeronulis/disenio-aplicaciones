package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

@SuppressWarnings("serial")
public class MenuCompView extends MenuBaseView {


	
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

		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
								ColorsUtils.COLORS.get("itemHover"),
								ColorsUtils.COLORS.get("background")
								};
		setLayout(new BorderLayout(0, 0));
		
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		this.setPreferredSize(panel.getPreferredSize());
		add(panel);
		
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
