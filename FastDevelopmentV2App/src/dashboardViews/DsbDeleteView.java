package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import java.awt.FlowLayout;

public class DsbDeleteView extends DsbBaseCrudView {
	
	private CustomDsBtn commitBtn;
	private CustomDsBtn deleteBtn;

	private JLabel selectLbl;
	private JPanel fields;
	private JPanel fieldsPanel;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component verticalStrut;
	private JTable table;
	
	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public CustomDsBtn getCommitBtn() {
		return commitBtn;
	}

	public CustomDsBtn getDeleteBtn() {
		return deleteBtn;
	}



	public JLabel getSelectLbl() {
		return selectLbl;
	}


	public JPanel getFields() {
		return fields;
	}

	public JPanel getFieldsPanel() {
		return fieldsPanel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public Component getHorizontalStrut() {
		return horizontalStrut;
	}

	public Component getHorizontalStrut_1() {
		return horizontalStrut_1;
	}

	public Component getVerticalStrut() {
		return verticalStrut;
	}

	public JTable getTable() {
		return table;
	}

	/**
	 * Create the panel.
	 */
	
	public DsbDeleteView(DsbBaseView baseView, String name) {
		Color[] defaultColors = {ColorsUtils.COLORS.get("background"),
				ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("txtbackground")
				};
		
		this.setName("delete");
		
		this.setCustomStuff();
		
		this.baseView = baseView;
		
		setLayout(new BorderLayout(0, 0));

		
		titlePanel = new JPanel();
		titlePanel.setBackground(ColorsUtils.COLORS.get("background"));
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		title = CustomizeDs.customizeJLabel(new JLabel());
		title.setFont(new Font("Verdana", Font.PLAIN, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setText("Eliminar "+name);
		titlePanel.add(title);
		
		panel = new JPanel();
		panel.setBackground(getBackground());
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		fieldsPanel.setBackground(getBackground());
		fieldsPanel.setMaximumSize(SizeUtils.DASHBOARDCOMPACTSIZE);
		panel.add(fieldsPanel, BorderLayout.NORTH);
		
		fields = new JPanel();
		fieldsPanel.add(fields);
		fields.setBackground(getBackground());
		
		int pssz = SizeUtils.PANELSIDESZ;
		int pcsz = SizeUtils.PANELCENTERSZ;
		
		fields.setLayout(new MigLayout("",  "["+pssz+":"+pssz+",right]["+pcsz+":"+pcsz+",center]["+pssz+":"+pssz+",left]", "[][][][1:n]"));
		
		this.selectLbl = CustomizeDs.customizeJLabel(new JLabel());
		this.selectCbx = CustomizeDs.cutomizeJComboBox(new JComboBox<Object>());
		fields.add(selectLbl, "cell 0 0");
		fields.add(selectCbx, "cell 1 0");
		
		this.txt1 = CustomizeDs.customizeJTextField(new JTextField());
		this.lbl1 = CustomizeDs.customizeJLabel(new JLabel());
		fields.add(lbl1, "cell 0 1");
		fields.add(txt1, "cell 1 1");
		
		this.commitBtn = new CustomDsBtn("Buscar");
		commitBtn.getVerticalStrut().setVisible(false);
		commitBtn.setPreferredSize(new Dimension(100, 40));
		commitBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		
		fields.add(commitBtn, "cell 2 1");
		
		this.lbl2 = CustomizeDs.customizeJLabel(new JLabel());
		this.lbl3 = CustomizeDs.customizeJLabel(new JLabel());
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		this.deleteBtn = new CustomDsBtn("Eliminar");
		deleteBtn.getVerticalStrut().setVisible(false);
		deleteBtn.setPreferredSize(new Dimension(100, 40));
		deleteBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		
		fields.add(lbl2, "cell 0 2");
		fields.add(lbl3, "cell 1 2");
		fields.add(deleteBtn, "cell 2 2");
		
		
		this.warning1 = CustomizeDs.customizeWarningJLabel(new JLabel());
		warning1.setPreferredSize(new Dimension(SizeUtils.PANELCENTERSZ, 20));
		warning1.setHorizontalAlignment(SwingConstants.CENTER);
		fields.add(warning1,"cell 1 3");
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(getBackground());
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, BorderLayout.EAST);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, BorderLayout.WEST);
		
		verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut, BorderLayout.SOUTH);
		
		scrollPane = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		panel_1.add(scrollPane);
		
		
		table = CustomizeDs.customizeInitJTable(new JTable());
		scrollPane.setViewportView(table);
		
		
	}

	protected void setCustomStuff() {	
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
	}
	
	
}
