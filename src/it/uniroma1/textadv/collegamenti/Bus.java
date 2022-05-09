package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta il mezzo di trasporto Bus che viene estesa da Link
 */
public class Bus extends Link{

	/**
	 * Costruttore della classe Bus che sfrutta il costruttore della superclasse Link
	 * @param nome nome che verrà dato al Bus generato
	 * @param room1 nome della 1' stanza che il bus collega
	 * @param room2 nome della 2' stanza che il bus collega 
	 */
	public Bus(String nome, String room1, String room2) {
		super(nome,room1, room2);
		this.closed = false;
	}
	
}
