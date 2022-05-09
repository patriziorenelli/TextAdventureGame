package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;
/**
 * Classe Scale specifica di un Link per collegare 2 Room
 */
public class Scale extends Link{

	/**
	 * Costruttore della classe Scale che sfrutta il costruttore della superclasse Link
	 * @param nome
	 * @param room1
	 * @param room2
	 */
	public Scale(String nome, String room1, String room2) {
		super(nome, room1, room2);
		super.closed = false;
		super.lock = false;
	}

}
