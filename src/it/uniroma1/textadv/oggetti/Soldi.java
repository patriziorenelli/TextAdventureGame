package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;

/**
 * Classe che rappresenta un Objects specifico di tipo Soldi
 */
public class Soldi extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Soldi che sfrutta il costruttore della superclasse Objects
	 * @param nome
	 * @param parametro
	 */
	public Soldi(String nome, String parametro) {
		super(nome, parametro);
	}

}
