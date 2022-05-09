package it.uniroma1.textadv.eccezioni;
/**
 * Eccezione nel caso si creino link con lo stesso nome 
 * @author Patrizio
 *
 */
public class LinkDoppio extends Exception{

	public LinkDoppio() {
		System.out.println("E' stato già creato un link con lo stesso nome ");
	}
	
}
