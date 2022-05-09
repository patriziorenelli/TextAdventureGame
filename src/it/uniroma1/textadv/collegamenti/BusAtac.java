package it.uniroma1.textadv.collegamenti;

/**
 * Un Bus di tipo BusAtac che deriva dalla classe Bus. Il BusAtac ti fa aspettare per essere preso 
 */
public class BusAtac extends Bus{

	/**
	 * Costruttore della classe BusAtac che sfrutta il costruttore della classe Bus che a sua volta sfrutta il costruttore della superclasse Link
	 * @param nome nome che verrà dato al BusAtac generato
	 * @param room1 nome della 1' stanza che il busAtac collega
	 * @param room2 nome della 2' stanza che il busAtac collega 
	 */
	public BusAtac(String nome, String room1, String room2) {
		super(nome, room1, room2);
	}
	
	
	/**
	 * Metodo che ritorna il nome dell'altra stanza collegata dal link come tutti i link ma ha anche un output specifico per il BusAtac
	 * @param nome nome della stanza da escludere dal link
	 * @return String 
	 */
	public String getNomeStanzaCollegata(String nome) {
		if(nome.equals(this.getRoom1())) {
			System.out.println("Atac: Devi aspettare che arrivi");
			System.out.println("\t\t...24 HOURS LATER...\nEcco il tuo "+this.getNome()+"\n		.-------------------------------------------------------------.\r\n"
					+ "		'------..-------------..----------..----------..----------..--.|\r\n"
					+ "		|       \\\\            ||          ||          ||          ||  ||\r\n"
					+ "		|        \\\\           ||          ||          ||          ||  ||\r\n"
					+ "		|    ..   ||  _    _  ||    _   _ || _    _   ||    _    _||  ||\r\n"
					+ "		|    ||   || //   //  ||   //  // ||//   //   ||   //   //|| /||\r\n"
					+ "		|_.------\"''----------''----------''----------''----------''--'|\r\n"
					+ "		 |)|      |       |       |       |    |   ATAC  |      ||==|  |\r\n"
					+ "		 | |      |  _-_  |       |       |    |  .-.    |      ||==| C|\r\n"
					+ "		 | |  __  |.'.-.' |   _   |   _   |    |.'.-.'.  |  __  | \"__=='\r\n"
					+ "		 '---------'|( )|'----------------------'|( )|'----------\"\"\r\n"
					+ "		             '-'                          '-'");
			return this.getRoom2();
		}
		return this.getRoom1();
		
	}

}
