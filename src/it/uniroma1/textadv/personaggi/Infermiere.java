package it.uniroma1.textadv.personaggi;

import it.uniroma1.textadv.Character;
/**
 * Classe che rappresenta un Infermiere che è un Character specifico 
 */
public class Infermiere extends Character{

	
	
	/**
	 * Costruttore della classe Infermiere che sfrutta il costruttore della superclasse Character
	 * @param nome nome dell'Infermiere da creare
	 */
	public Infermiere(String nome) {
		super(nome);
	}
	
	
	/**
	 * Costruttore della classe Infermiere che sfrutta il costruttore della superclasse Character
	 * @param nome nome dell'infermiere da creare 
	 * @param oggetti array dei nomi degli oggetti che il personaggio possiede
	 */
	public Infermiere(String nome, String[] oggetti) {
		super(nome, oggetti);
	}
	
	
	
	/**
	 * Override del metodo parla  della classe Character
	 */
	@Override
	public void parla() {
		System.out.println();
		System.out.println(this.getNome() + ": Ei eccoti! Dai vieni che ti faccio il vaccino, ti prendi il greenPass nell'area di attesa e puoi andare");
		System.out.println("Giocatore: Va bene anche se lo sai che gli aghi mi mettono un po' di ansia");
		System.out.println(this.getNome() + ": Dai non guardare. Te lo faccio in un attimo. Poi l'ago non è neanche tanto grande");
		System.out.println( "                                       |\r\n"
			+ "                 ,------------=--------|___________|\r\n"
			+ "-=============%%%|         |  |______|_|___________|\r\n"
			+ "                 | | | | | | ||| | | | |___________|\r\n"
			+ "                 `------------=--------|           |\r\n"
			+ "                                       |");
		System.out.println("Giocatore: Tu mi prendi in giro...Aio! ");
		System.out.println(this.getNome() + ": Abbiamo fatto dai! Aspetta 15 minuti nell'area di attesa e puoi andare");
	}


}
