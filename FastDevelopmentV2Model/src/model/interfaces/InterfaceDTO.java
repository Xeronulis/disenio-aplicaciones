package model.interfaces;

public interface InterfaceDTO {

	public int getId();
	public void setId(int id);
	
	
	public default String getName() {
		return "unimplemented";
	}
	
	public default void setName(String name) {
		
	}
	
	public default String getRut() {
		return "unimplemented";
	}
	public default void setRut(String rut) {
	}
	
	
	public default int getStartYear() {
		return 0;
	}
	public default void setStartYear(int startYear) {
		
	}
	
	public default int getTel() {
		return 0;
	}
	public default void setTel(int tel) {
		
	}
	
	public default String getDir() {
		return "unimplemented";
	}
	public default void setDir(String dire) {
		
	}
	
	
}
