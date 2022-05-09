package it.uniroma1.textadv;

/**
 * Classe che va a rappresentare gli oggetti che possono contenere altri oggetti ad esempio scrivania / salvadanaio / camino ...  derivata dalla classe Objects
 */
public abstract class ObjectContenitore extends Objects{

	// Objects generico contenuto nell'oggetto contenitore
	protected Objects oggettoContenuto;
	//indica se l'oggetto contenuto è visibile dal giocatore
	protected boolean visibile;
	/**
	 * Costruttore della classe ObejctContenitore che richiama il costruttore della superclasse Objects
	 * @param nome nome che verrà dato all'ogg 
	 * @param parametro lista di String contenente i nomi degli eventuali parametri dell'ogg
	 */
	public ObjectContenitore(String nome, String parametro) {
		super(nome, parametro);
		oggettoContenuto = null;
		visibile = false;
	}

	/**		
	 * Metodo che ritorna  il nome dell'oggetto contenuto
	 */
	public String nomeContenuto() {
		if(visibile)
			return oggettoContenuto.getNome();
		return "";
	}
	
	/**
	 * Metodo che aggiunge un oggetto all'interno dell'oggetto contenitore 
	 * @param oggettoContenuto Objects che deve essere aggiunto all'interno dell'ObjectContenitore
	 */
	public void addOggettoContenuto( Objects oggettoContenuto) {
		this.oggettoContenuto = oggettoContenuto;
	}
	
	/**
	  Metodo che prende dall'oggetto il suo contenuto
	 @return Objects
	*/
	protected Objects prendi() {
		Objects ogg = oggettoContenuto;
		// ho preso l'oggetto quindi non lo avrò più
		this.oggettoContenuto = null;
		// metto a false per una questione di compatibilità con dei metodi in Room 
		visibile = false;
		return ogg;
	}
	
	/**
	 * Metodo che controlla se l'oggetto effettivamente contiene la cosa che si vuole prendere e in caso positivo la restituisce 
	 * @param nomeOggetto nome dell'oggetto che si vuole prendere dal contenitore
	 * @return Objects se l'oggetto richiesto è contenuto oppure null
	 */
	public Objects prendi(String nomeOggetto) {
		
		if (this.getVisibilità() && this.getObjectInside() != null &&  this.nomeContenuto().equals(nomeOggetto) ) {
			return this.prendi();
		}else {
			System.out.println("Nessun oggetto presente in "+ this.getNome() + " con il nome "+ nomeOggetto);
			return null;
		}
			
	}
	
	/**
	 * Metodo che ritorna l'oggetto contenuto 
	 * @return Objects 
	 */
	public Objects getObjectInside() {
		if(this.getVisibilità()) {
			return this.oggettoContenuto;
		}
		return null;
	}
	
	
	/**
	 * Ritorna se il contenuto dell'oggetto è visibile o no 
	 * @return boolean
	 */
	public boolean getVisibilità() {
		return this.visibile ;
	}
	
	/**
	 * Metodo che ritorna il toString dell'oggetto controllando se deve mostrare o no l'oggetto contenuto 
	 * @return String 
	 */
	public String toString() {
		if(visibile) {
			return super.toString() + " contenente " + this.oggettoContenuto.getNome();
		}else {
			return super.toString();
		}
	}
	
	/**
	 * Metodo che setta a visibile l'oggetto contenuto 
	 */
	public void setVisibile() {
		visibile = true;
	}

	
}
