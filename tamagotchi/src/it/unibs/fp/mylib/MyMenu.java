package it.unibs.fp.mylib;

import java.io.IOException;

/**
*<p>
* La classe <strong>MyMenu</strong> permette di utilizzare un menu testuale
* semplice per l'interazione con l'utente, implementato metodi utili per la
* presentazione a video 
* </p>
* 
*/

public class MyMenu {
	
	final private static String CORNICE_SUPERIORE = "------------------------------------------";
	final private static String CORNICE_VERTICALE = "|";
	final private static String CORNICE_INFERIORE = "------------------------------------------";
	final private static String VOCE_USCITA = "0\tEsci";				
	final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";
	
	private String titolo;
	private String [] voci;
	private int lunghezza;
		
	/** Costruttore per un generico menu
	 * @param titolo Titolo da utilizzare nella visualizzazione
	 * @param voci Array contenente tutte le possibili scelte dell'utente
	 */
	public MyMenu (String titolo, String [] voci){
		  
		this.titolo = titolo;
		this.voci = voci;
	}

	/** Metodo per la scelta dell'operazione da eseguire
	 * @return Ritorna l'intero scelto dall'utente
	 */
	public int scegli (){
	  
		stampaMenu();
	
		return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);	 
	}
	
	/** Metodo per il calcolo della lunghezza della cornice del menu
	 * 
	 */
	private void calcolaLunghezza() {
		
		lunghezza = CORNICE_SUPERIORE.length() - titolo.length() - 2;
	}
	
	/** Metodo per bloccare l'esecuzione per un numero dato di millisecondi (utile per rendere più chiara la presentazione a video)
	 * @param millisecondi Durata della pausa in millisecondi
	 */
	public static void wait(int millisecondi) {
	    
		try {
			Thread.sleep(millisecondi);
	    } catch (InterruptedException e) {
	    	System.out.println("Thread is interrupted");
	    }
	}
	
	/** Metodo per stampare la cornice del menu
	 * 
	 */
	private void cornice() {
		
		int i;
		
		System.out.println(CORNICE_SUPERIORE);
		System.out.print(CORNICE_VERTICALE);
		
		for( i = 0; i < lunghezza/2; i++ ) {
			
			System.out.print(" ");
		}
		
		System.out.print(titolo);
		
		for(; i < lunghezza; i++ ) {
			
			System.out.print(" ");
		}
		
		System.out.println(CORNICE_VERTICALE);
		System.out.println(CORNICE_INFERIORE);
		
	}
		
	/** Metodo di stampa del menu
	 * 
	 */
	public void stampaMenu (){
		
		calcolaLunghezza();
		cornice();
	
		for (int i=0; i<voci.length; i++){
    	
			System.out.println( (i+1) + "\t" + voci[i]);
		}
	
		System.out.println();
		System.out.println(VOCE_USCITA);
		System.out.println();
	}		
}
	
