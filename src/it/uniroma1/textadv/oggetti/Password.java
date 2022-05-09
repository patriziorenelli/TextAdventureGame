package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta l'Objects specifico di tipo Password
 */
public class Password extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Password che sfrutta il costruttore della superclasse Objects 
	 * @param nome 
	 * @param parametro 
	 */
	public Password(String nome, String parametro) {
		super(nome, parametro);
	}

	
	/**
	 * Override del metodo usa rappresenta l'azione di usare la password su un oggetto computer che dovrà poi permettere di prendere l'oggetto all'interno 
	 * @param ob 
	 * @param stanzaAttuale 
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Objects ob, Room stanzaAttuale) throws LinkNotFound {
		if(Computer.class.isAssignableFrom(ob.getClass())) {
			((Computer) ob).setVisibile();
			System.out.println("Ora puoi prendere " + ((ObjectContenitore) ob).getObjectInside().getNome() +  " da " + ob.getNome());
		}else {
			System.out.println("La password può essere usato solo sul computer");
		}
	}
	
}
