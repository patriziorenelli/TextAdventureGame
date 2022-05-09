package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;

/**
 * Classe che rapprenta un Objects specifico di tipo Voto
 */
public class Voto extends Objects implements Inventariabile{

	/**
	 * Costruttore della classe Voto che sfrutta il costruttore della superclasse Objects
	 * @param nome
	 * @param parametro 
	 */
	public Voto(String nome, String parametro) {
		super(nome, parametro);
		
	}

}
