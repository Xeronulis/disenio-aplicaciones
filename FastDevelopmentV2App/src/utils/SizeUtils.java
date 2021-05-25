package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class SizeUtils {

	public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();;
	
	public static final Dimension WINDOWSIZE = new Dimension((int)(SCREENSIZE.getWidth()*0.7),(int) (SCREENSIZE.getHeight()*0.7));
	
	public static final Dimension MENUSIZE = new Dimension((int)WINDOWSIZE.getWidth()/3, 10);
	
	public static final double MENUICONSIZE = (MENUSIZE.getWidth()/6);
	
	public static final double MENUHIDESIZEX =(MENUSIZE.getWidth()-MENUICONSIZE);
	
	public static final int BOXSIZEX = (int) (MENUHIDESIZEX*0.9);
	
	public static final Dimension DASHBOARDSIZE = new Dimension((int)(WINDOWSIZE.getWidth()-MENUICONSIZE) ,(int)WINDOWSIZE.getHeight());
	
	
	
}
