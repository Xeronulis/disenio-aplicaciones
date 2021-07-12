package customItems;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import utils.AnimUtils;
import utils.ColorsUtils;
import utils.GeneralUtils;
import utils.SizeUtils;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CustomMenuBtn extends JPanel {
	private JPanel Panel;
	private Component verticalStrut;
	private JPanel btn;
	private JLabel btnTxt;
	private JLabel btnImg;
	private HoverLs hoverLs;
	
	public JPanel getPanel() {
		return Panel;
	}

	public Component getVerticalStrut() {
		return verticalStrut;
	}

	public JPanel getBtn() {
		return btn;
	}

	public JLabel getBtnTxt() {
		return btnTxt;
	}

	public JLabel getBtnImg() {
		return btnImg;
	}
	
	public HoverLs getHoverLs() {
		return this.hoverLs;
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
	public CustomMenuBtn() {
		createBtn(" name");
		
	}
	public CustomMenuBtn(String name) {
		createBtn(name);
	}
	
	public void createBtn(String name) {
		
		Color alpha = new Color(0,0,0,0);
		
		this.setBackground(alpha);
		setPreferredSize(new Dimension(SizeUtils.BOXSIZEX, 73));
		setLayout(new BorderLayout(0, 0));
		
		Panel = new JPanel();
		Panel.setBackground(new Color(38,38,73));
		add(Panel);
		Panel.setLayout(new BorderLayout(0, 0));
		
		verticalStrut = Box.createVerticalStrut(20);
		Panel.add(verticalStrut, BorderLayout.NORTH);
		
		btn = new JPanel();
		btn.setPreferredSize(new Dimension(10, 32));
		btn.setBackground(alpha);
		Panel.add(btn, BorderLayout.CENTER);
		btn.setLayout(new BorderLayout(0, 0));
		
		btnTxt = new JLabel(name);
		btnTxt.setHorizontalAlignment(SwingConstants.LEFT);
		btnTxt.setForeground(Color.WHITE);
		btnTxt.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnTxt.setAlignmentX(0.5f);
		btn.add(btnTxt, BorderLayout.CENTER);
		
		btnImg = new JLabel("");
		btnImg.setIcon(new ImageIcon(CustomMenuBtn.class.getResource("/icons/menu_32px.png")));
		btnImg.setPreferredSize(new Dimension(32, 0));
		btnImg.setHorizontalAlignment(SwingConstants.CENTER);
		btnImg.setAlignmentX(0.5f);
		btn.add(btnImg, BorderLayout.WEST);
		
		
		
		btn.addMouseListener(hoverLs = new HoverLs(btn));
	}
	
	
	/**
	 * HoverLs es la clase encargada del comportamiento visual del boton.
	 * 
	 * 
	 * @author grupo4
	 *
	 */
	
	
	public class HoverLs implements MouseListener, ActionListener{
		
		
		private boolean isIn;
		
		private JPanel link;
		
		private Color bColor = ColorsUtils.COLORS.get("menuHide");
		private Color hColor = ColorsUtils.COLORS.get("itemHover");
		private Color pColor = ColorsUtils.COLORS.get("itemPressed");
		
		private Color cColor= bColor;
		
		private int animFrames= 10;
		private int frameCounter=0;
		
		private Timer anim = new Timer(0, this);
		
		private Color[] btoh = AnimUtils.colorTransition(bColor, hColor, animFrames);
		private Color[] htob = GeneralUtils.reverseArray(btoh);
		
		private Color[] htop = AnimUtils.colorTransition(hColor, pColor, animFrames);
		private Color[] ptoh = GeneralUtils.reverseArray(htop);
		
		private Color[] ptob = AnimUtils.colorTransition(pColor, bColor, animFrames);
		
		//tipo de animacion, 0=idle, 1=hovering, -1=pressed
		private int animType=0;
		private int prevAnimStatus=0;
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				switch(animType) {
				case 0:
					if(prevAnimStatus == 1) {
						cColor = htob[frameCounter];
						
					}else {
						cColor = ptob[frameCounter];
						
					}
					break;
					
				case 1:
					if(prevAnimStatus == 0) {
						cColor = btoh[frameCounter];
					}else {
						cColor = ptoh[frameCounter];
					}
					break;
					
				case -1:
					cColor = htop[frameCounter];
					break;
				
				}
			}catch(Exception ex) {
				
			}finally {
				if(frameCounter >= animFrames-1) {
					anim.stop();
					frameCounter=0;
					
				}
				
				link.setBackground(cColor);
				
				++frameCounter;
			}
			
		}
		
		public HoverLs(JPanel jp) {
			link = jp;
			anim.setDelay(16);
			
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
			if(anim.isRunning()) {
				frameCounter = (int) AnimUtils.map(frameCounter, 0, animFrames-1, animFrames-1, 0);
				prevAnimStatus=animType;
				animType=-1;
			}else {
				prevAnimStatus=animType;
				animType=-1;
				anim.start();
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(isIn) {
				if(anim.isRunning()) {
					frameCounter = animFrames - frameCounter;
					prevAnimStatus=animType;
					animType=1;
				}else {
					prevAnimStatus=animType;
					animType=1;
					anim.start();
				}
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			if(anim.isRunning()) {
				frameCounter = animFrames - frameCounter;
				prevAnimStatus=animType;
				animType=1;
			}else {
				prevAnimStatus=animType;
				animType=1;
				anim.start();
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			isIn = false;
			if(anim.isRunning()) {
				
				if(prevAnimStatus == -1) {
					int halfAnimFrames = (animFrames)/2;
					
					if(frameCounter < halfAnimFrames) {
						frameCounter = (int) AnimUtils.map(frameCounter, 0, halfAnimFrames, 0, animFrames-1);
						prevAnimStatus=-1;
					}else {
						frameCounter = (int) AnimUtils.map(frameCounter, halfAnimFrames, animFrames, animFrames-1, 0);
						prevAnimStatus=animType;
					}
					
					
					
				}else {
					frameCounter = animFrames - frameCounter;
					prevAnimStatus=animType;
				}
				
				animType=0;
			}else {
				prevAnimStatus=animType;
				animType=0;
				anim.start();
			}
		}

		
		

	
	}

}
