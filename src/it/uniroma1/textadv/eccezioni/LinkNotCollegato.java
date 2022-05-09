package it.uniroma1.textadv.eccezioni;

public class LinkNotCollegato extends Exception {

	public LinkNotCollegato() {
		System.out.println("Impossibile creare il mondo! Il link indicato non è collegato con la stanza a cui si vuole collegare");
	}
}
