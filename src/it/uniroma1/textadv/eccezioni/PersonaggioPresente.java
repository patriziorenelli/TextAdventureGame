package it.uniroma1.textadv.eccezioni;

/**
 * Eccezione che viene sollevata nel caso in cui si stia cercando di inserire un personaggio che già esiste con quelle specifiche in un altra stanza 
 *
 */
public class PersonaggioPresente extends Exception{

	public PersonaggioPresente() {
		System.out.println("Il seguente personaggio è già presente in qualche altra stanza");
	}
}