package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DsbBaseFactView extends DsbBaseView {

	private String distribuidorTxt;
	private String folioTxt;
	private String fechaCompraTxt;
	private String horaCompraTxt;
	private String metodoPagoTxt;
	private String costoTotalTxt;
	
	private String distribuidorLbl;
	private String folioLbl;
	private String fechaCompraLbl;
	private String horaCompraLbl;
	private String metodoPagoLbl;
	private String costoTotalLbl;
	
	public String getDistribuidorTxt() {
		return distribuidorTxt;
	}

	public String getFolioTxt() {
		return folioTxt;
	}

	public String getFechaCompraTxt() {
		return fechaCompraTxt;
	}

	public String getHoraCompraTxt() {
		return horaCompraTxt;
	}

	public String getMetodoPagoTxt() {
		return metodoPagoTxt;
	}

	public String getCostoTotalTxt() {
		return costoTotalTxt;
	}

	public String getDistribuidorLbl() {
		return distribuidorLbl;
	}

	public String getFolioLbl() {
		return folioLbl;
	}

	public String getFechaCompraLbl() {
		return fechaCompraLbl;
	}

	public String getHoraCompraLbl() {
		return horaCompraLbl;
	}

	public String getMetodoPagoLbl() {
		return metodoPagoLbl;
	}

	public String getCostoTotalLbl() {
		return costoTotalLbl;
	}

	/**
	 * Create the panel.
	 */
	public DsbBaseFactView() {
		this.setName("fact");
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
	
	this.selectLbl = "Factura";
	this.folioLbl ="Folio";
	this.distribuidorLbl = "Distribuidor";
	this.fechaCompraLbl = "Fecha de compra";
	this.horaCompraLbl = "Hora de compra";
	this.costoTotalLbl = "Costo total";
	this.metodoPagoLbl = "Metodo de pago";
	
	
	}
}
