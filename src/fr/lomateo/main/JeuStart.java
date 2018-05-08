package fr.lomateo.main;

import fr.lomateo.gui.Menu;

/**
 * @author Malo Polèse
 *
 */
public class JeuStart {

	public static Fenetre fenetre;

	public static void main(String[] args) {

		// création de la Fenetre

		// Scene scene = new Scene();

		Menu menu = new Menu();
		fenetre = new Fenetre(menu);

		// rafraichissement de l'écran

		// Rafraîchissement chrono = new Rafraîchissement(scene);
		// chrono.start();

	}

}
