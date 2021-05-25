package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

@SuppressWarnings("serial")
public class MenuLibrosDetaIdioView extends MenuBaseView {
	
	private CustomMenuBtn backBtn;
	private CustomMenuBtn regisBtn;
	private CustomMenuBtn modifBtn;
	private CustomMenuBtn mostBtn;
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

	public CustomMenuBtn getMostBtn() {
		return mostBtn;
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
	public MenuLibrosDetaIdioView() {
		this.setName("MenuLibrosDetaIdio");

		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("itemHover"),
				ColorsUtils.COLORS.get("background")
				};
		setLayout(new BorderLayout(0, 0));
		
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		this.setPreferredSize(panel.getPreferredSize());
		add(panel);
		
		this.backBtn = new CustomMenuBtn(" Atrás");
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaIdioView.class.getResource("/icons/back_32px.png")));
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.regisBtn = new CustomMenuBtn(" Registrar");
		regisBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaIdioView.class.getResource("/icons/new_copy_32px.png")));
		regisBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.modifBtn = new CustomMenuBtn(" Modificar");
		modifBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaIdioView.class.getResource("/icons/edit_file_32px.png")));
		modifBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.mostBtn = new CustomMenuBtn(" Mostrar todos");
		mostBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaIdioView.class.getResource("/icons/eye_32px.png")));
		mostBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.buscBtn = new CustomMenuBtn(" Buscar / Cód. Idio");
		buscBtn.getBtnImg().setIcon(new ImageIcon(MenuLibrosDetaIdioView.class.getResource("/icons/search_32px.png")));
		buscBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.borBtn = new CustomMenuBtn(" Borrar");
		borBtn.getBtnImg().setIcon(new ImageIcon(MenuDistView.class.getResource("/icons/delete_document_32px.png")));
		borBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		panel.getBox().add(backBtn);
		panel.getBox().add(regisBtn);
		panel.getBox().add(modifBtn);
		panel.getBox().add(mostBtn);
		panel.getBox().add(buscBtn);
		panel.getBox().add(borBtn);
		
		panel.setNumberOfBtns(6);
		
	}
	

}
