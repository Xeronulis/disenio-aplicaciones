package dashboardViews;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DsbBaseLibroView extends DsbBaseView {
	
	private String numeroSerieLbl;
	private String isbnLbl;
	private String tituloLbl;
	private String numeroPaginasLbl;
	private String autorLbl;
	private String categoriaLbl;
	private String idiomaLbl;
	private String editorialLbl;
	private String estadoLbl;
	
	private String precioReferenciaLbl;
	private String fechaPublicacionLbl;
	
	private String numeroSerieTxt;        
	private String isbnTxt;               
	private String tituloTxt;             
	private String numeroPaginasTxt;      
	private String precioReferenciaTxt;   
	private String fechaPublicacionTxt;   
	private String estadoLibroTxt;        
	private String editorialTxt;
	
	public String getNumeroSerieLbl() {
		return numeroSerieLbl;
	}

	public String getIsbnLbl() {
		return isbnLbl;
	}

	public String getTituloLbl() {
		return tituloLbl;
	}

	public String getNumeroPaginasLbl() {
		return numeroPaginasLbl;
	}

	public String getAutorLbl() {
		return autorLbl;
	}

	public String getCategoriaLbl() {
		return categoriaLbl;
	}

	public String getIdiomaLbl() {
		return idiomaLbl;
	}

	public String getEditorialLbl() {
		return editorialLbl;
	}

	public String getEstadoLbl() {
		return estadoLbl;
	}

	public String getPrecioReferenciaLbl() {
		return precioReferenciaLbl;
	}

	public String getFechaPublicacionLbl() {
		return fechaPublicacionLbl;
	}

	public String getNumeroSerieTxt() {
		return numeroSerieTxt;
	}

	public String getIsbnTxt() {
		return isbnTxt;
	}

	public String getTituloTxt() {
		return tituloTxt;
	}

	public String getNumeroPaginasTxt() {
		return numeroPaginasTxt;
	}

	public String getPrecioReferenciaTxt() {
		return precioReferenciaTxt;
	}

	public String getFechaPublicacionTxt() {
		return fechaPublicacionTxt;
	}

	public String getEstadoLibroTxt() {
		return estadoLibroTxt;
	}

	public String getEditorialTxt() {
		return editorialTxt;
	}

	/**
	 * Create the panel.
	 */
	public DsbBaseLibroView() {
		this.setName("libro");
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
	
	this.selectLbl =			"Libro";
	this.numeroSerieLbl =		"Num. serie";
	this.isbnLbl =				"ISBN";
	this.tituloLbl =			"Título";
	this.numeroPaginasLbl = 	"Num. páginas";
	this.autorLbl = 			"Autor";
	this.categoriaLbl = 		"Categoría";
	this.idiomaLbl = 			"Idioma";
	this.editorialLbl =			"Editorial";
	this.estadoLbl=				"Estado del libro";
	this.precioReferenciaLbl =	"Precio de referencia";
	this.fechaPublicacionLbl =	"Fecha de publicación";
	
	
	
	
	
	}
}
