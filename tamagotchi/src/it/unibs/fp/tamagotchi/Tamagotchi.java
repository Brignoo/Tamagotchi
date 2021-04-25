package it.unibs.fp.tamagotchi;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.EstrazioniCasuali;

/**
 * <p>
 * La classe <strong>Tamagotchi</strong> contiene tute le informazioni del tamagotchi
 * al suo interno si trovano i metodi per modificare lo stato del tamagotchi
 * </p>
 * 
 * @version 1.0
 */

public class Tamagotchi {
	
	private static final int MAX_SAZIETA = 100;
	private static final int MIN_SAZIETA = 0;
	private static final int MAX_SODDISFAZIONE = 100;
	private static final int MIN_SODDISFAZIONE = 0;

	private static final double VARIAZIONE_POSITIVA = 0.5;
	private static final double VARIAZIONE_NEGATIVA = 0.3;
	private static final double MAX_MOLTIPLICATORE = 1.0;
	private static final double MIN_MOLTIPLICATORE = 0.0;
	
	private static final int FELICITA_SAZIETA = 80;
	private static final int FELICITA_SODDISFAZIONE = 80;
	private static final int TRISTEZZA_SAZIETA_MAX = 90;
	private static final int DECREMENTO = 5;

	private static final int MAX_AZIONE = 15;
	private static final int MIN_AZIONE = 5;
	
	/**
	 * Indica il <strong>grado di soddisfazione</strong> costantemente aggiornato del Tamagotchi
	 */
	private double soddisfazione;
	/**
	 * Indica il <strong>grado di sazietà</strong> costantemente aggiornato del Tamagotchi
	 */
	private double sazieta;
	/**
	 * Indica il <strong>nome</strong> del Tamagotchi
	 */
	private String nome;
	/**
	 * Indica il <strong>moltiplicatore di sazietà</strong> che viene applicato al numero di biscotti che l'utente decide di dare al Tamagotchi 
	 */
	private double punti_biscotto;
	/**
	 * Indica il <strong>moltiplicatore di carezze</strong> che viene applicato al numero di carezze che l'utente decide di dare al Tamagotchi 
	 */
	private double punti_carezza;
	
	/**
	 * Crea un oggetto della classe <strong>Tamagotchi</strong> specificando il
	 * <em>nome</em>, la <em>sazietà</em> e la <em>soddisfazione</em> ricevuti dalla classe
	 * <a href="TamaMain.html">TamaMain</a>.
	 * 
	 * @param nome				Indica il <em>nome</em> del Tamagotchi
	 * @param sazieta			Indica il grado iniziale di <em>sazietà</em> del Tamagotchi
	 * @param soddisfazione		Indica il grado iniziale di <em>soddisfazione</em> del Tamagotchi
	 */
	public Tamagotchi( String nome, double sazieta, double soddisfazione ) {
		
		this.nome = nome;
		this.soddisfazione = soddisfazione;
		this.sazieta = sazieta;
		this.punti_carezza = MAX_MOLTIPLICATORE;
		this.punti_biscotto = MAX_MOLTIPLICATORE;
	}

	/**
	 * Restituisce il <strong>nome</strong> del <em>Tamagotchi</em>
	 * 
	 * @return Una <code>String</code> rappresentante il <strong>nome</strong> del <em>Tamagotchi</em>
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Restituisce un <strong>numero casuale</strong> compreso tra <em>MIN_AZIONE</em> e <em>MAX_AZIONE</em>
	 * 
	 * @return Il numero casuale di tipo <code>int</code> estratto dalla funzione <em>EstrazioniCasuali.estraiIntero</em>
	 */
	public static int getRandomInt( ) {

		return EstrazioniCasuali.estraiIntero(MIN_AZIONE, MAX_AZIONE);
	}

	/**
	 * Imposta il <strong>nome</strong> del <em>Tamagotchi</em>
	 * 
	 * @param nome Valore da assegnare al <strong>nome</strong>
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Esegue il return del <strong>numero minimo</strong> dei due passati
	 *  come parametri, usando la funzione <em>Math.min()</em>
	 *  
	 * @param aumentato Il primo parametro passato alla funzione <strong>Math.min()</strong>
	 * @param riferimento Il secndo parametro passato alla funzione <strong>Math.min()</strong>
	 * @return Il numero di tipo <code>double</code> estratto dalla funzione <em>Math.min()</em>
	 */
	public double maxPunteggio(double aumentato, double riferimento ){

		return Math.min(aumentato, riferimento);
	}

