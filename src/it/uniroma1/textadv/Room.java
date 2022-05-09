package it.uniroma1.textadv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import it.uniroma1.textadv.eccezioni.LinkNotFound;
import it.uniroma1.textadv.eccezioni.OggettoPresente;

/**
 * Classe che va a rappresentare le singole stanze che vanno a formare il mondo 
 */
public class Room extends Element{

	private String description; 
	
	//Si sfruttano delle HashMap per una più veloce ricerca durante il gioco 
	private HashMap<String, Objects> objectsList = new HashMap<String, Objects>();
	private HashMap<String, Character> charactersList = new HashMap<String, Character>();
	private HashMap<String, Element> linkList = new HashMap<>() {{ put("0", null); put("1", null); put("2", null); put("3", null);  }};
	//Array contente i 4 collegamenti della stanza 
	private String[] linkNameList = new String[4];
	/**
	 * Costruttore della classe Room che sfrutta il costruttore della superclasse Element
	 * @param nome
	 * @param descrizione
	 */
	public Room(String nome, String descrizione) {
		super(nome);
		description = descrizione;
	}

	/**
	 * Metodo che ritorna tutta l'hashMap degli oggetti presenti nella stanza 
	 * @return HashMap<String, Objects>
	 */
	public HashMap<String, Objects> getObjectsMap(){
		HashMap<String, Objects> tutti  = new HashMap<String, Objects>(objectsList);
		// aggiungo gli oggetti contenuti in oggetti contenitori che però ora sono visibili
		for( Objects ob : objectsList.values() ) {
			if ( ObjectContenitore.class.isAssignableFrom(ob.getClass()) && ((ObjectContenitore) ob).getVisibilità()  ) 
						tutti.put( ((ObjectContenitore) ob).getObjectInside().getNome(),  ((ObjectContenitore) ob).getObjectInside()  );
		}

		return tutti;
	}
	
	/**
	 * Metodo che ritorna tutta l'hashMap dei personaggi  
	 * @return HashMap<String, Character>
	 */
	public HashMap<String, Character> getCharactersMap(){
		return charactersList;
	}
	
	/**
	 * Metodo che ritorna il nome della stanza
	 * @return String 
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo che aggiunge un oggetto alla lista objectsList che rappresenta gli oggetti all'interno della stanza
	 * @param oggetto 
	 */
	public void addObject(Objects oggetto) {
		objectsList.put( oggetto.getNome(),  oggetto);
	}


	/**
	 * Metodo che ritorna la lista dei personaggi presenti all'interno della stanza
	 * @return ArrayList<Character>
	 */
	public ArrayList<Character> getCharactersList() {
		return   new ArrayList<>(charactersList.values());
	}

	/**
	 * Metodo che aggiunge un personaggio alla lista charactersList che rappresenta i personaggi all'interno della stanza
	 * @param personaggio
	 */
	public void addCharacter(Character personaggio) {
		charactersList.put(personaggio.getNome(),   personaggio);
	}
	
	/**
	 * Override del metodo equals fatto appositamente per la classe Room
	 * @param ob
	 * @return boolean 
	 */
	@Override 
	public boolean equals(Object ob) {
		Room stanza = null;
		
		if(ob instanceof Room) {
			stanza = (Room) ob;
			return stanza.nome.equals(this.nome);
		}else {	
			return false;		 
		}
	}	
	
	/**
	 * Metodo per l'aggiunta dei link nell'HashMap dedicata 
	 * @param elemento
	 */
	public void addLink(Element elemento) {
		linkList.put(elemento.getNome(), elemento);
	}
	
	
	/**
	 * Metodo che dato il nome di un link lo restituisce 
	 * @param nome
	 * @return Link
	 * @throws LinkNotFound 
	 */
	public Link getLink(String nome) throws LinkNotFound {
		if( isLinkPresent(nome))
			return (Link) linkList.get(nome);
		throw new LinkNotFound();
	}

	
	// METODI CHE PRENDONO I VARI "LINK" DALLA STANZA 
	/**
	 * Ottiene il  link sotto forma di oggetto Element della stanza presente a nord 
	 * @return Element
	 */
	public Element getNord() {
		
		return linkList.get(linkNameList[0]);
	}
	/**
	 * Ottiene il  link sotto forma di oggetto Element della stanza presente a sud 
	 * @return Element
	 */
	public Element getSud() {
		return linkList.get(linkNameList[1]);
	}
	/**
	 * Ottiene il  link sotto forma di oggetto Element della stanza presente a est 
	 * @return Element
	 */
	public Element getEst() {
		return linkList.get(linkNameList[2]);
	}
	/**
	 * Ottiene il  link sotto forma di oggetto Element della stanza presente a ovest 
	 * @return Element
	 */
	public Element getOvest() {
		return linkList.get(linkNameList[3]);
	}
	
