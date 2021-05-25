package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.ColorsUtils;
import utils.SizeUtils;

@SuppressWarnings("serial")
public class DsbMainView extends DsbBaseView {


	/**
	 * Create the panel.
	 */
	public DsbMainView() {
		this.setName("main");
		this.setCustomStuff();

		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Fast Development");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		add(lblNewLabel);
		
	}
}
