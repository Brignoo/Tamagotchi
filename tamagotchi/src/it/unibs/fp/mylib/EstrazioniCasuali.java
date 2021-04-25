package it.unibs.fp.mylib;
import java.util.*;

/**
*<p>
* La classe <strong>EstrazioniCasuali</strong> permette di estrarre valori  
* numerici dati degli intervalli di appartenenza
* </p>
* 
*/
public class EstrazioniCasuali {
	
	private static Random rand = new Random();	
	
	/** Genera un int in modo casuale dato un intervallo di appartenenza
	 * @param min Valore minimo
	 * @param max Valore massimo
	 * @return Intero compreso tra i valori di riferimento
	 */
	public static int estraiIntero(int min, int max) {
		
		int range = max + 1 - min;
		int casual = rand.nextInt(range);
	 
		return casual + min;
	}
	
	/** Genera un double in modo casuale dato un intervallo di appartenenza
	 * @param min Valore minimo
	 * @param max Valore massimo
	 * @return Double compreso tra i valori di riferimento
	 */
	public static double estraiDouble(double min, double max) {
		
		double range = max - min;
		double casual = rand.nextDouble();
		double posEstratto = range*casual;
	 
		return posEstratto + min;
	}
}
