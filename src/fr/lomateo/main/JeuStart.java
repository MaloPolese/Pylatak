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
		Rafra�chissement chrono = new Rafra�chissement(scene);
		chrono.start();
		
		
		
	}

}
