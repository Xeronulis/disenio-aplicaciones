package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomizeDs;
import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

public class DsbDoubleTableView2 extends DsbBaseCrudView {
	
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	
	private JPanel backPanel;
	private CustomDsBtn backBtn;
	
	private JTable tableA;
	private JTable tableB;
	
	private JPanel panelA;
	private JPanel panelB;
	
	private JPanel titlePanelA;
	private JPanel titlePanelB;
	
	private JLabel titleA;
	private JLabel titleB;
	
	private JPanel linkPanel;
	private CustomDsBtn linkBtn;
	
	private JPanel titlePanel;
	private JLabel title;
	private JPanel migLayout;
	
	/**
	 * Create the panel.
	 */
	public DsbDoubleTableView2(DsbBaseView baseView, String name, DsbBaseCrudView crudView) {
		
		
		this.baseView = baseView;
		this.setName("link"+crudView.getName()+name);
		setLayout(new BorderLayout(0,0));
		this.setCustomStuff();
		
		titlePanel = new JPanel();
		titlePanel.setBackground(ColorsUtils.COLORS.get("background"));
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		this.title = CustomizeDs.customizeJLabel(new JLabel());
		title.setFont(new Font("Verdana", Font.PLAIN, 28));
		title.setText("Vincular "+name);;
		title.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		backPanel = new JPanel();
		backPanel.setBackground(getBackground());
		panel.add(backPanel, BorderLayout.NORTH);
		
		backBtn = new CustomDsBtn("volver");
		backBtn.deleteVertStrut();
		backPanel.add(backBtn);
		
		migLayout = new JPanel();
		migLayout.setBackground(getBackground());
		panel.add(migLayout, BorderLayout.CENTER);
		migLayout.setLayout(new MigLayout("", "[200,grow][80,center][200,grow]", "[472px,grow]"));
		
		scrollPaneA = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		migLayout.add(scrollPaneA, "cell 0 0,grow");
		
		tableA = CustomizeDs.customizeInitJTable(new JTable());
		tableB = CustomizeDs.customizeInitJTable(new JTable());
		
		scrollPaneA.setViewportView(tableA);
		
		linkPanel = new JPanel();
		linkPanel.setBackground(getBackground());
		migLayout.add(linkPanel, "cell 1 0,grow");
		GridBagLayout gbl_linkPanel = new GridBagLayout();
		gbl_linkPanel.columnWidths = new int[]{80, 0};
		gbl_linkPanel.rowHeights = new int[]{458, 0};
		gbl_linkPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_linkPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		linkPanel.setLayout(gbl_linkPanel);
		
		linkBtn = new CustomDsBtn("soy un boton jaja");
		linkBtn.deleteVertStrut();
		
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		linkPanel.add(linkBtn, gbc_panel_6);
		
		scrollPaneB = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		migLayout.add(scrollPaneB, "cell 2 0,grow");
		
		scrollPaneB.setViewportView(tableB);
		
		/*
		panelA = new JPanel();
		panelA.setLayout(new BorderLayout(0,0));
		this.add(panelA, BorderLayout.WEST);
		
		titlePanelA = new JPanel();
		titlePanelA.setLayout(new BorderLayout(0,0));
		titlePanelA.setBackground(getBackground());
		panelA.add(titlePanelA, BorderLayout.NORTH);
		
		titleA = CustomizeDs.customizeJLabel(new JLabel());
		titlePanelA.add(titleA);
		
		scrollPaneA = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		panelA.add(scrollPaneA, BorderLayout.CENTER);
		scrollPaneA.setBackground(getBackground());
		
		tableA = CustomizeDs.customizeInitJTable(new JTable());
		scrollPaneA.setViewportView(tableA);
		
		
		panelB = new JPanel();
		panelB.setLayout(new BorderLayout(0,0));
		this.add(panelB, BorderLayout.EAST);
		
		titlePanelB = new JPanel();
		titlePanelB.setLayout(new BorderLayout(0,0));
		titlePanelB.setBackground(getBackground());
		panelB.add(titlePanelB, BorderLayout.NORTH);
		
		titleB = CustomizeDs.customizeJLabel(new JLabel());
		titlePanelB.add(titleB);
		
		scrollPaneB = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		panelB.add(scrollPaneB, BorderLayout.CENTER);
		scrollPaneB.setBackground(getBackground());
		
		tableB = CustomizeDs.customizeInitJTable(new JTable());
		scrollPaneB.setViewportView(tableB);
		*/
		
		
	}

	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
	}
}
