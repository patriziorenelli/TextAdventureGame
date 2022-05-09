package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta un Objects specifico di tipo Martello
 */
public class Martello extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Martello che sfrutta il costruttore presente nella superclasse Objects
	 * @param nome 
	 * @param parametro 
	 */
	public Martello(String nome, String parametro) {
		super(nome, parametro);
	}
	
	
	/**
	 * Override del metodo usa rappresenta l'azione di usare se stesso su un altro 
	 * @param ob 
	 * @param stanzaAttuale 
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Objects ob, Room stanzaAttuale) throws LinkNotFound {
		ob.usa(stanzaAttuale);
	}
	
	/**
	 * Override del metodo usa che rappresenta l'uso dell'oggetto senza farlo interagire con altro
	 * @param stanzaAttuale 
	 */
	@Override
	public void usa(Room stanzaAttuale) {
		System.out.println("Perchè stai scuotendo un martello in aria? ");
	}
	
}
