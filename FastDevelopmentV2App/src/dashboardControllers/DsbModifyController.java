package dashboardControllers;

import dashboardViews.DsbBaseView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;

public class DsbModifyController extends DsbBaseController {
	
	private DsbModifyView  v;
	private DsbMainController dmc;

	public DsbModifyController(DsbModifyView v, DsbMainController dmc) {
		super(v, dmc);
		this.v = v;
		this.dmc =dmc;
	}
	
	

}
