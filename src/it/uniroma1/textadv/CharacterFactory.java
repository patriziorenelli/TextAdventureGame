package it.uniroma1.textadv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
/**
 * Classe che implementa il Factory Pattern per la creazione dei Character cioè i vari personaggi presenti nel gioco
 */
public class CharacterFactory {

		/**
		 * Metodo che implementa la factory per i Character, attraverso la reflection va ad ottenere il costruttore delle singole classi Character, lo invoca 
		 * e ritorna l'istanza del nuovo personaggio richiesto 
		 * @param nome nome del personaggio da ottenere 
		 * @param classe nome della classe del Character da creare
		 * @param parametro lista contenente i nomi degli eventuali possedimenti 
		 * @throws NoSuchMethodException
		 * @throws SecurityException
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 * @throws ClassNotFoundException 
		 */
	   public static Character getCharacter ( String nome, String classe, String[] parametro) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{

	    
	    	
	    	try {
	    	
	    		Class<?> classCh =  Class.forName("it.uniroma1.textadv.personaggi."+classe);
		    	Constructor<?> cons = null;
		    	Character pers = null; 
		    	
		    	if ( parametro.length > 0   ) {
		    		cons = classCh.getConstructor(String.class, String[].class);
		    		pers = (Character) cons.newInstance(nome, parametro);
		    	}else {
		    		cons = classCh.getConstructor(String.class);
		    		pers = (Character) cons.newInstance(nome);
		    	}
		    	 
				return pers;
			
	    	}catch(ClassNotFoundException e) {
				System.out.println("La classe del personaggio non esiste. Mondo non creato");
				System.exit(0);
				return null;
			}
			
	
	    	
	    }
		
}
