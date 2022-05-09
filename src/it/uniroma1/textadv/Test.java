package it.uniroma1.textadv;

import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Classe Test utilizzata per provare il funzionamento del progetto d'esame
 */
public class Test
{
	public static void main(String[] args) throws Exception
{
	Gioco g = new Gioco();

	
	//Mondo m = Mondo.fromFile("mioGioco.game");
	//Path scriptDiGioco = Paths.get("mioGioco.ff");
	
	Mondo m = Mondo.fromFile("minizak.game");
    Path scriptDiGioco = Paths.get("minizak.ff");
    
	
	//Mondo m = Mondo.fromFile("minizak_18.game");
    //Path scriptDiGioco = Paths.get("minizak_18.ff");
    
	g.play(m, scriptDiGioco);
	//g.play(m);

	
	
}
}
