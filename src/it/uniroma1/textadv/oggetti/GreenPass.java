package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;

/**
 * Classe che rappresenta un Objects specifico di tipo GreenPass
 */
public class GreenPass extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe GreenPass che richiama il costruttore della superclasse Objects
	 * @param nome nome del GreenPass 
	 * @param parametro  nome del parametro dell'ogg GreenPass
	 */
	public GreenPass(String nome, String parametro) {
		super(nome, parametro);
	}

}
