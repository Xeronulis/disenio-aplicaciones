package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menuViews.MenuLibrosDetaCategView;

public class MenuLibrosDetaCategController extends MenuBaseEndController{

	
	private MenuLibrosDetaCategView v;
	private MenuLibrosDetaController c;
	
	
	MenuLibrosDetaCategController(MenuLibrosDetaCategView v, MenuLibrosDetaController c){
		super(v,c);
		this.v = v;
		this.c = c;
		mmc = this.c.getMenuMainController();
		
	}
	
	public MenuLibrosDetaController getMenuDetaController() {
		return this.c;
	}
	
	
	public void start() {
		mmc.addToLayout(v, v.getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		
		/*
		v.getRegisBtn().getBtn().addMouseListener(new RegisBtnLs());
		this.initDsbRegister("categor�a");
		this.childDRegisterC.linkName(getName());
		this.childDRegisterC.start();
		
		v.getModifBtn().getBtn().addMouseListener(new ModifBtnLs());
		this.initDsbModify("");
		//this.childDModifyV.getLabelToChange().setText("modificar categorini");
		this.childDModifyC.linkName(getName());
		this.childDModifyC.start();
		
		v.getMostBtn().getBtn().addMouseListener(new MostBtnLs());
		this.initDsbShow();
		this.childDShowV.getLabelToChange().setText("mostrar categorini");
		this.childDShowC.linkName(getName());
		this.childDShowC.start();
		
		v.getBuscBtn().getBtn().addMouseListener(new BuscBtnLs());
		this.initDsbSearch();
		this.childDSearchV.getLabelToChange().setText("buscar categorini");
		this.childDSearchC.linkName(getName());
		this.childDSearchC.start();
		
		v.getBorBtn().getBtn().addMouseListener(new BorBtnLs());
		this.initDsbDelete();
		this.childDDeleteV.getLabelToChange().setText("borrar categorini");
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
				mmc.getDsbMainController().changeDs(childShowC.getName());
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