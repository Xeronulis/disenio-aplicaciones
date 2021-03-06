package controllers;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.ImageIcon;

import dashboardControllers.DsbMainController;
import dashboardViews.DsbCardLayout;
import dashboardViews.DsbMainView;
import menuControllers.MenuMainController;
import menuViews.MenuCardLayout;
import menuViews.MenuMainView;
import views.MainView;


/**
 * Esta clase controla las funciones generales del frame, dandonos las opciones basicas de 
 * manipulacion como por ejemplo abri o cerrar el menu lateral de la interfaz. 
 * @author Grupo4
 * @version 11-07-2021
 * 
 */

public class MainController {

	private MainView v;
	private MenuMainController mmc;
	private DsbMainController dmc;
	private Map<String, Color> colors;
	private DragHeader d = new DragHeader();
	private int persistent =0;
	private int prevPersistent=0;
	private static boolean isMenuShow = false;
	private CardLayout cLayout;
	
	/**
	 * Una breve descripcion del fin de cada atributo de la clase Arriendo.
	 * @param v: El frame principal
	 * @param mmc: Controlador de menu desplegable
	 * @param dmc: Controlador del dashboard
	 * @param colors: colores de la interfaz
	 * @param d: Clase que se encarga de arrastrar el frame principal con el mouse
	 * @param persistent: valor numerico que indica el id del menu abierto
	 * @param prevPersistent: valor numerico que indica el id del menu abierto anterior.
	 * @param cLayout: un card que contiene el menu principal.
	 */


	public static boolean isMenuShow() {
		return isMenuShow;
	}
	
	public MainView getMainView() {
		return this.v;
	}
	
	public DsbMainController getDsbMainController() {
		return this.dmc;
	}
	
	public MenuMainController getMenuMainController(){
		return this.mmc;
	}
	

	public MainController(MainView view) {
		this.v = view;
		mmc = new MenuMainController(new MenuMainView(), this,new MenuCardLayout() );
		dmc = new DsbMainController(new DsbMainView(), this, new DsbCardLayout());
	}
	
	/**
	 * El metodo start inicializa el frame principal con sus configuraciones en default.
	 */
	
	public void start() {
		int menuIconWdth = (int)v.getMenuIcon().getPreferredSize().getWidth();
		colors = MainView.getColors();
		cLayout = v.getCardLayout();
		mmc.start();
		dmc.start();
		
		v.getMenuHide().setVisible(false);
		v.getMenu().setPreferredSize(new Dimension(menuIconWdth, 10));
		
		v.getMinBtnImg().addMouseListener(new MinBtnLs());
		v.getMaxBtnImg().addMouseListener(new MaxBtnLs());
		v.getCloseBtnImg().addMouseListener(new CloseBtnLs());
		
		v.getHeader().addMouseListener(d);
		v.getHeader().addMouseMotionListener(d);
		
		v.getHideMenuBtnImg().addMouseListener(new MenuBtnLs());
		v.getSettingsImg().addMouseListener(new SettingsLs());
		
		v.setUndecorated(true);
		v.setVisible(true);
	}
	/**
	 * Funcion que ejecuta activateMenuGui() y deactivateMenuGui()
	 */
	
	public void updateMenuGuis() {
		activateMenuGui();
		deactivateMenuGui();
		
	}
	
	/**
	 * Funcion que se encarga de cambiar la vista principal del menu desplegable.
	 */
	public void activateMenuGui() {
		switch(persistent){
		case 1:
			
			if(isMenuShow) {
				v.getHideMenuBtnImg().setIcon(new ImageIcon(MainView.class.getResource("/icons/back_32px.png")));
			}else {
				v.getHideMenuBtnImg().setIcon(new ImageIcon(MainView.class.getResource("/icons/menu_32px.png")));
			}
			
			v.getHideMenuBtn().setBackground(colors.get("menuHide"));
			cLayout.show(v.getCardPanel(), "menuCardLayout");
			break;
		case 2:
			v.getSettings().setBackground(colors.get("menuHide"));
			cLayout.show(v.getCardPanel(), "optionsPanel");
			break;
		}
	}
	
	/**
	 * Funcion que se encarga de desactivar la vista principal anterior del menu desplegable.
	 */
	public void deactivateMenuGui() {
		switch(prevPersistent){
		
		case 1:
			v.getHideMenuBtn().setBackground(colors.get("background"));
			v.getHideMenuBtnImg().setIcon(new ImageIcon(MainView.class.getResource("/icons/menu_32px.png")));
			//mmc.changeMenu("menuMain");
			break;
		case 2:
			v.getSettings().setBackground(colors.get("background"));
			break;
		}
	}
	
	/**
	 * Contiene un parametro.
	 * @param b: indica si es que se quiere mostrar o no el menu principal
	 * La funcion se encarga de mostrar o ocultar el menu desplegable.
	 */
	
	public void changeMenuShow(boolean b) {
		isMenuShow=b;
		
		if(!isMenuShow) {
			v.getMenuHide().setVisible(false);
			int temp = v.getMenuIcon().getWidth();
			v.getMenu().setPreferredSize(new Dimension(temp, 10));
			//mmc.changeMenu("menuMain");
		}else {
			v.getMenuHide().setVisible(true);
			v.getMenu().setPreferredSize(new Dimension(318, 10));
		}
		
	}
	
