package utils;

import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;


import model.interfaces.*;

public class Validador <T extends InterfaceDTO> {
	
	private List<T> list;
	
	public final String NOMBRE = "Nombre"; 
	public final String TELEFONO = "Telefono";
	public final String DIRECCION = "Dirección";
	public final String ANIOINICIO = "Año de Inicio";
	private final String RUT = "Rut";
	
	private String types[] = {NOMBRE, TELEFONO, DIRECCION, ANIOINICIO, RUT};
	
	
	public void setList(List<T> list) {	
		this.list = list;
	}
	
	private boolean isTextBlank(JTextField txt, JLabel warning) {
		if(txt.getText().isBlank()) {
			warning.setVisible(true);
			warning.setText("Campo vacío");
			return true;
		}
		
		warning.setVisible(false);
		warning.setText("");
		return false;
	}
	
	private boolean isItemRegistered(JTextField txt, JLabel warning, T item, String type) {
				
		if(item != null) {
			for(String t : types) {
				if(t.contentEquals(type)) {
					warning.setVisible(true);
					warning.setText(type+" en uso");
					return true;
				}
			}
		}
		
		warning.setVisible(false);
		warning.setText("");
		return false;
	}
	
	private boolean isItemRegistered(JTextField txt, JLabel warning, T item, T selItem, String type) {
		
		
		switch(type) {
		
		case NOMBRE:
			if(item != null && selItem.getName().contentEquals(item.getName())) {
				item = null;
			}
			break;
			
		case RUT:
			
			if(item != null && selItem.getRut().contentEquals(item.getRut())) {
				item = null;
			}
			break;
			
		case TELEFONO:
			if(item != null && selItem.getTel() == item.getTel()) {
				item = null;
			}
			break;
			
		case DIRECCION:
			if(item != null && selItem.getDir().contentEquals(item.getDir())) {
				item = null;
			}
			break;
			
		case "Numero":
			if(item != null && selItem.getRut().contentEquals(item.getRut())) {
				item = null;
			}
			break;
			
		}
		

		
		return isItemRegistered(txt,warning,item, type);
	}
	
	
	
	
	public boolean checkStringRepeated(JTextField txt, JLabel warning, T selItem, String type) {
		
		if(isTextBlank(txt,warning)) return true;
		
		T item = null; 
		
		switch(type) {
		
		case NOMBRE:
			item = list.stream().filter(e->e.getName().toLowerCase().contentEquals(txt.getText().toLowerCase())).findFirst().orElse(null);
			break;
			
		case DIRECCION:
			item = list.stream().filter(e->e.getDir().toLowerCase().contentEquals(txt.getText().toLowerCase())).findFirst().orElse(null);
			break;
			
		default:
			System.out.println("mini excepción en: checkStringRepeated");
			System.out.println("tipo desconocido: "+type);
			System.out.println("tipos conocidos: "+types);
		}
		return isItemRegistered(txt, warning, item, selItem, type);
		
	}
	
	
	public boolean checkStringRepeated(JTextField txt, JLabel warning, String type) {
		
		
		if(isTextBlank(txt,warning)) return true;
		
		T item = null; 
		
		switch(type) {
		
		case NOMBRE:
			item = list.stream().filter(e->e.getName().toLowerCase().contentEquals(txt.getText().toLowerCase())).findFirst().orElse(null);
			break;
			
		case DIRECCION:
			item = list.stream().filter(e->e.getDir().toLowerCase().contentEquals(txt.getText().toLowerCase())).findFirst().orElse(null);
			break;
			
		default:
			System.out.println("mini excepción en: checkStringRepeated");
			System.out.println("tipo desconocido: "+type);
			System.out.println("tipos conocidos: ");
			for(String s : types) {
				System.out.println(s);
			}
		}

		return isItemRegistered(txt, warning, item, type);
	
		
	}
	
	
	public boolean checkRutRepeated(JTextField txt, JLabel warning) {
		
		if(isTextBlank(txt,warning)) return true;
		
		String txt1 = txt.getText();
		
		if(txt1.contains("K")) {
			txt1 = txt1.replaceAll("K", "k");
			txt.setText(txt1);
		}
		
		
		if(!Pattern.matches("[0-9[k]]+", txt1)) {
			txt1 = txt1.replaceAll("[^0-9[k]]", "");
			txt.setText(txt1);
			return checkRutRepeated(txt, warning);
			
		}else {
			while(txt1.split("k", -2).length >2) {
				txt1 = txt1.replaceFirst("k", "");
				txt.setText(txt1);
			}
			if(Pattern.matches("\\S+k\\S+", txt1)) {
				txt1 = txt1.replaceFirst("k", "");
				txt.setText(txt1);
			}
			
		}
		
		
		T item = list.stream().filter(e->e.getRut().toLowerCase().contentEquals(txt.getText())).findFirst().orElse(null);

		return isItemRegistered(txt, warning,item, RUT);
	}
	
