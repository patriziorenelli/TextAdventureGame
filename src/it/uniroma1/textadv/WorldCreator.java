package it.uniroma1.textadv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import it.uniroma1.textadv.eccezioni.ClasseLink;
import it.uniroma1.textadv.eccezioni.FileNonTrovato;
import it.uniroma1.textadv.eccezioni.InventarioDoppio;
import it.uniroma1.textadv.eccezioni.LinkDoppio;
import it.uniroma1.textadv.eccezioni.LinkNotCollegato;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
import it.uniroma1.textadv.eccezioni.LinkNotFoundCreation;
import it.uniroma1.textadv.eccezioni.LinkPresente;
import it.uniroma1.textadv.eccezioni.OggettoDoppio;
import it.uniroma1.textadv.eccezioni.OggettoNotFoundCreation;
import it.uniroma1.textadv.eccezioni.OggettoPresente;
import it.uniroma1.textadv.eccezioni.PersonaggioDoppio;
import it.uniroma1.textadv.eccezioni.PersonaggioNotFoundCreation;
import it.uniroma1.textadv.eccezioni.PersonaggioPresente;
import it.uniroma1.textadv.eccezioni.ProtagonistaDoppio;
import it.uniroma1.textadv.eccezioni.StanzaDoppia;
import it.uniroma1.textadv.eccezioni.StanzaNotFound;
/**
 * Classe che si occupa della creazione di un instanza di Mondo con tutti gli elementi indicati nel file "minizak.game" ritornando poi il mondo completo 
 */
public class WorldCreator{

	private  Mondo mondo;
	// HashMap degli oggetti creati
	private HashMap<String,  Objects> objectsCreati;
	// ArrayList dei personaggi creati
	private HashMap<String, Character> charactersCreati;
	// nome della stanza di partenza 
	private String stanzaPartenza;

	/**
	 * Costruttore della classe WorldCreatore
	 */
	public WorldCreator() {
		this.objectsCreati = new HashMap<String,  Objects>();
		this.charactersCreati = new HashMap<String, Character>();	
	}
	
	
	/**						
	 * Il metodo riceve una stringa contenente il nome del file da eseguire e poi con i metodi di appoggio effettua la creazione del mondo 
	 * Al suo interno va a richiamare i metodi letturaTesto che genera un HashMap del tipo <String, ArrayList<String>> che contiene la suddivisione in base alla tipologia degli oggetti
	 * da creare. Dopo di che attraverso uno switch, si invocano i metodi per la creazione di mondo - oggetti - link - personaggi   - stanze - giocatore  nel seguente ordine
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
	 * @throws PersonaggioPresente 
	 * @throws OggettoPresente 
	 * @throws StanzaDoppia 
	 * @throws FileNonTrovato 
	 * @throws PersonaggioDoppio 
	 * @throws StanzaNotFound 
	 */
	public  Mondo creazioneMondo(String nomeFile)throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ProtagonistaDoppio, OggettoDoppio, LinkDoppio, PersonaggioPresente, OggettoPresente, StanzaDoppia, FileNonTrovato, PersonaggioDoppio, StanzaNotFound {		
			
			// Ordine di creazione dei vari elementi 
			String[] cronologiaCreazione = new String[]{"world" , "objects", "links", "characters",   "room",  "player" };
			
			// suddivisione in base all  classe di appartenenza dei blocchi di testo degli oggetti da creare richiesti dal gioco
			HashMap<String , ArrayList<String>> blocchiSuddivisi = letturaTesto(nomeFile);		 		

			for(String s : cronologiaCreazione) {
				
				if (!s.equals("room")) {
					WorldCreator.class.getDeclaredMethod("crea"+ s.substring(0, 1).toUpperCase() + s.substring(1), String.class  ).invoke(this, blocchiSuddivisi.get(s).get(0));
				}else {
					WorldCreator.class.getDeclaredMethod("crea"+ s.substring(0, 1).toUpperCase() + s.substring(1), ArrayList.class  ).invoke(this, blocchiSuddivisi.get(s));
				}
				
			}
			
			// Si controlla se la stanza di partenza esiste se no si "alza" un eccezione 
			if(mondo.isRoomPresent(stanzaPartenza)) {
				mondo.addStartRoom(stanzaPartenza);
				return this.mondo;
			}
			System.out.println("La stanza di partenza non esiste. Mondo non creato");
			System.exit(0);
			return null;
			
		
	}
	

