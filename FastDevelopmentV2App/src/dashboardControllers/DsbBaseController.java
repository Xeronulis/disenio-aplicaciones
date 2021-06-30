package dashboardControllers;

import javax.swing.table.DefaultTableModel;

import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;

public abstract class DsbBaseController {

	
	protected DsbRegisterView registerView;
	protected DsbModifyView modifyView;
	protected DsbShowView showView;
	protected DsbSearchView searchView;
	protected DsbDeleteView deleteView;
	
	public DsbBaseController(DsbBaseView v) {
		
		
	}
	
	public abstract void changeView(String name);
	
	public abstract void addToLayout(DsbBaseCrudView v, String name);

	public abstract void initCustomLayout(DsbBaseCrudView crudView,String layout);
	
	
	protected abstract DefaultTableModel initTableModel(DefaultTableModel model );
	
}
