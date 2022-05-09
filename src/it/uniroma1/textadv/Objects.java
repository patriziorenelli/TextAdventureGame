package it.uniroma1.textadv;

import it.uniroma1.textadv.eccezioni.LinkNotFound;

/**
 * Classe astratta che rappresenta un oggetto base presente nel mondo  
 */
public abstract class Objects extends ElementChiudibile{

	// parametro per l'oggetto 
	protected String parametro;
	/**
	 * Costrttore della classe Objects che sfrutta il costruttore della superclasse ElementChiudibile
	 * @param nome nome dell'oggetto Objects che verrà generato
	 * @param parametro eventuale parametro dell'Objects
	 */
	public Objects(String nome, String parametro) {
		super(nome);
		this.parametro = parametro;
	}
	
	/**
	 * Metodo che ritorna il nome dell'oggetto
	 * @return String 
	 */
	@Override
	public String getNome() {
		return nome;
	}
	
	
	/**
	 * Override del metodo equals fatto appositamente per la classe Objects
	 * @param ob Object generico da confrontare con con un  Objects 
	 * @return boolean
	 */
	@Override 
	public boolean equals(Object ob) {
		Objects ogg= null;
		
		if(ob instanceof Objects) {
			ogg = (Objects) ob;
			return ogg.nome.equals(this.nome);
		}else {	
			return false;		 
		}
	}
	
	
	/**
	 * Override del metodo toString che restituisce soltanto il nome dell'oggetto 
	 * @return String name
	 */
	@Override
	public String toString ()
	{
		return this.getNome();
	}
	
	
	/**
	 * Metodo che ritorna il parametro
	 * @return String 
	 */
	public String getParametro() {
		return parametro;
	}
	
	

	/**
	 * Metodo da usare se si vuole rompere l'oggetto
	 */
	public void rompi() {
		System.out.println("Non puoi spaccare tutto se no poi con che giochi :(");
	}

	
	/**
	 * Metodo usa che ha come parametro la stanza Attuale, in caso possa eventualmente svolgere un azione specifica da solo 
	 * @param stanzaAttuale  oggetto Room che rappresenta la stanza in cui si trova attualmente il giocatore
	 * @throws LinkNotFound 
	 */
	public void usa(Room stanzaAttuale) throws LinkNotFound {
		System.out.println("L'oggetto non fa niente da solo, gioca e trovagli un amico dai!  :|");
	}
	
	/**
	 * Metodo usa che va a essere utilizzato su un altro oggetto che però ha bisogno di poter accedere alla stanza per effettuare le sue operazioni
	 * @param ob Oggetto su cui va usato l'oggetto
	 * @param stanzaAttuale oggetto Room che rappresenta la stanza in cui si trova attualmente il giocatore
	 * @throws LinkNotFound 
	 */
	public void usa(Objects ob, Room stanzaAttuale) throws LinkNotFound{
		System.out.println("Non saprei che fargli fare a queste cose insieme sinceramente");
	}
	
	
	
	
}
