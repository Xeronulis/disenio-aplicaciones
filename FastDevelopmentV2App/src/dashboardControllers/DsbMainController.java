package dashboardControllers;

import java.awt.CardLayout;

import javax.swing.JPanel;

import controllers.MainController;
import dashboardViews.DsbCardLayout;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbMainView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;

public class DsbMainController {
	
	private DsbMainView v;
	private MainController mc;
	private DsbCardLayout dsbCardLayout;
	private CardLayout cardLayout;
	

	
	public DsbMainController(DsbMainView v, MainController mc, DsbCardLayout dcl) {
		this.v = v;
		this.mc = mc;
		this.dsbCardLayout = dcl;
		

	}
	

	
	public void start() {

		
		cardLayout = (CardLayout) dsbCardLayout.getLayout();
		addToLayout(v, v.getName());
		mc.getMainView().getDashBoard().add(dsbCardLayout);
		
		changeDs(v.getName());
		
	}
	
	public void addToLayout(JPanel panel, String name) {
		dsbCardLayout.add(panel,name);
	}
	
	public void changeDs(String name) {
		cardLayout.show(dsbCardLayout, name);
	}
	
	public String getName() {
		return v.getName();
	}

}
