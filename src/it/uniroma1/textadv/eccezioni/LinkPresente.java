package it.uniroma1.textadv.eccezioni;

public class LinkPresente extends Exception {

	public LinkPresente() {
		System.out.println("Il link  è già stato associato ");
	}
}
