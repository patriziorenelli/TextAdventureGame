package it.uniroma1.textadv;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import it.uniroma1.textadv.eccezioni.ClasseOggetto;
import it.uniroma1.textadv.eccezioni.InventarioDoppio;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
import it.uniroma1.textadv.eccezioni.ProtagonistaDoppio;
import it.uniroma1.textadv.oggetti.Tesoro;
import it.uniroma1.textadv.personaggi.Animale;
import it.uniroma1.textadv.personaggi.Gatto;
/**
 * Classe che rappresenta il Protagonista, va ad implementare il Pattern singoletto, in modo che si possa generare una sola instanza del giocatore 
 */
public class Giocatore extends Character{

	static private Giocatore giocatore;
	private Room stanzaAttuale;
	private Inventario inventario;
	
	/**
	 * Costruttore privato del Giocatore che sfrutta il costruttore della superclasse Character
	 * @param name
	 * @throws InventarioDoppio
	 */
	private Giocatore(String name) throws InventarioDoppio {
		super(name);
		inventario = Inventario.getInstance();
	}
	
	/**
	 * Metodo getInstance che permette la creazione di un giocatore 
	 *@param  nome nome del giocatore 
	 *@return Giocatore  
	 *@throws ProtagonistaDoppio
	 *@throws InventarioDoppio
	 */
	static public Giocatore getInstance(String nome) throws ProtagonistaDoppio, InventarioDoppio{
		if (giocatore == null) {
			giocatore = new Giocatore(nome);
			return giocatore;
		}
			throw new ProtagonistaDoppio();
		
	}
	
	/**
	 * Metodo che imposta / aggiorna la stanza in cui si trova il giocatore -> viene usato solo in WorldCreator nella creazione del giocatore
	 * @param stanza  ogg Room che sar‡ la stanza attuale del giocatore 
	 */
	static public void setStanza(Room stanza) {
		giocatore.stanzaAttuale = stanza;
	}
	
	/**
	 * Metodo che ritorna la stanza in cui si trova il giocatore 
	 * @return Room
	 */
	public Room getStanza() {
		return giocatore.stanzaAttuale;
	}
	

	/**
	 * Metodo che descrive l'ambiente in cui si trova il giocatore senza parametri 
	 * (per parametri  si intende ad esempio "guarda LA SCRIVANIA" )
	 */
	 public void guarda() {
		 System.out.println( giocatore.stanzaAttuale.toString()  ) ;
	}
	
	 
	 // La partita ff impone la ricerca soltanto tra gli oggetti e non su link e personaggi presenti nella stanza 
	/**Metodo che descrive un oggetto che il cui nome viene passato come parametro dal comando utente 
	 * @param oggetto ArrayList<String> contenente il nome dell'ogg da guardare 
	 */
	public void guarda(ArrayList<String>  oggetto) {
		if(stanzaAttuale.isObjectPresent(oggetto.get(0))) {
			System.out.println("E' l'oggetto " + stanzaAttuale.getObjectsMap().get(oggetto.get(0)));
		}else {
			System.out.println("L'oggetto indicato non Ë presente in questa stanza ");
		}
	}
	
	/**
	 * Metodo che mostra l'inventario al giocatore 
	 */
	public void inventario() {
		System.out.println("IL TUO INVENTARIO: " + inventario);
	}
	
	/**
	 * Metodo che consente di vincere senza ottenere il tesoro
	 */
	public void vinci() {
		System.out.println("Ti piace vincere facile?   Bongi Bongi Po-po-po");
		
		System.out.println("          ___   ____\r\n"
				+ "        /' --;^/ ,-_\\     \\ | /\r\n"
				+ "       / / --o\\ o-\\ \\\\   --(_)--\r\n"
				+ "      /-/-/|o|-|\\-\\\\|\\\\   / | \\\r\n"
				+ "       '`  ` |-|   `` '\r\n"
				+ "             |-|\r\n"
				+ "             |-|O\r\n"
				+ "             |-(\\,__\r\n"
				+ "          ...|-|\\--,\\_....\r\n"
				+ "      ,;;;;;;;;;;;;;;;;;;;;;;;;,.\r\n"
				+ "~~,;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n"
				+ "~;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,  ______   ---------   _____     ------");
		System.out.println(" \n Nota: Non si vuole invogliare nessuno al gioco d'azzardo");
		inventario.inserisci("tesoro", new Tesoro("Tesoro facile", null));
		
		
	}
	
