package it.unibs.fp.tamagotchi;

import it.unibs.fp.mylib.MyInputDati;
import it.unibs.fp.mylib.MyMenu;

public class TamaMain {
	
	private static final int MAX_CAREZZE = 20;
	private static final int MIN_CAREZZE = 0;
	private static final int MAX_BISCOTTI = 20;
	private static final int MIN_BISCOTTI = 0;
	final private static int PAUSA = 1500;
	
	private static final String CAREZZE = "Quante carezze vuoi dare al tuo tamagotchi: ";
	private static final String BISCOTTI = "Quante biscotti vuoi dare al tuo tamagotchi: ";
	private static final String NUOVO = "Inserisci il nome del tuo tamagotchi\n";
	
	private static final String VOCE_1 = "Accarezza";
	private static final String VOCE_2 = "Nutri";
	private static final String[] MENU = {VOCE_1, VOCE_2};
	private static final String TITOLO = "TAMAGOTCHI";
	
	private static void inizio() {
		
		System.out.println(TITOLO);
	}
			
	public static void main(String[] args) {
		
		String nome;
		Tamagotchi t;
		int scelta, num;
		MyMenu menu;
		
		inizio();
		
		nome = MyInputDati.leggiStringaAlfabetica( NUOVO );
		t = new Tamagotchi(nome);
		menu = new MyMenu(TITOLO, MENU);
		
		do{
			
			menu.wait(PAUSA);
			System.out.println( t.toString() );
			scelta = menu.scegli();
			
			switch( scelta ) {
					
				case 1:	
					num = MyInputDati.leggiIntero(CAREZZE, MIN_CAREZZE, MAX_CAREZZE);
					t.accarezza(num);
					break;
						
				case 2:
					num = MyInputDati.leggiIntero(BISCOTTI, MIN_BISCOTTI, MAX_BISCOTTI);
					t.nutri(num);
					break;
			}
		}
		while( scelta != 0 );
	}
}
