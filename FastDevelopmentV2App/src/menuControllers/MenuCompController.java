package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menuViews.MenuCompPayView;
import menuViews.MenuCompTransView;
import menuViews.MenuCompView;

public class MenuCompController extends MenuBaseController{


	private MenuCompView v;
	
	private MenuCompPayController childPay;
	private MenuCompTransController childTrans;
	
	
	MenuCompController(MenuCompView v, MenuMainController mmc){
		super(v,mmc);
		this.v = v;
		this.mmc = mmc;
		
		childPay = new MenuCompPayController(new MenuCompPayView(), this);
		childTrans = new MenuCompTransController(new MenuCompTransView(), this);
		
	}
	
	public void start() {
		childPay.start();
		childTrans.start();
		mmc.addToLayout(v, v.getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		v.getTransBtn().getBtn().addMouseListener(new TransBtnLs());
		v.getPayMetBtn().getBtn().addMouseListener(new PayMetBtnLs());
		
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
	
	private class TransBtnLs implements MouseListener{

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
				mmc.changeMenu(childTrans.getName());
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
	
	private class PayMetBtnLs implements MouseListener{

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
				mmc.changeMenu(childPay.getName());
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
