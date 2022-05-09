package it.uniroma1.textadv.eccezioni;

/**
 * Classe che si occupa di gestire l'eccezione nel caso in cui si cerchino di creare più giocatori
 * @author Patrizio
 *
 */
public class ProtagonistaDoppio extends Exception{
		public ProtagonistaDoppio() {
			System.out.println("Si è già generato un giocatore. E' possibile crearne solo uno");
		}

}
