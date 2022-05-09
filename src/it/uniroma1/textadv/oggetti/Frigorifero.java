package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Objects specifico di tipo Frigorifero
 */
public class Frigorifero extends Objects{

	/**
	 * Costruttore della classe Frigorifero che sfrutta il costruttore della superclasse Objects
	 * @param nome nome dell'ogg Frigorifero da creare 
	 * @param parametro eventuale nome del parametro dell'ogg
	 */
	public Frigorifero(String nome, String parametro) {
		super(nome, parametro);
	}

	

	/**
	 * Override del metodo apri per il Frigorifero
	 */
	@Override
	public void apri() {
		System.out.println("E' pieno di cibo ma non ti puoi mangiare le cose dal frigo se no Mamma si arrabbia");
	}
	
}
