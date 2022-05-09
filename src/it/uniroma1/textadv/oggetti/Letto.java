package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta un Objects specifico di tipo Letto
 */
public class Letto extends Objects{

	/**
	 * Costruttore della classe Letto che sfrutta il supercostruttore di Objects
	 * @param nome nome del Letto da creare 
	 * @param parametro nome dell'eventuale parametro dell'ogg
	 */
	public Letto(String nome, String parametro) {
		super(nome, parametro);
	}
	
	/**
	 * Override del metodo usa che rappresenta l'azione di dormire  -> viene cantata una ninna nanna al Giocatore per farlo addormentare
	 * @param stanzaAttuale Room stanza attuale del giocatore
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Room stanzaAttuale) throws LinkNotFound {
		System.out.println("\n*.。.*・*°*.。.*・°\n" + "Ninna nanna, ninna oh\r\n"
				+ "Questo bimbo a chi lo do?\r\n"
				+ "Ninna nanna, ninna oh\r\n"
				+ "Questo bimbo a chi lo do?\r\n"
				+ "Se lo do alla Befana\r\n"
				+ "Me lo tiene una settimana\r\n"
				+ "Se lo do al al Bove Nero\r\n"
				+ "Me lo tiene un anno intero\r\n"
				+ "Se lo do al Lupo Bianco\r\n"
				+ "Me lo tiene tanto, tanto\r\n"
				+ "Ninna nanna, nanna fate\r\n"
				+ "Il mio bimbo addormentate\n" + 
				"*.。.*・*°*.。.*・°\n");
	}

}
