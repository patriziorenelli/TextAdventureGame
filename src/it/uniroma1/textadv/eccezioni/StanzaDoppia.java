package it.uniroma1.textadv.eccezioni;

/**
 * Classe che si occupa di gestire l'eccezione per la creazione di più stanze con lo stesso nome 
 * @author Patrizio
 *
 */
public class StanzaDoppia extends Exception{
	public StanzaDoppia() {
		System.out.println("Si è già creata una stanza con questo nome");
	}
}
