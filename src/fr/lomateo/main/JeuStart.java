package fr.lomateo.main;

import fr.lomateo.gui.Menu;

/**
 * @author Malo Pol�se
 *
 */
public class JeuStart {

	public static Fenetre fenetre;

	public static void main(String[] args) {

		// cr�ation de la Fenetre

		// Scene scene = new Scene();

		Menu menu = new Menu();
		fenetre = new Fenetre(menu);

		// rafraichissement de l'�cran

		// Rafra�chissement chrono = new Rafra�chissement(scene);
		// chrono.start();

	}

}
