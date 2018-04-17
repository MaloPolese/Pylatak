package fr.lomateo.main;
/**
 * @author Malo Polèse
 *
 */
public class JeuStart {

	public static void main(String[] args) {
		
		//création de la Fenetre
		
		Scene scene = new Scene();
		Fenetre fenetre  = new Fenetre(scene);
		Chrono chrono = new Chrono(scene);
		chrono.start();
		
		
	}

}
