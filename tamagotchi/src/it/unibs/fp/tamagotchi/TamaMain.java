package it.unibs.fp.tamagotchi;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.MyInputDati;
import it.unibs.fp.mylib.MyMenu;
/**
 * <p>
 * La classe <strong>TamaMain</strong> è la classe principale dove è racchiuso il
 * main e da cui parte il programma
 * </p>
 * 
 * @version 1.0
 */

public class TamaMain {

	public static final String NUOVO = "Inserisci il nome del tuo tamagotchi: ";
	public static final String SAZIETA = "Inserisci il livello di sazietà: ";
	public static final String SODDISFAZIONE = "Inserisci il livello di soddisfazione: ";

	public static final String VOCE_1 = "Accarezza";
	public static final String VOCE_2 = "Nutri";
	public static final String[] MENU = {VOCE_1, VOCE_2};
	public static final String TITOLO = "TAMAGOTCHI";
	private static final int PAUSA = 1000;

	private static final int MAX_SAZIETA = 90;
	private static final int MIN_SAZIETA = 10;
	private static final int MAX_SODDISFAZIONE = 90;
	private static final int MIN_SODDISFAZIONE = 10;

	public static Tamagotchi creaTamagotchi(){

		String nome;
		int sazieta, soddisfazione;

		nome = MyInputDati.leggiStringaAlfabetica( NUOVO );
		sazieta = MyInputDati.leggiIntero( SAZIETA, MIN_SAZIETA, MAX_SAZIETA );
		soddisfazione = MyInputDati.leggiIntero( SODDISFAZIONE, MIN_SODDISFAZIONE, MAX_SODDISFAZIONE );

		return new Tamagotchi(nome, sazieta, soddisfazione);
	}
	
	/**
	 * 
	 */
	public static void saluto() {

		System.out.println(BelleStringhe.incorniciaECentra(TITOLO));
	}
			
	public static void main(String[] args) {

		int scelta;
		Tamagotchi tama;
		MyMenu menu;

		saluto();
		tama = creaTamagotchi();
		menu = new MyMenu(tama.getNome(), MENU);
		
		do{
			
			if(tama.isVivo()){

				MyMenu.wait(PAUSA);

				System.out.println(tama);
				scelta = menu.scegli();

				switch( scelta ) {

					case 1:
						tama.accarezza();
						break;

					case 2:
						tama.nutri();
						break;
				}
			}
			else{

				System.out.println(tama.getNome() + " è morto :(");
				scelta = 0;
			}
		}
		while( scelta != 0 );
	}
}
