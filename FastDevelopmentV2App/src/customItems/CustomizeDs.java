package customItems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.PopupMenuUI;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dashboardViews.DsbBaseCrudView;
import dashboardViews.DsbBaseView;
import menuViews.MenuDistView;
import utils.ColorsUtils;
import utils.SizeUtils;

public class CustomizeDs {

	static CustomizeDs instance = new CustomizeDs();
	
	
	//funcion para crear el JLabel de advertencia
	public static JLabel customizeWarningJLabel(JLabel label) {
		
		label.setPreferredSize(new Dimension(SizeUtils.PANELSIDESZ, 32));
		
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setIcon(new ImageIcon(CustomizeDs.class.getResource("/icons/warning_32px.png")));
		
		return label;
	}
	
	
	//funcion para crear un JComboBox customizado
	public static JComboBox<Object> cutomizeJComboBox(JComboBox<Object> cbx) {
		
		cbx.setPreferredSize(new Dimension((int) (SizeUtils.PANELCENTERSZ*0.85), 16));
		
		cbx.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
		cbx.setFont(new Font("Verdana", Font.PLAIN, 16));
		cbx.setForeground(Color.WHITE);
		cbx.setBackground(ColorsUtils.COLORS.get("txtbackground"));
		
		cbx.setUI(new BasicComboBoxUI() {
			@Override
            protected JButton createArrowButton() {
            	JButton button = new BasicArrowButton(BasicArrowButton.SOUTH,
                        ColorsUtils.COLORS.get("menuHide"),
                        ColorsUtils.COLORS.get("menuHide"),
                        ColorsUtils.COLORS.get("background"),
                        ColorsUtils.COLORS.get("menuHide"));
            	button.setName("ComboBox.arrowButton");
            	return button;
            }
			
			@SuppressWarnings("serial")
			@Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        scroller.getVerticalScrollBar().setUI(instance.new CustomScrollBarUI() {
                         
                           
                        });
                        return scroller;
                    }
                    
                };
            }
		});
		
		
		
		Object child = cbx.getAccessibleContext().getAccessibleChild(0);
		ComboPopup popup = (ComboPopup)child;
		JList<Object> list = popup.getList();
		
		list.setSelectionBackground(ColorsUtils.COLORS.get("menuHide"));
		list.setSelectionForeground(Color.WHITE);
		
		return cbx;
		
	}
	
	//funcion para crear un JLabel customizado
	public static JLabel customizeJLabel(JLabel label) {
		
		label.setPreferredSize(new Dimension(SizeUtils.PANELSIDESZ, 55));
		
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		
		return label;
		
	}
	
	//funcion para crear JTextField customizado
	public static JTextField customizeJTextField(JTextField txt) {
		
		txt.setBorder(new LineBorder(ColorsUtils.COLORS.get("menuHide")));
		txt.setForeground(Color.WHITE);
		txt.setText("");
		txt.setFont(new Font("Verdana", Font.PLAIN, 16));
		txt.setBackground(ColorsUtils.COLORS.get("txtbackground"));
		txt.setPreferredSize(new Dimension((int) (SizeUtils.PANELCENTERSZ*0.85), 20));
		
		return txt;
		
	}
	
	
	//funcion para customizar una JTable ya creada
	public static JTable customizeJTable(JTable table) {
	
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		for(int i=0; i<tmodel.getColumnCount();++i) {
			table.getColumnModel().getColumn(i).setPreferredWidth(tmodel.getColumnName(i).length()*3);;
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		
		return table;
		
	}
	
	
	//funcion para inicializar la JTable base
	@SuppressWarnings("serial")
	public static JTable customizeInitJTable(JTable table) {
		
		table.setShowHorizontalLines(false);
		table.setRowMargin(5);
		table.setRowHeight(30);
		table.setGridColor(ColorsUtils.COLORS.get("menuHide"));
		table.setSelectionBackground(ColorsUtils.COLORS.get("menuHide"));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},

			},
			new String[] {
				"Sample column", "Sample column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		
		
		
		JTableHeader tableHeader = table.getTableHeader();
		
		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setFont(new Font("Verdana", Font.PLAIN, 16));
		tableRenderer.setBorder(null);
		tableRenderer.setForeground(Color.WHITE);
		tableRenderer.setBackground(ColorsUtils.COLORS.get("background"));
		tableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeader.setDefaultRenderer(tableRenderer);
		
		tableHeader.setReorderingAllowed(false);
		tableHeader.setPreferredSize(new Dimension(30,30));
		tableHeader.setBackground(ColorsUtils.COLORS.get("background"));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
		table.setBackground(ColorsUtils.COLORS.get("background"));
		table.setDefaultRenderer(Object.class, tableRenderer);
		table.setSelectionForeground(Color.WHITE);
		
		return table;
		
	}


	//funcion para inicializar un ScrollPane
	public static JScrollPane cutomizeScrollPane(JScrollPane scrollPane) {
		Color background = ColorsUtils.COLORS.get("background");
		
		ScrollBarUI customUI = instance.new CustomScrollBarUI();
		
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		scrollPane.setBackground(background);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setBackground(background);
		scrollPane.getHorizontalScrollBar().setBackground(background);
		scrollPane.setBorder(BorderFactory.createLineBorder(ColorsUtils.COLORS.get("menuHide"), 1));
		scrollPane.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(background);
		scrollPane.getVerticalScrollBar().setUI(customUI);
		
		return scrollPane;
		
	}
	
	private class CustomScrollBarUI extends BasicScrollBarUI{
		
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
