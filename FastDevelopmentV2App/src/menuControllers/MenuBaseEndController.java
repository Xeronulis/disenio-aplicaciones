package menuControllers;

import dashboardControllers.DsbDeleteController;
import dashboardControllers.DsbModifyController;
import dashboardControllers.DsbRegisterController;
import dashboardControllers.DsbSearchController;
import dashboardControllers.DsbShowController;
import dashboardViews.DsbBaseDistView;
import dashboardViews.DsbBaseView;
import dashboardViews.DsbDeleteView;
import dashboardViews.DsbModifyView;
import dashboardViews.DsbRegisterView;
import dashboardViews.DsbSearchView;
import dashboardViews.DsbShowView;
import menuViews.MenuBaseView;

//Esta clase solo sera padre de las clases que tengan que abrir una DashBoardView
public class MenuBaseEndController extends MenuBaseController{

	protected DsbRegisterController childRegisterC;
	protected DsbModifyController childModifyC;
	protected DsbShowController childShowC;
	protected DsbSearchController childSearchC;
	protected DsbDeleteController childDeleteC;
	
	protected DsbRegisterView childRegisterV;
	protected DsbModifyView childModifyV;
	protected DsbShowView childShowV;
	protected DsbSearchView childSearchV;
	protected DsbDeleteView childDeleteV;
	
	
	public MenuBaseEndController(MenuBaseView v, MenuMainController mmc) {
		super(v,mmc);
		this.v = v;
		this.mmc = mmc;
	}
	
	public MenuBaseEndController(MenuBaseView v, MenuBaseController mbc) {
		super(v,mbc);
		this.v = v;
		this.mmc = mbc.getMenuMainController();

	}
		/*
	public void initDsbRegister(String name) {
		
	}
	
	public void initDsbModify(String name) {
		this.childModifyC = new DsbModifyController(this.childModifyV = new DsbModifyView(name),mmc.getDsbMainController());
	}
	
	public void initDsbShow(String name) {
		this.childShowC = new DsbShowController(this.childShowV = new DsbShowView(name),mmc.getDsbMainController());
	}
	
	public void initDsbSearch(String name) {
		this.childSearchC = new DsbSearchController(this.childSearchV = new DsbSearchView(name),mmc.getDsbMainController());
	}
	
	public void initDsbDelete(String name) {
		this.childDeleteC = new DsbDeleteController(this.childDeleteV = new DsbDeleteView(name),mmc.getDsbMainController());
	}
	*/
	
	public DsbRegisterController getChildRegisterC() {
		return childRegisterC;
	}
	public DsbModifyController getChildModifyC() {
		return childModifyC;
	}
	public DsbShowController getChildShowC() {
		return childShowC;
	}
	public DsbSearchController getChildSearchC() {
		return childSearchC;
	}
	public DsbDeleteController getChildDeleteC() {
		return childDeleteC;
	}
	public DsbRegisterView getChildRegisterV() {
		return childRegisterV;
	}
	public DsbModifyView getChildModifyV() {
		return childModifyV;
	}
	public DsbShowView getChildShowV() {
		return childShowV;
	}
	public DsbSearchView getChildSearchV() {
		return childSearchV;
	}
	public DsbDeleteView getChildDeleteV() {
		return childDeleteV;
	}
	

	
}
