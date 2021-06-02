package dashboardViews;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customItems.CustomDsBtn;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import customItems.CustomizeDs;
import utils.ColorsUtils;
import utils.SizeUtils;

public class DsbBaseCrudView extends JPanel {

	protected DsbBaseView baseView;
	
	
	protected JPanel titlePanel;
	protected JLabel title;
	
	
	protected JComboBox<Object> selectCbx;
	
	protected JComboBox<Object> cbx1;
	protected JComboBox<Object> cbx2;
	protected JComboBox<Object> cbx3;
	protected JComboBox<Object> cbx4;
	protected JComboBox<Object> cbx5;
	protected JComboBox<Object> cbx6;
	protected JComboBox<Object> cbx7;
	protected JComboBox<Object> cbx8;
	protected JComboBox<Object> cbx9;
	protected JComboBox<Object> cbx10;
	protected JComboBox<Object> cbx11;
	
	
	protected CustomDsBtn  btn1;
	protected CustomDsBtn  btn2;
	protected CustomDsBtn  btn3;
	protected CustomDsBtn  btn4;
	protected CustomDsBtn  btn5;
	protected CustomDsBtn  btn6;
	protected CustomDsBtn  btn7;
	protected CustomDsBtn  btn8;
	protected CustomDsBtn  btn9;
	protected CustomDsBtn  btn10;
	protected CustomDsBtn  btn11;
	
	
	protected JLabel lbl1;
	protected JLabel lbl2;
	protected JLabel lbl3;
	protected JLabel lbl4;
	protected JLabel lbl5;
	protected JLabel lbl6;
	protected JLabel lbl7;
	protected JLabel lbl8;
	protected JLabel lbl9;
	protected JLabel lbl10;
	protected JLabel lbl11;
	
	protected JTextField txt1;
	protected JTextField txt2;
	protected JTextField txt3;
	protected JTextField txt4;
	protected JTextField txt5;
	protected JTextField txt6;
	protected JTextField txt7;
	protected JTextField txt8;
	protected JTextField txt9;
	protected JTextField txt10;
	protected JTextField txt11;
	
	protected JLabel warning1;
	protected JLabel warning2;
	protected JLabel warning3;
	protected JLabel warning4;
	protected JLabel warning5;
	protected JLabel warning6;
	protected JLabel warning7;
	protected JLabel warning8;
	protected JLabel warning9;
	protected JLabel warning10;
	protected JLabel warning11;
	
	
	
	//se obtienen todos los JComboBox con numeros en su nombre de variable
  	public List<JComboBox<Object>> getAllCbx(){
  		List<JComboBox<Object>> cbxs = new ArrayList<JComboBox<Object>>();
  		
  		cbxs.add(cbx1);
  		cbxs.add(cbx2);
  		cbxs.add(cbx3);
  		cbxs.add(cbx4);
  		cbxs.add(cbx5);
  		cbxs.add(cbx6);
  		cbxs.add(cbx7);
  		cbxs.add(cbx8);
  		cbxs.add(cbx9);
  		cbxs.add(cbx10);
  		cbxs.add(cbx11);
  		
  		return cbxs;
  		
  	}
	
	public List<JTextField> getAllTxt(){
		List<JTextField> txts = new ArrayList<JTextField>();
		
		txts.add(txt1);
		txts.add(txt2);
		txts.add(txt3);
		txts.add(txt4);
		txts.add(txt5);
		txts.add(txt6);
		txts.add(txt7);
		txts.add(txt8);
		txts.add(txt9);
		txts.add(txt10);
		txts.add(txt11);
		
		return txts;
	}
	
	public List<JLabel> getAllLabels(){
		List<JLabel> labels= new ArrayList<JLabel>();
		
		labels.add(lbl1);
		labels.add(lbl2);
		labels.add(lbl3);
		labels.add(lbl4);
		labels.add(lbl5);
		labels.add(lbl6);
		labels.add(lbl7);
		labels.add(lbl8);
		labels.add(lbl9);
		labels.add(lbl10);
		labels.add(lbl11);
		
		return labels;
		
	}
	
