package customItems;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class CustomMenuBtnContainer extends JPanel {

	
	private JPanel box;
	
	public JPanel getBox() {
		return box;
	}
	
	
	public void setNumberOfBtns(int number) {
		int boxSizeX = SizeUtils.BOXSIZEX;
		double btnSize =SizeUtils.WINDOWSIZE.getHeight()/7;
		
		
		this.setPreferredSize(new Dimension(boxSizeX,(int)(btnSize*number)));
		
		box.setPreferredSize(getPreferredSize());
		
		
		

	}
	
	
	public CustomMenuBtnContainer() {
		
		int boxSizeX = SizeUtils.BOXSIZEX;
		this.setPreferredSize(new Dimension(boxSizeX, 500));
		this.setBackground(ColorsUtils.COLORS.get("menuHide"));
		setLayout(new BorderLayout(0,0));
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		panel.setBackground(getBackground());
		add(panel, BorderLayout.CENTER);
				
		
		box = new JPanel();
		panel.add(box);
		box.setBackground(ColorsUtils.COLORS.get("menuHide"));
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		box.setPreferredSize(getPreferredSize());
		
		
		
		
		

		
	}

}