	/**
	 * Ottiene il  link sotto forma di oggetto Element della stanza presente a ovest 
	 * @return Element
	 */
	public Element getWest() {
		return linkList.get(linkNameList[3]);
	}
	
	
	// METODI CHE SETTANO I NOMI DEI LINK NELLE VARIE POSIZIONI
	
	/**
	 * Setta il nome del link o stanza che si trova in posizione nord
	 * @param nome
	 */
	public void setNameN(String nome) {
		linkNameList[0] = nome;
	}
	/**
	 * Setta il nome del link o stanza che si trova in  posizione sud
	 * @param nome
	 */
	public void setNameS(String nome) {
		linkNameList[1] = nome;
	}
	/**
	 *Setta il nome del link o stanza che si trova in posizione est
	 * @param nome
	 */
	public void setNameE(String nome) {
		linkNameList[2] = nome;
	}
	/**
	 * Setta il nome del link o stanza che si trova in posizione ovest
	 * @param nome
	 */
	public void setNameO(String nome) {
		linkNameList[3] = nome;
	}
	
	
	/**
	 * Setta il nome del link o stanza che si trova in posizione ovest
	 * @param nome
	 */
	public void setNameW(String nome) {
		linkNameList[3] = nome;
	}
	
	// METODI CHE PRENDONO I NOMI NELLE VARIE POSIZIONI 
	
	
	/**
	 * Ottiene il nome del link o della stanza presente a nord 
	 * @return String
	 */
	public String getNordName() {
		return linkNameList[0];
	}
	/**
	 * Ottiene il nome del link o della stanza presente a sud 
	 * @return String
	 */
	public String getSudName() {
		return linkNameList[1];
	}
	/**
	 * Ottiene il nome del link o della stanza presente a est 
	 * @return String
	 */
	public String getEstName() {
		return linkNameList[2];
	}
	/**
	 * Ottiene il nome del link o della stanza presente a ovest 
	 * @return String
	 */
	public String getOvestName() {
		return linkNameList[3];
	}
	
