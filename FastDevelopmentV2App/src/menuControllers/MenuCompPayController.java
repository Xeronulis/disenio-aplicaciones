package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menuViews.MenuCompPayView;

public class MenuCompPayController extends MenuBaseEndController{

	private MenuCompPayView v;
	private MenuCompController c;
	
	
	
	MenuCompPayController(MenuCompPayView v, MenuCompController c){
		super(v,c);
		this.v = v;
		this.c = c;
		this.mmc = this.c.getMenuMainController();
		
	}
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		
		/*
		this.initDsbRegister("metodo de pago");
		
		this.childDRegisterC.linkName(getName());
		this.childDRegisterC.start();
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		this.initDsbModify("");
		//this.childDModifyV.get.setText("modificar metodo de paguini");
		this.childDModifyC.linkName(getName());
		this.childDModifyC.start();
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		this.initDsbDelete();
		this.childDDeleteV.getLabelToChange().setText("borrar metodo de paguini");
		this.childDDeleteC.linkName(getName());
		this.childDDeleteC.start();
		*/
		
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
				mmc.getDsbMainController().changeDs(childRegisterC.getName());
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
				mmc.getDsbMainController().changeDs(childModifyC.getName());
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
				mmc.getDsbMainController().changeDs(childDeleteC.getName());
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