	/**
	 * 
	 * @author Grupo4
	 * @version 12-07-2021
	 */
	
	private class MinBtnLs implements MouseListener{

		private boolean isIn;
		
		/**
		 * metodo que permite el minimizado de la aplicacion
		 */
		
		public void minimize() {
			if(v.getExtendedState() == Frame.MAXIMIZED_BOTH) {
				v.getHeader().addMouseListener(d);
				v.getHeader().addMouseMotionListener(d);
			}
			v.setExtendedState(Frame.ICONIFIED);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			v.getMinBtn().setBackground(colors.get("itemPressed"));
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			v.getMinBtn().setBackground(colors.get("itemHover"));
			if(isIn) {
				minimize();
			}else {
				v.getMinBtn().setBackground(colors.get("background"));
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			v.getMinBtn().setBackground(colors.get("itemHover"));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			v.getMinBtn().setBackground(colors.get("background"));
			
		}
		
	}
	
	
	
	private class MaxBtnLs implements MouseListener{

		private boolean isIn;
		
		/**
		 * Permite maximinar la aplicacion
		 */
		public void maximize() {
			if(v.getExtendedState() != 0) {
				v.setExtendedState(Frame.NORMAL);
				v.getHeader().addMouseListener(d);
				v.getHeader().addMouseMotionListener(d);
			}else {
				v.setExtendedState(Frame.MAXIMIZED_BOTH);
				v.getHeader().removeMouseListener(d);
				v.getHeader().removeMouseMotionListener(d);
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			v.getMaxBtn().setBackground(colors.get("itemPressed"));
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			v.getMaxBtn().setBackground(colors.get("itemHover"));
			if(isIn) {
				maximize();
			}else {
				v.getMaxBtn().setBackground(colors.get("background"));
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			v.getMaxBtn().setBackground(colors.get("itemHover"));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			v.getMaxBtn().setBackground(colors.get("background"));
			
		}
		
	}

	
	private class CloseBtnLs implements MouseListener{

		private boolean isIn;
		
		/**
		 * Permite cerrar la aplicion por completo
		 */
		public void close() {
			v.dispatchEvent(new WindowEvent(v , WindowEvent.WINDOW_CLOSING));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			v.getCloseBtn().setBackground(colors.get("itemPressed"));
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			v.getCloseBtn().setBackground(colors.get("itemHover"));
			if(isIn) {
				close();
			}else {
				v.getCloseBtn().setBackground(colors.get("background"));
			}
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			v.getCloseBtn().setBackground(colors.get("itemHover"));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			v.getCloseBtn().setBackground(colors.get("background"));
			
		}
		
	}
	
	
		class DragHeader implements MouseMotionListener, MouseListener{

		Point winLocation;
		
		/**
		 * Esta clase tiene un solo atributo.
		 * @param winLocation: La coordenada donde se encuentra la pantalla
		 */
		
		
		/**
		 * Permite que se pueda manipular la aplicacion con el mouse.
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			v.setLocation(e.getXOnScreen()-winLocation.x, e.getYOnScreen()-winLocation.y);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {	
			winLocation = new Point(e.getXOnScreen()-v.getLocation().x, e.getYOnScreen()-v.getLocation().y);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			winLocation = null;
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	/**
	 * 
	 */
	private class MenuBtnLs implements MouseListener{

		private final int ID =1;	
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if(!isMenuShow) {
				changeMenuShow(true);
				
			}else if(persistent== ID){
				changeMenuShow(false);
				
			}
			if(persistent != ID) {
				prevPersistent = persistent;
				persistent =ID;
					
			}
			updateMenuGuis();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(persistent != ID || !isMenuShow) {
				v.getHideMenuBtn().setBackground(colors.get("itemHover"));
			}
			v.getMenuIconLine().setBackground(colors.get("menuLineSlctd"));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(persistent != ID || !isMenuShow) {
				v.getHideMenuBtn().setBackground(colors.get("background"));
			}
			v.getMenuIconLine().setBackground(colors.get("background"));
			
		}
		
	}
	
	/**
	 *Al igual que la clase anterior esta solo se encarga de mostrar el menu de ajustes del menu
	 *desplegable.
	 *@author Grupo4
	 *@version 11-07-2021
	 */
	private class SettingsLs implements MouseListener{

		private final int ID = 2;
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			if(!isMenuShow) {
				changeMenuShow(true);

			}else if(persistent== ID){
				changeMenuShow(false);
			}
			
			if(persistent != ID) {
				prevPersistent = persistent;
				persistent =ID;
			}
			updateMenuGuis();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(persistent != ID || !isMenuShow) {
				v.getSettings().setBackground(colors.get("itemHover"));
			}
			v.getMenuIconLine2().setBackground(colors.get("menuLineSlctd"));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(persistent != ID || !isMenuShow) {
				v.getSettings().setBackground(colors.get("background"));
			}
			v.getMenuIconLine2().setBackground(colors.get("background"));
			
		}
		
	}
	
}
