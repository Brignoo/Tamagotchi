package it.unibs.fp.tamagotchi;

import java.util.Random;

public class Tamagotchi {

	private static final int MAX_SAZIETA = 100;
	private static final int MIN_SAZIETA = 0;
	private static final int MAX_SODDISFAZIONE = 100;
	private static final int MIN_SODDISFAZIONE = 0;

	private static final double VARIAZIONE_POSITIVA = 0.5;
	private static final double VARIAZIONE_NEGATIVA = 0.3;
	private static final double MAX_MOLTIPLICATORE = 1.0;
	private static final double MIN_MOLTIPLICATORE = 0.1;
	
	private static final int FELICITA_SAZIETA = 80;
	private static final int FELICITA_SODDISFAZIONE = 80;
	private static final int TRISTEZZA_SAZIETA_MIN = 30;
	private static final int TRISTEZZA_SAZIETA_MAX = 90;
	private static final int TRISTEZZA_SODDISFAZIONE = 30;
	private static final int DECREMENTO = 5;

	private static final int MAX_AZIONE = 20;
	private static final int MIN_AZIONE = 10;

	private static final String SEPARATORE = "═════════════════════════════════";
	
	private int soddisfazione;
	private int sazieta;
	private String nome;
	private double punti_biscotto;
	private double punti_carezza;
	
	public Tamagotchi( String nome, int sazieta, int soddisfazione ) {
		
		this.nome = nome;
		this.soddisfazione = soddisfazione;
		this.sazieta = sazieta;
		this.punti_carezza = MAX_MOLTIPLICATORE;
		this.punti_biscotto = MAX_MOLTIPLICATORE;
	}

	public double getSoddisfazione() {

		return soddisfazione;
	}

	public double getSazieta() {

		return sazieta;
	}

	public double maxPunteggio( double aumentato, double riferimento ){

		if ( aumentato >= riferimento ) {

			return riferimento;
		}
		else{

			return aumentato;
		}
	}

	public double minPunteggio( double diminuito, double riferimento ){

		if ( diminuito <= riferimento ) {

			return riferimento;
		}
		else{

			return diminuito;
		}
	}

	public static int getRandomInt( ) {

		Random rand = new Random();
		int n = rand.nextInt((MAX_AZIONE - MIN_AZIONE) + 1) + MIN_AZIONE;

		return n;
	}
	
	public void accarezza( ) {

		int n = getRandomInt();

		this.soddisfazione +=  n * this.punti_carezza;
		this.sazieta -= DECREMENTO;

		this.punti_biscotto = aumentaPunteggio(this.punti_biscotto);
		this.punti_carezza = diminuisciPunteggio(this.punti_carezza);

		this.soddisfazione = (int) maxPunteggio(this.soddisfazione, MAX_SODDISFAZIONE);
		this.sazieta = (int) minPunteggio(this.sazieta, MIN_SAZIETA);

		this.punti_biscotto = maxPunteggio(this.punti_biscotto, MAX_MOLTIPLICATORE);
		this.punti_carezza = minPunteggio(this.punti_carezza, MIN_MOLTIPLICATORE);
	}
	
	public void nutri( ) {

		int n = getRandomInt();
		
		this.sazieta +=  n * this.punti_biscotto;
		this.soddisfazione -= DECREMENTO;

		this.punti_carezza = aumentaPunteggio(this.punti_carezza);
		this.punti_biscotto = diminuisciPunteggio(this.punti_biscotto);

		this.sazieta = (int) maxPunteggio(this.sazieta, MAX_SAZIETA);
		this.soddisfazione = (int) minPunteggio(this.soddisfazione, MIN_SODDISFAZIONE);

		this.punti_carezza = maxPunteggio(this.punti_carezza, MAX_MOLTIPLICATORE);
		this.punti_biscotto = minPunteggio(this.punti_biscotto, MIN_MOLTIPLICATORE);
	}

	private double aumentaPunteggio(double aumenta){

		 return aumenta + VARIAZIONE_POSITIVA;
	}

	private double diminuisciPunteggio(double diminuisci){

		return diminuisci - VARIAZIONE_NEGATIVA;
	}
	
	public String isFelice() {
		
		if( this.sazieta > FELICITA_SAZIETA && this.soddisfazione > FELICITA_SODDISFAZIONE && this.sazieta < TRISTEZZA_SAZIETA_MAX) {
			
			return ": )";
		}
		else if( this.sazieta < TRISTEZZA_SAZIETA_MIN || this.soddisfazione < TRISTEZZA_SODDISFAZIONE || this.sazieta > TRISTEZZA_SAZIETA_MAX ) {
			
			return ": (";
		}
		else {
			
			return ": |";
		}
	}

	public String toString() {

		String felicita = "";
		int lunghezza = SEPARATORE.length() - 5, i = 0;

		for( i = 0; i < lunghezza/2; i++ ) {

			felicita = felicita + " ";
		}

		felicita = felicita + isFelice();

		for(; i < lunghezza; i++ ) {

			felicita = felicita + " ";
		}
		
		return SEPARATORE + "\n" + "Sazietà: " + this.sazieta + "   Soddisfazione: " + this.soddisfazione + "\n" + SEPARATORE + "\n" + felicita + "\n\n";
	}
}
