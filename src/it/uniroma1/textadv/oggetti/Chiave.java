package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta  un Objects specifico di tipo Chiave 
 */
public class Chiave extends Objects implements Inventariabile{

	/**
	 *Costruttore della classe Chiave che sfrutta il costruttore della superclasse Objects
	 * Il parametro per la chiave rappresenta la cosa che può aprire 
	 * @param nome nome della Chiave da creare 
	 * @param parametro eventuale parametro
	 */
	public Chiave(String nome, String parametro) {
		super(nome, parametro);
	}



}
