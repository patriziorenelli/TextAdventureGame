package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Objects specifico di tipo Pasterella 
 */
public class Pastarella extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Pastarella che sfrutta il costruttore della classe Objects 
	 * @param nome
	 * @param parametro
	 */
	public Pastarella(String nome, String parametro) {
		super(nome, parametro);
	}

}
