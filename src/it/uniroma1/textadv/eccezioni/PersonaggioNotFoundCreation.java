package it.uniroma1.textadv.eccezioni;

public class PersonaggioNotFoundCreation extends Exception{

	public PersonaggioNotFoundCreation(){
		System.out.println("Impossibile creare il mondo! Il personaggio indicato non esiste");
	}
}