	/**
	 * Metodo che legge il testo dal file e gestendo le varie righe vuote va a suddividerlo in blocchi e lo inserisce all'interno di un dizionario collegato alla classe associata in modo da poterci poi lavorare  
	 * @param String
	 * @return  HashMap<String, ArrayList<String>>
	 * @throws FileNonTrovato 
	 */
	private  HashMap<String, ArrayList<String>> letturaTesto(String nomeFile) throws FileNonTrovato {
		BufferedReader reader;
		HashMap<String , ArrayList<String>> blocchiEsecuzione = new HashMap<String , ArrayList<String>>();
		try {
			reader = new BufferedReader(new FileReader(nomeFile));
			String riga = reader.readLine();
			String blocco = ""; 
			
			// BISOGNA LEGGERLO TUTTO E DIVIDERLO PER I SUOI BLOCCHI SE NO POSSIAMO AVERE ERRORE SU RIGHE VUOTE ALL'INTERNO DI UN BLOCCO
			
			while (riga != null) {	
				if(!riga.isEmpty()) {
					blocco+=riga+"\n";
				}else if (!blocco.equals("")) {
					String[] b = blocco.substring(blocco.indexOf("[") + 1, blocco.indexOf("]")).split("\\:");	
					blocchiEsecuzione.computeIfAbsent(b[0], k -> new ArrayList<String>()).add(blocco);				
					blocco = "";
				}
				riga = reader.readLine();
			}
			
			if (!blocco.equals("")) {
				String[] b = blocco.substring(blocco.indexOf("[") + 1, blocco.indexOf("]")).split("\\:");	
				blocchiEsecuzione.computeIfAbsent(b[0], k -> new ArrayList<String>()).add(blocco);
			}
			reader.close();
		} catch (IOException e) {
			throw new FileNonTrovato();
		}
		return blocchiEsecuzione;
	}
	
	// 			METODI PER LA CREAZIONE 
	
	/**
	 * Metodo che riceve una lista di oggetti di tipo Objects da creare e attravero la factory li crea 
	 * Va ad eseguire uno split sui singoli blocchi di testo, per ogni riga (che rappresenta un singolo oggetto da creare)
	 * quindi va a richiamare la FactoryObjects passandogli il nome dell'oggetto, la classe dell'oggetto e l'eventuale parametro da aggiungere, creando in questo modo i singoli oggetti 
	 * @param String
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws OggettoDoppio 
	 */
	private  void  creaObjects(String daCreare) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, OggettoDoppio  {

			String[] oggetti = Arrays.copyOfRange(daCreare.split("\n"), 1, daCreare.split("\n").length );  
			Objects ogg = null;
			
			for(String oggetto : oggetti) {

				String[] parametri = oggetto.split("\\t");
				parametri[parametri.length-1] = parametri[parametri.length-1].split(" //")[0];
				
								
				// controllo dell'unicità degli oggetti 
				if(objectsCreati.keySet().contains(parametri[0])) {
					throw new OggettoDoppio();
				}else { 
					// Creazione dei singoli oggetti invocando la FactoryObjects 
					if(parametri.length < 3 ) {
						ogg =  ObjectFactory.getObjet( parametri[0], parametri[1], null) ;
					}else { 
						// es del caso gestito qui tronchesi	Tronchesi	armadio luccicante
						ogg =  ObjectFactory.getObjet(parametri[0], parametri[1], parametri[2]); }
					
					objectsCreati.put(parametri[0], ogg); 
					
				}

			}
			// invoco il metodo che inserisce l'oggetto all'interno del contenitore 
			aggiungiContenuto();
			
			//  effettuo il blocco degli oggetti che possono essere aperti solo attraverso un oggetto
			for(Objects ob : objectsCreati.values()) {
				if(controllaAttivazione(ob.getNome()))
					ob.blocca();
			}
			
	}
	
	
	/**
	 * Metodo che si occupa di aggiungere  l'eventuale contenuto ad un ObjectContenitore 
	 * @return boolean
	 */
	private  boolean aggiungiContenuto() {
		for(Objects ob : objectsCreati.values()) {
				if( objectsCreati.get(ob.getParametro()) != null && ObjectContenitore.class.isAssignableFrom(ob.getClass()) ) {
						// effettuo il cast e aggiungo all'interno l'oggetto indicato 
						((ObjectContenitore) ob).addOggettoContenuto(objectsCreati.get(ob.getParametro()));
				}
					
					
		}
		return false;
		
		
	}
	
	
	
	
	/**
	 * Metodo che riceve una lista di oggetti di tipo Links da creare e richiamando la factory che li crea 
	 * @param String
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws LinkDoppio 
	 * @throws ClasseLink 
	 */
	private void creaLinks(String daCreare ) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, LinkDoppio, ClasseLink {
		
			String[] links = Arrays.copyOfRange(daCreare.split("\n"), 1, daCreare.split("\n").length );  
		    Link link = null;
			for(String l : links) {
				String[] parametri = l.split("\\t");								
				link = LinkFactory.getLink(parametri[0], parametri[1], parametri[2], parametri[3]);
				// controllo che non si creino più link con lo stesso nome 
				if(mondo.getLink().contains(link)) {
					throw new LinkDoppio();
				}else { mondo.addLink(link);}
				
				if( controllaAttivazione(link.getNome())) 
					link.blocca();
		
			}
	}
	
	

