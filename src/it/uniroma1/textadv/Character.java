package it.uniroma1.textadv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Classe astratta che rappresenta la struttura di un personaggio base senza funzionalità particolari
 */
public abstract  class Character extends Element{
	// rappresenta gli oggetti posseduti da un Character
	ArrayList<String> oggettiTenuti = new ArrayList<String>();
	/**
	 * Costruttore di Character con solo il nome che richiama il costruttore della superclasse Element
	 * @param nome nome che viene dato al Character 
	 */
	public Character(String nome ) {
		super(nome);
	}
	
	/**
	 * Costruttore di Character con nome e lista di parametri che richiama il costruttore della superclasse Element
	 * @param nome nome che viene dato al Character
	 * @param oggetti array dei nomi degli oggetti posseduti dal Character
	 */
	public Character(String nome,String[] oggetti) {
		super(nome);
		this.setPossedimenti(oggetti);
	}
	
	
	/**
	 * Metodo che restituisce il nome 
	 * @return String  
	 */
	@Override
	public String getNome() {
		return nome;
	}
	
	/**
	 * Override del metodo equals fatto appositamente per la classe Character
	 * @return boolean 
	 */
	@Override 
	public boolean equals(Object ch) {
		Character cha= null;
		
		if(ch instanceof Character) {
			cha = (Character) ch;
			return cha.nome.equals(this.nome);
		}else {	
			return false;		 
		}
	}
	
	/**
	 * Override del metodo toString che restituisce soltanto il nome del giocatore 
	 * @return String name
	 */
	@Override
	public String toString ()
	{
		return this.getNome();
	}
	
	/**
	 * Metodo che ritorna gli oggetti che un personaggio possiede 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getPossedimenti() {
		return oggettiTenuti;
	}
	
	/**
	 * Metodo che consente ai personaggi di parlare 
	 */
	public void parla() {
		System.out.println("BLA BLA BLA");
	}
	
	/**
	 * Metodo che setta la lista dei nomi di oggetti posseduti di un personaggio
	 * @param oggetti una lista contenente i nomi degli oggetti da aggiungere ai possedimenti 
	 */
	public void setPossedimenti(String[] oggetti) {
		
		oggettiTenuti.addAll( Arrays.asList(oggetti) );
	}
	
	/**
	 * Metodo che aggiunge il nome di un oggetto posseduto
	 * @param  oggetto nome dell'oggetto da aggiungere ai possedimenti
	 */
	public void addOggettoPosseduto(String oggetto) {
		oggettiTenuti.add(oggetto);
	}
	
	/**
	 * Metodo che consente ad un personaggio di prendere delle cose 
	 * @param nomeOggetto nome di un oggetto da aggiungere ai possedimenti del Character
	 */
	public void prendi(String nomeOggetto) {
		oggettiTenuti.add(nomeOggetto);
	}
	
	/**
	 * Imposta a null l'elenco degli oggetti posseduti
	 */
	public void svuotaPossedimenti() {
		oggettiTenuti = null;
	}
	
	/**
	 * Metodo che ritorna tutti i nomi di oggetti contenuti e ne cede il possesso 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> dai() {
		
		if(this.getPossedimenti().size() != 0) {
			ArrayList<String> possedimenti = this.getPossedimenti();
			this.svuotaPossedimenti();
			return possedimenti;
		}else {
			System.out.println("Non ho niente per te ");
			return new ArrayList<String>();
		}

		
	
	}
	
	/**Metodo che saluta
	 */
	public void saluta() {
		System.out.println(this.getNome().substring(0, 1).toUpperCase() + this.getNome().substring(1) + ": Ciao!");
	}
	
	
	/**
	 * Metodo dai 
	 * @param personaggio rappresenta il giocatore a cui dare l'oggetto
	 * @param room è la stanza attuale in cui si trova il Character
	 * @param element è l'elemento da dare al giocatore
	 */
	public void dai(Giocatore personaggio, Room room, Element element) {
		// E' un operazione fittizia perchè si perderà l'istanza dell'oggetto comunque 
		this.oggettiTenuti.add(element.getNome());
		System.out.println(this.getNome() +": Grazie per " + element.getNome());
		System.out.println("Giocatore: Prego");
		// rinuncio all'oggetto
		personaggio.getInventario().prendi(element.getNome());
	}

	/**
	 * Metodo discuti che permette di avere due conversazioni diverse con un altro personaggio
	 * @throws IOException 
	 */
	public void discuti() throws IOException {
		
	}
	
}
