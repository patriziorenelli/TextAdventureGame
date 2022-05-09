package it.uniroma1.textadv.personaggi;

import java.util.Arrays;
import it.uniroma1.textadv.Character;
import it.uniroma1.textadv.Element;
import it.uniroma1.textadv.Giocatore;
import it.uniroma1.textadv.Room;
/**
 * Classe che rapprenta un Guardiano che è un Character specifico
 */
public class Guardiano extends Character{

	/**
	 * Nome dell'Element richiesto per effettuare lo scambio con il Tesoro
	 */
	private String scambio;
	
	
	/**
	 * Costruttore della classe Guardiano che sfrutta il costruttore della classe Character
	 * @param nome nome del Guardiano da creare 
	 */
	public Guardiano(String nome) {
		super(nome);
	}
	
	
	
	/**
	 * Costruttore della classe Guardiano che sfrutta il costruttore della classe Character
	 * @param nome nome del Guardiano da creare 
	 * @param parametri array dei nomi degli ogg posseduti dal personaggio
	 */
	public Guardiano(String nome, String[] parametri) {
		super(nome, Arrays.copyOfRange(parametri, 0, 1) );
		this.scambio = parametri[1];
	}
	
		
	/**
	 * Override del metodo  dai per il Guardiano della classe Character
	 * @param personaggio giocatore a cui dare il tesoro in caso positivo
	 * @param  stanza Room attuale in cui si trova il giocatore 
	 * @param element Element che viene dato al Guardiano per effettuare lo scambio con il tesoro 
	 */
	@Override
	public void dai(Giocatore personaggio, Room stanza, Element element){
		if(element.getNome().equals(scambio) && super.getPossedimenti().size() != 0    ) {
			System.out.println(this.getNome() + ": Finalmente ho " + scambio + " non mi serve più " + super.getPossedimenti().get(0));
			super.svuotaPossedimenti();		
			personaggio.getInventario().prendi(element.getNome());
		}else if(super.getPossedimenti().size() == 0){
			System.out.println(this.getNome() + ": Non hai quello che voglio!! VATTENE!");
		}else {
			System.out.println(this.getNome() + ": Non ho niente per te ");
		}
		
		
	}

}
