package it.uniroma1.textadv.personaggi;

import it.uniroma1.textadv.Character;
/**
 * Classe che rappresenta un Character specifico di tipo LavoratoreSapienza
 */
public class LavoratoreSapienza extends Character{

	/**
	 * Costruttore della classe LavoratoreSapienza che sfrutta il costruttore della superclasse Character
	 * @param nome nome del LavoratoreSapienza da creare 
	 * @param oggetti array dei nomi degli oggetti posseduti
	 */
	public LavoratoreSapienza(String nome, String[] oggetti) {
		super(nome, oggetti);
	}
	
	/**
	 * Costruttore della classe LavoratoreSapienza che sfrutta il costruttore della superclasse Character
	 * @param nome nome del LavoratoreSapienza da creare 
	 */
	public LavoratoreSapienza(String nome) {
		super(nome);
	}
	
	/**
	 * Override del metodo saluta specifico dei LavoratoreSapienza, dalla superclasse Character 
	 */
	@Override
	public void saluta() {
		System.out.println(this.getNome().substring(0, 1).toUpperCase() + this.getNome().substring(1) + ": Salve studente!");
	}
	
	

}
