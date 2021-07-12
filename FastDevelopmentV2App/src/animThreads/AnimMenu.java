package animThreads;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;

import javax.swing.JPanel;
import javax.swing.Timer;

import utils.AnimUtils;
import views.MainView;

public class AnimMenu implements ActionListener{

	private MainView v;
	
	
	private Timer timer = new Timer(0, this);
	
	private int cWidth;
	private int oWidth;
	
	private boolean opening;
	
	
	Dimension dim;
	
	
	private int cFrame =0;
	private int fFrame = 30;
	
	private double[] framesVal = new double[fFrame+1];
	private double[] framesValInv = new double[fFrame+1];
	
	private double[] values;
	
	
	public AnimMenu(MainView v){
		timer.setDelay(12);
		
		this.v = v;
		
		this.cWidth = v.getMenuIcon().getPreferredSize().width;
		oWidth = 318;
		
		dim = new Dimension(cWidth, 10);
		
		
		
		framesVal = AnimUtils.cubicBezier(0, -100, 1100, 1000, fFrame);
		
		double minLimit = framesVal[0];
		double maxLimit = framesVal[framesVal.length-1];
		
		for(int i=0; i<framesVal.length; ++i) {
			
			framesVal[i] = AnimUtils.map(framesVal[i], minLimit, maxLimit, cWidth, oWidth);
			
			
			framesValInv[framesVal.length-1-i] = framesVal[i];
			
		}
		
		
	}
	
	
	
	
	

	

	public void openMenu() {
		
		opening = true;
		v.getMenu().setPreferredSize(dim);
		values = framesVal;
		if(!timer.isRunning()) {
			
			
			timer.start();
		}else {
			cFrame = fFrame - cFrame;
			
			
		}
		
		
	}
	
	public void closeMenu() {
		
		opening = false;	
		v.getMenu().setPreferredSize(dim);
		
		values = framesValInv;
		
		if(!timer.isRunning()) {
			
			
			timer.start();
		}else {
			cFrame = fFrame - cFrame;
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		v.getMenuHide().setVisible(false);
		
		dim.width = (int) values[cFrame];
		
		v.getMenuHide().setVisible(true);
		
		
		
		if(cFrame == fFrame-1) {
			timer.stop();
			cFrame=0;
			
			if(opening) {
				v.getMenuHide().setVisible(true);
				dim.width = oWidth;
			}else {
				v.getMenuHide().setVisible(false);
				dim.width = cWidth;
			}
			
		}else {
			++cFrame;
		}
		
		
		
		
		
	}


	
	
	
}
