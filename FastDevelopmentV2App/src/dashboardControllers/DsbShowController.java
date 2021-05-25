package dashboardControllers;

import dashboardViews.DsbRegisterView;
import dashboardViews.DsbShowView;

public class DsbShowController extends DsbBaseController{
	
	private DsbShowView  v;
	private DsbMainController dmc;
	
	public DsbShowController(DsbShowView v, DsbMainController dmc){
		super(v,dmc);
		this.v = v;
		this.dmc = dmc;
		
	}
	

	
	
}
