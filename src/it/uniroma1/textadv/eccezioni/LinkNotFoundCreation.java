package it.uniroma1.textadv.eccezioni;

public class LinkNotFoundCreation extends Exception{

	public LinkNotFoundCreation(){
		System.out.println("Impossibile creare il mondo! Il link indicato non esiste");
	}
}
