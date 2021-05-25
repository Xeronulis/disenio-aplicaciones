package menuControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import menuViews.MenuLibrosDetaView;
import menuViews.MenuLibrosLibrosView;
import menuViews.MenuLibrosView;

public class MenuLibrosController extends MenuBaseController{

	
	private MenuLibrosView v;
	
	private MenuLibrosDetaController childDetails;
	private MenuLibrosLibrosController childLibros;
	
	MenuLibrosController(MenuLibrosView v, MenuMainController mmc){
		super(v,mmc);
		this.v = v;
		this.mmc = mmc;
		childDetails = new MenuLibrosDetaController(new MenuLibrosDetaView(), this);
		childLibros = new MenuLibrosLibrosController(new MenuLibrosLibrosView(), this);
		
	}
	
	
	
	public void start() {
		childDetails.start();
		childLibros.start();
		mmc.addToLayout(v, v.getName());
		
		v.getDetaBtn().getBtn().addMouseListener(new DetaBtnLs());
		v.getLibroBtn().getBtn().addMouseListener(new LibroBtnLs());
		v.getBackBtn().getBtn().addMouseListener(new BackBtnLs());
		
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
				mmc.changeMenu(childLibros.getName());
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
	
	private class DetaBtnLs implements MouseListener{
		
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
				mmc.changeMenu("menuLibrosDeta");
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
}
