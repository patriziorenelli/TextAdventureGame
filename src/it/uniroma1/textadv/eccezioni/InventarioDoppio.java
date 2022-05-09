package it.uniroma1.textadv.eccezioni;

public class InventarioDoppio extends Exception{

	public InventarioDoppio() {
		System.out.println("E' stato già creato un inventario per il personaggio ");
	}
	
}
