package it.uniroma1.textadv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import com.sun.jdi.ClassObjectReference;
import com.sun.jdi.Method;

import it.uniroma1.textadv.eccezioni.FileNonTrovato;
import it.uniroma1.textadv.eccezioni.LinkDoppio;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
import it.uniroma1.textadv.eccezioni.OggettoDoppio;
import it.uniroma1.textadv.eccezioni.OggettoPresente;
import it.uniroma1.textadv.eccezioni.PersonaggioDoppio;
import it.uniroma1.textadv.eccezioni.PersonaggioPresente;
import it.uniroma1.textadv.eccezioni.ProtagonistaDoppio;
import it.uniroma1.textadv.eccezioni.StanzaDoppia;
import it.uniroma1.textadv.eccezioni.StanzaNotFound;
import it.uniroma1.textadv.oggetti.Armadio;
import java.lang.reflect.*;

/**
 * La classe attraverso il metodo fromFile va a creare in modo fittizio il mondo, poichè fromFile va a richiamare i metodi della classe WorldCreator che vanno effettivamente a creare il mondo 
 * La classe rappresenta il mondo su cui si andrà ad effettuare la partita ( in un futuro si potrebbero voler generare più mondo all'inizio della partita e volercisi spostare durante la stessa)
 */

public class Mondo {	
	
	private Giocatore player = null; 
	private String name;
	private String description;
	private String start;
	private ArrayList<Room> stanze = new ArrayList<Room>();
	// deve mettere qui tutti i collegamenti speciali 
	private ArrayList<Link> link = new ArrayList<Link>();
	
	
	/**
	 * Costruttore privato che viene invocato dal metodo fromFile una volta che si è generato tutto il necessario per la sua creazione 
	 * @param nome
	 * @param descrizione
	 */
	public  Mondo(String nome, String descrizione) {
		this.name = nome;
		this.description = descrizione;
	}
	
	/**
	 * Metodo che setta la stanza di partenza del mondo 
	 */
	public void addStartRoom(String start ) {
		this.start = start;
	}
	
	
	/**
	 * Metodo che aggiunge una stanza al mondo 
	 * @param stanza
	 */
	public void addRoom(Room stanza){
		stanze.add(stanza);
	}
	/**
	 * Metodo che aggiunge un link al mondo 
	 * @param li
	 */
	public void addLink(Link li) {
		link.add(li);
	}
	
	/**
	 * Metodo che ritorna la lista dei link presenti nel mondo 
	 * @return ArrayList<Link>
	 */
	public ArrayList<Link> getLink() {
		return link;
	}
	
	/**
	 * Metodo che setta il giocatore della partita 
	 * @param gio
	 */
	public void setGiocatore(Giocatore gio) {
		player = gio;
	}
	
	/**
	 * Ritorna il personaggio del gioco 
	 * @return  Giocatore
	 */
	public Giocatore getGiocatore() {
		return player;
	}
	
	/**
	 * Metodo che ritorna il nome del mondo 
	 * @return String 
	 */
	public String getNome() {
		return name;
	}
	
	
	/**
	 * Metodo che ricerca se esiste già una stanza con lo stesso nome 
	 * @param stanza 
	 * @return boolean
	 */
	public boolean roomExist(Room stanza) {
		for(Room s : stanze)
			if(s.equals(stanza))
				return true;
		
		return false;
	}
	
	
	/**
	 * Metodo che ritorna un oggetta stanza partendo dal suo nome 
	 * @param stanza 
	 * @return Room
	 */
	public Room getRoom(String stanza) {
		for(Room s : stanze) {	
			if( stanza.equals( s.getNome()) ) {
				return s;
			}
		}
				
		return null;
	}
	 

	/**
	 * Metodo che restituisce true se esiste una stanza con un nome 
	 * @param stanza
	 * @return boolean
	 */
	public boolean isRoomPresent(String stanza) {
		if(this.getRoom(stanza) != null)
			return true;
		return false;
	}
	
	/**
	 * Metodo che ricerca e restituisce un link partendo dal suo nome univoco
	 * @param nomeLink
	 * @return Link 
	 * @throws LinkNotFound
	 */
	public Link searchLink(String nomeLink) throws LinkNotFound {
		for(Link l : link) {
			if(l.getNome().equals(nomeLink))
				return l;
		}
		throw new LinkNotFound();
		
	}
	
	
	/**
	 * Metodo che ricerca se un link con un nome specifico è presente nel mondo 
	 * @param nome 
	 * @return boolean
	 */
	public boolean isLinkPresent(String nome) {
		for(Link l : link) {
			if(l.getNome().equals(nome)) 
				return true;
			//System.out.println(l.getNome() + " " +nome);
		}
		return false;
	}
	
	/**
	 * Metodo che ritorna la lista delle stanze
	 * @return ArrayList<Room>
	 */
	public ArrayList<Room> getRoomList() {
		return this.stanze;
	}
	
	/**
	 * Metodo che ritorna la stanza in cui si trova il giocatore 
	 * @return Room
	 */
	public Room getStanzaGiocatore() {
		return player.getStanza();
	}
	
	
	
	/**
	 * Il metodo va ad invocare il metodo statico creazioneMondo della classe WorldCreator che genera l'istanza di Mondo richiesta, generata dal file indicato dal passato al metodo fromFile 
	 * @param nomeFile 
	 * @return Mondo  
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InstantiationException 
	 * @throws ProtagonistaDoppio 
	 * @throws OggettoDoppio 
	 * @throws LinkDoppio 
	 * @throws PersonaggioDoppio 
	 * @throws OggettoPresente 
	 * @throws StanzaDoppia 
	 * @throws FileNonTrovato 
	 * @throws PersonaggioPresente 
	 * @throws StanzaNotFound 
	 */
	public static Mondo  fromFile(String nomeFile) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ProtagonistaDoppio, OggettoDoppio, LinkDoppio, PersonaggioDoppio, OggettoPresente, StanzaDoppia, FileNonTrovato, PersonaggioPresente, StanzaNotFound  {		
		WorldCreator creatore = new WorldCreator();
		return creatore.creazioneMondo(nomeFile);
	}	

	
	/**
	 * Il metodo va ad invocare il metodo statico creazioneMondo della classe WorldCreator che genera l'istanza di Mondo richiesta, generata dal file indicato dal passato al metodo fromFile 
	 * @param pathFile 
	 * @return Mondo 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InstantiationException 
	 * @throws ProtagonistaDoppio 
	 * @throws OggettoDoppio 
	 * @throws LinkDoppio 
	 * @throws PersonaggioDoppio 
	 * @throws OggettoPresente 
	 * @throws StanzaDoppia 
	 * @throws FileNonTrovato 
	 * @throws PersonaggioPresente 
	 * @throws StanzaNotFound 
	 */
	public static Mondo  fromFile(Path pathFile) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ProtagonistaDoppio, OggettoDoppio, LinkDoppio, PersonaggioDoppio, OggettoPresente, StanzaDoppia, FileNonTrovato, PersonaggioPresente, StanzaNotFound  {		
		WorldCreator creatore = new WorldCreator();
		return creatore.creazioneMondo(pathFile.toString());
		
	}	

	/**
	 * Override del metodo toString della classe Mondo
	 * @return String
	 */
	@Override
	public String toString ()
	{
		String s = name + "\t\t" + description + "\t Si parte da: " + start + "\n\n";
		for(Room r : stanze)
			s+= r.toString() + "\n";
		return s;
	}
	
}
