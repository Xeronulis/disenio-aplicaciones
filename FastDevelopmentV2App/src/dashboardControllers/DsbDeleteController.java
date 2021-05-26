package dashboardControllers;

import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbShowView;

public class DsbDeleteController {
	
	private DsbDeleteView  v;
	private DsbMainController dmc;
	

	public DsbDeleteView getView(){
		return this.v;
	}
}
