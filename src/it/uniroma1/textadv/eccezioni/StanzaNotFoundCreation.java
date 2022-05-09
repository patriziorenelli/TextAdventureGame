package it.uniroma1.textadv.eccezioni;

public class StanzaNotFoundCreation extends Exception{

	public StanzaNotFoundCreation(){
		System.out.println("Impossibile creare il mondo! La stanza indicata non esiste");
	}
	
}