	/**
	 * Ottiene il nome del link o della stanza presente a ovest 
	 * @return String
	 */
	public String getWestName() {
		return linkNameList[3];
	}
	
	
	/**
	 * Metodo che controlla se una stanza ha almeno un link valido 
	 * @return boolean 
	 */
	public boolean hasLink() {
		for(String s : linkNameList) {
			if(s != null)
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo che controlla se una stanza ha almeno un Objects 
	 * @return boolean 
	 */
	public boolean hasObjects() {
		if(objectsList.size() == 0)
			return false;
		return true;
	}
	
	/**
	 * Metodo che controlla se una stanza ha almeno un Character
	 * @return boolean 
	 */
	public boolean hasCharacter() {
		if(charactersList.size() == 0)
			return false;
		return true;
	}
	
	
	/**
	 * Metodo che indica se un oggetto è presente o no nella stanza 
	 * @param nomeOggetto 
	 * @return boolean
	 */
	public boolean isObjectPresent(String nomeOggetto) {
		if( this.getObjectsMap().get(nomeOggetto) != null)
			return true;
		return false;
	}
	
	
	/**
	 * Metodo che ritorna se un oggetto è inventariabile o no, andandolo a cercare anche all'interno degli oggetti contenitore 
	 * che permettono di vedere il loro contenuto oltre che nella stanza normalmente 
	 * @param nomeOggetto 
	 * @return boolean
	 */
	public boolean isObjectInventariabile (String nomeOggetto) {
		if( this.isObjectPresent(nomeOggetto)) {
			if(this.getObjectsMap().get(nomeOggetto).inventariabile() )
				return true;
		}		
		return false;
	}
	
	
	
	
	/**
	 * Metodo che ritorna se un elemento (Objects e Character) contenuto nella stanza è inventariabile (cioè può essere preso e messo nell'inventario)
	 * @param nome
	 * @return boolean
	 */
	public boolean isElementInventariabile(String nome) {
		if(isObjectInventariabile(nome))
			return true;
		
		if(isCharacterInventariabile(nome))
			return true;
		
		return false;
	}
	
	
	/**	
	 * Metodo che ritorna se un link è presente o no nella stanza 
	 * @param nome 
	 * @return boolean
	 */
	public boolean isLinkPresent(String nome) {
		return Arrays.asList( this.getLinkNameList() ).contains(nome);
	}
	
	/**
	 * Metodo che ritorna true se all'interno della stanza è presente un personaggio con il nome passato come parametro
	 * @param nome 
	 * @return boolean
	 */
	public boolean isCharacterPresent(String nome) {
		return this.getCharactersMap().keySet().contains(nome);
	}
	
	
	/**
	 * Controlla se l'oggetto è posseduto da un personaggio 
	 * @param nome
	 * @return boolean
	 */
	public boolean personaggioPossiedeOggetto(String nome) {
		for(Character ch  : charactersList.values()) {
			if(ch.getPossedimenti() != null &&   ch.getPossedimenti().contains(nome) )
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo che ritorna true se il personaggio richiesto è nella stanza ed è inventariabile 
	 * @param nome
	 * @return boolean
	 */
	public boolean isCharacterInventariabile(String nome) {
		if( this.getCharactersMap().get(nome) != null)
			if(this.getCharactersMap().get(nome).inventariabile() )
				return true;
		return false;
	}
	
	/**
	 * Metodo che ritorna un oggetto se presente nella stanza oppure null
	 * @param nome 
	 * @return Objects
	 */
	public Objects getObject(String nome) {		
		return this.getObjectsMap().get(nome);
	}
	
	/**
	 * Metodo che ritorna un personaggio se presente nella stanza oppure null
	 * @param nome 
	 * @return Character
	 */
	public Character getCharacter(String nome) {		
		return this.getCharactersMap().get(nome);
	}
	
	/**
	 * Metodo che ritorna un Element dalla stanza con il nome richiesto se presente oppure null 
	 * @param nome
	 * @return Element
	 */
	public Element getElement(String nome) {
		if(this.getCharacter(nome) != null)
			return (Element) this.getCharacter(nome);
		
		if(this.getObject(nome) != null)
			return (Element) this.getObject(nome);
		
		return null;
		
	}
	
	/**
	 * Prende un Element dalla stanza rimuovendolo dalla stanza
	 * @param nome
	 * @return Element
	 */
	public Element prendi(String nome) {
			Element elemento = this.getElement(nome);
			rimuoviElement(nome);
			return elemento;
	}
	 
	
	/**
	 * Metodo che rimuove un Element dalla stanza 
	 * @param nome 
	 */
	public void rimuoviElement(String nome) {
		
		if(this.getCharacter(nome)!= null) {
			this.objectsList.remove(nome);
		}
		

		if(this.getObject(nome) != null) {
			this.objectsList.remove(nome);
		}
		

		/**
		 *  Devo rimuovere l'oggetto se è eventualmente contenuto in un ObjectContenitore
		 *  Es: prendi gemma rossa -> prende l'oggetto dal camino anche senza specificare prendi gemma rossa da camino
		 */
		for(Object ob : objectsList.values()) {
			
			if(ObjectContenitore.class.isAssignableFrom(ob.getClass()) && ((ObjectContenitore) ob).getObjectInside() != null && ((ObjectContenitore) ob).getObjectInside().getNome().equals(nome)    ) {
				((ObjectContenitore) ob).prendi(nome);
			}
		}
		

	}
	
	
	
	/**
	 * Controlla se l'oggetto è in un contenitore 
	 * @param nome
	 * @return boolean 
	 */
	public boolean isInContenitore(String nome) {
		for( Objects ob : objectsList.values() ) {
			if ( ObjectContenitore.class.isAssignableFrom(ob.getClass()) && ((ObjectContenitore) ob).getVisibilità()  ) 
					return true;
		}
		return false;
	}
	
	/**
	 * Metodo che ritorna la lista dei vari link/ stanze collegate  della stanza 
	 * @return Collection<Element>
	 */
	public Collection<Element> getLinksList(){
		return   linkList.values();
	}
	
	/**
	 * Ritorna un String[] contentente i vari link/ stanza collegati alla stanza 
	 * @return String[]
	 */
	public String[] getLinkNameList() {
		return linkNameList;
	}
	
	
	/**
	 * Metodo che ritorna la classe di un link presente nella stanza
	 * @param nome 
	 * @return Class
	 */
	public Class getLinkClass(String nome) {
		if(isLinkPresent(nome))
			return linkList.get(nome).getClass();
		return null;
	}
	
	/**
	 * Metodo che ritorna il giocatore se presente nella stanza
	 * @return Giocatore
	 */
	public Giocatore getGiocatore() {
		
		for(Character ch : getCharactersList()) {
			if( Giocatore.class.isAssignableFrom(ch.getClass() )  )
				return (Giocatore) ch;
		}
		
		return null;
		
	}
	
	
	
	
	/**
	 * Override del metodo toString per la classe Room
	 * @return String
	 */
	@Override
	public String toString() {
		String descrizione = nome;
		
		if(this.hasObjects())
			descrizione+= " | OGGETTI: ";
		
		for( Objects ob : this.getObjectsMap().values())
			descrizione+= ob.getNome() + " ";
		
		if(this.hasLink())
			descrizione+="| LINKS: ";
		
		if(this.getNordName() != null) 
			descrizione+="N:"+ this.getNordName() ;
		
		
		if(this.getSudName() != null) 
			descrizione+=" S:"+ this.getSudName() + " ";	
		
		if(this.getEstName() != null) 
			descrizione+=" E:"+ this.getEstName()+ " ";
		
		if(this.getOvestName() != null) 
			descrizione+=" O:"+ this.getOvestName()+ " ";
		
		
		
		if(this.hasCharacter())
			descrizione+="|	PERSONAGGI: ";
		for(Character ch : charactersList.values())
			descrizione+=ch;
		
		
		return descrizione;
			
	}

	
	
	
}
