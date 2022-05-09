package it.uniroma1.textadv.personaggi;

/**
 * Classe Cane che rappresenta un Animale specifico
 */
public class Cane extends Animale {

	/**
	 * Costruttore della classe Cane che sfrutta il costruttore della superclasse Animale
	 * @param nome nome dell'ogg Cane 
	 */
	public Cane(String nome) {
		super(nome);
	}
	
	
	/**
	 * Costruttore della classe Cane che sfrutta il costruttore della superclasse Animale
	 * @param nome nome dell'ogg Cane
	 * @param oggetti array contenente i nomi degli oggetti posseduti
	 */
	public Cane(String nome,String[] oggetti) {
		super(nome,oggetti);
	}
	
	
	/**
	 * Override del metodo accarezza del metodo della superclasse Animale
	 */
	@Override
	public void accarezza() {
		System.out.println(this.getNome() + ": BAU BAU!! ");
	}
	
}
