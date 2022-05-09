package it.uniroma1.textadv;

/**
 * Classe astratta Element che rappresenta un elemento generico del mondo, da questa classe derivano tutte le classi fondamentali per il gioco (Room, Character, ElementChiudibile)
 */
public abstract class Element {
	
	protected String nome;
	/**
	 * Costruttore della classe Element
	 * @param nome rappresenta il nome che viene impostato all'oggetto Element
	 */
	public Element(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo che ritorna il nome dell'Element
	 * @return String 
	 */
	 public String getNome() {
		 return this.getNome();
	 }


	/**
	 * Ritorna se l'oggetto è inventariabile (se può essere inserito nell inventario) o no 
	 * @return boolean
	 */
	public boolean inventariabile() {
		return Inventariabile.class.isAssignableFrom(this.getClass() );
	}

}
