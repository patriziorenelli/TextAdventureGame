package it.uniroma1.textadv;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Classe astratta che rappresenta un Link tra più stanze 
 */
public abstract class Link extends ElementChiudibile{

	// stanze collegate 
	protected String room1;
	protected String room2;
	
	/**
	 * Costruttore della classe Link che sfrutta il costuttore della superclasse ElementChiudibile
	 * Ha come parametri il mome del link e i nomi delle due stanze collegate 
	 * @param nome nome che verrà dato al Link generato
	 * @param room1 nome della 1' stanza che il link collega
	 * @param room2 nome della 2' stanza che il link collega 
	 */
	public Link(String nome, String room1, String room2) {
		super(nome);
		this.room1 = room1;
		this.room2 = room2;
	}
	

	/**
	 * Override del metodo equals fatto appositamente per la classe Link
	 */
	@Override 
	public boolean equals(Object li) {
		Link link= null;
		
		if(li instanceof Link) {
			link = (Link) li;
			return link.nome.equals(this.nome);
		}else {	
			return false;		 
		}
	}
	
	/**
	 * Metodo che ritorna il nome del Link
	 * @return String nome
	 */
	@Override
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo che ritorna il nome della prima stanza collegata 
	 * @return String room1
	 */
	public String getRoom1() {
		return room1;
	}
	
	/**
	 * Metodo che ritorna il nome della seconda stanza collegata 
	 * @return String room2
	 */
	public String getRoom2() {
		return room2;
	}
	
	/**
	 * Metodo che gestisce se il link è attivo o no e se quindi può essere usato per spostarsi
	 * @return boolean 
	 */
	public boolean vai() {
		if (!lock && !closed)
			return true;
		if(lock) {
			System.out.println(this.getNome() + " bloccato");
			return false;
		}
		
		if(!lock && closed) {
			System.out.println(this.getNome() + " chiuso ");
			return false;
		}
		
		if(!lock && closed) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Metodo che ritorna un array di stringhe contenente il nome delle due stanze 
	 * @return String[] 
	 */
	public String[] getNomiStanze() {
		return  new String[]{this.getRoom1(), this.getRoom2() };
	}
	
	/**
	 * Metodo che ritorna il nome dell'altra stanza collegata dal link 
	 * @param nome nome della stanza che non si vuole prendere dal Link
	 * @return String 
	 */
	public String getNomeStanzaCollegata(String nome) {
		if(nome.equals(this.getRoom1()))
			return this.getRoom2();
		return this.getRoom1();
		
	}


	/**
	 * Metodo standard che sblocca e apre il link ritorna il nome dell'altra stanza a cui si viene portati sfruttando il link
	 * @param nomeStanza nome della stanza che non si vuole prendere dal Link
	 * @return String
	 */
	public  String usa( String nomeStanza) {
		super.sblocca();
		super.apri();
		return getNomeStanzaCollegata(nomeStanza);
	}
	
	
	
	
}
