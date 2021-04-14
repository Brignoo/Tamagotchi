package it.unibs.fp.tamagotchi;

import it.unibs.fp.mylib.MyInputDati;

public class TamaMain {
	
	private static final int MAX_CAREZZE = 20;
	private static final int MIN_CAREZZE = 0;
	private static final int MAX_BISCOTTI = 20;
	private static final int MIN_BISCOTTI = 0;
	
	private static final String ATTENZIONE = "Attenzione selezionare un numero consentito";
	private static final String CAREZZE = "Quante carezze vuoi dare al tuo tamagotchi: ";
	private static final String BISCOTTI = "Quante biscotti vuoi dare al tuo tamagotchi: ";
	private static final String NUOVO = "Inserisci il nome del tuo tamagotchi\n";
	private static final String MENU = "Cosa vuoi fare? \n"
									 + " 1 = accarezza \n"
									 + " 2 = nutri \n"
									 + " 0 = ESCI \n";
	
	private static void inizio() {
		
		System.out.println("TAMAGOTCHI");
	}
			
	public static void main(String[] args) {
		
		String nome;
		Tamagotchi t;
		int scelta, num;
		
		inizio();
		
		nome = MyInputDati.leggiStringa( NUOVO );
		t = new Tamagotchi(nome);
		
		do{
			
			System.out.println( t.toString() );
			scelta = MyInputDati.leggiIntero( MENU );
			
			switch( scelta ) {
				case 0:
					break;
					
				case 1:	
					num = MyInputDati.leggiIntero(CAREZZE, MIN_CAREZZE, MAX_CAREZZE);
					t.accarezza(num);
					break;
						
				case 2:
					num = MyInputDati.leggiIntero(BISCOTTI, MIN_BISCOTTI, MAX_BISCOTTI);
					t.nutri(num);
					break;
				
				default:
					System.out.println(ATTENZIONE);
					break;
			}
		}
		while( scelta != 0 );
	}
}
