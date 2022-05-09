package it.uniroma1.textadv.eccezioni;

public class OggettoNotFoundCreation extends Exception{

	public OggettoNotFoundCreation(){
		System.out.println("Impossibile creare il mondo! L'oggetto indicato non esiste");
	}
}
