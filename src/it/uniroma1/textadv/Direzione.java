package it.uniroma1.textadv;

/**
 * Enumerazione dedicata alla Direzione.
 * Non si limita ad avere Nord, Sud, Ovest, Est come valori ma va a creare dei veri e proprio oggetti Direzione   
 */
public enum Direzione 
{
	 	NORD("Nord",  'N'   ),
	    SUD("Sud", 'S'),
	    OVEST("Ovest", 'O'),
	    EST("Est", 'E');

		private final String nome;
	    private final char abbreviazione;

	   

	/**
	 * Costruttore  della classe Direzione
	 * @param nome 
	 * @param abbreviazione
	 */
	Direzione(String nome, char abbreviazione ) {
		this.abbreviazione = abbreviazione;
		this.nome = nome;
	}

	/**
	 * Metodo che ritorna il nome di una direzione 
	 * @return String 
	 */
	public String getNome() {
		return nome;
	}
	

	/**
	 * Metodo che ricerca e ritorna l'abbreviazione di una direzione     
	 * @param dir stringa che rappresenta una direzione per esteso
	 * @return String 
	 */
	public static String getAbbreviazione(String dir) {
		for(Direzione s : 	Direzione.values()) {
			if(s.nome.equalsIgnoreCase(dir)) 
				return String.valueOf( s.abbreviazione ) ;
		}
		return null;
	}


	/**
	 * Metodo che ricerca e ritorna il nome completo di una direzione 
	 * @param dir abbreviazione della direzione di cui si vuole ottenere il nome completo
	 * @return String 
	 */
	public static String getNome(String dir) {
		
		if ( dir != null) {
				if (dir.length() == 1 ) {
						for(Direzione d : 	Direzione.values()) {
							if( String.valueOf(d.abbreviazione).equalsIgnoreCase(dir)) 
								return d.getNome();
						}
				}else if( getAbbreviazione(dir) != null) {
					return getNome(getAbbreviazione(dir));
				}
		}
		
		return null;
	}
	
	/**
	 * Se si passa una direzione valida allore ritorna true 
	 * @param nome stringa che si vuole verificare se sia una direzione valida 
	 * @return boolean 
	 */
	public static boolean isDirezione(String nome) {
		if(getNome(nome) != null || getAbbreviazione(nome) != null )
			return true;
		return false;
	}
  


}