package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomizeDs;
import net.miginfocom.swing.MigLayout;
import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class DsbDoubleTableView extends DsbBaseCrudView {

	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	
	private JPanel backPanel;
	private CustomDsBtn backBtn;
	
	private JTable tableA;
	private JTable tableB;
	
	private JLabel titleA;
	private JLabel titleB;
	
	private JPanel linkPanel;
	private CustomDsBtn linkBtnAtoB;
	private CustomDsBtn linkBtnBtoA;
	
	private JPanel titlePanel;
	private JLabel title;
	private JPanel migLayout;
	private Box verticalBox;
	private Component verticalStrut;
	private Component verticalStrut_1;
	
	public JScrollPane getScrollPaneA() {
		return scrollPaneA;
	}

	public JScrollPane getScrollPaneB() {
		return scrollPaneB;
	}

	public JPanel getBackPanel() {
		return backPanel;
	}

	public CustomDsBtn getBackBtn() {
		return backBtn;
	}

	public JTable getTableA() {
		return tableA;
	}

	public JTable getTableB() {
		return tableB;
	}

	public JLabel getTitleA() {
		return titleA;
	}

	public JLabel getTitleB() {
		return titleB;
	}

	public JPanel getLinkPanel() {
		return linkPanel;
	}

	public CustomDsBtn getLinkBtnAtoB() {
		return linkBtnAtoB;
	}

	public CustomDsBtn getLinkBtnBtoA() {
		return linkBtnBtoA;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public JLabel getTitle() {
		return title;
	}

	public JPanel getMigLayout() {
		return migLayout;
	}

	public Box getVerticalBox() {
		return verticalBox;
	}

	public Component getVerticalStrut() {
		return verticalStrut;
	}

	public Component getVerticalStrut_1() {
		return verticalStrut_1;
	}

	/**
	 * Create the panel.
	 */
	public DsbDoubleTableView(DsbBaseView baseView, String name, DsbBaseCrudView crudView) {
		
		
		this.baseView = baseView;
		this.setName("link"+crudView.getName()+name);
		setLayout(new BorderLayout(0,0));
		this.setCustomStuff();
		
		titlePanel = new JPanel();
		titlePanel.setBackground(ColorsUtils.COLORS.get("menuHide"));
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		this.title = CustomizeDs.customizeJLabel(new JLabel());
		title.setFont(new Font("Verdana", Font.PLAIN, 28));
		title.setText("Vincular "+name);
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
		backBtn.setPreferredSize(new Dimension(100,32));
		backBtn.deleteVertStrut();
		backPanel.add(backBtn);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(getBackground());
		panel2.setLayout(new BorderLayout(0,0));
		panel.add(panel2,BorderLayout.CENTER);
		
		
		migLayout = new JPanel();
		migLayout.setBackground(getBackground());
		panel2.add(migLayout, BorderLayout.CENTER);
		migLayout.setLayout(new MigLayout("", "[200,grow,center][36,center][200,grow,center]", "[center][350px,grow,fill]"));
		
		scrollPaneA = CustomizeDs.customizeScrollPane(new JScrollPane());
		migLayout.add(scrollPaneA, "cell 0 1,grow");
		
		titleA = CustomizeDs.customizeJLabel(new JLabel("Vinculados"));
		titleA.setHorizontalAlignment(JLabel.CENTER);
		titleB = CustomizeDs.customizeJLabel(new JLabel("Sin vincular"));
		titleB.setHorizontalAlignment(JLabel.CENTER);
		migLayout.add(titleA, "cell 0 0,grow");
		migLayout.add(titleB, "cell 2 0,grow");
		
		tableA = CustomizeDs.customizeInitJTable(new JTable());
		tableB = CustomizeDs.customizeInitJTable(new JTable());
		
		scrollPaneA.setViewportView(tableA);
		
		linkPanel = new JPanel();
		linkPanel.setPreferredSize(new Dimension(36, 10));
		linkPanel.setBackground(getBackground());
		linkPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		migLayout.add(linkPanel, "cell 1 1,growx,aligny top");
		
		verticalBox = Box.createVerticalBox();
		linkPanel.add(verticalBox);
		
		
		linkBtnAtoB = new CustomDsBtn();
		linkBtnAtoB.getBtnTxt().setIcon(new ImageIcon(DsbDoubleTableView.class.getResource("/icons/right_32px.png")));
		linkBtnAtoB.getPanel().setBorder(BorderFactory.createEmptyBorder());
		linkBtnAtoB.setPreferredSize(new Dimension(36,36));
		linkBtnAtoB.getBtnTxt().setText("");
		linkBtnAtoB.deleteVertStrut();
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 50));
		verticalBox.add(verticalStrut_1);
		
		verticalBox.add(linkBtnAtoB);
		
		linkBtnBtoA = new CustomDsBtn();
		linkBtnBtoA.getBtnTxt().setIcon(new ImageIcon(DsbDoubleTableView.class.getResource("/icons/left_32px.png")));
		linkBtnBtoA.getPanel().setBorder(BorderFactory.createEmptyBorder());
		linkBtnBtoA.setPreferredSize(new Dimension(36,36));
		linkBtnBtoA.getBtnTxt().setText("");
		linkBtnBtoA.deleteVertStrut();
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 10));
		verticalStrut.setMinimumSize(new Dimension(0, 10));
		verticalBox.add(verticalStrut);
		
		verticalBox.add(linkBtnBtoA);
		
		
		
		scrollPaneB = CustomizeDs.customizeScrollPane(new JScrollPane());
		migLayout.add(scrollPaneB, "cell 2 1,grow");
		
		scrollPaneB.setViewportView(tableB);
		
		
		
		
		/*
		titlePanel = new JPanel();
		titlePanel.setBackground(ColorsUtils.COLORS.get("background"));
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		this.title = CustomizeDs.customizeJLabel(new JLabel());
		title.setFont(new Font("Verdana", Font.PLAIN, 28));
		title.setText("Vincular "+name);;
		title.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(title);
		
		
		linkBtnPanel = new JPanel();
		linkBtnPanel.setLayout(new BorderLayout(0,0));
		add(linkBtnPanel, BorderLayout.CENTER);
		
		linkBtn = new CustomDsBtn();
		linkBtn.getVerticalStrut().setVisible(false);
		linkBtnPanel.add(linkBtn,BorderLayout.CENTER);
		
		verticalGlue = Box.createVerticalGlue();
		linkBtnPanel.add(verticalGlue, BorderLayout.NORTH);
		
		verticalGlue_1 = Box.createVerticalGlue();
		linkBtnPanel.add(verticalGlue_1, BorderLayout.SOUTH);
		
		
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

	@Override
	public Object getCommitBtn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getFieldsPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCardPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCardLayout() {
		// TODO Auto-generated method stub
		return null;
	}
}
