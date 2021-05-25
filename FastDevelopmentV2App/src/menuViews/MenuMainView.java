package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import utils.ColorsUtils;


@SuppressWarnings("serial")
public class MenuMainView extends MenuBaseView {
	
	private CustomMenuBtn backBtn;
	private CustomMenuBtn libroBtn;
	private CustomMenuBtn distBtn;
	private CustomMenuBtn factBtn;
	private CustomMenuBtn compBtn;
	
	
	public CustomMenuBtn getCompBtn() {
		return compBtn;
	}

	public CustomMenuBtn getLibroBtn() {
		return libroBtn;
	}

	public CustomMenuBtn getDistBtn() {
		return distBtn;
	}

	public CustomMenuBtn getFactBtn() {
		return factBtn;
	}
	
	public CustomMenuBtn getBackBtn(){
		return backBtn;
	}
	

	/**
	 * Create the panel.
	 */
	public MenuMainView() {
		this.setName("menuMain");
		
		Color[] defaultColors = {ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("itemHover"),
				ColorsUtils.COLORS.get("background")
				};
		setLayout(new BorderLayout(0, 0));
		
		CustomMenuBtnContainer panel = new CustomMenuBtnContainer();
		
		this.setPreferredSize(panel.getPreferredSize());
		add(panel);
		
		this.backBtn = new CustomMenuBtn(" ");
		backBtn.getBtnTxt().setText(" Inicio");
		backBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		backBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/restore_32px.png")));

		
		this.libroBtn = new CustomMenuBtn(" Libros");
		libroBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/book_32px.png")));
		libroBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.distBtn = new CustomMenuBtn(" Distribuidores");
		distBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/truck_32px.png")));
		distBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.factBtn = new CustomMenuBtn(" Gestión Factura");
		factBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		factBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.compBtn = new CustomMenuBtn(" Gestión Compra");
		compBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		compBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		
		panel.getBox().add(backBtn);
		panel.getBox().add(libroBtn);
		panel.getBox().add(distBtn);
		panel.getBox().add(factBtn);
		panel.getBox().add(compBtn);

		
		panel.setNumberOfBtns(5);
		
	}
}
