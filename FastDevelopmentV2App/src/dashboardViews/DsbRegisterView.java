package dashboardViews;

import javax.swing.JPanel;

import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import customItems.CustomMenuBtn;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class DsbRegisterView extends DsbBaseCrudView {


	private CustomDsBtn commitBtn;
	private CustomDsLabel title;
	
	private CustomDsTxtField txt1;
	private CustomDsTxtField txt2;
	private CustomDsTxtField txt3;
	private CustomDsTxtField txt4;
	
	private CustomDsLabel lbl1;
	private CustomDsLabel lbl2;
	private CustomDsLabel lbl3;
	private CustomDsLabel lbl4;
	
	private CustomDsTxtField txt5;
	private CustomDsLabel lbl5;
	
	private JPanel titlePanel;
	private JPanel fieldsPanel;
	private JPanel fields;
	
	
	public CustomDsBtn getCommitBtn() {
		return commitBtn;
	}
	public CustomDsLabel getTitle() {
		return title;
	}
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
	public CustomDsTxtField getTxt5() {
		return txt5;
	}
	public CustomDsLabel getLbl5() {
		return lbl5;
	}
	
	
	
	public DsbRegisterView(DsbBaseView baseView,String name) {
		Color[] defaultColors = {ColorsUtils.COLORS.get("background"),
				ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("txtbackground")
				};
		
		this.baseView = baseView;
		
		this.setName("register");
		this.setLayout(new BorderLayout(0,0));
		this.setCustomStuff();

		
		titlePanel = new JPanel();
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		title = new CustomDsLabel();
		title.getLabel().setFont(new Font("Verdana", Font.PLAIN, 28));
		title.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		title.getLabel().setText("Registrar "+name);
		titlePanel.add(title);
		
		
		fieldsPanel = new JPanel();
		fieldsPanel.setBackground(getBackground());
		this.add(fieldsPanel, BorderLayout.CENTER);
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		fields = new JPanel();
		fields.setLayout(new MigLayout("", "[140][275.00,center][140]", "[][][][][][][]"));
		fields.setBackground(getBackground());
		fieldsPanel.add(fields);
		
		this.lbl1 = new CustomDsLabel();
		this.txt1 = new CustomDsTxtField();
		fields.add(lbl1, "cell 0 0");
		fields.add(txt1, "cell 1 0");
		
		this.lbl2 = new CustomDsLabel();
		this.txt2 = new CustomDsTxtField();
		fields.add(lbl2, "cell 0 1");
		fields.add(txt2, "cell 1 1,aligny center");
		
		this.lbl3 = new CustomDsLabel();
		this.txt3 = new CustomDsTxtField();
		fields.add(lbl3, "cell 0 2");
		fields.add(txt3, "cell 1 2");
		
		this.lbl4 = new CustomDsLabel();
		this.txt4 = new CustomDsTxtField();
		fields.add(lbl4, "cell 0 3");
		fields.add(txt4, "cell 1 3");
		
		this.lbl5 = new CustomDsLabel();
		this.txt5 = new CustomDsTxtField();
		this.txt5.getTxt().setEditable(false);
		fields.add(lbl5, "cell 0 4");
		fields.add(txt5, "cell 1 4");
		
		this.commitBtn = new CustomDsBtn("Ejecutar");
		commitBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		fields.add(commitBtn, "cell 1 5");
		
		
	}

	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
	}

}
