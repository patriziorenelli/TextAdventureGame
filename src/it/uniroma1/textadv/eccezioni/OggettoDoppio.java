package it.uniroma1.textadv.eccezioni;
/**
 * Classe che gestisce l'eccezione nel caso in cui si cerchi di generare un oggetto ma il nome è già stato usato 
 * @author Patrizio
 *
 */
public class OggettoDoppio extends Exception{

	public OggettoDoppio() {
		System.out.println("Impossibile creare il mondo! L'oggetto esite già in un altra stanza");
	}
	
}
