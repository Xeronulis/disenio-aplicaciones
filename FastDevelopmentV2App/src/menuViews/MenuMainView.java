package menuViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.ScrollBarUI;

import customItems.CustomMenuBtn;
import customItems.CustomMenuBtnContainer;
import customItems.CustomizeDs;
import customItems.CustomizeMenu;
import utils.ColorsUtils;
import utils.SizeUtils;

/*Esta es la vista inicio, donde el usuario puede elegir que desa hacer en el programa
 *aqui se muestra lo que el usuario vera en el software
@author Grupo 4
@Version 14/07/2021*/
@SuppressWarnings("serial")
public class MenuMainView extends MenuBaseView {

	//Se definen las variables de las opciones como botones tipo CustomMenuBtn
	private CustomMenuBtn backBtn;
	private CustomMenuBtn libroBtn;
	private CustomMenuBtn distBtn;
	private CustomMenuBtn factBtn;
	private CustomMenuBtn compBtn;
	private CustomMenuBtn clientBtn;
	private CustomMenuBtn empBtn;
	private CustomMenuBtn ventaBtn;
	private CustomMenuBtn boletaBtn;
	private CustomMenuBtn arriendoBtn;
	
	
	
	
	
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
		
		this.clientBtn = new CustomMenuBtn(" Clientes");
		clientBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/truck_32px.png")));
		clientBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.empBtn = new CustomMenuBtn(" Empleados");
		empBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/truck_32px.png")));
		empBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.factBtn = new CustomMenuBtn(" Gestión Factura");
		factBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		factBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.compBtn = new CustomMenuBtn(" Compra de Libros");
		compBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		compBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.ventaBtn = new CustomMenuBtn(" Venta de Libros");
		ventaBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		ventaBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.boletaBtn = new CustomMenuBtn(" Gestión Boleta");
		boletaBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		boletaBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		this.arriendoBtn = new CustomMenuBtn(" Arriendo de Libros");
		arriendoBtn.getBtnImg().setIcon(new ImageIcon(MenuMainView.class.getResource("/icons/user_32px.png")));
		arriendoBtn.setAllColors(defaultColors[0],defaultColors[1] , defaultColors[2]);
		
		panel.getBox().add(backBtn);
		panel.getBox().add(libroBtn);
		panel.getBox().add(distBtn);
		panel.getBox().add(clientBtn);
		panel.getBox().add(empBtn);
		panel.getBox().add(compBtn);
		panel.getBox().add(ventaBtn);
		panel.getBox().add(arriendoBtn);
		panel.getBox().add(factBtn);
		panel.getBox().add(boletaBtn);

		panel.setNumberOfBtns(10);
		
	}
	
	
}
