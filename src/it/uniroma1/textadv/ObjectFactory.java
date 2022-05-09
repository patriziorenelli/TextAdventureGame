package it.uniroma1.textadv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Classe FactoryObjects che implementa il Factory Pattern per la creazione dei vari oggetti richiesti dal gioco.
 * Inoltre la classe sfrutta la reflection nel metodo getObjects che è l'unico metodo della classe, che si occupa della creazione degli oggetti 
 */
public class ObjectFactory {

	public ObjectFactory() {}
	
	/**
	 * Metodo che ricevuto il nome dell'oggetto, la classe specifica dell'oggetto e l'eventuale parametro, ritorna un oggetto di classe Objects padre dei singoli oggetti (	Armadio, Cacciavite, Camino, Cassetto, ...) 
	 * Sfruttando la reflection si ricava la classe dell'oggetto da creare (con il metodo forName), il costruttore della classe (con il metodo getConstructor) 
	 * e infine si genera l'oggetto richiesto con il metodo (con il metodo newInstance)
	 * @param nome
	 * @param classe
	 * @param parametro
	 * @return Objects ogg 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
    public static Objects getObjet ( String nome, String classe, String parametro ) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{    	
    	
    	try {
	    	Class<?> classObj =  Class.forName("it.uniroma1.textadv.oggetti."+classe);
	    	Constructor<?> cons = classObj.getConstructor(String.class, String.class);
	    	Objects ogg = (Objects) cons.newInstance(nome, parametro);
			return ogg;
		
    	}catch(ClassNotFoundException e) {
    		System.out.println("Classe dell'oggetto non esistente. Mondo non creato");
			System.exit(0);
    		return null;
    	}
		
    }
	
	

}