	public boolean checkRutRepeated(JTextField txt, JLabel warning, T selItem) {
		
		if(isTextBlank(txt,warning)) return true;
		
		String txt1 = txt.getText();
		
		if(txt1.contains("K")) {
			txt1 = txt1.replaceAll("K", "k");
			txt.setText(txt1);
		}
		
		
		if(!Pattern.matches("[0-9[k]]+", txt1)) {
			txt1 = txt1.replaceAll("[^0-9[k]]", "");
			txt.setText(txt1);
			return checkRutRepeated(txt, warning);
			
		}else {
			while(txt1.split("k", -2).length >2) {
				txt1 = txt1.replaceFirst("k", "");
				txt.setText(txt1);
			}
			if(Pattern.matches("\\S+k\\S+", txt1)) {
				txt1 = txt1.replaceFirst("k", "");
				txt.setText(txt1);
			}
			
		}
		
		T item = list.stream().filter(e->e.getRut().toLowerCase().contentEquals(txt.getText())).findFirst().orElse(null);

		return isItemRegistered(txt, warning,item,selItem, RUT);
	}
	
	
	public boolean checkNumberRepeated(JTextField txt, JLabel warning, String type) {
		
		if(this.isTextBlank(txt, warning)) return true;
		
		String txt1 = txt.getText();
		
		if(!Pattern.matches("\\d+", txt1)){
			txt1 = txt1.replaceAll("\\D", "");
			txt.setText(txt1);
			return checkNumberRepeated(txt,warning,type);
		}
		T item = null;
		
		switch(type) {
		
		case TELEFONO:
			item = list.stream().filter(e-> e.getTel() == Integer.parseInt(txt.getText())).findFirst().orElse(null);
			break;

		default:
			System.out.println("mini excepcion en: checkNumberRepeated");
			System.out.println("tipo desconocido: ");
			System.out.println("tipos conocidos: ");
			for(String s : types) {
				System.out.println(s);
			}
			
		}
		
		return isItemRegistered(txt,warning,item,type);
	}
	

	public boolean checkNumberRepeated(JTextField txt, JLabel warning,T selItem, String type) {
		
		if(this.isTextBlank(txt, warning)) return true;
		
		String txt1 = txt.getText();
		
		if(!Pattern.matches("\\d+", txt1)){
			txt1 = txt1.replaceAll("\\D", "");
			txt.setText(txt1);
			return checkNumberRepeated(txt,warning,type);
		}
		T item = null;
		
		switch(type) {
		
		case TELEFONO:
			item = list.stream().filter(e-> e.getTel() == Integer.parseInt(txt.getText())).findFirst().orElse(null);
			break;
			
		default:
			System.out.println("tipo desconocido: "+type);
			System.out.println("tipos conocidos: ");
			for(String s : types) {
				System.out.println(s);
			}
			
		}
		
		return isItemRegistered(txt,warning,item,selItem,type);
	}
	
	
	public boolean checkNumber(JTextField txt, JLabel warning, String type) {
		
		if(this.isTextBlank(txt, warning)) return true;
		
		String txt1 = txt.getText();
		
		if(!Pattern.matches("\\d+", txt1)){
			txt1 = txt1.replaceAll("\\D", "");
			txt.setText(txt1);
			return checkNumberRepeated(txt,warning,type);
		}
		
		return false;
		
	}
	
	
	
	
	public void showBaseListItems() {	
		
		list.forEach(e->{
			System.out.println(e.toString());
		});
		
	}
	

	
}
