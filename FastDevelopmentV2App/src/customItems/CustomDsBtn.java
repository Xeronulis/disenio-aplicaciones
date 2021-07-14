package customItems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomMenuBtn.HoverLs;
import utils.ColorsUtils;
import utils.SizeUtils;
import javax.swing.border.LineBorder;

/**
 * En esta clase es donde realizamos la configuracion de todos los botones dentro de la interfaz
 * desde la forma hasta los colores que estos van a poseer
 *@author Grupo4
 *@version 12-07-2021
 */
public class CustomDsBtn extends JPanel {
	private JPanel Panel;
	private JPanel btn;
	private JLabel btnTxt;
	private HoverLs hoverLs;
	private Component verticalStrut;
	
	/**
	 * Una breve descripcion de cada atributo
	 * @param panel: El lugar donde aparece el boton.
	 * @param btn: el boton en si.
	 * @param btnTxt: texto dentro del boton.
	 * @param hoverLs:
	 * @param verticalStrut:
	 */
	
	

	public JPanel getPanel() {
		return Panel;
	}

	public Component getVerticalStrut() {
		return this.verticalStrut;
	}
	public JPanel getBtn() {
		return btn;
	}

	public JLabel getBtnTxt() {
		return btnTxt;
	}

	
	public HoverLs getHoverLs() {
		return this.hoverLs;
	}
	
	public void deleteVertStrut() {
		this.remove(this.getVerticalStrut());
	}
	
	public void setAllColors(Color bg, Color h, Color p) {
		setColors(1, bg);
		setColors(2, h);
		setColors(3, p);
	}
	
	public Color[] getAllColors() {
		Color[] colors = new Color[3];
		
		for(int i=0;i<3;++i) {
			colors[i] = getColors(++i);
			
		}
		return colors;
		
		
	}
	
	public void setColors(int id, Color color) {
		
		switch(id) {
		case 1: 
			hoverLs.setBgColor(color);
			break;
		case 2:
			hoverLs.setHColor(color);
			break;
		case 3:
			hoverLs.setPColor(color);
			break;
		default:
		}
	}
	
	public Color getColors(int id) {
		
		switch(id) {
		
		case 1:
			return hoverLs.getBgColor();
		case 2:
			return hoverLs.getHColor();
		case 3:
			return hoverLs.getPColor();
			
		default:
			return new Color(100,100,100);
		}
	}

	/**
	 * Create the panel.
	 */
	public CustomDsBtn() {
		createBtn("name");
		
	}
	public CustomDsBtn(String name) {
		createBtn(name);
	}
	
	public void createBtn(String name) {
		
		
		
		this.setBackground(ColorsUtils.COLORS.get("background"));
		setPreferredSize(new Dimension(14*name.length(), 60));

		setLayout(new BorderLayout(0, 0));
		
		Panel = new JPanel();
		Panel.setBackground(new Color(38,38,73));
		Panel.setBorder(new LineBorder(ColorsUtils.COLORS.get("menuHide"), 1, true));
		add(Panel);
		Panel.setLayout(new BorderLayout(0, 0));
		
		btn = new JPanel();
		btn.setPreferredSize(new Dimension(10, 32));
		btn.setBackground(ColorsUtils.COLORS.get("background"));
		Panel.add(btn, BorderLayout.CENTER);
		btn.setLayout(new BorderLayout(0, 0));
		
		btnTxt = new JLabel(name);
		btnTxt.setHorizontalAlignment(SwingConstants.CENTER);
		btnTxt.setForeground(Color.WHITE);
		btnTxt.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnTxt.setAlignmentX(0.5f);
		btn.add(btnTxt, BorderLayout.CENTER);
		
		
		
		btn.addMouseListener(hoverLs = new HoverLs(btn));
		
		verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
	}
	
	

	
	
	private class HoverLs implements MouseListener{
		private boolean isIn;		
		private JPanel link;		
		private Color bColor = ColorsUtils.COLORS.get("background");
		private Color hColor = ColorsUtils.COLORS.get("itemHover");
		private Color pColor = ColorsUtils.COLORS.get("itemPressed");
		
		
		public HoverLs(JPanel jp) {
			link = jp;

		}
		
		public void setBgColor(Color bColor) {
			this.bColor = bColor;
		}
		
		public void setHColor(Color hColor) {
			this.hColor = hColor;
		}
		
		public void setPColor(Color pColor) {
			this.pColor = pColor;
		}
		
		public Color getBgColor() {
			return this.bColor;
		}
		
		public Color getHColor() {
			return this.hColor;
		}
		
		public Color getPColor() {
			return this.pColor;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void mousePressed(MouseEvent e) {
			link.setBackground(pColor);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				link.setBackground(hColor);
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			link.setBackground(hColor);	
		}
		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			link.setBackground(bColor);
		}
	}
}
