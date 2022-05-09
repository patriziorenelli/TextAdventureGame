package it.uniroma1.textadv.personaggi;

import it.uniroma1.textadv.Character;
import it.uniroma1.textadv.Element;
import it.uniroma1.textadv.Giocatore;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.oggetti.Maglietta;
import it.uniroma1.textadv.oggetti.Progetto;
import it.uniroma1.textadv.oggetti.Voto;

/**
 * Classe che rappresenta un Character specifico di tipo Professore 
 */
public class Professore extends Character{

	/**
	 * Parametro usato per indicare si è già esposto il progetto al professore
	 */
	private boolean esposto;
	
	/**
	 * Costruttore della classe Professore che sfrutta il costruttore della classe Character
	 * @param nome
	 * @param oggetti
	 */
	public Professore(String nome, String[] oggetti) {
		super(nome, oggetti);
		esposto = false;
	}

	/**
	 * Costruttore della classe Professore che sfrutta il costruttore della classe Character
	 * @param nome 
	 */
	public Professore(String nome) {
		super(nome);
	}
	
	
	/**
	 * Override del metodo parla, che rappresenta una conversazione specifica con il Professore sull'esame, della classe Character
	 */
	@Override
	public void parla() {
		if(!esposto) {
			System.out.println("Giocatore: Buongiorno"+this.getNome());
			System.out.println(this.getNome() + ": Buongiorno. Pronto per l'esposizione?");
			System.out.println("Giocatore: Lo spero, ho fatto l'esame a Luglio e vorrei chiudere il cerchio"
					+ "\n	   E' l'unico esame del primo anno che mi è rimasto e ho cercato di fare un buon progetto per alzare la media");
			System.out.println(this.getNome() + ": Bene dai! Fammi vedere il progetto così ne discutiamo");
		}else {
			System.out.println(this.getNome()+": Ciao! Hai già discusso il progetto puoi andare");
		}
	
	}
	
	
	
	
	
	/**
	 * Override del metodo dai, specifico per la classe Professore che si aspetta un oggetto di tipo Progetto, della classe Character 
	 * Il professore ti dà il voto e la maglietta di BabelNet
	 * @param personaggio
	 * @param room
	 * @param element
	 */
	@Override
	public void dai(Giocatore personaggio, Room room, Element element) {
		if(Progetto.class.isAssignableFrom(element.getClass())) {
			personaggio.getInventario().prendi(element.getNome());
			super.dai(personaggio, room, element);
			System.out.println(this.getNome() + ": Ottimo progetto. Ti meriti un buon voto! E ho una sorpresa per te... La maglietta di BabelNet");
			personaggio.getInventario().inserisci("maglietta BabelNet", new Maglietta("maglietta BabelNet", null));
			personaggio.getInventario().inserisci("voto esame Metodologie di Programmazione", new Voto("voto esame Metodologie di Programmazione", null));
			personaggio.inventario();
		}else {
			System.out.println(this.getNome()+": Per ricevere il voto dell'esame devi farmi vedere il progetto");
		}
	}
	
	
	
	
	
	


}
