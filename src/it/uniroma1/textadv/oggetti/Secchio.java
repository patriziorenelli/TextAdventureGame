package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;

/**
 * Classe che rappresenta un Objects specifico di tipo Secchio
 */
public class Secchio extends Objects implements Inventariabile{

	/**
	 * Parametro che rappresenta sel'oggetto Secchio è pieno o no 
	 */
	private boolean pieno;
	
	/**
	 * Costruttore della classe Secchio che sfrutta il costruttore della superclasse Objects
	 * @param nome
	 * @param parametro
	 */
	public Secchio(String nome, String parametro) {
		super(nome, parametro);
		pieno = false;
	}
	
	
	/**
	 * Override del metodo usa della classe ObjectConenitore
	 * @param ob 
	 * @param stanzaAttuale 
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Objects ob, Room stanzaAttuale) throws LinkNotFound {
		ob.usa( this, stanzaAttuale);
	}

	/**
	 * Metodo che riempe l'oggetto secchio
	 */
	public void riempi() {
		pieno = true;
	}
	
	/**
	 * Metodo che svuota il secchio
	 */
	public void svota() {
		pieno = false;
	}
	
	
	/**
	 * Metodo che ritorna se il secchio è pieno o no 
	 * @return boolean 
	 */
	public boolean isPieno() {
		return pieno;
	}
	
}
