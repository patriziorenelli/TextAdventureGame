package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;
import it.uniroma1.textadv.Objects;

/**
 * Classe Porta che rappresenta un Link specifico per collegare 2 Room
 * @author Patrizio
 *
 */
public class Porta extends Link{

	/**
	 * Costuttore della classe Porta che sfrutta il costruttore della superclasse Link
	 * @param nome
	 * @param room1
	 * @param room2
	 */
	public Porta (String nome, String room1, String room2) {
		super(nome,room1, room2);
	}	
	
	

	/**
	 * Metodo che apre la Porta con un determinato oggetto
	 * Controlla se l'oggetto può effettivamente aprire la porta, se può la apre se no gestisce le varie situazioni
	 * @param  oggetto
	 */
	@Override
	public void apri(Objects oggetto) {
		super.apri(oggetto);
	}
	
	
	/**
	 * Metodo apri senza parametri che può essere usato nel caso in cui la porta non sia bloccata
	 */
	@Override
	public void apri() {
		super.apri();
	}
	
}
