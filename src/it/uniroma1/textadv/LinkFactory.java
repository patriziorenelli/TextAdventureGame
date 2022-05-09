package it.uniroma1.textadv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import it.uniroma1.textadv.eccezioni.ClasseLink;
/**
 * Classe che implementa la factory per i link 
 */
public class LinkFactory {

	/**
	 * Metodo che attraverso la reflection va a ottenere la classe del link richiesto, ottiene il suo costruttore e genera e restituisce il link richiesto 
	 * @param nome nome del Link da creare 
	 * @param classe nome della classe del Link da creare 
	 * @param room1 nome della 1' stanza collegata
	 * @param room2 nome della 2' stanza collegata 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	 public static Link getLink ( String nome, String classe, String room1, String room2 ) throws  ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		 	try {
		 
	    	Class<?> classCh =  Class.forName("it.uniroma1.textadv.collegamenti."+classe);
	    
	    	Constructor<?> cons = classCh.getConstructor(String.class, String.class, String.class);
	    	Link link = (Link) cons.newInstance(nome, room1, room2) ;
			return link;
			
		 	}catch(ClassNotFoundException e) {
		 		System.out.println("La classe del personaggio non esiste. Mondo non creato");
				System.exit(0);
				return null;
		 	}
	    }

}
