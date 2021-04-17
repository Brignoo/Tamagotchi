package it.unibs.fp.mylib;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyInputDati {
	
	  private static Scanner lettore = creaScanner();
	  
	  private final static String ERRORE_FORMATO = "ATTENZIONE: il dato inserito non e' nel formato corretto! ";
	  private final static String ERRORE_MINIMO = "ATTENZIONE: e' richiesto un valore maggiore o uguale a ";
	  private final static String ERRORE_STRINGA_VUOTA = "ATTENZIONE: non hai inserito alcun carattere";
	  private final static String ERRORE_MASSIMO = "ATTENZIONE: e' richiesto un valore minore o uguale a ";
	  private final static String ERRORE_DATA_COMPRESA = "ATTENZIONE: l'età deve essere compresa tra %i e %i \n\n";
	  private final static String ERRORE_STRINGA_NON_ALFANUMERICA = "ATTENZIONE: è necessario inserire una stringa contentente almeno un carattere alfanumerico";
	  private final static String ERRORE_STRINGA_NON_ALFABETICA = "ATTENZIONE: è necessario inserire una stringa contentente solo caratteri alfabetici";
	  private final static String MESSAGGIO_AMMISSIBILI = "ATTENZIONE: i caratteri ammissibili sono: ";
	  private final static String MESSAGGIO_FORMATO = "Il formato ammissibile è %s:";
	  private static final String ALFANUMERICO = "abcdefghijklmnopqrstuvwxyzABCDEFGHILMNOPQRSTUVWXYZ124567890";
	  private static final String ALFABETICO = "abcdefghijklmnopqrstuvwxyzABCDEFGHILMNOPQRSTUVWXYZ";

	  private final static char RISPOSTA_SI='S';
	  private final static char RISPOSTA_NO='N';
 
	  private static Scanner creaScanner () {
		  
		  Scanner creato = new Scanner(System.in);
		  creato.useDelimiter(System.getProperty("line.separator"));
		  
		  return creato;
	  }
	  
	  public static String leggiStringa (String messaggio) {
		  
		  System.out.print(messaggio);
		  return lettore.next();
	  }
	  
	  public static String leggiStringaNonVuota(String messaggio) {
		  
		  boolean finito=false;
		  String lettura = null;

		  do {

			  lettura = leggiStringa(messaggio);
			  lettura = lettura.trim();
			  
			  if (lettura.length() > 0) {
				  
				  finito=true;
			  }
			  else {
				  
				  System.out.println(ERRORE_STRINGA_VUOTA);
			  }
		  } 
		  while (!finito);
	   
		  return lettura;
	  }
	  
	  public static String leggiStringa( String messaggio, String CONSTRAINT, String ERRORE ) {
		  
		  boolean finito=false;
		  String lettura = null, lettura1 = null;
		  int count = 0;

		  do{
			  
			  lettura1 = leggiStringa(messaggio);
			  lettura = lettura1.trim();
			  
			  if (lettura.length() > 0) {
				  
				  finito=true;
			  }
			  else {
				  
				  System.out.println(ERRORE);
				  finito=false;
			  }
			  
			  for ( int i = 0; i < CONSTRAINT.length(); i++ ) {
				  
				  String confronto = "" + CONSTRAINT.charAt(i);
				  
				  if( lettura1.contains(confronto) ) {
					  count ++;
				  }
			  }
			  
			  if (count <= 0) {
				  
				  System.out.println(ERRORE);
				  finito=false;
			  }
			  else {
				  
				  finito=true;
			  }
		  }
		  while(!finito);
		  
		  return lettura;
	  }
	  
	  public static String leggiStringaAlfaNumerica(String messaggio){
		  
		  String lettura = leggiStringa(messaggio, ALFANUMERICO, ERRORE_STRINGA_NON_ALFANUMERICA);
		  
		  return lettura;
	  }
	  
	  public static String leggiStringaAlfabetica(String messaggio){
		  
		  String lettura = leggiStringa(messaggio, ALFABETICO, ERRORE_STRINGA_NON_ALFABETICA);
		  
		  return lettura;
	  }
	  
	  public static char leggiChar (String messaggio) {
		  
		  boolean finito = false;
		  char valoreLetto = '\0';
		  
		  do{
			  
			  System.out.print(messaggio);
			  String lettura = lettore.next();
			  
			  if (lettura.length() > 0) {
				  
				  	valoreLetto = lettura.charAt(0);
				  	finito = true;
			  }
			  else {
				  
				  System.out.println(ERRORE_STRINGA_VUOTA);
			  }
		  } 
		  while (!finito);
		  
		  return valoreLetto;
	  }
	  
	  public static char leggiUpperChar (String messaggio, String ammissibili) {
		  
		  boolean finito = false;
		  char valoreLetto = '\0';
		  
		  do {
			  valoreLetto = leggiChar(messaggio);
			  valoreLetto = Character.toUpperCase(valoreLetto);
			  
			  if (ammissibili.indexOf(valoreLetto) != -1) {
				  
				  finito  = true;
			  }
			  else {
				  
				  System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
			  }
		  } 
		  while (!finito);
		  
		  return valoreLetto;
	  }
	  
	  public static int leggiIntero (String messaggio) {
		  
		  boolean finito = false;
		  int valoreLetto = 0;
	   
		  do{
			  
			  System.out.print(messaggio);
	     
			  try {
				  
				  valoreLetto = lettore.nextInt();
				  finito = true;
			  }
			  catch (InputMismatchException e) {
	       
				  System.out.println(ERRORE_FORMATO);
				  String daButtare = lettore.next();
			  }
		  } 
		  while (!finito);
		  
		  return valoreLetto;
	  }
	  
	  public static Date leggiDataControllo(String messaggio, String formato, int minimo, int massimo) {
		  
		  Date data;
		  int flag = 0;
		  
		  do{ 
			  data = leggiData(messaggio, formato);
			  
			  if ( Calendar.getInstance().get(Calendar.YEAR) - (data.getYear()+1900) >= minimo && 
				  Calendar.getInstance().get(Calendar.YEAR) - (data.getYear()+1900) <= massimo ) {
				  
				  flag = 1;
			  }
			  else {
				  
				  System.out.print( String.format( ERRORE_DATA_COMPRESA, minimo, massimo ) );
			  }
		  }
		  while( flag == 0 );
		  
		  return data;
	  }
	  
	  public static Date leggiData(String messaggio, String formato) {
		  
		  Date data = null;
		  DateFormat datef = new SimpleDateFormat(formato);
		  boolean finito = false;
		  String s;
		  
		  do {
			  
			  System.out.println( messaggio );
		      System.out.print( String.format(MESSAGGIO_FORMATO, formato) );
		      s = lettore.next();
		       
		      try{
		    	  
		    	  data = datef.parse(s);
		    	  datef.setLenient(false) ;
		    	  datef.parse(s);
		    	  finito = true;
		      } 
		      catch (ParseException e) {
		    	 
		    	  System.out.println(ERRORE_FORMATO + formato);
		       }
		  }
		  while( !finito );
	       
	      return data;
	  }

	  public static int leggiInteroPositivo(String messaggio){
		  
		  return leggiInteroConMinimo(messaggio,1);
	  }
	  
	  public static int leggiInteroNonNegativo(String messaggio){
		  
		  return leggiInteroConMinimo(messaggio,0);
	  }
	  
	  public static int leggiInteroConMinimo(String messaggio, int minimo){
		  
		  boolean finito = false;
		  int valoreLetto = 0;
		  
		  do {
			  valoreLetto = leggiIntero(messaggio);
			  
			  if (valoreLetto >= minimo) {
				  finito = true;
			  }
			  else {
				  System.out.println(ERRORE_MINIMO + minimo);
			  }
		  }
		  while (!finito);
	     
		  return valoreLetto;
	  	}

	  public static int leggiIntero(String messaggio, int minimo, int massimo) {
		  
		  boolean finito = false;
		  int valoreLetto = 0;
	   
		  do {
			  
			  valoreLetto = leggiIntero(messaggio);
			  
			  if (valoreLetto >= minimo && valoreLetto<= massimo) {
				  
				  finito = true;
			  }
			  else {
				  if (valoreLetto < minimo) {
					  
					  System.out.println(ERRORE_MINIMO + minimo);
				  }
				  else {
					  
					  System.out.println(ERRORE_MASSIMO + massimo); 
				  }
			  }
		  } 
		  while (!finito);
	     
		  return valoreLetto;
	  	}
	  
	  public static double leggiDouble (String messaggio) {
		  
		  boolean finito = false;
		  double valoreLetto = 0;
	   
		  do{
			  
			  System.out.print(messaggio);
	     
			  try {
				  
				  valoreLetto = lettore.nextDouble();
				  finito = true;
			  }
			  catch (InputMismatchException e){
				  
				  System.out.println(ERRORE_FORMATO);
				  String daButtare = lettore.next();
			  }
		  }
		  while (!finito);
		  
		  return valoreLetto;
	  }
	 
	  public static double leggiDoubleConMinimo (String messaggio, double minimo){
		  
		  boolean finito = false;
		  double valoreLetto = 0;
		  
		  do {
	     
			  valoreLetto = leggiDouble(messaggio);
	     
			  if (valoreLetto >= minimo) {
				  
				  finito = true;
			  }
			  else {
				  
				  System.out.println(ERRORE_MINIMO + minimo);
			  }
		  }
		  while (!finito);
	     
		  return valoreLetto;
	  }

	  public static boolean yesOrNo(String messaggio) {
		  
		  String mioMessaggio = messaggio + "("+RISPOSTA_SI+"/"+RISPOSTA_NO+")";
		  char valoreLetto = leggiUpperChar(mioMessaggio,String.valueOf(RISPOSTA_SI)+String.valueOf(RISPOSTA_NO));
		  
		  if (valoreLetto == RISPOSTA_SI) {
			  
			return true;
		  }
		  else {
			  
			return false;
		  }
	  }
}
