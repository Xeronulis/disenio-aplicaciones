package customItems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboPopup;

import utils.ColorsUtils;
import utils.SizeUtils;

public class CustomDsCbx extends JPanel {
	private JComboBox<Object> comboBox;
	
	public JComboBox<Object> getComboBox() {
		return comboBox;
	}
	/**
	 * Create the panel.
	 */
	public CustomDsCbx() {
		Color alpha = new Color(0,0,0,0);

		this.setBackground(ColorsUtils.COLORS.get("background"));
		setPreferredSize(new Dimension(SizeUtils.BOXSIZEX, 20));
		setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox<Object>();

		
		comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 16));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(ColorsUtils.COLORS.get("background"));
		
		
		
		Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
		BasicComboPopup popup = (BasicComboPopup)child;
		JList<Object> list = popup.getList();
		list.setSelectionBackground(ColorsUtils.COLORS.get("menuHide"));
		list.setSelectionForeground(Color.WHITE);
		
		
		add(comboBox, BorderLayout.CENTER);
	}
	


}
