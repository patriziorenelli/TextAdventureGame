package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Objects specifico di tipo Palina
 */
public class Palina extends Objects{

	/**
	 * Costruttore della classe Palina che sfrutta il costruttore della classe Objects
	 * @param nome
	 * @param parametro
	 */
	public Palina(String nome, String parametro) {
		super(nome, parametro);
	}

	/**
	 * Override del metodo toString di Objects 
	 */
	@Override
	public String toString() {
		return "			PALINA AUTOBUS\n		Tutte le linee sono sospese ad eccezione del 542\n			Arrivo previsto del 542 tra 22 MINUTI" ;
	}
}
