package start;

import controllers.MainController;
import views.MainView;

public class Start {

	private static MainView mainView = new MainView();
	private static MainController ctrl = new MainController(mainView);
	
	public static MainView getMainView() {
		return mainView;
	}
	
	public static MainController getMainController() {
		return ctrl;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ctrl.start();
		
		
	}

}
