package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;
import it.uniroma1.textadv.Objects;
/**
 * Collegamento Botola derivante dalla classe Link
 */
public class Botola extends Link{

	/**
	 * Costuttore della classe Botola che sfrutta il costruttore della superclasse Link
	 * @param nome nome che verrà dato alla Botola generata
	 * @param room1 nome della 1' stanza che la botola collega
	 * @param room2 nome della 2' stanza che la botola collega 
	 */
	public Botola(String nome, String room1, String room2) {
		super(nome,room1, room2);
	}
	

	/**
	 * Metodo che apre la Botola con un determinato oggetto
	 * Controlla se l'oggetto può effettivamente aprire la botola, se può la apre se no gestisce le varie situazioni
	 * @param  oggetto Objects che si vuole usare per aprire la botola 
	 */
	@Override
	public void apri(Objects oggetto) {
		super.apri(oggetto);
	}
	
	
	/**
	 * Metodo apri senza parametri che può essere usato nel caso in cui la botola non sia bloccata
	 */
	@Override
	public void apri() {
		super.apri();
	}
	
	

}
