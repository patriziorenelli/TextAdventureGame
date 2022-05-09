package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;

/**
 * Rappresenta un Link specifico di tipo Macchina
 */
public class Macchina extends Link{

	/**
	 * Costruttore della classe Macchina 
	 * @param nome nome della Macchina da creare 
	 * @param room1 nome della 1' stanza collegata
	 * @param room2 nome della 2' stanza collegata
	 */
	public Macchina(String nome, String room1, String room2) {
		super(nome, room1, room2);
	}
	
	/**
	 * Override del metodo chiudi per la macchina
	 */
	@Override
	public void chiudiConOggetto() {
		System.out.print("BLIP BLIP! ");
		super.chiudiConOggetto();
	}
	
	/**
	 * Override del metodo chiudi della macchina
	 */
	@Override
	public void chiudi() {
		super.chiudi();
	}
	
	
	

}
