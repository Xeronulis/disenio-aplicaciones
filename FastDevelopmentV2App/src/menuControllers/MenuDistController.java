package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	private DsbBaseDistView dsv;

	
	MenuDistController(MenuDistView v, MenuMainController mmc){
		super(v,mmc);
		this.v = v;
		
		dsv = new DsbBaseDistView();
	}
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		mmc.getDsbMainController().addToLayout(dsv, getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		this.childRegisterC = new DsbRegisterController(this.childRegisterV = new DsbRegisterView(dsv,"distribuidor"),mmc.getDsbMainController());
		this.dsv.initCustomLayout(childRegisterV, "register");
		this.dsv.addToLayout(childRegisterV, childRegisterV.getName());
		
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		this.childModifyC = new DsbModifyController(this.childModifyV = new DsbModifyView(dsv,"distribuidor"), mmc.getDsbMainController());
		this.dsv.initCustomLayout(childModifyV, "modify");
		this.dsv.addToLayout(childModifyV, childModifyV.getName());
		
		
		v.getMostBtn().getBtn().addMouseListener(new MostBtnLs());
		this.childShowC = new DsbShowController(this.childShowV = new DsbShowView(dsv,"distribuidor"), mmc.getDsbMainController());
		this.dsv.initCustomLayout(childShowV, "show");
		this.dsv.addToLayout(childShowV, childShowV.getName());
		
		
		v.getBuscBtn().getBtn().addMouseListener(new BuscBtnLs());
		this.childSearchC = new DsbSearchController(this.childSearchV = new DsbSearchView(dsv, "distribuidor"), mmc.getDsbMainController());
		this.dsv.initCustomLayout(childSearchV, "search");
		this.dsv.addToLayout(childSearchV, childSearchV.getName());
		
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		this.childDeleteC = new DsbDeleteController(this.childDeleteV = new DsbDeleteView(dsv, "distribuidor"), mmc.getDsbMainController());
		this.dsv.initCustomLayout(childDeleteV, "delete");
		this.dsv.addToLayout(childDeleteV, childDeleteV.getName());
		
		
		
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
				dsv.changeView(childRegisterV.getName());
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
				dsv.changeView(childModifyV.getName());
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
				dsv.changeView(childShowV.getName());
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
				dsv.changeView(childSearchV.getName());
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
				dsv.changeView(childDeleteV.getName());
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
