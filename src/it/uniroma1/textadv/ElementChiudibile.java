package it.uniroma1.textadv;

/**
 * Classe che rappresenta un Element qualsiasi che può essere chiuso e bloccato (se sarà bloccato (locked) per aprire l'elemento generico sarà necessario un elemento specifico capace di aprirlo)
 */
public class ElementChiudibile extends Element{

	// lock rappresenta se l'oggetto deve essere sbloccato da un Objects
	protected boolean lock;
	// closed rappresenta se l'oggetto è semplicemente chiuso 
	protected boolean closed;
	
	/**
	 * Costruttore della classe ElementChiudibile che sfrutta il costruttore della superclasse Element
	 * @param nome nome da dare all'ElementChiudibile generato
	 */
	public ElementChiudibile(String nome) {
		super(nome);
		lock = false;
		closed = true;
	}

	/**
	 * Metodo getNome della classe ElementChiudibile
	 */
	@Override
	public String getNome() {
		return super.getNome();
	}

	
	
	/**
	 * Metodo che chiude/disattiva un link
	 */
	public void blocca() {
		lock = true;
	}
	
	/**
	 * Metodo per aprire/attivare un link 
	 */
	public void sblocca() {
		lock = false;
	}
	
	/**
	 * Metodo che prendi in ingresso un Objects e verificare se quell'oggetto può aprire l' Element  su cui è invocato
	 * @param oggetto oggetto di tipo Objects che si vuole usare per aprire l'ogg chiuso
	 */
	public void apri(Objects oggetto) {
		if(closed) {
			if(this.lock &&  oggetto.getParametro().equals(this.getNome())) {
				this.sblocca();
				closed = false;
				System.out.println( this.getNome() + " aperto");
				setVisibilità();
			}else if(this.lock && !oggetto.getParametro().equals(this.getNome()) ) {
				System.out.println( oggetto.getNome() + " non può aprire " + this.getNome());
			}
		}else{
			setVisibilità();
			System.out.println(this.getNome() + " è già aperto");
		}
		
	}


	/**
	 * Metodo apri senza parametri che può essere usato nel caso in cui un link non sia bloccato
	 */
	public void apri() {
		if(this.lock) {
			System.out.println(this.getNome() + " bloccato");
		}else if(!this.lock && !closed){
			setVisibilità();
			System.out.println(this.getNome() + " aperto");
		}else if(!this.lock && closed) {
			closed = false;
			setVisibilità();
			System.out.println(this.getNome() + " aperto");
		}
	}
	
	/**
	 * Un ElementChiudibile se è anche un ObjectContenitore una volta aperto deve mostrare l'eventuale contenuto 
	 */
	private void setVisibilità() {
		if( ObjectContenitore.class.isAssignableFrom(this.getClass())  )
			(  (ObjectContenitore) this ).setVisibile();
	}
	
	
	/**
	 * Metodo chiudi 
	 */
	public void chiudi() {
		System.out.println(this.getNome() + " chiuso");
		closed = true;
	}
	
	/**
	 * Metodo che chiude e blocca un ElementChiudibile
	 */
	public void chiudiConOggetto() {
		closed = true;
		lock = true;
		System.out.println(this.getNome() + " bloccato");
	}
}
