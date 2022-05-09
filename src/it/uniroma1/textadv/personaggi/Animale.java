package it.uniroma1.textadv.personaggi;

import it.uniroma1.textadv.Character;

/**
 * Classe astratta che rappresenta un Animale generico derivante da Character
 */
public abstract class Animale extends Character{

	/**
	 * Costruttore della classe Animale che sfrutta la classe Character
	 * @param nome nome che verrà dato all'ogg Animale
	 */
	public Animale(String nome) {
		super(nome);
	}
	

	/**
	 * Costruttore della classe Animale che sfrutta la classe Character
	 * @param nome nome che verrà dato all'ogg Animale
	 * @param oggetti lista di String contenente i nomi degli eventuali parametri dell'ogg
	 */
	public Animale(String nome,String[] oggetti) {
		super(nome,oggetti);
	}
	
	/**
	 * Metodo accarezza di un animale 
	 */
	public void accarezza() {		
	}

}
