package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import customItems.CustomDsLabel;
import customItems.CustomizeDs;
import utils.ColorsUtils;
import utils.SizeUtils;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout.Alignment;

public class DsbShowView extends DsbBaseCrudView {

	private JPanel titlePanel;
	private CustomDsLabel title;
	private JScrollPane scrollPane;
	private JTable table;
	private Component negSpaceRight;
	private Component negSpaceLeft;
	private Component negSpaceTop;
	private Component negSpaceBottom;
	
	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public CustomDsLabel getTitle() {
		return title;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public Component getNegSpaceRight() {
		return negSpaceRight;
	}

	public Component getNegSpaceLeft() {
		return negSpaceLeft;
	}

	public Component getNegSpaceTop() {
		return negSpaceTop;
	}

	@SuppressWarnings("serial")
	public DsbShowView(DsbBaseView baseView, String name) {
		this.baseView = baseView;
		this.setBackground(getBackground());
		this.setName("show");
		this.setCustomStuff();
		setLayout(new BorderLayout(0, 0));
		
		titlePanel = new JPanel();
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		title = new CustomDsLabel();
		title.getLabel().setFont(new Font("Verdana", Font.PLAIN, 28));
		title.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		title.getLabel().setText("Mostrar "+name);
		titlePanel.add(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(getBackground());
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		negSpaceTop = Box.createVerticalStrut(20);
		panel.add(negSpaceTop, BorderLayout.NORTH);
		
		negSpaceRight = Box.createHorizontalStrut(20);
		panel.add(negSpaceRight, BorderLayout.EAST);
		
		negSpaceLeft = Box.createHorizontalStrut(20);
		panel.add(negSpaceLeft, BorderLayout.WEST);
		
		scrollPane = CustomizeDs.cutomizeScrollPane(new JScrollPane());
		
		
		negSpaceBottom = Box.createVerticalStrut(20);
		panel.add(negSpaceBottom, BorderLayout.SOUTH);
		panel.add(scrollPane);
		
		
		table = CustomizeDs.customizeJTable(new JTable());
		scrollPane.setViewportView(table);
		
		
		
		
	}

	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
				
	}
	
}
