package it.uniroma1.textadv.eccezioni;
/**
 * Eccezione che viene sollevata in cui si stia cercando di creare un personaggio ma la sua classe non esiste 
 *
 */
public class ClassePersonaggio extends Exception{

	public ClassePersonaggio() {
		System.out.println("La classe del personaggio che si vuole creare non esiste ");
	}
	
}