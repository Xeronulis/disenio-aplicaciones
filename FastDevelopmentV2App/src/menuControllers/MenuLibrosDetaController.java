package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menuViews.MenuLibrosDetaAutorView;
import menuViews.MenuLibrosDetaCategView;
import menuViews.MenuLibrosDetaEditView;
import menuViews.MenuLibrosDetaEstView;
import menuViews.MenuLibrosDetaIdioView;
import menuViews.MenuLibrosDetaView;

public class MenuLibrosDetaController extends MenuBaseController{
	
	
	private MenuLibrosDetaView v;
	private MenuLibrosController c;
	
	
	private MenuLibrosDetaAutorController childAutor;
	private MenuLibrosDetaEditController childEdit;
	private MenuLibrosDetaCategController childCateg;
	private MenuLibrosDetaIdioController childIdio;
	private MenuLibrosDetaEstController childEst;
	
	
	MenuLibrosDetaController(MenuLibrosDetaView v, MenuLibrosController c){
		super(v,c);
		this.v = v;
		this.c = c;
		mmc = this.c.getMenuMainController();
		childAutor = new MenuLibrosDetaAutorController(new MenuLibrosDetaAutorView(), this);
		childEdit = new MenuLibrosDetaEditController(new MenuLibrosDetaEditView(),this);
		childCateg = new MenuLibrosDetaCategController(new MenuLibrosDetaCategView(), this);
		childIdio = new MenuLibrosDetaIdioController(new MenuLibrosDetaIdioView(), this);
		childEst = new MenuLibrosDetaEstController(new MenuLibrosDetaEstView(), this);
	}
	
	public MenuLibrosController getMenuLibrosController() {
		return this.c;
	}
	

	
	public void start() {
		childAutor.start();
		childEdit.start();
		childCateg.start();
		childIdio.start();
		childEst.start();
		
		mmc.addToLayout(v, v.getName());
		
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		v.getAutorBtn().getBtn().addMouseListener(new AutorBtnLs());
		v.getEditBtn().getBtn().addMouseListener(new EditBtnLs());
		v.getCategBtn().getBtn().addMouseListener(new CategBtnLs());
		v.getIdioBtn().getBtn().addMouseListener(new IdioBtnLs());
		v.getEstBtn().getBtn().addMouseListener(new EstBtnLs());
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

	private class AutorBtnLs implements MouseListener{

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
				mmc.changeMenu(childAutor.getName());
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

	private class EditBtnLs implements MouseListener{

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
				mmc.changeMenu(childEdit.getName());
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

	private class CategBtnLs implements MouseListener{

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
				mmc.changeMenu(childCateg.getName());
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
	
	private class IdioBtnLs implements MouseListener{

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
				mmc.changeMenu(childIdio.getName());
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
	
	private class EstBtnLs implements MouseListener{

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
				mmc.changeMenu(childEst.getName());
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
