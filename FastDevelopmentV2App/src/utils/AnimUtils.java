package utils;

import java.awt.Color;
import java.awt.Point;

public class AnimUtils {

	/**
	 * Funcion que usa y devuelve un double[] solamente de los valores Y de la funcion cubica de Bezier
	 * @param p0 = punto de inicio (valor minimo)
	 * @param p1 = permite ajustar la diferencia entre la generacion de valores
	 * @param p2 = permite ajustar la diferencia entre la generacion de valores
	 * @param p3 = punto final (valor maximo)
	 * @param finalFrame = se refiere a cuantos valores se calcularan ex. 30 equivale a un array de 30 valores 
	 * @return double[] de valores Y de la funcion cubica de Bezier
	 */
	
	public static double[] cubicBezier(double p0, double p1, double p2, double p3, int finalFrame) {
		
		double[] array = new double[finalFrame];
		
		double tMul = (double)1/(finalFrame+1);
		
		
		for(int i=0; i<array.length ; ++i) {
			
			double t = (i+1)*tMul;
			
			array[i] = Math.pow(1 - t , 3) * p0 +
					Math.pow(1 - t, 2) * 3 * t * p1 +
					(1 - t) * 3 * t * t * p2 +
					t * t * t * p3;
			
		}
		
		
		return array;
	}
	
	/**
	 * Funcion que mapea un valor entre un rango inferior y superior a un nuevo valor entre un nuevo rango inferior y superior
	 * @param x = valor a mapear
	 * @param in_min = rango de entrada inferior
	 * @param in_max = rango de entrada superior
	 * @param out_min = rango de salida inferior
	 * @param out_max = rango de salida superior
	 * 
	 * @return double mapeado
	 */
	
	public static double map(double x, double in_min, double in_max, double out_min, double out_max) {
		  return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
		
	}
	
	/**
	 * Funcion que calcula de forma lineal una cantidad de colores entre dos colores distintos
	 * @param from = el color inicial
	 * @param to = el color final
	 * @param duration = cuantos colores se generaran
	 * @return Color[], un array de colores
	 */
	
	
	public static Color[] colorTransition(Color from, Color to, int duration) {
		
		Color[] colors = new Color[duration];
		
		int fromR= from.getRed();
		int fromG= from.getGreen();
		int fromB= from.getBlue();
		
		int toR= to.getRed();
		int toG= to.getGreen();
		int toB= to.getBlue();
		
		int difR= Math.abs(fromR-toR);
		int difG= Math.abs(fromG-toG);
		int difB= Math.abs(fromB-toB);
		
		double mulR= (double)difR/duration;
		double mulG= (double)difG/duration;
		double mulB= (double)difB/duration;
		
		double minR= 1*mulR;
		double maxR= duration*mulR;
		
		double minG= 1*mulG;       
		double maxG= duration*mulG;
		
		double minB= 1*mulB;       
		double maxB= duration*mulB;
		
		
		for(int i=1; i<=duration; ++i) {
			int r= (int) (i*mulR);
			int g= (int) (i*mulG);
			int b= (int) (i*mulB);
			
			r = (int) map(r, minR, maxR, fromR, toR);
			g = (int) map(g, minG, maxG, fromG, toG);
			b = (int) map(b, minB, maxB, fromB, toB);
			
			colors[i-1] = new Color(r,g,b);
		}	
		
		
		return colors;
	}
	
}
	

