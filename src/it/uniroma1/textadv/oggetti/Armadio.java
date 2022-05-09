package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un ObjectsContenitore di tipo Armadio 
 */
public class Armadio extends ObjectContenitore {

	/**
	 * Costruttore della classe Armadio che sfrutta il costruttore della superclasse ObjectContenitore
	 * @param nome nome che verrà dato all'ogg
	 * @param parametro nome dell'eventuale parametro dell'ogg Armadio
	 */
	public Armadio(String nome, String parametro) {
		super(nome, parametro);
	}
	
	/**
	 * Override del metodo apri della classe ObjectContenitore
	 * @param ob Objects che si vuole usare per aprire l'ogg chiuso
	 */
	@Override
	public void apri(Objects ob) {
		super.apri(ob);
	}
	
}
