package dashboardViews;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import utils.ColorsUtils;
import utils.SizeUtils;

public class DsbBaseCrudView extends JPanel {

	protected CustomDsTxtField txt1;
	protected CustomDsTxtField txt2;
	protected CustomDsTxtField txt3;
	protected CustomDsTxtField txt4;
	protected CustomDsTxtField txt5;
	protected CustomDsTxtField txt6;
	protected CustomDsTxtField txt7;
	protected CustomDsTxtField txt8;
	protected CustomDsTxtField txt9;
	protected CustomDsTxtField txt10;
	
	protected CustomDsLabel lbl1;
	protected CustomDsLabel lbl2;
	protected CustomDsLabel lbl3;
	protected CustomDsLabel lbl4;
	protected CustomDsLabel lbl5;
	protected CustomDsLabel lbl6;
	protected CustomDsLabel lbl7;
	protected CustomDsLabel lbl8;
	protected CustomDsLabel lbl9;
	protected CustomDsLabel lbl10;
	
	
	protected DsbBaseView baseView;
	
	public CustomDsTxtField getTxt1() {
		return txt1;
	}

	public CustomDsTxtField getTxt2() {
		return txt2;
	}

	public CustomDsTxtField getTxt3() {
		return txt3;
	}

	public CustomDsTxtField getTxt4() {
		return txt4;
	}

	public CustomDsTxtField getTxt5() {
		return txt5;
	}

	public CustomDsTxtField getTxt6() {
		return txt6;
	}

	public CustomDsTxtField getTxt7() {
		return txt7;
	}

	public CustomDsTxtField getTxt8() {
		return txt8;
	}

	public CustomDsTxtField getTxt9() {
		return txt9;
	}

	public CustomDsTxtField getTxt10() {
		return txt10;
	}

	public CustomDsLabel getLbl1() {
		return lbl1;
	}

	public CustomDsLabel getLbl2() {
		return lbl2;
	}

	public CustomDsLabel getLbl3() {
		return lbl3;
	}

	public CustomDsLabel getLbl4() {
		return lbl4;
	}

	public CustomDsLabel getLbl5() {
		return lbl5;
	}

	public CustomDsLabel getLbl6() {
		return lbl6;
	}

	public CustomDsLabel getLbl7() {
		return lbl7;
	}

	public CustomDsLabel getLbl8() {
		return lbl8;
	}

	public CustomDsLabel getLbl9() {
		return lbl9;
	}

	public CustomDsLabel getLbl10() {
		return lbl10;
	}

	public DsbBaseView getBaseView() {
		return baseView;
	}

	/**
	 * Create the panel.
	 */
	public DsbBaseCrudView() {

	}
	
	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
	}

}
