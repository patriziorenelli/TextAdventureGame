package it.uniroma1.textadv.eccezioni;

/**
 * Eccezione che viene sollevata in cui si stia cercando di creare un oggetto ma la sua classe non esiste 
 *
 */
public class ClasseOggetto extends Exception{

	public ClasseOggetto() {
		System.out.println("La classe dell'oggetto che si vuole creare non esiste ");
	}
	
}