	/**
	 * Metodo che riceve una lista di oggetti di tipo Objects da creare e richiamando la factory li crea
	 * @param String
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws PersonaggioDoppio 
	 */
	private  void creaCharacters(String daCreare) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, PersonaggioDoppio {
		
		 String[] characters = Arrays.copyOfRange(daCreare.split("\n"), 1, daCreare.split("\n").length );  
		 Character character = null;
			for(String ch : characters) {
				String[] parametri = ch.split("\\t");
				
				
				// si verifica di non creare più collegamenti con lo stesso nome 
				if(charactersCreati.keySet().contains(parametri[0])  ) {
					throw new PersonaggioDoppio();
				}else {
					character = CharacterFactory.getCharacter(parametri[0], parametri[1], Arrays.copyOfRange(parametri, 2, parametri.length));
					charactersCreati.put( parametri[0], character);
				}
				
			}
	}
	
	
	/**
	 * 
	 * Metodo che riceve e crea un oggetto di tipo Player invocando la classe Giocatore impostata come singoletto 
	 * @param String
	 * @throws ProtagonistaDoppio 
	 * @throws InventarioDoppio 
	 */
	private void creaPlayer(String daCreare) throws ProtagonistaDoppio, InventarioDoppio {
		String[] personaggio = Arrays.copyOfRange(daCreare.split("\n"), 1, daCreare.split("\n").length );		
		mondo.setGiocatore(Giocatore.getInstance(personaggio[0].split("\\t")[0]));
		Giocatore.setStanza(mondo.getRoom(stanzaPartenza));
	}
	
	
	
	/**
	 * Metodo che riceve una lista di oggetti di tipo Rooms da creare 
	 * @param ArrayList<String>
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws OggettoPresente 
	 * @throws PersonaggioPresente 
	 * @throws StanzaDoppia 
	 * @throws LinkNotFoundCreation 
	 * @throws LinkNotFound 
	 * @throws LinkNotCollegato 
	 */
	private void creaRoom(ArrayList<String> daCreare) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, OggettoPresente, PersonaggioPresente, StanzaDoppia, LinkNotFoundCreation, LinkNotFound, LinkNotCollegato {
		Room stanzaCreata = null; 
		
		for( String stanza : daCreare) {
			String[] righeStringa = stanza.split("\n");
			String nomeStanza = righeStringa[0].split(":")[1].split("]")[0];
			String descrizione = righeStringa[1].split("\\t")[1];
			stanzaCreata = new Room(nomeStanza, descrizione);
			int c = 2;
			while(c < righeStringa.length) {
				
				String[] partiRiga = righeStringa[c].split("\\t");
				if (partiRiga.length == 2  ) { 
					WorldCreator.class.getDeclaredMethod("aggiunta"+partiRiga[0].substring(0, 1).toUpperCase() + partiRiga[0].substring(1), String.class, Room.class).invoke(this, partiRiga[1], stanzaCreata);
				}
				c+=1;
			}	
			
			
			//  Si effettua il controllo che non ci sia già un altra stanza con lo stesso nome
			if(mondo.roomExist(stanzaCreata)) {
				throw new StanzaDoppia();
			}else { mondo.addRoom(stanzaCreata);}
		}
		
		// qui viene fatta la sotituzione con i veri link/ stanza portate in forma Element
		sostituzioneVeriLink();
		
		
	}
	
	
	
	
	
	/**
	 * Viene effettuata l'aggiunta dei veri link/stanze portate in forma Element
	 * @throws LinkNotFoundCreation
	 * @throws LinkNotFound 
	 * @throws LinkNotCollegato 
	 */
	private void sostituzioneVeriLink() throws LinkNotFoundCreation, LinkNotFound, LinkNotCollegato {
				
		for(Room stanza : mondo.getRoomList() ) {
			
			for(String el : stanza.getLinkNameList()) {
				
					if(el != null) {
						
						// condizione aggiunta per versione 18 che ha uno spazio su stanza blu verde quando lo aggiunge come link N alla stanza del tesoro
						if(el.endsWith(" "))
						  el = el.substring(0,el.length() - 1);
													
						
							// controllo che esista un link come richiesto e si controlla che il link sia effettivamente collegato alla stanza a cui si vuole richiedere 
							if( mondo.isLinkPresent( el )   &&    Arrays.asList(mondo.searchLink(el).getNomiStanze()).contains(stanza.getNome())        ) {
								
								stanza.addLink(  mondo.searchLink(el)   );
							}else if(mondo.isRoomPresent( el )  ) {
								stanza.addLink(  mondo.getRoom( el  )  ) ;
							}else if( !Arrays.asList(mondo.searchLink(el).getNomiStanze()).contains(stanza.getNome())){
								throw new LinkNotCollegato();
							}else {
									throw new LinkNotFoundCreation();
							}
							
					}
			}
		}
		
	}


