package dashboardControllers;

import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbMainView;

public class DsbBaseController {

	private DsbBaseCrudView v;
	private DsbMainController dmc;
	
	public DsbBaseController(DsbBaseCrudView v, DsbMainController dmc) {
		this.v = v;
		this.dmc = dmc;
		
	}
	
	public  void start(){
		dmc.addToLayout(v, v.getName());
	}
	
	public String getName() {
		return this.v.getName();
		
	}
	
	public void linkName(String name) {
		this.v.setName(name+v.getName());
	}
	
	public DsbBaseCrudView getView() {
		return this.v;
	}
	
}