	/**
	 * Metodo che chiude un link 
	 * @param comando rappresenta la stringa dopo il comando chiudi (es chiudi + arr ( porta / porta . chiave  ))
	 * @param mondo l'istanza del Mondo su cui si sta giocando la partita 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws LinkNotFound 
	 */
	public void chiudiLink(ArrayList<String> comando, Mondo mondo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound{
		if(comando.size() == 1) {
			stanzaAttuale.getLink(comando.get(0)).chiudi();
		}else {
			if(  Objects.class.isAssignableFrom(inventario.classeOggetto(comando.get(1)))  &&   ((Objects) inventario.getOggetto(comando.get(1))).getParametro().equals(comando.get(0))) {
				stanzaAttuale.getLink(comando.get(0)).chiudiConOggetto();

			}
		}
	}
	
	/**
	 * Metodo che si occupa di aprire oggetti, si tiene comunque l'oggetto usato
	 * @param comando comando rappresenta la stringa dopo il comando apri (es apri + arr ( frigo / scrivania . chiave  ))
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void apri(ArrayList<String> comando) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		try {
			
			if(comando.size() > 1 ) {
				// verifichiamo che l'oggetto da aprire sia nella stanza e che abbiamo l'oggetto che vogliamo usare per aprirlo 
				if(stanzaAttuale.isObjectPresent( comando.get(0) ) && inventario.contiene(comando.get(1)) ) {
					// un oggetto si puÚ aprire soltanto con un altro oggetto
					stanzaAttuale.getObject(comando.get(0)).getClass().getDeclaredMethod("apri", Objects.class ).invoke(stanzaAttuale.getObject(comando.get(0)), (Objects)  inventario.getOggetto(comando.get(1))  );
				}
			}else {
				if(	stanzaAttuale.isObjectPresent( comando.get(0)) ) 
					stanzaAttuale.getObject(comando.get(0)).getClass().getDeclaredMethod("apri", null).invoke(stanzaAttuale.getObject(comando.get(0)), null);
			}
		}catch (NoSuchMethodException e) {
			System.out.println("Impossibile aprire l'oggetto");
		}	 
	
	}
	
	
	/**
	 * Metodo che viene invocato per spostarsi attraverso il comando vai / vai + parametro 
	 * @param comando comando rappresenta la stringa dopo il comando vai  (es vai + arr ( E  ))
	 * @param mondo istanza del Mondo su cui si sta giocando la partita 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws LinkNotFound
	 */
	public void vai(ArrayList<String> comando, Mondo mondo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound {
			
			String direzione = Direzione.getNome( comando.get(0));
			
			// dentro questo if io so gi‡ che ho gi‡ qualcosa di ammissibile perchË vincolato dalla creazione 
			if(direzione != null) {
				Element  next =   (Element) Room.class.getDeclaredMethod("get"+direzione, null).invoke(stanzaAttuale, null);
				if(next == null) {
					stampaImpossibilit‡Esecuzione();
					return;
				}
					
				// bisogna vedere se Ë un link o una stanza diretta     mondo.isLinkPresent(next.getNome())  
				if(   Link.class.isAssignableFrom(next.getClass())  ) {
					if( ((Link) next).vai()) {
						// se sono qui significa che il link Ë attivo  e posso sfruttarlo
						// ottengo la stanza di destinazione da mondo -> la sostituisco alla stanza attuale 
						stanzaAttuale = mondo.getRoom(  ((Link) next).getNomeStanzaCollegata(stanzaAttuale.getNome()) );
						System.out.println("SEI IN " + stanzaAttuale.getNome());
					}
				}else{
					stanzaAttuale = mondo.getRoom(next.getNome());
					System.out.println("SEI IN " + stanzaAttuale.getNome());

				}
			}else {
				stampaImpossibilit‡Esecuzione();
			}
			
			
		}
	
	/**
	 * Metodo per gestire l'apertura dei link (es apri porta - apri botola ) , il giocatore apre il link ma si tiene comunque l'oggetto che ha usato
	 * @param comando comando rappresenta la stringa dopo il comando chiudi (es apri + arr ( porta / porta . chiave  ))
	 * @param mondo ogg Mondo su cui si sta giocando la partita  
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws LinkNotFound
	 */
	public void apriLink(ArrayList<String> comando, Mondo mondo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound {
				
			
			if(comando.size()>1 && inventario.contiene(comando.get(1)) && inventario.verificaClasseObjects(comando.get(1)) ) {
				// prendo il link -> prendo l'oggetto in get(0) -> apro 
				( mondo.searchLink(comando.get(0))	).apri( (Objects) inventario.getOggetto(comando.get(1)) );
			}else if( comando.size() == 1) {
				( mondo.searchLink(comando.get(0))	).apri( );
			}else {
				stampaImpossibilit‡Esecuzione();
			}
			
			
	}
	
	
	/**
	 * Metodo per accarezzare un animale 
	 * @param comando comando rappresenta la stringa dopo il comando accarezza (es accarezza + arr ( Tom ))
	 */
	public void accarezza(ArrayList<String> comando) {
		
		if( stanzaAttuale.getCharactersMap().containsKey(comando.get(0)) && Animale.class.isAssignableFrom( stanzaAttuale.getCharactersMap().get(comando.get(0)).getClass() )  )  {
			((Animale) stanzaAttuale.getCharactersMap().get(comando.get(0))).accarezza();
		}else {
			stampaImpossibilit‡Esecuzione();
		}
	}
	
	

	/**
	 * Metodo che rompe un oggetto nel caso in cui si usi un altro oggetto 
	 * @param comando comando rappresenta la stringa dopo il comando rompi (es rompi + arr ( salvadanaio / salvadanaio . martello  ))
	 */
	public void rompi(ArrayList<String> comando) {
			if(comando.size() == 1) {
				System.out.println("E' necessario un oggetto per romperne un altro");
			}else {
				if( stanzaAttuale.isObjectPresent(comando.get(0)) && inventario.contiene(comando.get(1))  )
					stanzaAttuale.getObject(comando.get(0)).rompi(  );
			}
	}
	
	/**
	 * Metodo che permette di parlare con un altro personaggio
	 * @param comando comando rappresenta la stringa dopo il comando parla (es parla + arr ( Teresa  ))
	 */
	public void parla(ArrayList<String> comando) {
		if(stanzaAttuale.isCharacterPresent(comando.get(0))) {
			stanzaAttuale.getCharactersMap().get(comando.get(0)).parla();

		}else {
			stampaFantasma(comando.get(0));
		}
	}
	

	/**
	 * Metodo che rappresenta l'azione "usa un oggetto"
	 * @param comando comando rappresenta la stringa dopo il comando usa (es usa + arr ( secchio . camino  ))
	 * @throws LinkNotFound
	 */
	public void usa(ArrayList<String> comando) throws LinkNotFound {
					
		// il caso in cui si vuole usare un oggetto che gi‡ si ha nell'inventario
		if(comando.size()==1 && inventario.contiene(comando.get(0)) && inventario.verificaClasseObjects(comando.get(0))) {
			((Objects) inventario.getOggetto(comando.get(0))).usa(stanzaAttuale);	
			return;
			// il caso in cui si vuole usare un oggetto che gi‡ si ha nell'inventario su un altro ogetto 
		}else if(comando.size()==1 && stanzaAttuale.isObjectPresent(comando.get(0))) {
			stanzaAttuale.getObject(comando.get(0)).usa(stanzaAttuale);
			return;
		}
			
		
		if( comando.size() > 1 &&  inventario.contiene(comando.get(0)) && inventario.verificaClasseObjects(comando.get(0)) && stanzaAttuale.isObjectPresent(comando.get(1))  ) {
			((Objects) inventario.getOggetto(comando.get(0))).usa( stanzaAttuale.getObject(comando.get(1)) , stanzaAttuale);	
			return;
		}
		
		stampaImpossibilit‡Esecuzione();	
	}
	
	

	
	/**
	 * Metodo che rappresenta l'azione di "prendere un link" es. prendi navetta 
	 * @param comando comando rappresenta la stringa dopo il comando prendi (es prendi + arr ( autobus ))
	 * @param mondo  l'ogg Mondo su cui si sta giocando la partita 
	 * @throws LinkNotFound 
	 */
	public void prendiLink(ArrayList<String> comando, Mondo mondo) throws LinkNotFound {
		if( stanzaAttuale.getLink(comando.get(0)).vai() ) { 
			stanzaAttuale =  mondo.getRoom( stanzaAttuale.getLink(comando.get(0)).getNomeStanzaCollegata(stanzaAttuale.getNome())  );
			System.out.println("SEI IN " + stanzaAttuale.getNome());		

		}else {
			stampaImpossibilit‡Esecuzione();
		}
	}
	
	
	
	
	/**
	 * Metodo che gestisce l'azione usa un link
	 *  va a gestire sia il caso in cui si voglia usare un oggeto su un link sia quello in cui si voglia usare direttamente un link (es. usa chiave teletrasporto su teletrasporto / usa  teletrasporto )
	 * @param comando comando rappresenta la stringa dopo il comando usa (es usa + arr ( teletrasporto /  chiave . teletrasporto  ))
	 * @param	mondo il Mondo su cui si sta eseguendo la partita 
	 * @throws LinkNotFound 
	 */
	public void usaLink(ArrayList<String> comando, Mondo mondo) throws LinkNotFound {
		if(comando.size() == 1 && stanzaAttuale.getLink(comando.get(0)).vai() ) {
				stanzaAttuale = mondo.getRoom( stanzaAttuale.getLink(comando.get(0)).getNomeStanzaCollegata( stanzaAttuale.getNome() )  );		
				System.out.println("SEI IN " + stanzaAttuale.getNome());		
		}else if(inventario.contiene(comando.get(0)) ) {
			// controllo che si stia cercando di usare un Objects su un link  e che questo possa operare sul link richiesto
			if( Objects.class.isAssignableFrom(inventario.classeOggetto(comando.get(0)))  &&  comando.get(1).equals(inventario.getParametroOggetto(comando.get(0)))  ) {
				stanzaAttuale =   mondo.getRoom( stanzaAttuale.getLink(comando.get(1)).usa( stanzaAttuale.getNome() )  );
				System.out.println("SEI IN " + stanzaAttuale.getNome());		
			}
		}else {
			stampaImpossibilit‡Esecuzione();
		}
		
		
	}
	
	
	/**
	 * Metodo che rappresenta l'azione di entrare in un link o in una stanza direttamente (es. entra in stanza rosso fuoco / entra in grande porta  )
	 * @param comando comando rappresenta la stringa dopo il comando entra (es entra + arr ( stanza rosso fuoco   ))
	 * @param mondo  oggetto Mondo su cui si sta giocando
	 * @throws LinkNotFound 
	 */
	public void entraLink(ArrayList<String> comando, Mondo mondo) throws LinkNotFound {		
		
		if(stanzaAttuale.getLinkClass(comando.get(0)) == null) {
			stampaImpossibilit‡Esecuzione();
			return;
		}
		
		// controlla se si vuole accedere ad una stanza direttamente 
		if(  Room.class.isAssignableFrom(stanzaAttuale.getLinkClass(comando.get(0)))  ) {
			stanzaAttuale = mondo.getRoom(  comando.get(0)  );
			System.out.println("SEI IN " + stanzaAttuale.getNome());		
			return;
		}
		
		// controlla se si vuole entrare in un link e se quest'ultimo Ë aperto e quindi utilizzabile 
		if(Link.class.isAssignableFrom( stanzaAttuale.getLinkClass(comando.get(0)) ) && !stanzaAttuale.getLink(comando.get(0)).closed )
			stanzaAttuale = mondo.getRoom(   stanzaAttuale.getLink(comando.get(0)).getNomeStanzaCollegata(stanzaAttuale.getNome())   );
		
		System.out.println("SEI IN " + stanzaAttuale.getNome());		

	}
	
	
	/**
	 * Metodo che gestisce l'azione dai qualcosa a qualcuno 
	 * Si passa anche Element indicato nel comando dai + element + Character in modo che si possano eseguire eventuali controlli sulla classe dell'Element
	 * o su sue altre propriet‡
	 * @param comando comando rappresenta la stringa dopo il comando dai (es dai + arr ( chiave . Mario ))
	 */
	public void dai(ArrayList<String> comando) {
		if(comando.size()==2 &&  stanzaAttuale.isCharacterPresent(comando.get(1)) && inventario.contiene(comando.get(0))) {
			// eseguo il comando dai appropriato per il personaggio 
			stanzaAttuale.getCharactersMap().get(comando.get(1)).dai(this,  stanzaAttuale, inventario.getOggetto(comando.get(0)) );
			giocatore.inventario.prendi(comando.get(0));
			return;
		}
		stampaImpossibilit‡Esecuzione();
	}
	
	/**
	 * Metodo che permette al giocatore di prendere delle cose dalla stanza (oppure oggetti che sono contenuti in altri oggetti)
	 * @param comando comando rappresenta la stringa dopo il comando prendi (es prendi + arr ( chiave / gemma . camino ))
	 */
	public void prendi(ArrayList<String> comando) {
		
		// caso in cui sia soltanto prendi + Element inventariabile
		if (comando.size() == 1) {			
			
				// se l'oggetto non Ë di propriet‡ di qualcuno e lo possiamo prendere 
				if(stanzaAttuale.personaggioPossiedeOggetto(comando.get(0))) {
					System.out.println("L'oggetto Ë di qualcuno gi‡. NON SI RUBA!");
					return;
				}
			
				
				//controlla se Ë un elemento inventariabile e quindi prendibile dalla stanza 
				if ( stanzaAttuale.isElementInventariabile(comando.get(0)) ) {
						inventario.inserisci(comando.get(0), stanzaAttuale.prendi(comando.get(0)));
						inventario();
						return;
				}
				
								
				System.out.println("Non si puÚ prendere " + comando.get(0));
							
			
		}else {
			// caso in cui si abbia prendi + Element inventariabile + ObjectsContenitore ( es. prendi chiave da scrivania ->  0: chiave 1: scrivania )
				// controlla che si posso prendere l'element richiesto e che l'altro oggetto sia un oggetto contenitore 
				if (stanzaAttuale.isElementInventariabile(comando.get(0)) &&  ObjectContenitore.class.isAssignableFrom(stanzaAttuale.getObject(comando.get(1)).getClass()) )  {
					inventario.inserisci( comando.get(0) ,    ( (ObjectContenitore) stanzaAttuale.getObject(comando.get(1))).prendi(comando.get(0)) );
					inventario();
					return;
				}
				
				System.out.println("Non si puÚ prendere " + comando.get(0) + " da " + comando.get(1));
				
		}
		

	}
	

	/**
	 * Metodo che permette di discutere con un altro personaggio
	 * @param comando comando rappresenta la stringa dopo il comando discuti (es discuti + arr ( Mario ))
	 * @throws IOException 
	 */
	public void discuti(ArrayList<String> comando) throws IOException {
		if(stanzaAttuale.isCharacterPresent(comando.get(0))) {
			stanzaAttuale.getCharactersMap().get(comando.get(0)).discuti();
		}else {
			stampaFantasma(comando.get(0));
		}
	}
	
	/**
	 * Metodo che fa salutare il giocatore un altro personaggio
	 * @param comando comando rappresenta la stringa dopo il comando ringrazia (es ringrazia + arr ( Tom ))
	 */
	public void ringranzia(ArrayList<String> comando) {
		if(stanzaAttuale.isCharacterPresent(comando.get(0))) {
			System.out.println("Giocatore: Grazie "+ comando.get(0)+"!");
			stanzaAttuale.getCharacter(comando.get(0)).saluta();
		}else {
			stampaFantasma(comando.get(0));
		}
	}
	

	
	/**
	 * Metodo che fa salutare il giocatore un altro personaggio
	 * @param comando comando rappresenta la stringa dopo il comando saluta (es saluta + arr ( Luigi ))
	 */
	public void saluta(ArrayList<String> comando) {
		if(stanzaAttuale.isCharacterPresent(comando.get(0))) {
			System.out.println("Giocatore: Ciao "+ comando.get(0)+"!");
			stanzaAttuale.getCharacter(comando.get(0)).saluta();
		}else {
			stampaFantasma(comando.get(0));
		}
	}
	
	
	
	
	/**
	 * Metodo che ritorna l'inventario del giocatore 
	 * @return Inventario
	 */
	public Inventario getInventario() {
		return inventario;
	}
	
	/**
	 * Metodo che stampa l'errore del personaggio non presente, il cui nome Ë passato come parametro
	 * @param nome nome del personaggio non presente con cui si voleva interagire
	 */
	public void stampaFantasma(String nome) {
		System.out.println("Qui " + nome +  " non c'Ë...Hai per caso visto un fantasma?");
		System.out.println("     .-.\r\n"
				+ "   .'   `.\r\n"
				+ "   :g g   :\r\n"
				+ "   : o    `.\r\n"
				+ "  :         ``.\r\n"
				+ " :             `.\r\n"
				+ ":  :         .   `.\r\n"
				+ ":   :          ` . `.\r\n"
				+ " `.. :            `. ``;\r\n"
				+ "    `:;             `:'\r\n"
				+ "       :              `.\r\n"
				+ "        `.              `.     .\r\n"
				+ "          `'`'`'`---..,___`;.-'");
	}
	
	
	
	/**
	 * Metodo che stampa messaggio di errore 
	 */
	private static void stampaImpossibilit‡Esecuzione() {
		System.out.println("Impossibile eseguire il comando");
	}
	
	
}
