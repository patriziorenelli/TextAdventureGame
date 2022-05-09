package it.uniroma1.textadv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.uniroma1.textadv.eccezioni.FileNonTrovato;
import it.uniroma1.textadv.eccezioni.LinkNotFound;

/**
 * Classe che permette una partita
 * @author Patrizio
 *
 */
public class Gioco {

	static final String[] stopWord = { "con", "da", "su", "nel", "a", "nella", "in", "la" };
	
	// IMPLEMENTAZIONE DELLA PARTITA COMANDO PER COMANDO DA CONSOLE -> deve prendere i singoli comandi riga per riga e richiederli 
	public void play(Mondo mondo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound, IOException {
		
		//System.out.println(mondo);

		 System.out.println("Che il gioco abbia inizio.");
		 BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		//ciclo infinito finche' il giocatore non vince 
		while(true) {
			 comprensioneComando(reader.readLine(), mondo);
		}
		
	}

	/**
	 * Metodo che implementa la possibilità di effettuare una partita in modalità ff, quindi prendendo i vari comandi dal file selezionato di cui viene passato il Path
	 * @param mondo istanza di Mondo su cui verrà giocata la partita
	 * @param fast Path della partita che rappresenta una giocata fast
	 * @throws FileNonTrovato
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws LinkNotFound 
	 */
	public void play(Mondo mondo, Path fast) throws FileNonTrovato, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound{
		
		//System.out.println(mondo);
		
		BufferedReader reader;
		try {
			reader = new BufferedReader( new FileReader(fast.toString()) );
			String riga = reader.readLine();
			while (riga != null) {		
				
				// 	Bisogna sistemare lo split sugli  E VARI CASI
				
				if (riga.contains(" //")) {
					comprensioneComando(riga.split(" //")[0], mondo);
				}else if(riga.contains("	//")){ 
					comprensioneComando(riga.split("	//")[0], mondo); 
				}else if(riga.contains("//")){
					comprensioneComando(riga.split("//")[0], mondo); 
				}else {
					comprensioneComando(riga, mondo); 
				}
				
				
				
				riga = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			throw new FileNonTrovato();
		}
		
	}
	
	
	// VEDERE COME SNELLIARE STO METODO CON QUEGLI IF/ELSE INGUARDABILI 
	
	/**
	 * Si occupa di comprendere i singoli comandi dati in input al gioco 
	 * @param  comand stringa che rappresenta il comando da eseguire
	 * @param  mondo istanza del Mondo su cui giocare la partita 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws LinkNotFound 
	 */
	public void comprensioneComando(String comand, Mondo mondo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, LinkNotFound{
		String test = comand;
		// effettua il controllo se si invia solo spazi o tab o una riga vuota
		if(comand.isEmpty() || test.trim().length() == 0   ) {			
			return;
		}		
		
		// Stringhe manipolate per eliminazione stopWord e inizale suddivisione 
		List<String> comando = generazioneComando(comand);
		
		
		// gestione del caso in cui si abbia un comando con dei spazi eccessivi tra il comando e il nome dell'oggetto su cui effettuare il comando (es. "guarda  frigo")
		int spazi = 0;
		if( comando.size()>1) {
			
			 for (int i = 0; i < comando.get(1).length(); i++) {
				 if(comando.get(1).charAt(i) == ' ' ) {
					 spazi+=1;
				 }else {
					 break;
				 }
			}
			
		}
		// rimuovi i spazi eccessivi rilevati
		if(spazi>0) {
				comando.set(1, comando.get(1).substring(spazi, comando.get(1).length()));
		}
		
		
		
		
		
		comando.set(0, comando.get(0).toLowerCase());
		//System.out.println(comando);
	
		
		// abbiamo 3  possibilità il comando ha solo il comando "guarda" oppure un parametro "guarda, scrivania"  oppure 2 "apri, porta ripostiglio, chiave"
		try {
			
			//switch che gestisce i tipi di controlli da fare basandosi sul numero di parametri che ha il comando
			switch(comando.size()) {
			
				case 1:
					// nel caso si abbia solo il comando ( es: guarda / invntario ) 
					Giocatore.class.getDeclaredMethod(comando.get(0), null).invoke(mondo.getGiocatore(), null);
					break;
					
				case 2:{
					// nel caso in cui si abbia il comando + parametro ( che può essere sia un Link che un Objects)
					
					// caso in cui si stia eseguendo un comando + Objects ( es: guarda la scrivania, prendi chiave)   -> ho un parametro che non è link e non è vai il comando 
					if( !mondo.getStanzaGiocatore().isLinkPresent(comando.get(1)) && !Direzione.isDirezione(comando.get(1))  && !mondo.isRoomPresent(comando.get(1))  ) {
						Giocatore.class.getDeclaredMethod(comando.get(0), ArrayList.class).invoke(mondo.getGiocatore(), new ArrayList<String>(   comando.subList(1, comando.size()) )  );
						
					}else if(mondo.getStanzaGiocatore().isLinkPresent(comando.get(1)) || mondo.isRoomPresent(comando.get(1)) ) {
						// ho un parametro ed è un link o una stanza
						Giocatore.class.getDeclaredMethod(comando.get(0)+"Link", ArrayList.class, Mondo.class).invoke(mondo.getGiocatore(), new ArrayList<String>(   comando.subList(1, comando.size()) ), mondo  );
					}else {
						// ho un comando che è ad esempio vai N 
						Giocatore.class.getDeclaredMethod(comando.get(0), ArrayList.class, Mondo.class).invoke(mondo.getGiocatore(), new ArrayList<String>(   comando.subList(1, comando.size()) ), mondo  );
					}
				}break;
				
				case 3:{
					// nel caso si abba il comando + parametro + parametro ( es. usa chiave su armadio) 
					// caso in cui si stia eseguendo un comando + Objects +Objects  ( es: gusa chiave su armadio )   -> ho due oggetti che non sono link
					if( !mondo.getStanzaGiocatore().isLinkPresent(comando.get(1)) && !mondo.getStanzaGiocatore().isLinkPresent(comando.get(2))   ) {
						Giocatore.class.getDeclaredMethod(comando.get(0), ArrayList.class).invoke(mondo.getGiocatore(), new ArrayList<String>(   comando.subList(1, comando.size()) )  );
						
					}else if(mondo.getStanzaGiocatore().isLinkPresent(comando.get(2)) || mondo.getStanzaGiocatore().isLinkPresent(comando.get(1))) 
						// ho il secondo parametro che è link 
						Giocatore.class.getDeclaredMethod(comando.get(0)+"Link", ArrayList.class, Mondo.class).invoke(mondo.getGiocatore(), new ArrayList<String>(   comando.subList(1, comando.size()) ), mondo  );
					
				}break;
			}
			
		}catch(NoSuchMethodException e ) {
			
			if(comand.length() != 0)
				System.out.println("Impossibile eseguire il comando");
				
			

		}

		controllaVittoria(mondo);
	}
	
	
	
	
	/**
	 * Metodo che si occupa della gestione delle stopWord, eliminandole e generando un List<String> effettuando una divisione sulla stopWord contenuta  
	 * @param comand
	 * @return List<String>
	 */
	private List<String> gestioneStopWord(String comand) {
		//System.out.print(comand);
		for(String s : stopWord) {
			if(comand.indexOf(" "+s+" ") != -1 ) 				
				return  Arrays.stream(comand.replace(" "+s+" ", "!#").split("!#") ).collect(Collectors.toList());
		}
		return new ArrayList<String>( Arrays.asList(comand));
	}
	
	
	/**
	 * Metodo che si occupa di gestire lo split della prima parte del comando o di un comando senza stopWord 
	 * (es : vai S -> [vai, S] oppure prendi chiave da scrivania diventava [prendi chiave , scrivania] -> [prendi, chiave, scrivania] ) 
	 * @param comand
	 * @return List<String
	 */
	private List<String> generazioneComando(String comand){
		
		
		
		// Stringhe manipolate per eliminazione stopWord e inizale suddivisione 
		List<String> comando = gestioneStopWord(comand);		

		
		// controllo sullo split perchè può capitare come in  riga 35 che ha uno spazio dopo "guarda" e quindi diventa [guarda, ]  -> si rimuovono tutte le stringhe con lunghezza pari a  0
		String[] c = Arrays.stream( comando.get(0).split(" ", 2) ).filter(x -> x.length() != 0).toArray(String[]::new);
		// comando[0] contiene il comando da invocare 
		comando.set(0, c[0]);
		for(int x = 1; x<c.length; x++) 
				comando.add(x, c[x]);	
		
		return comando;
	}
	
	
	
	
	/**
	 * Metodo che controlla se il giocatore ha ottenuto il Tesoro ed ha quindi vinto -> se il giocatore ha il tesoro termina il gioco
	 * @param Mondo
	 */
	private void controllaVittoria(Mondo mondo) {
		if(mondo.getGiocatore().getInventario().contieneTesoro()) {
			System.out.println();
			
			System.out.println(" .----------------.  .----------------.  .----------------.   .----------------.  .----------------.  .-----------------. .----------------. \r\n"
					+ "| .--------------. || .--------------. || .--------------. | | .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
					+ "| |  ____  ____  | || |     ____     | || | _____  _____ | | | | _____  _____ | || |     ____     | || | ____  _____  | || |              | |\r\n"
					+ "| | |_  _||_  _| | || |   .'    `.   | || ||_   _||_   _|| | | ||_   _||_   _|| || |   .'    `.   | || ||_   \\|_   _| | || |      _       | |\r\n"
					+ "| |   \\ \\  / /   | || |  /  .--.  \\  | || |  | |    | |  | | | |  | | /\\ | |  | || |  /  .--.  \\  | || |  |   \\ | |   | || |     | |      | |\r\n"
					+ "| |    \\ \\/ /    | || |  | |    | |  | || |  | '    ' |  | | | |  | |/  \\| |  | || |  | |    | |  | || |  | |\\ \\| |   | || |     | |      | |\r\n"
					+ "| |    _|  |_    | || |  \\  `--'  /  | || |   \\ `--' /   | | | |  |   /\\   |  | || |  \\  `--'  /  | || | _| |_\\   |_  | || |     | |      | |\r\n"
					+ "| |   |______|   | || |   `.____.'   | || |    `.__.'    | | | |  |__/  \\__|  | || |   `.____.'   | || ||_____|\\____| | || |     |_|      | |\r\n"
					+ "| |              | || |              | || |              | | | |              | || |              | || |              | || |     (_)      | |\r\n"
					+ "| '--------------' || '--------------' || '--------------' | | '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
					+ " '----------------'  '----------------'  '----------------'   '----------------'  '----------------'  '----------------'  '----------------' ");
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("   _____ _                                       _              _         _____      _        _     _         _____                 _ _ _ \r\n"
					+ "  / ____(_)                                     | |            | |       |  __ \\    | |      (_)   (_)       |  __ \\               | | (_)\r\n"
					+ " | |  __ _  ___   ___ ___     ___ _ __ ___  __ _| |_ ___     __| | __ _  | |__) __ _| |_ _ __ _ _____  ___   | |__) |___ _ __   ___| | |_ \r\n"
					+ " | | |_ | |/ _ \\ / __/ _ \\   / __| '__/ _ \\/ _` | __/ _ \\   / _` |/ _` | |  ___/ _` | __| '__| |_  | |/ _ \\  |  _  // _ | '_ \\ / _ | | | |\r\n"
					+ " | |__| | | (_) | (_| (_) | | (__| | |  __| (_| | || (_) | | (_| | (_| | | |  | (_| | |_| |  | |/ /| | (_) | | | \\ |  __| | | |  __| | | |\r\n"
					+ "  \\_____|_|\\___/ \\___\\___/   \\___|_|  \\___|\\__,_|\\__\\___/   \\__,_|\\__,_| |_|   \\__,_|\\__|_|  |_/___|_|\\___/  |_|  \\_\\___|_| |_|\\___|_|_|_|\r\n"
					+ "                                                                                                                                          \r\n"
					+ "                                                                                                                                          ");
			System.exit(0);
		}
	}
	
	
	
}
