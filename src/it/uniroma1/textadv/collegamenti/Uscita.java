package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;
/**
 * Classe Uscita che rappresenta un Link specifico 
 */
public class Uscita extends Link{

	/**
	 * Costruttore della classe Uscita che sfrutta  il costruttore della superclasse Link
	 * @param nome
	 * @param room1
	 * @param room2
	 */
	public Uscita(String nome, String room1, String room2) {
		super(nome, room1, room2);
	}

}
