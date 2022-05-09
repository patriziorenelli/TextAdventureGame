package it.uniroma1.textadv;

import java.util.ArrayList;
import java.util.HashMap;

import it.uniroma1.textadv.eccezioni.InventarioDoppio;
import it.uniroma1.textadv.oggetti.Tesoro;

/**
 * Classe che implementa il singleton dell Inventario 
 *
 */
public class Inventario{

	// HashMap<String, Element> che rappresenta l'inventario di un giocatore 
	private HashMap<String, Element> inventario; 
	//oggetto inventario 
	static private Inventario oggettoInventario;
	/**
	 *  costruttore privato dell'inventario
	 */
	private Inventario() {
		inventario = new HashMap<String, Element>();

	}

	/**
	 * Metodo che gestisce il singleton dell Inventario
	 * @return Inventario
	 * @throws InventarioDoppio
	 */
	static public Inventario getInstance() throws InventarioDoppio{
		if (oggettoInventario == null) {
			oggettoInventario = new Inventario();
			return oggettoInventario;
		}else {
			throw new InventarioDoppio();
		}
	}
	

	
	/**
	 * Metodo che inserisce nella nostra HashMap l'oggetto selezionato se è diverso da null
	 * @param nome nome dell'oggetto da aggiungere 
	 * @param oggetto Element da aggiungere all'inventario 
	 */
	public void inserisci(String nome, Element oggetto) {
		if(nome != null && oggetto != null) {
			//System.out.println("Ho inserito: " +  nome + " "+ oggetto);
			inventario.put(nome, oggetto);
		}
		
	}
	
	
	/**
	 * Override del metodo toString per l'inventario
	 * return String 
	 */
	@Override
	public String toString() {
		return  inventario.values().toString();
	}
	
	/**
	 * Metodo che ritorna se l'inventario contiene un oggetto o no
	 * @param nome nome dell'ogg da ricercare se presente nell'inventario 
	 * @return boolean
	 */
	public boolean contiene(String nome ) {
		return inventario.keySet().contains(nome);
	}
	
	/**
	 * Metodo che restituisce il nome del parametro contenuto in un oggetto inventariato
	 * @param nome nome del parametro di un ogg contenuto nell'inventario
	 * @return String se l'oggetto è presente nell'inventario ed è di tipo Objects oppure null 
	 */
	public String getParametroOggetto(String nome) {
		
		if(inventario.get(nome) != null && Objects.class.isAssignableFrom(classeOggetto(nome))) 
			return ((Objects) inventario.get(nome)).getParametro();
		
		return null;
		
	}
	
	/**
	 * Metodo che ritorna un oggetto richiesto rimuovendolo dall'inventario 
	 * @param nome nome dell'ogg da prendere dall'inventario 
	 * @return Element
	 */
	public Element prendi(String nome) {
		Element el = inventario.get(nome);
		this.inventario.remove(nome);
		return el;
	}
	
	/**
	 * Metodo che ritorna se un determinato oggetto è un Objects 
	 * @param nome dell'ogg da verificare 
	 * @return boolean 
	 */
	public boolean verificaClasseObjects(String nome) {
		return  Objects.class.isAssignableFrom( inventario.get(nome).getClass() ) ;
	}
	
	/**
	 * Metodo che ritorna la classe di un elemento contenuto nell'inventario
	 * @param nome dell'ogg di cui si vuole la classe 
	 * @return Class
	 */
	public Class classeOggetto(String nome) {
		//System.out.println(inventario.get(nome).getClass());
		return inventario.get(nome).getClass();
	}
	
	
	/**
	 * Metodo che ritorna un oggetto senza rimuoverlo dall'inventario 
	 * @param nome   dell'ogg da prendere dall'inventario
	 * @return Element
	 */
	public Element getOggetto(String nome) {
		return inventario.get(nome);
	}

	/**
	 * Metodo che controlla se si ha il tesoro 
	 * @return boolean
	 */
	public boolean contieneTesoro() {
		
		for( Element el : inventario.values()) {
			if( Tesoro.class.isAssignableFrom(el.getClass())) 
				return true;
		}
		
		return false;
	}
	
	/**
	 * Metodo che ritorna la lista di tutti gli oggetti presenti nell'inventario
	 * @return ArrayList<Element>
	 */
	public ArrayList<Element> getElementList(){
		return (ArrayList<Element>) this.inventario.values();
	}
	
	/**
	 * Metodo che ricerca se nell'inventario c'è un oggetto della classe richiesta 
	 * @param classe classe che si vuole ricercare 
	 * @return
	 */
	public boolean isObjectClassPresent(Class classe) {
		for(Element el: this.getElementList()) {
			if(classe.isAssignableFrom(el.getClass()))
				return true;
		}
		return false;
	}
	
	
}
