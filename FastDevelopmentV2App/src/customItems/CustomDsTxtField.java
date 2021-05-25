package customItems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.ColorsUtils;
import utils.SizeUtils;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

public class CustomDsTxtField extends JPanel {
	
	private JTextField text;
	
	public JTextField getTxt() {
		return text;
	}
	
	public CustomDsTxtField() {
		createField("");
		
	}
	public CustomDsTxtField(String name) {
		createField(name);
	}
	
	public void createField(String name) {
		
		Color alpha = new Color(0,0,0,0);
		
		this.setBackground(alpha);
		setPreferredSize(new Dimension(SizeUtils.BOXSIZEX, 20));
		setLayout(new BorderLayout(0, 0));
		
		text = new JTextField();
		text.setBorder(new LineBorder(ColorsUtils.COLORS.get("menuHide")));
		text.setForeground(Color.WHITE);
		text.setText(name);
		text.setFont(new Font("Verdana", Font.PLAIN, 16));
		text.setBackground(ColorsUtils.COLORS.get("txtbackground"));
		add(text, BorderLayout.CENTER);
		text.setColumns(10);
	}
	
}
