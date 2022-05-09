package it.uniroma1.textadv.oggetti;

import it.uniroma1.textadv.Inventariabile;
import it.uniroma1.textadv.ObjectContenitore;
import it.uniroma1.textadv.Objects;

/**
 *Classe che rappresenta un ObjectContenitore specifico di tipo Scrivania 
 */
public class Scrivania extends  ObjectContenitore implements Inventariabile{

	/**
	 *Costruttore della classe Scrivania che sfrutta il costruttore della superclasse ObjectContenitore
	 * @param nome
	 * @param parametro
	 */
	public Scrivania(String nome, String parametro) {
		super(nome, parametro);
	}

	/**
	 * Override del metodo apri della classe ObjectConenitore
	 * Può essere chiusa ma non blocca (nel senso che serve un altro oggetto per aprirla)
	 */
	@Override
	public void apri() {
		if(!lock) {
			visibile = true;
			System.out.println("Scrivania APERTA");
		}else {
			super.apri();
		}
	}
	
	
	/**
	 * Override del metodo apri della classe ObjectContenitore
	 */
	@Override
	public void apri(Objects oggetto) {
		super.apri(oggetto);
	}
	
	
	/**
	 * Override del metodo toString della classe ObjectConenitore
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	/**
	 * Override del metodo addOggettoContenuto presente in ObjectContenitore che aggiunge l'oggetto all'interno 
	 * @param oggettoContenuto 
	 */
	@Override
	public void addOggettoContenuto( Objects oggettoContenuto) {
		super.addOggettoContenuto(oggettoContenuto);
	}
	
	
	/**
	 * Override del metodo prendi della classe ObjectContenitore
	 * @param nomeOggetto
	 * @return Objects
	 */
	@Override
	public Objects prendi(String nomeOggetto) {
		return super.prendi(nomeOggetto);
	}	
	

	
}
