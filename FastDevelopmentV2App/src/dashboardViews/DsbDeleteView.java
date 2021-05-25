package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import customItems.CustomizeDs;
import net.miginfocom.swing.MigLayout;
import utils.ColorsUtils;
import utils.SizeUtils;

public class DsbDeleteView extends DsbBaseCrudView {
	
	private JPanel titlePanel;
	private CustomDsBtn commitBtn;
	private CustomDsBtn deleteBtn;
	private CustomDsLabel title;
	
	private CustomDsTxtField txt1;
	
	private CustomDsLabel lbl1;
	private CustomDsLabel lbl2;
	private CustomDsLabel lbl3;
	
	private CustomDsLabel selectLbl;
	private CustomDsCbx selectCbx;
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

	public CustomDsLabel getTitle() {
		return title;
	}

	public CustomDsTxtField getTxt1() {
		return txt1;
	}

	public CustomDsLabel getLbl1() {
		return lbl1;
	}

	public CustomDsLabel getSelectLbl() {
		return selectLbl;
	}

	public CustomDsCbx getSelectCbx() {
		return selectCbx;
	}

	public JPanel getFields() {
		return fields;
	}

	public JPanel getFieldsPanel() {
		return fieldsPanel;
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
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		title = new CustomDsLabel();
		title.getLabel().setFont(new Font("Verdana", Font.PLAIN, 28));
		title.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		title.getLabel().setText("Eliminar "+name);
		titlePanel.add(title);
		
		panel = new JPanel();
		panel.setBackground(getBackground());
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 20));
		
		fieldsPanel = new JPanel();
		fieldsPanel.setBackground(getBackground());
		panel.add(fieldsPanel, BorderLayout.NORTH);
		
		fields = new JPanel();
		fieldsPanel.add(fields);
		fields.setBackground(getBackground());
		fields.setLayout(new MigLayout("", "[140][275.00,center][140,center]", "[][][]"));
		
		this.selectLbl = new CustomDsLabel();
		this.selectCbx = new CustomDsCbx();
		fields.add(selectLbl, "cell 0 0");
		fields.add(selectCbx, "cell 1 0");
		
		this.txt1 = new CustomDsTxtField();
		this.lbl1 = new CustomDsLabel();
		fields.add(lbl1, "cell 0 1");
		fields.add(txt1, "cell 1 1");
		
		this.commitBtn = new CustomDsBtn("Buscar");
		//commitBtn.getPanel().remove(commitBtn.getVerticalStrut());
		commitBtn.getVerticalStrut().setVisible(false);
		commitBtn.setPreferredSize(new Dimension(100, 40));
		commitBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		
		fields.add(commitBtn, "cell 2 1");
		
		this.lbl2 = new CustomDsLabel();
		this.lbl3 = new CustomDsLabel();
		lbl3.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.deleteBtn = new CustomDsBtn("Eliminar");
		deleteBtn.getVerticalStrut().setVisible(false);
		deleteBtn.setPreferredSize(new Dimension(100, 40));
		deleteBtn.setAllColors(defaultColors[0], defaultColors[1], defaultColors[2]);
		
		fields.add(lbl2, "cell 0 2");
		fields.add(lbl3, "cell 1 2");
		fields.add(deleteBtn, "cell 2 2");
		
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
		
		
		table = CustomizeDs.customizeJTable(new JTable());
		scrollPane.setViewportView(table);
		
		
	}

	protected void setCustomStuff() {	
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
	}
}
