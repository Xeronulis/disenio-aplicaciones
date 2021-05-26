package customItems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.ColorsUtils;
import utils.SizeUtils;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CustomDsLabel extends JPanel {
	
	private JLabel label;

	public JLabel getLabel() {
		return this.label;
	}
	
	
	
	/**
	 * Create the panel.
	 */
	public CustomDsLabel() {

		Color alpha = new Color(0,0,0,0);
		
		this.setBackground(ColorsUtils.COLORS.get("background"));
		setPreferredSize(new Dimension(SizeUtils.BOXSIZEX, 55));
		setLayout(new BorderLayout(0, 0));
		
		label = new JLabel("sample");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		add(label, BorderLayout.CENTER);
		
		
		
	}

}
