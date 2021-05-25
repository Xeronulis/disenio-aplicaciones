package menuControllers;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controllers.MainController;
import dashboardControllers.DsbMainController;
import dashboardViews.DsbMainView;
import menuViews.MenuCardLayout;
import menuViews.MenuCompView;
import menuViews.MenuDistView;
import menuViews.MenuFactView;
import menuViews.MenuLibrosView;
import menuViews.MenuMainView;

public class MenuMainController {

	
	private MenuMainView v;
	private MenuCardLayout menuCardLayout;
	private CardLayout cardLayout;
	private MainController mc;
	
	private MenuLibrosController childLibros;
	private MenuDistController childDist;
	private MenuFactController childFact;
	private MenuCompController childComp;
		
	
	public MenuMainController(MenuMainView v, MainController mc, MenuCardLayout mcl){
		this.v = v;
		this.mc = mc;
		this.menuCardLayout = mcl;
		
		childLibros = new MenuLibrosController(new MenuLibrosView(), this);
		childDist = new MenuDistController(new MenuDistView(), this);
		childFact = new MenuFactController(new MenuFactView(), this);
		childComp = new MenuCompController(new MenuCompView(), this);
		
	}
	
	public DsbMainController getDsbMainController() {
		return mc.getDsbMainController();
	}
	
	public String getName() {
		return this.v.getName();
	}
	

	public void start() {
		childLibros.start();
		childDist.start();
		childFact.start();
		childComp.start();
		menuCardLayout.add(v, v.getName());
		cardLayout = (CardLayout) menuCardLayout.getLayout();
		mc.getMainView().getCardPanel().add(menuCardLayout, "menuCardLayout");
		
		v.getBackBtn().getBtn().addMouseListener(new HomeBtnLs());
		v.getLibroBtn().getBtn().addMouseListener(new LibroBtnLs());
		v.getDistBtn().getBtn().addMouseListener(new DistBtnLs());
		v.getFactBtn().getBtn().addMouseListener(new FactBtnLs());
		v.getCompBtn().getBtn().addMouseListener(new CompBtnLs());
		
		changeMenu(v.getName());
		
	}
	
	public void addToLayout(JPanel panel, String name) {
		menuCardLayout.add(panel,name);
	}
	
	public void changeMenu(String name) {
		cardLayout.show(menuCardLayout, name);
	}
	
	private class HomeBtnLs implements MouseListener{

		private boolean isIn;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				mc.getDsbMainController().changeDs(mc.getDsbMainController().getName());
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			
		}
		
	}
	
	private class LibroBtnLs implements MouseListener{
		
		private boolean isIn;
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}
		@Override
		public void mousePressed(MouseEvent e) {	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				changeMenu(childLibros.getName());
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
		}
		@Override
		public void mouseExited(MouseEvent e) {	
			isIn = false;
		}
		
	}
	
	private class DistBtnLs implements MouseListener{

		private boolean isIn;
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}
		@Override
		public void mousePressed(MouseEvent e) {	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				changeMenu(childDist.getName());
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
		}
		@Override
		public void mouseExited(MouseEvent e) {	
			isIn = false;
		}
		
	}

	private class FactBtnLs implements MouseListener{

		private boolean isIn;
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}
		@Override
		public void mousePressed(MouseEvent e) {	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				changeMenu(childFact.getName());
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
		}
		@Override
		public void mouseExited(MouseEvent e) {	
			isIn = false;
		}
		
	}
	
	private class CompBtnLs implements MouseListener{

		private boolean isIn;
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}
		@Override
		public void mousePressed(MouseEvent e) {	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				changeMenu(childComp.getName());
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
		}
		@Override
		public void mouseExited(MouseEvent e) {	
			isIn = false;
		}
		
	}
	
}
