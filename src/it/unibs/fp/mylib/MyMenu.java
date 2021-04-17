package it.unibs.fp.mylib;

import java.io.IOException;

/*
Questa classe rappresenta un menu testuale generico a piu' voci
Si suppone che la voce per uscire sia sempre associata alla scelta 0 
e sia presentata in fondo al menu

*/
public class MyMenu {
	
	final private static String CORNICE_SUPERIORE = "╔═══════════════════════════════╗";
	final private static String CORNICE_VERTICALE = "║";
	final private static String CORNICE_INFERIORE = "╚═══════════════════════════════╝";
	final private static String VOCE_USCITA = "0\tEsci";				
	final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";
	
	private String titolo;
	private String [] voci;
	private int lunghezza;
		
	public MyMenu (String titolo, String [] voci){
		  
		this.titolo = titolo;
		this.voci = voci;
	}

	public int scegli (){
	  
		stampaMenu();
	
		return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.length);	 
	}
	
	private void calcolaLunghezza() {
		
		lunghezza = CORNICE_SUPERIORE.length() - titolo.length() - 2;
	}
	
	public static void wait(int millisecondi) {
	    
		try {
			Thread.sleep(millisecondi);
	    } catch (InterruptedException e) {
	    	System.out.println("Thread is interrupted");
	    }
	}
	
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
	
