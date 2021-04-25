package it.unibs.fp.mylib;

/**
 *<p>
 * La classe <strong>BelleStringhe</strong> permette di modificare delle stringhe 
 * per visualizzare un output ordinato e organizzato
 * </p>
 * 
 */
public class BelleStringhe {

 private final static String SPAZIO = " ";
private final static String CORNICE = "-----------------------------------------";
 private final static String ACAPO = "\n";

 	/** Metodo per incorniciare una stringa data
 	 * @param s Stringa di partenza senza cornice
 	 * @return Stringa incorniciata 
 	 */
 	public static String incornicia (String s) { 
 		
 		StringBuffer res = new StringBuffer();
		
 		res.append(CORNICE+ACAPO);
 		res.append(s+ACAPO);
 		res.append(CORNICE+ACAPO);

 		return res.toString();
 	}

	/** Metodo per incorniciare una stringa data e centrarla rispetto alla cornice
	 * @param s Stringa di partenza 
	 * @return Stringa incorniciata e centrata
	 */
	public static String incorniciaECentra (String s) {

		StringBuffer res = new StringBuffer();

		res.append(CORNICE+ACAPO);
		res.append( centrata(s, CORNICE.length()) +ACAPO );
		res.append(CORNICE+ACAPO);

		return res.toString();
	}
	

 	/** Metodo per centrare una stringa in uno spazio di lunghezza nota
 	 * @param s Stringa di partenza
 	 * @param larghezza Lunghezza dello spazio in cui si vuole centrare la stringa
 	 * @return Stringa centrata rispetto alla lunghezza di riferimento
 	 */
 	public static String centrata (String s, int larghezza) {

		 StringBuffer res = new StringBuffer(larghezza);

		 if (larghezza <= s.length()){
			res.append(s.substring(larghezza));
		 }
		 else {

			 int spaziPrima = (larghezza - s.length()) / 2;
			 int spaziDopo = larghezza - spaziPrima - s.length();

			 for (int i = 1; i <= spaziPrima; i++) {
				 res.append(SPAZIO);
			 }

			 res.append(s);

			 for (int i = 1; i <= spaziDopo; i++) {
				 res.append(SPAZIO);
			 }
		 }

		 return res.toString();
	}

	/** Metodo per produrre una stringa contenente un numero dato di elementi uguali (char)
	 * @param elemento Char di partenza da ripetere 
	 * @param larghezza Numero di volte che si vuole ripetere il char
	 * @return Stringa di lunghezza data composta da char ripetuti
	 */
	public static String ripetiChar (char elemento, int larghezza) {

 		StringBuffer result = new StringBuffer(larghezza);

 		for (int i = 0; i < larghezza; i++) {

 			result.append(elemento);
 		}

 		return result.toString();
 	}

	/** Metodo per isolare una riga nella console
	 * @param daIsolare Stringa di partenza
	 * @return Stringa modificata con ritorni a capo prima e dopo quella di partenza
	 */
	public static String rigaIsolata(String daIsolare) {

		 StringBuffer result = new StringBuffer();

		 result.append(ACAPO);
		 result.append(daIsolare);
		 result.append(ACAPO);

		 return result.toString();
 	}
}

