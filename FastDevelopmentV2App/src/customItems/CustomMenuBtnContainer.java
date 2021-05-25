package customItems;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class CustomMenuBtnContainer extends JPanel {

	private JPanel box;
	/**
	 * Create the box.
	 */
	public JPanel getBox() {
		return this.box;
	}
	
	public void setNumberOfBtns(int number) {
		int boxSizeX = SizeUtils.BOXSIZEX;
		double btnSize =SizeUtils.WINDOWSIZE.getHeight()/7;
		box.setPreferredSize(new Dimension(boxSizeX,(int)(btnSize*number)));
		
		

	}
	
	
	public CustomMenuBtnContainer() {
		
		int boxSizeX = SizeUtils.BOXSIZEX;
		int prefSizeX=(int) SizeUtils.MENUHIDESIZEX;
		
		
		this.setPreferredSize(new Dimension(prefSizeX, 500));
		this.setBackground(ColorsUtils.COLORS.get("menuHide"));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(ColorsUtils.COLORS.get("alpha"));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		box = new JPanel();
		panel.add(box, BorderLayout.NORTH);
		box.setBackground(ColorsUtils.COLORS.get("alpha"));
		box.setPreferredSize(new Dimension(boxSizeX,200));
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
	}

}
