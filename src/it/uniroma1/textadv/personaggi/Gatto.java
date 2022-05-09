package it.uniroma1.textadv.personaggi;
import it.uniroma1.textadv.Inventariabile;
/**
 * Classe che rappresenta un Gatto che è un Animale specifico 
 */
public class Gatto extends Animale implements Inventariabile{

	/**
	 * Costruttore della classe Gatto che sfrutta il costruttore della superclasse Animale
	 * @param nome nome dell'ogg Gatto da creare 
	 */
	public Gatto(String nome) {
		super(nome);
	}
	
	
	/**
	 * Costruttore della classe Gatto che sfrutta il costruttore della superclasse Animale
	 * @param nome nome dell'ogg Gatto da generare 
	 * @param oggetti array dei nomi degli ogg posseduti dal gatto
	 */
	public Gatto(String nome,String[] oggetti) {
		super(nome,oggetti);
	}
	

	/**
	 * Override del metodo accarezza della classe Animale
	 */
	@Override
	public void accarezza() {
		System.out.println(this.getNome() + ": MIAAAAAO ");
	}
	
	/**
	 * Override del metodo parla della superclasse Character (superclasse di Animale)
	 */
	@Override
	public void parla() {
		System.out.println("Gatto: FRRR!!  PRIMA IL PUNTINO ROSSO POI IL MONDO!! MIAOOOOOO!!!");
		System.out.println("Protagonista: Cosa? Ma i gatti non parlano! Tu sai farlo? ");
		System.out.println("Gatto: Miaoo  ... ");
		System.out.println("Gatto fissa l'umano con sguardo di sfida e affamato");
	}

}
