package it.uniroma1.textadv.personaggi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.uniroma1.textadv.Character;
import it.uniroma1.textadv.Element;
import it.uniroma1.textadv.Giocatore;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.oggetti.Tesoro;
import it.uniroma1.textadv.oggetti.Voto;

/**
 * Classe che rappresenta Mamma che è un Character specifico 
 * @author Patrizio
 *
 */
public class Mamma extends Character{

	/**
	 * Costruttore specifico della classe  Mamma che sfrutta il costruttore della superclasse Character
	 * @param nome
	 * @param oggetti
	 */
	public Mamma(String nome, String[] oggetti) {
		super(nome, oggetti);
	}
	
	/**
	 * Costruttore specifico della classe  Mamma che sfrutta il costruttore della superclasse Character
	 * @param nome
	 */
	public Mamma(String nome) {
		super(nome);
	}

	/**
	 * Override del metodo discuti della classe Character 
	 * @throws IOException 
	 */
	@Override
	public void discuti() throws IOException {
		System.out.println("Mamma: Come va con il progetto?");
		
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		
		String risposta;
		
		//ciclo infinito finche' il giocatore non da una risposta del tipo bene/male
		while(true) {
			System.out.print("Risposta: ");
			risposta = reader.readLine();
			
			if (risposta.equalsIgnoreCase("bene") ) {
				System.out.println("Mamma: Ne sono felice. Spero che andrà bene");
				System.out.println("Mamma: Se esci ricordati di prendere la mascherina in salone");
				return;
			}else if(risposta.equalsIgnoreCase("male")) {
				System.out.println("Mamma: Non ti preoccupare ce la farai dai...");
				System.out.println("Mamma: Se esci ricordati di prendere la mascherina in salone");
				return;
			}else {
				System.out.println("Mamma: Non ho capito, come sta andando quindi?");
			}
		}
	}
	
	
	/**
	 * Override del metodo dai specifico per Mamma. Se Mamma riceve un voto allora è felice, ti prepara una carbonara e te la da,  se no ringrazia per l'oggetto che gli dai 
	 * @param personaggio
	 * @param stanza
	 * @param element 
	 */
	@Override
	public void dai(Giocatore personaggio, Room stanza, Element element){
		
		if(Voto.class.isAssignableFrom(element.getClass())) {
			System.out.println(this.getNome() +": Finalmente! Ora ti preparo una carbonara per festeggiare");
			System.out.println(this.getNome() +": Eccola, come piace a te. Te la sei meritata <3");
			System.out.println("Giocatore: Grazie Mamma <3");
			personaggio.getInventario().inserisci("carbonara", new Tesoro("carbonara", null));
		}else {
			super.dai(personaggio, stanza, element);
		}
	}
	


}
