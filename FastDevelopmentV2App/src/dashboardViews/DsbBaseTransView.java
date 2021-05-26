package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DsbBaseTransView extends DsbBaseView {

	private String clienteTxt;
	private String folioTxt;
	private String trabajadorTxt;
	private String fechaVentaTxt;
	private String horaVentaTxt;
	private String costoTotalTxt;
	private String metodoPagoTxt;
	
	private String clienteLbl;
	private String folioLbl;
	private String trabajadorLbl;
	private String fechaVentaLbl;
	private String horaVentaLbl;
	private String costoTotalLbl;
	private String metodoPagoLbl;
	
	public String getClienteTxt() {
		return clienteTxt;
	}

	public String getFolioTxt() {
		return folioTxt;
	}

	public String getTrabajadorTxt() {
		return trabajadorTxt;
	}

	public String getFechaVentaTxt() {
		return fechaVentaTxt;
	}

	public String getHoraVentaTxt() {
		return horaVentaTxt;
	}

	public String getCostoTotalTxt() {
		return costoTotalTxt;
	}

	public String getMetodoPagoTxt() {
		return metodoPagoTxt;
	}

	public String getClienteLbl() {
		return clienteLbl;
	}

	public String getFolioLbl() {
		return folioLbl;
	}

	public String getTrabajadorLbl() {
		return trabajadorLbl;
	}

	public String getFechaVentaLbl() {
		return fechaVentaLbl;
	}

	public String getHoraVentaLbl() {
		return horaVentaLbl;
	}

	public String getCostoTotalLbl() {
		return costoTotalLbl;
	}

	public String getMetodoPagoLbl() {
		return metodoPagoLbl;
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
	this.folioLbl ="Folio";
	this.clienteLbl ="Cliente";
	this.trabajadorLbl = "Trabajador";
	this.fechaVentaLbl = "Fecha de venta";
	this.horaVentaLbl = "Hora de venta";
	this.costoTotalLbl = "Costo total";
	this.metodoPagoLbl = "Metodo de pago";
	
	
	}
}
