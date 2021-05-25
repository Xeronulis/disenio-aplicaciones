package customItems;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseView;
import utils.ColorsUtils;
import utils.SizeUtils;

public interface CustomizeDs {

	
	@SuppressWarnings("serial")
	public static JTable customizeJTable(JTable table) {
		
		table.setShowHorizontalLines(false);
		table.setRowMargin(5);
		table.setRowHeight(30);
		table.setGridColor(ColorsUtils.COLORS.get("menuHide"));
		table.setSelectionBackground(ColorsUtils.COLORS.get("menuHide"));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		
		JTableHeader tableHeader = table.getTableHeader();
		
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setFont(new Font("Verdana", Font.PLAIN, 16));
		tableRenderer.setBorder(null);
		tableRenderer.setForeground(Color.WHITE);
		tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeader.setDefaultRenderer(tableRenderer);
		
		tableHeader.setReorderingAllowed(false);
		tableHeader.setPreferredSize(new Dimension(30,30));
		tableHeader.setBackground(ColorsUtils.COLORS.get("background"));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
		table.setBackground(ColorsUtils.COLORS.get("background"));
		
		return table;
		
	}


	public static JScrollPane cutomizeScrollPane(JScrollPane scrollPane) {
		Color background = ColorsUtils.COLORS.get("background");
		
		ScrollBarUI customUI = new CustomScrollBarUI();
		
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		scrollPane.setBackground(background);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setBackground(background);
		scrollPane.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
		scrollPane.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(background);
		scrollPane.getVerticalScrollBar().setUI(customUI);
		
		return scrollPane;
		
	}
	
	public class CustomScrollBarUI extends BasicScrollBarUI{
		
		Color background = ColorsUtils.COLORS.get("background");
		
		@Override
		protected void configureScrollBarColors(){
			
			this.thumbColor = ColorsUtils.COLORS.get("menuHide");
			this.trackColor = background;
			this.scrollbar.setBackground(trackColor);
		}
	    @Override
	    protected JButton createDecreaseButton(int orientation) {
	        JButton button = super.createDecreaseButton(orientation);
	        button.setBackground(background);
	        button.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
	        button.addMouseListener(new MouseAdapter() {
	        	private boolean isIn;
				@Override
				public void mousePressed(MouseEvent e) {
					button.setBackground(ColorsUtils.COLORS.get("itemPressed"));			
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if(isIn) {
						button.setBackground(ColorsUtils.COLORS.get("menuHide"));
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					isIn = true;
					button.setBackground(ColorsUtils.COLORS.get("menuHide"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					isIn = false;
					button.setBackground(ColorsUtils.COLORS.get("background"));
				}
	        	
	        });
	        return button;
	    }
	    
	    
	    @Override
	    protected JButton createIncreaseButton(int orientation) {
	        JButton button = super.createIncreaseButton(orientation);
	        button.setBackground(background);
	        button.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
	        button.addMouseListener(new MouseAdapter() {
	        	private boolean isIn;
				@Override
				public void mousePressed(MouseEvent e) {
					button.setBackground(ColorsUtils.COLORS.get("itemPressed"));			
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if(isIn) {
						button.setBackground(ColorsUtils.COLORS.get("menuHide"));
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					isIn = true;
					button.setBackground(ColorsUtils.COLORS.get("menuHide"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					isIn = false;
					button.setBackground(ColorsUtils.COLORS.get("background"));
				}
	        	
	        });
	        return button;
	    }
	}
}
