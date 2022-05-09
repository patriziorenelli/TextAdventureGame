package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Objects di tipo specifico Tronchesi
 */
public class Tronchesi extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Tronchesi che sfrutta il supercostruttore della classe Objects 
	 * @param nome 
	 * @param parametro 
	 */
	public Tronchesi(String nome, String parametro) {
		super(nome, parametro);
	}

}
