package it.uniroma1.textadv.collegamenti;

import it.uniroma1.textadv.Link;
import it.uniroma1.textadv.Objects;
/**
 * Classe che rappresenta un Link specifico di tipo Teletrasporto
 */
public class Teletrasporto extends Link{

	/**
	 * Costuttore della classe Teletrasporto che sfrutta il costruttore della superclasse Link
	 * @param nome
	 * @param room1
	 * @param room2
	 */
	public Teletrasporto(String nome, String room1, String room2) {
		super(nome,room1, room2);
	}
	
	

	/**
	 * Metodo che apre il Teletrasporto con un determinato oggetto
	 * Controlla se l'oggetto può effettivamente aprire il teletrasporto, se può lo apre se no gestisce le varie situazioni
	 * @param oggetto
	 */
	@Override
	public void apri(Objects oggetto) {
		super.apri(oggetto);
	}
	
	
	/**
	 * Metodo apri senza parametri che può essere usato nel caso in cui il teletrasporto non sia bloccato
	 */
	@Override
	public void apri() {
		super.apri();
	}
	
	
}
