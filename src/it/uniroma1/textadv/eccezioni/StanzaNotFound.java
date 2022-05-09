package it.uniroma1.textadv.eccezioni;
/**
 * Classe che gestisce l'eccezione del tentativo di far partire il mondo da una stanza che non esite 
 */
public class StanzaNotFound extends Exception{
	public StanzaNotFound() {
		System.out.println("La stanza non esiste");
	}
}
