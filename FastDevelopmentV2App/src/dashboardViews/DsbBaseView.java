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
	
	
	
	//autor
	protected CustomDsTxtField autorNameTxt;
	protected CustomDsTxtField autorFatherLstNameTxt;
	protected CustomDsTxtField autorMotherLstNameTxt;
	
	protected CustomDsLabel autorNameLbl;
	protected CustomDsLabel autorFatherLstNameLbl;
	protected CustomDsLabel autorMotherLstNameLbl;
	
	//Estado libro
	protected CustomDsTxtField estStatusTxt;
	
	protected CustomDsLabel estStatusLbl;
	
	//Categoria
	protected CustomDsTxtField categCategoryTxt;
	
	protected CustomDsLabel categCategoryLbl;
	
	//Editorial
	protected CustomDsTxtField editEditorialTxt;
	protected CustomDsLabel editEditorialLbl;
	
	//Idioma
	protected CustomDsTxtField idioLangTxt;
	protected CustomDsLabel idioLangLbl;
	
	//Metodo de pago
	protected CustomDsTxtField payPaymetTxt;
	protected CustomDsLabel payPaymetLbl;
	
	
	

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
		
		/*
		this.setName(layout);
		
		selectLbl = new CustomDsLabel();
		selectCbx = new CustomDsCbx();
		
		titlePanel = new JPanel();
		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		
		title = new CustomDsLabel();
		title.getLabel().setFont(new Font("Verdana", Font.PLAIN, 28));
		title.getLabel().setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(title);
		
		
		fieldsPanel = new JPanel();
		fieldsPanel.setBackground(getBackground());
		this.add(fieldsPanel, BorderLayout.CENTER);
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		fields = new JPanel();
		fields.setLayout(new MigLayout("", "[140][275.00,center][140]", "[1.00px:n][][][][][][]"));
		fields.setBackground(getBackground());
		fieldsPanel.add(fields);
		
		setCustomLayout(layout);
		*/		
	}
	

}
