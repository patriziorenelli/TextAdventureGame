package it.uniroma1.textadv.personaggi;

import it.uniroma1.textadv.Element;
import it.uniroma1.textadv.Giocatore;
import it.uniroma1.textadv.Room;

/**
 * Classe che rappresenta un Pasticciere che è un Venditore specifico 
 */
public class Pasticciere extends Venditore{

	/**
	 * Costruttore della classe Pasticciere che sfrutta il costruttore della superclasse Venditore
	 * @param nome
	 * @param oggetti
	 */
	public Pasticciere(String nome, String[] oggetti) {
		super(nome, oggetti);
	}
	
	/**
	 * Costruttore della classe Pasticciere che sfrutta il costruttore della superclasse Venditore
	 * @param nome
	 */
	public Pasticciere(String nome) {
		super(nome);
	}
	
	/**
	 * Metodo sai del Pasticciere
	 * @param personaggio
	 * @param  stanza
	 * @param element
	 */
	public void dai(Giocatore personaggio, Room stanza, Element element){
		super.dai(personaggio, stanza, element);
	}
	

}
