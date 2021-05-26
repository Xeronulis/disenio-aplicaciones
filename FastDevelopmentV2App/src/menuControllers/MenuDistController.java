package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dashboardControllers.DsbBaseDistController;
import dashboardControllers.DsbDeleteController;
import dashboardControllers.DsbModifyController;
import dashboardControllers.DsbRegisterController;
import dashboardControllers.DsbSearchController;
import dashboardControllers.DsbShowController;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import menuViews.MenuDistView;
import utils.ColorsUtils;

public class MenuDistController extends MenuBaseEndController{

	private MenuDistView v;
	private DsbBaseDistController dsc;
	
	private DsbBaseDistView dsv;

	
	MenuDistController(MenuDistView v, MenuMainController mmc){
		super(v,mmc);
		this.v = v;
		
		dsv = new DsbBaseDistView();
		dsc = new DsbBaseDistController(dsv);
	}
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		mmc.getDsbMainController().addToLayout(dsv, getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		childRegisterV = new DsbRegisterView(dsv, "distribuidor");
		this.dsc.initCustomLayout(childRegisterV, "register");
		this.dsc.addToLayout(childRegisterV, childRegisterV.getName());
		
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		childModifyV = new DsbModifyView(dsv, "distribuidor");
		this.dsc.initCustomLayout(childModifyV, "modify");
		this.dsc.addToLayout(childModifyV, childModifyV.getName());
		
		
		v.getMostBtn().getBtn().addMouseListener(new MostBtnLs());
		childShowV = new DsbShowView(dsv, "distribuidor");
		this.dsc.initCustomLayout(childShowV, "show");
		this.dsc.addToLayout(childShowV, childShowV.getName());
		
		
		v.getBuscBtn().getBtn().addMouseListener(new BuscBtnLs());
		childSearchV = new DsbSearchView(dsv, "distribuidor");
		this.dsc.initCustomLayout(childSearchV, "search");
		this.dsc.addToLayout(childSearchV, childSearchV.getName());
		
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		childDeleteV = new DsbDeleteView(dsv, "distribuidor");
		this.dsc.initCustomLayout(childDeleteV, "delete");
		this.dsc.addToLayout(childDeleteV, childDeleteV.getName());
		
		
		
	}
	
	public void createDsView() {
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
				mmc.changeMenu(mmc.getName());
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
