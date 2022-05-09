package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;

/**
 * Classe che rappresenta l'oggetto Camino che è un ObjectContenitore
 */
public class Camino extends ObjectContenitore{

	/** parametro che indica se il camino è acceso o no */
	private boolean acceso;
	
	/**
	 * Costruttore della classe Camino che sfrutta il costruttore della classe ObjectContenitore 
	 * @param nome nome che verrà dato all'ogg Camino creato
	 * @param parametro  eventuale nome dell'ogg da creare 
	 */
	public Camino(String nome, String parametro) {
		super(nome, parametro);
		acceso = true;
	}

	
	
	/**
	 * Override del metodo usa della superclasse ObjectContenitore
	 * @param ob Oggetto che viene usato sull'ogg Camino
	 * @param stanza stanza attuale 
	 */
	@Override
	public void usa(Objects ob, Room stanza) {
			spegni(ob);		
	}

	
	/**
	 * Metodo che spegne il camino se acceso
	 * @param ob
	 */
	private void spegni(Objects ob) {
		if(Secchio.class.isAssignableFrom(ob.getClass())   ) {
			if(((Secchio) ob).isPieno() && acceso) {
				acceso = false;
				((Secchio) ob).svota();
				System.out.println(nome + " spento");
				this.setVisibile();				
			}else if (!((Secchio) ob).isPieno()) {
				System.out.println("Dovresti usare un Secchio");
			}else if(!acceso) {
				System.out.println("Il camino è già spento");
			}
		}else {
			System.out.println("Attento potresti bruciare l'oggetto");
		}
		
	}
	
}
