package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DsbBaseTransView extends DsbBaseView {

	private String libroNumeroSerieTxt;
	private String idFacturaTxt;
	private String precioNetoTxt;
	private String costoConIvaTxt;
	private String costoIvaTxt;
	
	private String libroNumeroSerieLbl;
	private String idFacturaLbl;
	private String precioNetoLbl;
	private String costoConIvaLbl;
	private String costoIvaLbl;
	public String getLibroNumeroSerieTxt() {
		return libroNumeroSerieTxt;
	}

	public String getIdFacturaTxt() {
		return idFacturaTxt;
	}

	public String getPrecioNetoTxt() {
		return precioNetoTxt;
	}

	public String getCostoConIvaTxt() {
		return costoConIvaTxt;
	}

	public String getCostoIvaTxt() {
		return costoIvaTxt;
	}

	public String getLibroNumeroSerieLbl() {
		return libroNumeroSerieLbl;
	}

	public String getIdFacturaLbl() {
		return idFacturaLbl;
	}

	public String getPrecioNetoLbl() {
		return precioNetoLbl;
	}

	public String getCostoConIvaLbl() {
		return costoConIvaLbl;
	}

	public String getCostoIvaLbl() {
		return costoIvaLbl;
	}

	/**
	 * Create the panel.
	 */
	public DsbBaseTransView() {
		this.setName("trans");
		this.setCustomStuff();
		this.cLayout = (CardLayout) this.getLayout();
		
		JLabel lblNewLabel = new JLabel("testing...");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, "name_1634406629890300");
		
		
		initItems();
	}
	
	private void initItems() {
	
	this.selectLbl = "Transacción";
	this.libroNumeroSerieLbl ="Id del libro";
	this.idFacturaLbl= "Id de la Factura";
	this.precioNetoLbl="Precio neto";
	this.costoConIvaLbl="Costo con iva";
	this.costoIvaLbl="Costo del iva";
	
	
	}
}
