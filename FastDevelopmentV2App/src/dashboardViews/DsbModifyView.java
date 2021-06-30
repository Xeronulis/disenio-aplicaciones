package dashboardViews;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import customItems.CustomizeDs;
import net.miginfocom.swing.MigLayout;
import utils.ColorsUtils;
import utils.SizeUtils;

public class DsbModifyView extends DsbBaseCrudView {
	private CustomDsBtn commitBtn;
	
	private JLabel selectLbl;
	
	private JPanel fieldsPanel;
	private JPanel fields;
	private JScrollPane scrollPane;
	
	private JPanel cardPanel;
	private CardLayout cardLayout;
	
	
	@Override
	public JPanel getFieldsPanel() {
		return fieldsPanel;
	}
	
	@Override
	public JPanel getFields() {
		return fields;
	}
	
	@Override
	public CustomDsBtn getCommitBtn() {
		return commitBtn;
	}

	
	public JLabel getSelectLbl() {
		return selectLbl;
	}

	
	@Override
	public JPanel getCardPanel() {
		return cardPanel;
	}
	
	@Override
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	public DsbModifyView(DsbBaseView baseView,String name) {

		this.baseView = baseView;
		this.setName("modify");
		setLayout(new BorderLayout(0,0));
		this.setCustomStuff();
		
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		
		JPanel inCardPanel = new JPanel();
		cardPanel.add(inCardPanel, "main");
		inCardPanel.setLayout(new BorderLayout(0,0));
		this.add(cardPanel, BorderLayout.CENTER);
		
		titlePanel = new JPanel();
		titlePanel.setBackground(ColorsUtils.COLORS.get("background"));
		inCardPanel.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		this.title = CustomizeDs.customizeJLabel(new JLabel());
		title.setFont(new Font("Verdana", Font.PLAIN, 28));
		title.setText("Modificar "+name);;
		title.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(title);
		
		scrollPane = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		scrollPane.setBorder(null);
		inCardPanel.add(scrollPane, BorderLayout.CENTER);
		
		fieldsPanel = new JPanel();
		fieldsPanel.setBackground(getBackground());
		fieldsPanel.setMaximumSize(SizeUtils.DASHBOARDCOMPACTSIZE);
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		scrollPane.setViewportView(fieldsPanel);
		
		int pssz = SizeUtils.PANELSIDESZ;
		int pcsz = SizeUtils.PANELCENTERSZ;
		
		fields = new JPanel();
		fields.setLayout(new MigLayout("", "[175,right][287,center][175,left]", "[][][][][][][][][][][][][]"));
		fields.setBackground(getBackground());
		fieldsPanel.add(fields);
		
		initLblTxtBtn();
	}
	/**
	 * Create the panel.
	 */

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
		
		this.selectLbl = CustomizeDs.customizeJLabel(new JLabel());
		this.selectCbx = CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		selectCbx.setMaximumSize(new Dimension(selectCbx.getPreferredSize().width,55));
		JLabel fillEmptySpace = CustomizeDs.customizeWarningJLabel(new JLabel());
		fillEmptySpace.setVisible(false);
		fields.add(selectLbl, "cell 0 0");
		fields.add(selectCbx, "cell 1 0");
		fields.add(fillEmptySpace, "cell 2 0");
		
		this.lbl1 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt1 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning1 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn1 = new CustomDsBtn("Seleccionar");
		btn1.setPreferredSize(new Dimension(120,32));
		btn1.getVerticalStrut().setVisible(false);
		this.cbx1= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl1, "cell 0 1");
		fields.add(txt1, "cell 1 1");
		fields.add(warning1, "cell 2 1");
		
		this.lbl2 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt2 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning2 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn2 = new CustomDsBtn("Seleccionar");
		btn2.setPreferredSize(new Dimension(120,32));
		btn2.getVerticalStrut().setVisible(false);
		this.cbx2= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl2, "cell 0 2");
		fields.add(txt2, "cell 1 2");
		fields.add(warning2, "cell 2 2");
		
		this.lbl3 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt3 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning3 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn3 = new CustomDsBtn("Seleccionar");
		btn3.setPreferredSize(new Dimension(120,32));
		btn3.getVerticalStrut().setVisible(false);
		this.cbx3= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl3, "cell 0 3");
		fields.add(txt3, "cell 1 3");
		fields.add(warning3, "cell 2 3");
		
		this.lbl4 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt4 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning4 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn4 = new CustomDsBtn("Seleccionar");
		btn4.setPreferredSize(new Dimension(120,32));
		btn4.getVerticalStrut().setVisible(false);
		this.cbx4= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl4, "cell 0 4");
		fields.add(txt4, "cell 1 4");
		fields.add(warning4, "cell 2 4");
		
		this.lbl5 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt5 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning5 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn5 = new CustomDsBtn("Seleccionar");
		btn5.setPreferredSize(new Dimension(120,32));
		btn5.getVerticalStrut().setVisible(false);
		this.cbx5= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl5, "cell 0 5");
		fields.add(txt5, "cell 1 5");
		fields.add(warning5, "cell 2 5");
		
		this.lbl6 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt6 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning6 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn6 = new CustomDsBtn("Seleccionar");
		btn6.setPreferredSize(new Dimension(120,32));
		btn6.getVerticalStrut().setVisible(false);
		this.cbx6= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl6, "cell 0 6");
		fields.add(txt6, "cell 1 6");
		fields.add(warning6, "cell 2 6");
		
		this.lbl7 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt7 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning7 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn7 = new CustomDsBtn("Seleccionar");
		btn7.setPreferredSize(new Dimension(120,32));
		btn7.getVerticalStrut().setVisible(false);
		this.cbx7= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl7, "cell 0 7");
		fields.add(txt7, "cell 1 7");
		fields.add(warning7, "cell 2 7");
		
		this.lbl8 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt8 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning8 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn8 = new CustomDsBtn("Seleccionar");
		btn8.setPreferredSize(new Dimension(120,32));
		btn8.getVerticalStrut().setVisible(false);
		this.cbx8= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl8, "cell 0 8");
		fields.add(txt8, "cell 1 8");
		fields.add(warning8, "cell 2 8");
		
		this.lbl9 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt9 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning9 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn9 = new CustomDsBtn("Seleccionar");
		btn9.setPreferredSize(new Dimension(120,32));
		btn9.getVerticalStrut().setVisible(false);
		this.cbx9= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl9, "cell 0 9");
		fields.add(txt9, "cell 1 9");
		fields.add(warning9, "cell 2 9");
				
		this.lbl10 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt10 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning10 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn10 = new CustomDsBtn("Seleccionar");
		btn10.setPreferredSize(new Dimension(120,32));
		btn10.getVerticalStrut().setVisible(false);
		this.cbx10= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl10, "cell 0 10");
		fields.add(txt10, "cell 1 10");
		fields.add(warning10, "cell 2 10");
		
		this.lbl11 = CustomizeDs.customizeJLabel(new JLabel());
		this.txt11 = CustomizeDs.customizeJTextField(new JTextField());
		this.warning11 = CustomizeDs.customizeWarningJLabel(new JLabel());
		this.btn11 = new CustomDsBtn("Seleccionar");
		btn11.setPreferredSize(new Dimension(120,32));
		btn11.getVerticalStrut().setVisible(false);
		this.cbx11= CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(lbl11, "cell 0 11");
		fields.add(txt11, "cell 1 11");
		fields.add(warning11, "cell 2 11");
		
		
		this.commitBtn = new CustomDsBtn("Ejecutar");
		commitBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		fields.add(commitBtn, "cell 1 12");
	}

}
