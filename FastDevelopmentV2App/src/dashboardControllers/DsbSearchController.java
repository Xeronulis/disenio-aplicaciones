package dashboardControllers;

import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;

public class DsbSearchController extends DsbBaseController {
	
	private DsbSearchView  v;
	private DsbMainController dmc;
	
	public DsbSearchController(DsbSearchView v, DsbMainController dmc){
		super(v,dmc);
		this.v = v;
		this.dmc = dmc;
		
	}
	
	
	
}
