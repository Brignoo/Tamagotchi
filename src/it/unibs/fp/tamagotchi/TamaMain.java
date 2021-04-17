package it.unibs.fp.tamagotchi;

import it.unibs.fp.mylib.MyInputDati;
import it.unibs.fp.mylib.MyMenu;

public class TamaMain {

	private static final int MAX_SAZIETA = 100;
	private static final int MIN_SAZIETA = 10;
	private static final int MAX_SODDISFAZIONE = 100;
	private static final int MIN_SODDISFAZIONE = 10;
	final private static int PAUSA = 1500;

	private static final String NUOVO = "Inserisci il nome del tuo tamagotchi\n";
	private static final String SAZIETA = "Inserisci il livello di sazietà: ";
	private static final String SODDISFAZIONE = "Inserisci il livello di soddisfazione: ";
	
	private static final String VOCE_1 = "Accarezza";
	private static final String VOCE_2 = "Nutri";
	private static final String[] MENU = {VOCE_1, VOCE_2};
	private static final String TITOLO = "TAMAGOTCHI";
	
	private static void inizio() {
		
		System.out.println(TITOLO);
	}

	private static Tamagotchi creaTamagotchi(){

		String nome;
		int sazieta, soddisfazione;

		nome = MyInputDati.leggiStringaAlfabetica( NUOVO );
		sazieta = MyInputDati.leggiIntero( SAZIETA, MIN_SAZIETA, MAX_SAZIETA );
		soddisfazione = MyInputDati.leggiIntero( SODDISFAZIONE, MIN_SODDISFAZIONE, MAX_SODDISFAZIONE );

		return new Tamagotchi(nome, sazieta, soddisfazione);
	}
			
	public static void main(String[] args) {

		int scelta, num;
		MyMenu menu;
		Tamagotchi t;
		
		inizio();
		t = creaTamagotchi();

		menu = new MyMenu(TITOLO, MENU);
		
		do{
			
			menu.wait(PAUSA);
			System.out.println( t );
			scelta = menu.scegli();

			switch( scelta ) {

				case 1:
					t.accarezza();
					break;

				case 2:
					t.nutri();
					break;
			}
		}
		while( scelta != 0 );
	}
}
