package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Objects specifico di tipo Mascherina 
 */
public class Mascherina extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Mascherina che sfrutta il costruttore della classe Objects
	 * @param nome
	 * @param parametro
	 */
	public Mascherina(String nome, String parametro) {
		super(nome, parametro);
	}

}
