package it.uniroma1.textadv.eccezioni;

/**
* Eccezione che viene sollevata in cui si stia cercando di creare un link ma la sua classe non esiste 
*
*/
public class ClasseLink extends Exception{

	public ClasseLink() {
		System.out.println("La classe del link che si vuole creare non esiste ");
	}
	
}