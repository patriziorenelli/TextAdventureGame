package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta un Objects specifico di tipo Computer che può contenere altri oggetti al suo interno
 */
public class Computer extends  ObjectContenitore{

	/**
	 * Costruttore della classe Computer
	 * @param nome nome che verrà dato all'ogg Computer 
	 * @param parametro nome dell'eventuale parametro dell'ogg
	 */
	public Computer(String nome, String parametro) {
		super(nome, parametro);
	}
	
	
	/**
	 * Metodo usa che ha come parametro la stanza Attuale, quando si usa il computer si ottiene il progetto
	 * @param stanzaAttuale  Room attuale in cui si trova il giocatore
	 */
	@Override
	public void usa(Room stanzaAttuale)  {
		
		System.out.println("             ____________________________________________________\r\n"
				+ "            /                                                    \\\r\n"
				+ "           |    _____________________________________________     |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |  C:\\> _ Progettone Java                     |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |                                             |    |\r\n"
				+ "           |   |_____________________________________________|    |\r\n"
				+ "           |                                                      |\r\n"
				+ "            \\_____________________________________________________/\r\n"
				+ "                   \\_______________________________________/\r\n"
				+ "                _______________________________________________\r\n"
				+ "             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\r\n"
				+ "          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\r\n"
				+ "       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\r\n"
				+ "    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\r\n"
				+ " _-'.-.-.-.-.-. .---.-. .-----------------------------. .-.---. .---.-.-.-.`-_\r\n"
				+ ":-----------------------------------------------------------------------------:\r\n"
				+ "`---._.-----------------------------------------------------------------._.---'\r\n"
				+ "");
		
		System.out.println();
		System.out.println();
		// finisce il progetto e lo mette nel computer
		this.addOggettoContenuto( (Objects) new Progetto("progettone Java", null));
	}
	
	

}
