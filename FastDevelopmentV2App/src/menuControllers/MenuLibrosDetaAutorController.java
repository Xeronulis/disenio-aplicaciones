package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dashboardControllers.DsbBaseAutorController;
import dashboardViews.DsbBaseAutorView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import menuViews.MenuLibrosDetaAutorView;

public class MenuLibrosDetaAutorController extends MenuBaseEndController{


	private MenuLibrosDetaAutorView v;
	private MenuLibrosDetaController c;
	
	private DsbBaseAutorView dsv;
	private DsbBaseAutorController dsc;
	
	MenuLibrosDetaAutorController(MenuLibrosDetaAutorView v, MenuLibrosDetaController c){
		super(v,c);
		this.v = v;
		this.c = c;
		mmc = this.c.getMenuMainController();
		
		dsv = new DsbBaseAutorView();
		dsc = new DsbBaseAutorController(dsv);
		
	}
	
	public MenuLibrosDetaController getMenuDetaController() {
		return this.c;
	}
	
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		mmc.getDsbMainController().addToLayout(dsv, getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		childRegisterV = new DsbRegisterView(dsv, "autor");
		this.dsc.initCustomLayout(childRegisterV, "register");
		this.dsc.addToLayout(childRegisterV, childRegisterV.getName());
		
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		childModifyV = new DsbModifyView(dsv, "autor");
		this.dsc.initCustomLayout(childModifyV, "modify");
		this.dsc.addToLayout(childModifyV, childModifyV.getName());
		
		
		v.getMostBtn().getBtn().addMouseListener(new MostBtnLs());
		childShowV = new DsbShowView(dsv, "autor");
		this.dsc.initCustomLayout(childShowV, "show");
		this.dsc.addToLayout(childShowV, childShowV.getName());
		
		
		v.getBuscBtn().getBtn().addMouseListener(new BuscBtnLs());
		childSearchV = new DsbSearchView(dsv, "autor");
		this.dsc.initCustomLayout(childSearchV, "search");
		this.dsc.addToLayout(childSearchV, childSearchV.getName());
		
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		childDeleteV = new DsbDeleteView(dsv, "autor");
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
				dsc.resetRegister();
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
				dsc.resetModify();
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
				dsc.resetShow();
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
				dsc.resetSearch();
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
				dsc.resetDelete();
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