	/**
	 * Esegue il return del <strong>numero massimo</strong> dei due passati
	 *  come parametri, usando la funzione <em>Math.max()</em>
	 *  
	 * @param diminuito Il primo parametro passato alla funzione <strong>Math.max()</strong>
	 * @param riferimento Il secndo parametro passato alla funzione <strong>Math.max()</strong>
	 * @return Il numero di tipo <code>double</code> estratto dalla funzione <em>Math.max()</em>
	 */
	public double minPunteggio( double diminuito, double riferimento ){

		return Math.max(diminuito, riferimento);
	}
	
	/**
	 * Questo metodo viene richiamato dalla classe <a href="TamaMain.html">TamaMain</a>
	 * quando l'utente vuole dare delle carezze al <em>Tamagotchi</em>
	 */
	public void accarezza( ) {

		int n = getRandomInt();

		this.soddisfazione +=  n * this.punti_carezza;
		this.sazieta -= DECREMENTO;

		this.punti_biscotto = aumentaPunteggio(this.punti_biscotto);
		this.punti_carezza = diminuisciPunteggio(this.punti_carezza);

		this.soddisfazione = maxPunteggio(this.soddisfazione, MAX_SODDISFAZIONE);
		this.sazieta = minPunteggio(this.sazieta, MIN_SAZIETA);

		this.punti_biscotto = maxPunteggio(this.punti_biscotto, MAX_MOLTIPLICATORE);
		this.punti_carezza = minPunteggio(this.punti_carezza, MIN_MOLTIPLICATORE);
	}
	
	/**
	 * Questo metodo viene richiamato dalla classe <a href="TamaMain.html">TamaMain</a>
	 * quando l'utente vuole nutrire il <em>Tamagotchi</em>
	 */
	public void nutri( ) {

		int n = getRandomInt();
		
		this.sazieta +=  n * this.punti_biscotto;
		this.soddisfazione -= DECREMENTO;

		this.punti_carezza = aumentaPunteggio(this.punti_carezza);
		this.punti_biscotto = diminuisciPunteggio(this.punti_biscotto);

		this.sazieta = maxPunteggio(this.sazieta, MAX_SAZIETA);
		this.soddisfazione = minPunteggio(this.soddisfazione, MIN_SODDISFAZIONE);

		this.punti_carezza = maxPunteggio(this.punti_carezza, MAX_MOLTIPLICATORE);
		this.punti_biscotto = minPunteggio(this.punti_biscotto, MIN_MOLTIPLICATORE);
	}

	/** 
	 * Aumenta il valore del moltiplicatore di sazietà o soddisfazione (necessario per diminuire l'effetto di azioni ripetute)
	 * 
	 * @param aumenta Valore di tipo <code>double</code> corrispondente al moltiplicatore prima della variazione
	 * @return Esegue un return del valore aumentato del moltiplicatore
	 */
	private double aumentaPunteggio(double aumenta){

		 return aumenta + VARIAZIONE_POSITIVA;
	}

	/** 
	 * Diminuisce il valore del moltiplicatore di sazietà o soddisfazione (necessario per diminuire l'effetto di azioni ripetute)
	 * 
	 * @param diminuisci Valore di tipo <code>double</code> corrispondente al moltiplicatore prima della variazione
	 * @return Esegue un return del valore diminuito del moltiplicatore
	 */
	private double diminuisciPunteggio(double diminuisci){

		return diminuisci - VARIAZIONE_NEGATIVA;
	}
	
	/**
	 * Questa funzione viene utilizzate per controllare se il <em>Tamagotchi</em>
	 *  felice o triste.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà
	 *  <em>vero</em> se il <em>Tamagotchi</em> risulta felice,
	 *  <em>falso</em> se triste.
	 */
	public boolean isFelice() {
		
		if( this.sazieta > FELICITA_SAZIETA && this.soddisfazione > FELICITA_SODDISFAZIONE && this.sazieta < TRISTEZZA_SAZIETA_MAX) {
			
			return true;
		}

		return false;
	}

	/**
	 * Questa funzione viene utilizzate per controllare se il <em>Tamagotchi</em>
	 *  è vivo.
	 * 
	 * @return Esegue un return di tipo <code>boolean</code> che sarà
	 *  <em>vero</em> se il <em>Tamagotchi</em> risulta vivo,
	 *  <em>falso</em> se morto.
	 */
	public boolean isVivo( ) {

		if(this.soddisfazione == 0 || this.sazieta == 0 || this.sazieta == MAX_SAZIETA){

			return false;
		}

		return true;
	}

	/**
	 * Restituisce una rappresentazione leggibile di un oggetto della classe
	 * <strong>Tamagotchi</strong>
	 * 
	 * @return Una <code>String</code> che rappresenta un <strong>Tamagotchi</strong>
	 */
	public String toString() {

		String s = String.format("Sazietà: %.2f Soddisfazione: %.2f", this.sazieta, this.soddisfazione);

		return BelleStringhe.incorniciaECentra( s );
	}
}