	/**
	 * Metodo che si occupa di aggiungere i vari link richiesti alla stanza
	 * @param elenco
	 * @param stanza
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws LinkNotFound 
	 */
	public void aggiuntaLinks( String elenco, Room stanza) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound {
		 //  N, S, O, W, E (O e W hanno il medesimo significato),
		String[] li = elenco.split(",");		
		for(String s : li) {
				Room.class.getDeclaredMethod("setName"+s.split(":")[0], String.class).invoke(stanza, s.split(":")[1] );
		}
		
	}
	
	
	/**
	 * Metodo che si occupa di controllare se esiste un oggetto che può attivare o disattivare un determinato link 
	 * @param String 
	 * @return boolean
	 */
	private boolean controllaAttivazione(String nome) {
		for(Objects ob : objectsCreati.values()) {
			if( ob.getParametro() != null &&    ob.getParametro().equals(nome)) 
				return true;
		}
		return false;
	}

	
	
	/**
	 * Metodo che si occupa di aggiungere i vari oggetti richiesti nella stanza 
	 * @param elenco
	 * @param stanza
	 * @throws OggettoPresente
	 * @throws OggettoNotFoundCreation 
	 */
	public void aggiuntaObjects(String elenco, Room stanza) throws OggettoPresente, OggettoNotFoundCreation {
		String[] ogg = elenco.split(",");
		for(String o : ogg) {
			// Alcune stanze tra , e oggetto c'è uno spazio e in altre no 
			if(o.charAt(0) == ' ')
				o = o.substring(1);			
			Objects oggetto= ottieniOggetto(o);
			stanza.addObject(oggetto);
		}
	}
	

	
	/**
	 * Metodo che aggiunge alla stanza i vari character richiesti
	 * @param elenco 
	 * @param stanza
	 * @throws PersonaggioPresente
	 * @throws PersonaggioNotFoundCreation 
	 */
	public  void aggiuntaCharacters(String elenco, Room stanza ) throws PersonaggioPresente, PersonaggioNotFoundCreation {
		String[] ch = elenco.split(",");
		for(String o : ch) {
			// Alcune stanze tra , e oggetto c'è uno spazio e in altre no 
			if(o.charAt(0) == ' ')
				o = o.substring(1);
			Character personaggio= ottieniPersonaggio(o);
			stanza.addCharacter(personaggio);
		}
	}
	
	/**
	 * Metodo che riceve una stringa rappresentante il mondo da creare e crea un oggetto di tipo Mondo
	 * @param String
	 */
	private void creaWorld(String daCreare)  {
		String[] m = daCreare.split("\\n");
		String nome = m[0].split(":")[1].split("]")[0];
		String descrizione = m[1].split("\\t")[1];
		String start = m[2].split("\\t")[1];
		stanzaPartenza = start;
		mondo =  new Mondo(nome, descrizione);
	}
	
   /**
    * Metodo che ottiene l'oggetto con un determinato nome dalla lista degli oggetti creati, se è già stato posizionato allora solleva l'eccezione 
    * @param String
    * @return Objects
    * @throws OggettoPresente
    * @throws OggettoNotFoundCreation 
    * @throws OggettoNotFound 
    */
   private  Objects ottieniOggetto(String nome) throws OggettoPresente, OggettoNotFoundCreation {
	   
	   if (objectsCreati.get(nome) != null) {
		   Objects ob = objectsCreati.get(nome);
		   objectsCreati.replace(nome, null);
		   return ob;
	   }
	   if (objectsCreati.keySet().contains(nome) ) 
			   throw new OggettoPresente();
	   
	   throw new OggettoNotFoundCreation();

   }
   
   /**
	*Metodo che ottiene un personaggio con un determinato nome dalla lista dei personaggi creati, se è già stato posizionato allora solleva l'eccezione     
	* @param String 
    * @return	Character
    * @throws PersonaggioPresente
    * @throws PersonaggioNotFoundCreation 
    */
   private Character ottieniPersonaggio(String nome) throws PersonaggioPresente, PersonaggioNotFoundCreation {
	   	   
		   if( charactersCreati.get(nome) != null) {
			   Character ch = charactersCreati.get(nome);
			   charactersCreati.replace(nome, null);
			   return ch;
		   }
		   if( charactersCreati.keySet().contains(nome))
			   throw new PersonaggioPresente();
	   
	   throw new PersonaggioNotFoundCreation();
   }
   
	
}
