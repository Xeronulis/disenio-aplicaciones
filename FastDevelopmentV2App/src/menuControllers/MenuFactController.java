package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menuViews.MenuFactView;

public class MenuFactController extends MenuBaseEndController {


	private MenuFactView v;
	private MenuMainController mmc;
	
	
	
	MenuFactController(MenuFactView v, MenuMainController mmc){
		super(v,mmc);
		this.v = v;
		this.mmc = mmc;
		
	}
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		/*
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		this.initDsbRegister("factura");
		this.childDRegisterC.linkName(getName());
		this.childDRegisterC.start();
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		this.initDsbModify("");
		//this.childDModifyV.getLabelToChange().setText("modificar facturini");
		this.childDModifyC.linkName(getName());
		this.childDModifyC.start();
		
		v.getBuscBtn().getBtn().addMouseListener(new BuscBtnLs());
		this.initDsbSearch();
		this.childDSearchV.getLabelToChange().setText("buscar facturini");
		this.childDSearchC.linkName(getName());
		this.childDSearchC.start();
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		this.initDsbDelete();
		this.childDDeleteV.getLabelToChange().setText("borrar facturini");
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
				mmc.getDsbMainController().changeDs(childSearchC.getName());
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
