package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta un Objects specifico di tipo specifico Pozzo
 */
public class Pozzo extends Objects{

	/**
	 * Costruttore della classe Pozzo che sfrutta il costruttore della superclasse Objects
	 * @param nome 
	 * @param parametro 
	 */
	public Pozzo(String nome, String parametro) {
		super(nome, parametro);
	}
	
	
	/**
	 * Override del metodo usa della classe Objects
	 * @param stanzaAttuale 
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Room stanzaAttuale) throws LinkNotFound  {
		super.usa(stanzaAttuale);
	}
	
	/**
	 * Override del metodo usa della classe Objects 
	 * @param ob 
	 * @param stanzaAttuale 
	 */
	@Override
	public void usa(Objects ob, Room stanzaAttuale) {
		if( Secchio.class.isAssignableFrom(ob.getClass()) ) {
			((Secchio) ob).riempi();
			System.out.println("Secchio riempito");
		}else {
			System.out.println("Non posso riempire cose diverse dal secchio");
		}

	}
	

}
