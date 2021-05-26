package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomizeDs;
import customItems.CustomDsTxtField;
import utils.ColorsUtils;
import utils.SizeUtils;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;

public class DsbSearchView extends DsbBaseCrudView {
	
	private JPanel titlePanel;
	private CustomDsBtn commitBtn;
	private CustomDsLabel title;
	
	private CustomDsTxtField txt1;
	
	
	private CustomDsLabel lbl1;
	
	
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
	public DsbSearchView(DsbBaseView baseView, String name) {
		Color[] defaultColors = {ColorsUtils.COLORS.get("background"),
				ColorsUtils.COLORS.get("menuHide"),
				ColorsUtils.COLORS.get("txtbackground")
				};
		
		this.setName("search");
		
		this.setCustomStuff();
		
		this.baseView = baseView;
		
		setLayout(new BorderLayout(0, 0));

		
		titlePanel = new JPanel();
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		title = new CustomDsLabel();
		title.getLabel().setFont(new Font("Verdana", Font.PLAIN, 28));
		title.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		title.getLabel().setText("Buscar "+name);
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
		fields.setLayout(new MigLayout("", "[140][275.00,center][140,center]", "[][]"));
		
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
