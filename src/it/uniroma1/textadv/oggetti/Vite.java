package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Objects;
import it.uniroma1.textadv.Room;
import it.uniroma1.textadv.eccezioni.LinkNotFound;
/**
 * Classe che rappresenta una Vite che è un Objects specifico 
 */
public class Vite extends Objects{

	/**
	 * Costruttore della classe Vite che sfrutta il costruttore della classse Objects 
	 * @param nome
	 * @param parametro
	 */
	public Vite(String nome, String parametro) {
		super(nome, parametro);
	}


	/**
	 * Override del metodo usa della classe Objects 
	 * Il metodo apre specificamente la Botola
	 * @param stanzaAttuale 
	 * @throws LinkNotFound 
	 */
	@Override
	public void usa(Room stanzaAttuale) throws LinkNotFound {
		
		if(parametro != null) {
			if(stanzaAttuale.isLinkPresent(parametro) ) {
				 stanzaAttuale.getLink(parametro).sblocca();
				 System.out.println(parametro + " sbloccato");
			}else if(stanzaAttuale.isObjectPresent(parametro)) {
				stanzaAttuale.getObject(parametro).usa(stanzaAttuale);
			}else {
				super.usa(stanzaAttuale);
			}
		}else {
			super.usa(stanzaAttuale);
		}
	}
	
	


	
	
}
