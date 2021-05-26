package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dashboardControllers.DsbBaseLibroController;
import dashboardViews.DsbBaseLibroView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import menuViews.MenuLibrosLibrosView;

public class MenuLibrosLibrosController extends MenuBaseEndController{

	
	private MenuLibrosLibrosView v;
	private MenuLibrosController c;
	
	
	private DsbBaseLibroView dsv;
	private DsbBaseLibroController dsc;
	
	
	MenuLibrosLibrosController(MenuLibrosLibrosView v, MenuLibrosController c){
		super(v,c);
		this.v = v;
		this.c = c;
		mmc = this.c.getMenuMainController();
		
		dsv = new DsbBaseLibroView();
		dsc = new DsbBaseLibroController(dsv);
		
	}
	
	public MenuLibrosController getMenuLibrosController() {
		return this.c;
	}
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		mmc.getDsbMainController().addToLayout(dsv, getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		childRegisterV = new DsbRegisterView(dsv, "Libro");
		this.dsc.initCustomLayout(childRegisterV, "register");
		this.dsc.addToLayout(childRegisterV, childRegisterV.getName());
		
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		childModifyV = new DsbModifyView(dsv, "Libro");
		this.dsc.initCustomLayout(childModifyV, "modify");
		this.dsc.addToLayout(childModifyV, childModifyV.getName());
		
		v.getMostBtn().getBtn().addMouseListener(new MostBtnLs());
		childShowV = new DsbShowView(dsv, "Libro");
		this.dsc.initCustomLayout(childShowV, "show");
		this.dsc.addToLayout(childShowV, childShowV.getName());
		
		v.getBuscBtn().getBtn().addMouseListener(new BuscBtnLs());
		childSearchV = new DsbSearchView(dsv, "Libro");
		this.dsc.initCustomLayout(childSearchV, "search");
		this.dsc.addToLayout(childSearchV, childSearchV.getName());
		
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		childDeleteV = new DsbDeleteView(dsv, "Libro");
		this.dsc.initCustomLayout(childDeleteV, "delete");
		this.dsc.addToLayout(childDeleteV, childDeleteV.getName());
	}
	
	private class BackBtnLs implements MouseListener{

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
				mmc.changeMenu(c.getName());
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
	
	private class RegisBtnLs implements MouseListener{

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
				mmc.getDsbMainController().changeDs(v.getName());
				dsc.changeView(childRegisterV.getName());
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

	private class ModifBtnLs implements MouseListener{

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
				mmc.getDsbMainController().changeDs(v.getName());
				dsc.changeView(childModifyV.getName());
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
	
	private class MostBtnLs implements MouseListener{

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
				mmc.getDsbMainController().changeDs(v.getName());
				dsc.changeView(childShowV.getName());
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
	
	private class BuscBtnLs implements MouseListener{

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
				mmc.getDsbMainController().changeDs(v.getName());
				dsc.changeView(childSearchV.getName());
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
	
	private class BorBtnLs implements MouseListener{

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
				mmc.getDsbMainController().changeDs(v.getName());
				dsc.changeView(childDeleteV.getName());
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
