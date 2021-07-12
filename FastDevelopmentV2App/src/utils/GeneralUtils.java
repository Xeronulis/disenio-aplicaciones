package utils;

public class GeneralUtils {

	/**
	 * 
	 * @param <T> = Generico que permite trabajar con cualquier tipo de array
	 * @param array = el array a invertir
	 * @return T[] un array del mismo tipo del ingresado
	 */
	
	public static <T> T[] reverseArray(T[] array) {
		
		T[] tempAr = array.clone();
		
		for(int i=0, u=array.length-1; i<u; ++i, --u) {
			T temp = tempAr[i];
			tempAr[i] = tempAr[u];
			tempAr[u] = temp;
			
			
		}
		
		return tempAr;
		
	}
}
