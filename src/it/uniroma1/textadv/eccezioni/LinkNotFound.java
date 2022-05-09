package it.uniroma1.textadv.eccezioni;
/**
 * Classe che gestisce il caso in cui non si trovi un link
 */
public class LinkNotFound extends Exception{

	public  LinkNotFound() {
		System.out.println("Il link non esiste");
	}
}
