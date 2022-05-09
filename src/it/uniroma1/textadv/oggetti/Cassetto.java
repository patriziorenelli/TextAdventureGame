package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un ObjectsContenitore di tipo Cassetto 
 */
public class Cassetto extends ObjectContenitore{

	/**
	 * Costruttore della classe Cassetto che sfrutta il costruttore della superclasse ObjectContenitore
	 * @param nome nome dell'ogg Cassetto da creare 
	 * @param parametro nome dell'eventuale parametro
	 */
	public Cassetto(String nome, String parametro) {
		super(nome, parametro);
	}

	/**
	 * Override del metodo apri della classe ObjectContenitore
	 */
	@Override
	public void apri() {
		super.apri();
	}
	

}
