package it.uniroma1.textadv.eccezioni;
/**
 * Classe che si occupa di gestire l'eventuale eccezione che viene sollevata nel caso in cui il file indicato da cui va generato
 * il mondo non viene trovato
 * @author Patrizio
 *
 */
public class FileNonTrovato extends Exception{

	public FileNonTrovato() {
		System.out.println("Il file indicato non è stato trovato!");
	}
}
