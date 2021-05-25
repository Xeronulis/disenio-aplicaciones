package menuControllers;

import menuViews.MenuBaseView;

//clase padre (de forma directa o indirecta) de todos los MenuController exceptuando MenuMainController
public class MenuBaseController{

	
	protected MenuBaseView v;
	protected MenuMainController mmc;
	
	public MenuBaseController(MenuBaseView v, MenuMainController mmc) {
		this.v = v;
		this.mmc = mmc;
	}
	
	public MenuBaseController(MenuBaseView v, MenuBaseController mbc) {
		this.v = v;
		this.mmc = mbc.getMenuMainController();
		
	}
		

	public MenuMainController getMenuMainController() {
		return this.mmc;
	}
	
	public String getName() {
		return v.getName();
	}
	

	

	
}
