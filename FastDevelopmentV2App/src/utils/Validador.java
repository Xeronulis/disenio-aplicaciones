package utils;

import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;


import model.interfaces.*;

public class Validador <T extends InterfaceDTO> {
	
	private List<T> list;
	
	public final String STRING_COMBINADO = "Nombre comb.";
	public final String NOMBRE = "Nombre"; 
	public final String TELEFONO = "Telefono";
	public final String DIRECCION = "Direcci�n";
	public final String ANIO_INICIO = "A�o de Inicio";
	private final String RUT = "Rut";
	
	private String types[] = {NOMBRE, TELEFONO, DIRECCION, ANIO_INICIO, RUT, STRING_COMBINADO};
	
	
	public void setList(List<T> list) {	
		this.list = list;
	}
	
	private boolean isTextBlank(JTextField txt, JLabel warning) {
		if(txt.getText().isBlank()) {
			warning.setVisible(true);
			warning.setText("Campo vac�o");
			return true;
		}
		
		warning.setVisible(false);
		warning.setText("");
		return false;
	}
	
	private T searchItemRegistered(String str,String type) {
		
		T item = null;
		
		final int compInt = Pattern.matches("\\d+", str) ? Integer.parseInt(str) : 0;
		
		final String compStr = str.toLowerCase();
		
		
		switch(type) {
		
		case STRING_COMBINADO:
			item = list.stream().filter(e-> e.getNameConcat().toLowerCase().contentEquals(compStr)).findFirst().orElse(null);
			break;
		
		case NOMBRE:
			item = list.stream().filter(e-> e.getName().toLowerCase().contentEquals(compStr)).findFirst().orElse(null);
			break;
		
		case TELEFONO:
			item = list.stream().filter(e-> e.getTel() == compInt).findFirst().orElse(null);
			break;
			
		case DIRECCION:
			item = list.stream().filter(e-> e.getDir().toLowerCase().contentEquals(compStr)).findFirst().orElse(null);
			break;
		
		case ANIO_INICIO:
			item = list.stream().filter(e-> e.getStartYear() == compInt).findFirst().orElse(null);
			break;
		
		case RUT:
			item = list.stream().filter(e-> e.getRut().toLowerCase().contentEquals(compStr)).findFirst().orElse(null);
			break;
		
			
		}
		
		return item;
	}
	
	
	private boolean isItemRegisteredFunc(JLabel warning,T item, String type) {
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
	
	private boolean isItemRegistered(String txt, JLabel warning, String type) {
		
		T item = searchItemRegistered(txt, type);
		
		return isItemRegisteredFunc(warning, item, type);
		
	}
	
	
	private boolean isItemRegistered(String txt, JLabel warning,T selItem, String type) {
		
		T item = searchItemRegistered(txt, type);
		
		
		
		if(item != null) {
			switch(type) {
			
			case STRING_COMBINADO:
				/*
				System.out.println(selItem.getNameConcat().toLowerCase().contentEquals(item.getNameConcat().toLowerCase()));
				System.out.println(selItem.getNameConcat());
				System.out.println(item.getNameConcat());
				*/
				if(selItem.getNameConcat().toLowerCase().contentEquals(item.getNameConcat().toLowerCase())) item = null;
				break;
			
			case NOMBRE:
				if(selItem.getName().contentEquals(item.getName())) item = null;
				break;
				
			case RUT:
				
				if(selItem.getRut().contentEquals(item.getRut())) item = null;
				break;
				
			case TELEFONO:
				if(selItem.getTel() == item.getTel()) item = null;
				break;
				
			case DIRECCION:
				if(selItem.getDir().contentEquals(item.getDir())) item = null;
				break;
				
			case ANIO_INICIO:
				if(selItem.getRut().contentEquals(item.getRut())) item = null;
				break;
				
			}
		}
		
		
		

		
		return isItemRegisteredFunc(warning, item, type);
	}
	
	
	
	
	public boolean checkStringRepeated(JTextField txt, JLabel warning, T selItem, String type) {
		
		if(isTextBlank(txt,warning)) return true;
		
		return isItemRegistered(txt.getText().toLowerCase(),warning, selItem, type);
		
	}
	
	
	public boolean checkStringRepeated(JTextField txt, JLabel warning, String type) {
		
		if(isTextBlank(txt,warning)) return true;

		return isItemRegistered(txt.getText().toLowerCase(),warning, type);
	
		
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

		return isItemRegistered(txt.getText(), warning, RUT);
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

		return isItemRegistered(txt.getText(), warning,selItem, RUT);
	}
	
	
	public boolean checkNumberRepeated(JTextField txt, JLabel warning, String type) {
		
		if(this.isTextBlank(txt, warning)) return true;
		
		String txt1 = txt.getText();
		
		if(!Pattern.matches("\\d+", txt1)){
			txt1 = txt1.replaceAll("\\D", "");
			txt.setText(txt1);
			return checkNumberRepeated(txt,warning,type);
		}
		
		return isItemRegistered(txt.getText(),warning,type);
	}
	

	public boolean checkNumberRepeated(JTextField txt, JLabel warning,T selItem, String type) {
		
		if(this.isTextBlank(txt, warning)) return true;
		
		String txt1 = txt.getText();
		
		if(!Pattern.matches("\\d+", txt1)){
			txt1 = txt1.replaceAll("\\D", "");
			txt.setText(txt1);
			return checkNumberRepeated(txt,warning,type);
		}
		
		return isItemRegistered(txt.getText(),warning,selItem,type);
	}
	
	
	public boolean checkNumber(JTextField txt, JLabel warning, String type) {
		
		if(this.isTextBlank(txt, warning)) return true;
		
		String txt1 = txt.getText();
		
		if(!Pattern.matches("\\d+", txt1)){
			txt1 = txt1.replaceAll("\\D", "");
			txt.setText(txt1);
			return checkNumber(txt,warning,type);
		}
		
		return false;
		
	}
	
	
	public boolean checkMixedStringRepeated(JTextField txt, JLabel warning, String mixedStr, String type) {
		
		if(isTextBlank(txt,warning)) return true;
		
		return isItemRegistered(mixedStr.replaceAll("\\s", "").toLowerCase(), warning, type);
		
	}
	
	public boolean checkMixedStringRepeated(JTextField txt, JLabel warning, String mixedStr,T selItem, String type) {
		
		if(isTextBlank(txt,warning)) return true;
		
		return isItemRegistered(mixedStr.replaceAll("\\s", "").toLowerCase(), warning,selItem, type);
		
	}
	
	
	
	public void showBaseListItems() {	
		
		list.forEach(e->{
			System.out.println(e.toString());
		});
		
	}
	

	
}
