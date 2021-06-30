package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;

@SuppressWarnings("serial")
public class MenuLibrosView extends MenuBaseView {
	
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
		
		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("itemHover"),
				ColorsUtils.COLORS.get("background")
				};
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		this.setViewportView(panel);
		
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
