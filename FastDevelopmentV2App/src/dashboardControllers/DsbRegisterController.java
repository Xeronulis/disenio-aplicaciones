package dashboardControllers;

import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbRegisterView;

public class DsbRegisterController extends DsbBaseController {
	
	private DsbBaseCrudView  v;
	private DsbMainController dmc;
	
	public DsbRegisterController(DsbBaseCrudView v, DsbMainController dmc) {
		super(v, dmc);
		this.v = v;
		this.dmc = dmc;
	}
	
	

	
	
}