	public List<JLabel> getAllWarnLabels(){
		List<JLabel> labels = new ArrayList<JLabel>();
		
		labels.add(warning1);
		labels.add(warning2);
		labels.add(warning3);
		labels.add(warning4);
		labels.add(warning5);
		labels.add(warning6);
		labels.add(warning7);
		labels.add(warning8);
		labels.add(warning9);
		labels.add(warning10);
		labels.add(warning11);
		
		return labels;
		
	}
	
	public DsbBaseView getBaseView() {
		return baseView;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public JLabel getTitle() {
		return title;
	}

	public JComboBox<Object> getSelectCbx() {
		return selectCbx;
	}

	public JComboBox<Object> getCbx1() {
		return cbx1;
	}

	public JComboBox<Object> getCbx2() {
		return cbx2;
	}

	public JComboBox<Object> getCbx3() {
		return cbx3;
	}

	public JComboBox<Object> getCbx4() {
		return cbx4;
	}

	public JComboBox<Object> getCbx5() {
		return cbx5;
	}

	public JComboBox<Object> getCbx6() {
		return cbx6;
	}

	public JComboBox<Object> getCbx7() {
		return cbx7;
	}

	public JComboBox<Object> getCbx8() {
		return cbx8;
	}

	public JComboBox<Object> getCbx9() {
		return cbx9;
	}

	public JComboBox<Object> getCbx10() {
		return cbx10;
	}
	
	public JComboBox<Object> getCbx11(){
		return cbx11;
	}

	public CustomDsBtn getBtn1() {
		return btn1;
	}

	public CustomDsBtn getBtn2() {
		return btn2;
	}

	public CustomDsBtn getBtn3() {
		return btn3;
	}

	public CustomDsBtn getBtn4() {
		return btn4;
	}

	public CustomDsBtn getBtn5() {
		return btn5;
	}

	public CustomDsBtn getBtn6() {
		return btn6;
	}

	public CustomDsBtn getBtn7() {
		return btn7;
	}

	public CustomDsBtn getBtn8() {
		return btn8;
	}

	public CustomDsBtn getBtn9() {
		return btn9;
	}

	public CustomDsBtn getBtn10() {
		return btn10;
	}
	
	public CustomDsBtn getBtn11() {
		return btn11;
	}

	public JLabel getLbl1() {
		return lbl1;
	}

	public JLabel getLbl2() {
		return lbl2;
	}

	public JLabel getLbl3() {
		return lbl3;
	}

	public JLabel getLbl4() {
		return lbl4;
	}

	public JLabel getLbl5() {
		return lbl5;
	}

	public JLabel getLbl6() {
		return lbl6;
	}

	public JLabel getLbl7() {
		return lbl7;
	}

	public JLabel getLbl8() {
		return lbl8;
	}

	public JLabel getLbl9() {
		return lbl9;
	}

	public JLabel getLbl10() {
		return lbl10;
	}
	
	public JLabel getLbl11() {
		return lbl11;
	}

	public JTextField getTxt1() {
		return txt1;
	}

	public JTextField getTxt2() {
		return txt2;
	}

	public JTextField getTxt3() {
		return txt3;
	}

	public JTextField getTxt4() {
		return txt4;
	}

	public JTextField getTxt5() {
		return txt5;
	}

	public JTextField getTxt6() {
		return txt6;
	}

	public JTextField getTxt7() {
		return txt7;
	}

	public JTextField getTxt8() {
		return txt8;
	}

	public JTextField getTxt9() {
		return txt9;
	}

	public JTextField getTxt10() {
		return txt10;
	}
	
	public JTextField getTxt11() {
		return txt11;
	}

	public JLabel getWarning1() {
		return warning1;
	}

	public JLabel getWarning2() {
		return warning2;
	}

	public JLabel getWarning3() {
		return warning3;
	}

	public JLabel getWarning4() {
		return warning4;
	}

	public JLabel getWarning5() {
		return warning5;
	}

	public JLabel getWarning6() {
		return warning6;
	}

	public JLabel getWarning7() {
		return warning7;
	}

	public JLabel getWarning8() {
		return warning8;
	}

	public JLabel getWarning9() {
		return warning9;
	}

	public JLabel getWarning10() {
		return warning10;
	}
	
	public JLabel getWarning11() {
		return warning11;
	}

	public DsbBaseCrudView() {

	}
	
	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
	}

}
