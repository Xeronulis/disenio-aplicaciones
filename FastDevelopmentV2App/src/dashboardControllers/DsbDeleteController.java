package dashboardControllers;

import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbShowView;

public class DsbDeleteController extends DsbBaseController {
	
	private DsbDeleteView  v;
	private DsbMainController dmc;
	
	public DsbDeleteController(DsbDeleteView v, DsbMainController dmc) {
		super(v, dmc);
		this.v = v;
		this.dmc = dmc;
		// TODO Auto-generated constructor stub
	}
	
	public DsbDeleteView getView(){
		return this.v;
	}
}
