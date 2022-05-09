package it.uniroma1.textadv.eccezioni;

/**
 * Classe che si occupa di gestire l'eccezione per la creazione di pi� stanze con lo stesso nome 
 * @author Patrizio
 *
 */
public class StanzaDoppia extends Exception{
	public StanzaDoppia() {
		System.out.println("Si � gi� creata una stanza con questo nome");
	}
}
