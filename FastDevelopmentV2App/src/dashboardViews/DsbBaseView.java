package dashboardViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import customItems.CustomDsBtn;
import customItems.CustomDsCbx;
import customItems.CustomDsLabel;
import customItems.CustomDsTxtField;
import net.miginfocom.swing.MigLayout;
import utils.ColorsUtils;
import utils.SizeUtils;
import java.awt.CardLayout;

//esta clase sera padre de todas las vistas del mismo tipo
public class DsbBaseView extends JPanel {

	//general
	
	
	
	protected Color[] defaultColors = {ColorsUtils.COLORS.get("background"),
			ColorsUtils.COLORS.get("menuHide"),
			ColorsUtils.COLORS.get("txtbackground")
			};
	
	protected CustomDsBtn commitBtn;
	protected CustomDsLabel title;
	
	protected String selectLbl;
	protected String selectCbx;
	
	protected JPanel titlePanel;
	protected JPanel fieldsPanel;
	protected JPanel fields;
	
	protected CardLayout cLayout;

	

	
	
	

	

	
	//Metodo de pago
	protected CustomDsTxtField payPaymetTxt;
	protected CustomDsLabel payPaymetLbl;
	
	
	

	public CustomDsBtn getCommitBtn() {
		return commitBtn;
	}


	public CustomDsLabel getTitle() {
		return title;
	}


	public String getSelectLbl() {
		return selectLbl;
	}


	public String getSelectCbx() {
		return selectCbx;
	}


	public JPanel getTitlePanel() {
		return titlePanel;
	}


	public JPanel getFieldsPanel() {
		return fieldsPanel;
	}


	public JPanel getFields() {
		return fields;
	}


	public CardLayout getcLayout() {
		return cLayout;
	}


	public void initCustomLayout(DsbBaseCrudView crudView,String layout) {
		switch (layout) {
		
		case "register":
			title.getLabel().setText("Registrar ");
			break;
		case "modify":
			title.getLabel().setText("Modificar ");
			break;
		case "show":
			title.getLabel().setText("Mostrar ");
			break;
		case "search":
			title.getLabel().setText("Buscar ");
			break;
		case "delete":
			title.getLabel().setText("Eliminar ");
			break;
		}
		
	}
	
	
	protected void setCustomStuff() {
		
		this.setSize(new Dimension((int)(SizeUtils.DASHBOARDSIZE.getWidth()-SizeUtils.MENUHIDESIZEX),
				(int)SizeUtils.DASHBOARDSIZE.getHeight()));
		this.setBackground(ColorsUtils.COLORS.get("background"));
		setLayout(new CardLayout(0, 0));
		
		
	}
	/**
	 * Create the panel.
	 */
	
	public DsbBaseView() {
		this.setCustomStuff();	
	}
	

}
