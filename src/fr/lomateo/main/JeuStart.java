package fr.lomateo.main;
/**
 * @author Malo Pol�se
 *
 */
public class JeuStart {

	public static void main(String[] args) {
		
		//cr�ation de la Fenetre
		Scene scene = new Scene();
		Fenetre fenetre  = new Fenetre(scene);
		
		//rafraichissement de l'�cran
		Chrono chrono = new Chrono(scene);
		chrono.start();
		
		
	}

}
