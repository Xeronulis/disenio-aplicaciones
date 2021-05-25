package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.ColorsUtils;
import utils.SizeUtils;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Map<String, Color> colors = ColorsUtils.COLORS;
	private JLabel minBtnImg;
	private JPanel minBtn;
	private JLabel closeBtnImg;
	private JLabel maxBtnImg;
	private JPanel maxBtn;
	private JPanel closeBtn;
	private JPanel header;
	private JPanel menu;
	private JPanel menuIcon;
	private JPanel menuHide;
	private JPanel cardPanel;
	private JLabel lblNewLabel;
	private JPanel menuIconLine;
	private JPanel hideMenuBtn;
	private JPanel menuIconLine2;
	private JPanel settings;
	private JLabel hideMenuBtnImg;
	private JLabel settingsImg;
	
	private CardLayout cardLayout;
	private JPanel dashBoard;

	public static Map<String, Color> getColors() {
		return colors;
	}
	
	public JLabel getMinBtnImg() {
		return this.minBtnImg;
	}
	
	public JPanel getMinBtn() {
		return this.minBtn;
	}
	
	public JLabel getMaxBtnImg() {
		return this.maxBtnImg;
	}
	
	public JPanel getMaxBtn() {
		return this.maxBtn;
	}
	
	public JLabel getCloseBtnImg() {
		return this.closeBtnImg;
	}
	
	public JPanel getCloseBtn() {
		return this.closeBtn;
	}
	
	public JPanel getHeader() {
		return this.header;
	}
	
	public JLabel getHideMenuBtnImg() {
		return this.hideMenuBtnImg;
	}
	
	public JLabel getSettingsImg() {
		return this.settingsImg;
	}
	
	public JPanel getHideMenuBtn() {
		return this.hideMenuBtn;
	}
	
	public JPanel getSettings() {
		return this.settings;
	}
	
	public JPanel getMenuIconLine() {
		return this.menuIconLine;
	}
	
	public JPanel getMenuIconLine2() {
		return this.menuIconLine2;
	}
	
	public JPanel getMenu() {
		return this.menu;
	}
	
	public JPanel getMenuIcon() {
		return this.menuIcon;
	}
	
	public JPanel getMenuHide() {
		return this.menuHide;
	}

	public JPanel getCardPanel() {
		return this.cardPanel;
	}
	
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
	
	public JPanel getDashBoard(){
		return this.dashBoard;
	}
	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int menuIconWdth;
		Dimension menuIconLineDmnsn;
		Dimension menuIconPanelDmnsn;
		
		
		Dimension winSz = SizeUtils.WINDOWSIZE;
		
		
		
		
		this.setSize(winSz);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(colors.get("background"));
		setContentPane(contentPane);
		
		header = new JPanel();
		header.setBackground(colors.get("background"));
		header.setPreferredSize(new Dimension(50, 32));
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JPanel iconMinMaxClose = new JPanel();
		iconMinMaxClose.setPreferredSize(new Dimension((int)(winSz.getWidth()/6), 10));
		iconMinMaxClose.setBackground(ColorsUtils.COLORS.get("background"));
		header.add(iconMinMaxClose, BorderLayout.EAST);
		iconMinMaxClose.setLayout(new BoxLayout(iconMinMaxClose, BoxLayout.LINE_AXIS));
		
		minBtn = new JPanel();
		minBtn.setBackground(header.getBackground());
		iconMinMaxClose.add(minBtn);
		minBtn.setLayout(new BorderLayout(0, 0));
		
		minBtnImg = new JLabel("");
		minBtnImg.setHorizontalAlignment(SwingConstants.CENTER);
		minBtnImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		minBtnImg.setIcon(new ImageIcon(MainView.class.getResource("/icons/minimize_window_32px.png")));
		minBtn.add(minBtnImg, BorderLayout.CENTER);
		
		maxBtn = new JPanel();
		maxBtn.setBackground(header.getBackground());
		iconMinMaxClose.add(maxBtn);
		maxBtn.setLayout(new BorderLayout(0, 0));
		
		maxBtnImg = new JLabel("");
		maxBtnImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		maxBtnImg.setIcon(new ImageIcon(MainView.class.getResource("/icons/full_screen_32px.png")));
		maxBtnImg.setHorizontalAlignment(SwingConstants.CENTER);
		maxBtn.add(maxBtnImg, BorderLayout.CENTER);
		
		closeBtn = new JPanel();
		closeBtn.setBackground(header.getBackground());
		iconMinMaxClose.add(closeBtn);
		closeBtn.setLayout(new BorderLayout(0, 0));
		
		closeBtnImg = new JLabel("");
		closeBtnImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		closeBtnImg.setIcon(new ImageIcon(MainView.class.getResource("/icons/delete_32px.png")));
		closeBtnImg.setHorizontalAlignment(SwingConstants.CENTER);
		closeBtn.add(closeBtnImg, BorderLayout.CENTER);
		
		menu = new JPanel();
		menu.setBackground(new Color(50,50,50));
		menu.setPreferredSize(SizeUtils.MENUSIZE);
		contentPane.add(menu, BorderLayout.WEST);
		menu.setLayout(new BorderLayout(0, 0));
		
		//set menuIconWdth
		menuIconWdth = (int)menu.getPreferredSize().getWidth()/6;
		
		menuIcon = new JPanel();
		menuIcon.setBackground(header.getBackground());
		menuIcon.setPreferredSize(new Dimension(menuIconWdth,10));
		menu.add(menuIcon, BorderLayout.WEST);
		menuIcon.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		//set menuIconLineDmnsn and menuIconPanelDmnsn
		menuIconLineDmnsn = new Dimension(menuIconWdth, (int)menuIconWdth/10 );
		menuIconPanelDmnsn = new Dimension(menuIconWdth, menuIconWdth);
		
		menuIconLine = new JPanel();
		menuIconLine.setPreferredSize(menuIconLineDmnsn);
		menuIconLine.setBackground(ColorsUtils.COLORS.get("background"));
		menuIcon.add(menuIconLine);
		
		hideMenuBtn = new JPanel();
		hideMenuBtn.setPreferredSize(menuIconPanelDmnsn);
		hideMenuBtn.setBackground(ColorsUtils.COLORS.get("background"));
		menuIcon.add(hideMenuBtn);
		hideMenuBtn.setLayout(new BorderLayout(0, 0));
		
		hideMenuBtnImg = new JLabel("");
		hideMenuBtnImg.setIcon(new ImageIcon(MainView.class.getResource("/icons/menu_32px.png")));
		hideMenuBtnImg.setHorizontalAlignment(SwingConstants.CENTER);
		hideMenuBtn.add(hideMenuBtnImg, BorderLayout.CENTER);
		
		menuIconLine2 = new JPanel();
		menuIconLine2.setPreferredSize(menuIconLineDmnsn);
		menuIconLine2.setBackground(ColorsUtils.COLORS.get("background"));
		menuIcon.add(menuIconLine2);
		
		settings = new JPanel();
		settings.setPreferredSize(menuIconPanelDmnsn);
		settings.setBackground(ColorsUtils.COLORS.get("background"));
		menuIcon.add(settings);
		settings.setLayout(new BorderLayout(0, 0));
		
		settingsImg = new JLabel("");
		settingsImg.setIcon(new ImageIcon(MainView.class.getResource("/icons/settings_32px.png")));
		settingsImg.setHorizontalAlignment(SwingConstants.CENTER);
		settings.add(settingsImg, BorderLayout.CENTER);
		
		menuHide = new JPanel();
		menuHide.setBackground(colors.get("menuHide"));
		menu.add(menuHide, BorderLayout.CENTER);
		menuHide.setLayout(new BorderLayout(0, 0));
		
		cardPanel = new JPanel();
		menuHide.add(cardPanel, BorderLayout.CENTER);
		cardPanel.setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout) cardPanel.getLayout();
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(ColorsUtils.COLORS.get("menuHide"));
		cardPanel.add(optionsPanel, "optionsPanel");
		optionsPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Hellooooo");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 170, 245, 84);
		optionsPanel.add(lblNewLabel);
		
		
		
		dashBoard = new JPanel();
		dashBoard.setBackground(colors.get("background"));
		contentPane.add(dashBoard, BorderLayout.CENTER);
		dashBoard.setLayout(new BorderLayout(0, 0));
	}
}
