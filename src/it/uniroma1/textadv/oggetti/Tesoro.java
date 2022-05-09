package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Objects specifico di tipo Tesoro
 */
public class Tesoro extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Tesoro che sfrutta il costruttore della classe Objects
	 * @param nome
	 * @param parametro
	 */
	public Tesoro(String nome, String parametro) {
		super(nome, parametro);
	}

}
