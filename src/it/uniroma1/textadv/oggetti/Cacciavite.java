package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Element;
import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta l'Objects specifico di tipo Cacciavite, inoltre l'oggetto implementa l'interfaccia Inventariabile che consente di inserire il seguente oggetto nell'inventario del giocatore
 */
public class Cacciavite extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Cacciavite che sfrutta il costruttore della superclasse Objects 
	 * @param nome nome che verrà dato al Cacciavite creato
	 * @param parametro eventuale nome del parametro dell'ogg
	 */
	public Cacciavite(String nome, String parametro) {
		super(nome, parametro);
	}

	/**
	 * Override del metodo usa della classe Objects 
	 * @param ob Objects su cui viene usato l'ogg
	 * @param stanzaAttuale ogg Room che rappresenta la stanza attuale in cui si trova il giocatore
	 */
	@Override
	public void usa(Objects ob, Room stanzaAttuale) throws LinkNotFound{
		ob.usa(stanzaAttuale);
	}
	
	
}
