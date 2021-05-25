package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

@SuppressWarnings("serial")
public class MenuLibrosDetaView extends MenuBaseView {

	
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
		
		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("itemHover"),
				ColorsUtils.COLORS.get("background")
				};
		setLayout(new BorderLayout(0, 0));
		
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		this.setPreferredSize(panel.getPreferredSize());
		add(panel);
		
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
