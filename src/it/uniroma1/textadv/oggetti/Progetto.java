package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rapprenta un Objects specifico di tipo Progetto
 */
public class Progetto extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Progetto che sfrutta il costruttore della classe Objects
	 * @param nome 
	 * @param parametro
	 */
	public Progetto(String nome, String parametro) {
		super(nome, parametro);
	}

}
