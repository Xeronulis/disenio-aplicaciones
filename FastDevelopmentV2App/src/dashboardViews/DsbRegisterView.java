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
import customItems.CustomizeDs;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class DsbRegisterView extends DsbBaseCrudView {


	private CustomDsBtn commitBtn;
	private CustomDsLabel title;
	
	private JPanel titlePanel;
	private JPanel fieldsPanel;
	private JPanel fields;
	private JScrollPane scrollPane;

	
	public CustomDsBtn getCommitBtn() {
		return commitBtn;
	}

	public CustomDsLabel getTitle() {
		return title;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public JPanel getFieldsPanel() {
		return fieldsPanel;
	}

	public JPanel getFields() {
		return fields;
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
		
		
		scrollPane = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		
		scrollPane.setBorder(null);
		this.add(scrollPane, BorderLayout.CENTER);
		
		
		
		fieldsPanel = new JPanel();
		fieldsPanel.setBackground(getBackground());
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		scrollPane.setViewportView(fieldsPanel);
		
		
		
		
		fields = new JPanel();
		fields.setLayout(new MigLayout("", "[140][275.00,center][140]", "[][][][][][][][][][][]"));
		fields.setBackground(getBackground());
		fieldsPanel.add(fields);
		
		initLblTxtBtn();
		
		
	}

	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
	}
	private void initLblTxtBtn() {
		Color[] defaultColors = {ColorsUtils.COLORS.get("background"),
				ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("txtbackground")
				};
		
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
		fields.add(lbl5, "cell 0 4");
		fields.add(txt5, "cell 1 4");
		
		this.lbl6 = new CustomDsLabel();
		this.txt6 = new CustomDsTxtField();
		fields.add(lbl6, "cell 0 5");
		fields.add(txt6, "cell 1 5");
		
		this.lbl7 = new CustomDsLabel();
		this.txt7 = new CustomDsTxtField();
		fields.add(lbl7, "cell 0 6");
		fields.add(txt7, "cell 1 6");
		
		this.lbl8 = new CustomDsLabel();
		this.txt8 = new CustomDsTxtField();
		fields.add(lbl8, "cell 0 7");
		fields.add(txt8, "cell 1 7");
		
		this.lbl9 = new CustomDsLabel();
		this.txt9 = new CustomDsTxtField();
		fields.add(lbl9, "cell 0 8");
		fields.add(txt9, "cell 1 8");
				
		
		this.commitBtn = new CustomDsBtn("Ejecutar");
		commitBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		fields.add(commitBtn, "cell 1 9");
	}

}
