package it.uniroma1.textadv.personaggi;
import java.util.ArrayList;
import java.util.List;
import it.uniroma1.textadv.Character;
import it.uniroma1.textadv.Element;
import it.uniroma1.textadv.Giocatore;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.oggetti.Soldi;

/**
 * Classe che rappresenta un Character specifico di tipo Venditore
 */
public class Venditore extends Character {
	
	/**
	 * Costruttore della classe Venditore che sfrutta il costruttore dlla superclasse Character 
	 * @param nome 
	 */
	public Venditore(String nome) {
		super(nome);
	}
	
	/**
	 * Costruttore della classe Venditore che sfrutta il costruttore dlla superclasse Character 
	 * @param nome 
	 * @param oggetti
	 */
	public Venditore(String nome,String[] oggetti) {
		super(nome);
		super.setPossedimenti(oggetti);
	}
	
	/**
	 * Override del metodo getPossediamenti della classe Character
	 * @return ArrayList<String>
	 */
	@Override
	public ArrayList<String>  getPossedimenti() {
		return super.getPossedimenti();
	}

	
	
	/**
	 * Override del metodo specifico dai per il venditore, se il giocatore propone dei Soldi allora il venditore effettuerà lo scambio, 
	 * se non il giocatore gli offre altro e il Venditore ha comunque oggetti rifiuterà lo scambio
	 * se il venditore non ha oggetti ma gli viene offerto qualcosa lui lo prende senza dare nulla in cambio
	 * @param personaggio
	 * @param  stanza
	 * @param element
	 */
	@Override
	public void dai(Giocatore personaggio, Room stanza, Element element){
		if(this.getPossedimenti().size() != 0 && Soldi.class.isAssignableFrom(element.getClass())) {
			
			ArrayList<String> possedimenti = super.dai();
			personaggio.getInventario().prendi(element.getNome());
			for(String el : possedimenti) {
				personaggio.prendi( new ArrayList<String>(List.of(el)) );
			}
		}else if(!Soldi.class.isAssignableFrom(element.getClass()) ) {
			System.out.println("Non mi stai dando dei soldi. Vattene!");
		}else if(this.getPossedimenti().size() == 0 && Soldi.class.isAssignableFrom(element.getClass())){
			System.out.println("Non ho niente da darti, ma visto che me li hai proposti i soldi me li tengo!  ;)");
			personaggio.getInventario().prendi(element.getNome());
		}else {
			System.out.println("Non mi stai dando dei soldi. Vattene!");
		}
	}
	
	
}
