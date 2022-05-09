package it.uniroma1.textadv.eccezioni;

/**
 * Eccezione che viene sollevata nel caso  in cui si stia cercando di inserire un oggetto che già esiste con quelle specifiche in un altra stanza 
 */
public class OggettoPresente extends Exception{

	public OggettoPresente() {
		System.out.println("Impossibile creare il mondo! L'oggetto esite già in un altra stanza");
	}
}
