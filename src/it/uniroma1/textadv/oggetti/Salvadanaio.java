package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta un ObjectContenitore specifico di tipo Salvadanaio
 */
public class Salvadanaio extends ObjectContenitore{

	/**
	 * Parametro usato per verificare se il salvadanio è rotto oppure no
	 */
	private boolean rotto;
	
	/**
	 * Costruttore della classe Salvadanaio che sfrutta il costruttore della superclassse ObjectContenitore
	 * @param nome
	 * @param parametro
	 */
	public Salvadanaio(String nome, String parametro) {
		super(nome, parametro);
		rotto = false; 
	}

	/**	
	 * Override del metodo, invocato quando si vuole rompere il salvadanaio, della classe ObjectContenitore
	 */
	@Override
	public void rompi() {
		rotto = true;
		nome = "salvadanaio rotto";
	}

	/**
	 * Override del metodo addOggettoContenuto della classe ObjectContenitore
	 * @param oggettoContenuto
	 */
	@Override
	public void addOggettoContenuto( Objects oggettoContenuto) {
		super.addOggettoContenuto(oggettoContenuto);
	}
	
	/**
	 * Override del metodo prendi della classe ObjectContenitore
	 * @param nomeOggetto
	 */
	@Override
	public Objects prendi(String nomeOggetto) {
		return super.prendi(nomeOggetto);
	}
	
	/**
	 * Override del metodo usa della classe ObjectContenitore
	 * @param stanzaAttuale
	 */
	@Override
	public void usa(Room stanzaAttuale)  {
		this.rompi();
		stanzaAttuale.addObject(prendi());
		System.out.println("Salvadanaio rotto");
	}
	
	/**
	 * Override del metodo usa della classe ObjectContenitore
	 * @param ob 
	 * @param stanzaAttuale 
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Objects ob, Room stanzaAttuale) throws LinkNotFound  {
		super.usa(ob, stanzaAttuale);
	}
	
	
}
