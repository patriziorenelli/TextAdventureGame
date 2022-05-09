package it.uniroma1.textadv.eccezioni;
/**
 * Classe che gestisce il caso in cui si cerchino di generare diversi personaggi con lo stesso nome 
 * @author Patrizio
 *
 */
public class PersonaggioDoppio extends Exception{

	public PersonaggioDoppio() {
		System.out.println("E' stato già creato un personaggio con lo stesso nome ");
	}
}
