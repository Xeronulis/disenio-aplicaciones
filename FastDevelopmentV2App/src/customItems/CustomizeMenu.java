package customItems;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import utils.ColorsUtils;

public class CustomizeMenu {
	
	static CustomizeMenu instance = new CustomizeMenu();
	

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
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
			scrollPane.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
			scrollPane.getViewport().setBackground(background);
			scrollPane.getVerticalScrollBar().setUI(customUI);
			
			
			return scrollPane;
			
		}
		
		private class CustomScrollBarUI extends BasicScrollBarUI{
			
			
			
			@Override
			protected void configureScrollBarColors(){
				
				
				Map<String, Color> colors = ColorsUtils.COLORS;
				
		        thumbColor = colors.get("scrollBarThumb");
		        thumbHighlightColor =  thumbColor;
		        thumbLightShadowColor = thumbColor;
		        thumbDarkShadowColor = thumbColor;
		        trackColor = colors.get("itemHover");
		        trackHighlightColor = trackColor;
				
				
			}
		    @Override
		    protected JButton createDecreaseButton(int orientation) {
		       return createNoButton();
		    }
		    
		    
		    @Override
		    protected JButton createIncreaseButton(int orientation) {
		    	return createNoButton();
		        
		    }
		    
		    private JButton createNoButton() {
				JButton btn = new JButton();
				btn.setPreferredSize(new Dimension(0,0));
				btn.setMinimumSize(new Dimension(0,0));
				btn.setMaximumSize(new Dimension(0,0));
				
				return btn;
		    	
		    	
		    }
		}
}
