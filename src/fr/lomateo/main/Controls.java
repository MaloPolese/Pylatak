package fr.lomateo.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {//quand la touche est utilisée

		// Joueur1
		// mouvements
		if (e.getKeyCode() == KeyEvent.VK_Z) { // saut
			Fenetre.scene.joueur1.setSaut(true);
		} else if (e.getKeyCode() == KeyEvent.VK_Q) { // gauche
			Fenetre.scene.joueur1.setMarche(true);
			Fenetre.scene.joueur1.setVersDroite(false);
			Fenetre.scene.setDxJ1(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {// droite
			Fenetre.scene.joueur1.setMarche(true);
			Fenetre.scene.joueur1.setVersDroite(true);
			Fenetre.scene.setDxJ1(1);
			// attack
		} else if (e.getKeyCode() == KeyEvent.VK_E) { // coup de point
			Fenetre.scene.joueur1.setFrappe(true);
		}

		// Joueur2
		// mouvements
		if (e.getKeyCode() == KeyEvent.VK_UP) { // saut
			Fenetre.scene.joueur2.setSaut(true);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // gauche
			Fenetre.scene.joueur2.setMarche(true);
			Fenetre.scene.joueur2.setVersDroite(false);
			Fenetre.scene.setDxJ2(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // droite
			Fenetre.scene.joueur2.setMarche(true);
			Fenetre.scene.joueur2.setVersDroite(true);
			Fenetre.scene.setDxJ2(1);
			// attack
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) { // coup de poind
			Fenetre.scene.joueur2.setFrappe(true);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {//quand la touche est relâchée

		//joueur 2
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Fenetre.scene.joueur2.setMarche(false);
			Fenetre.scene.setDxJ2(0);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Fenetre.scene.joueur2.setMarche(false);
			Fenetre.scene.setDxJ2(0);
		}
		
		//joueur 1
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Fenetre.scene.joueur1.setMarche(false);
			Fenetre.scene.setDxJ1(0);
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			Fenetre.scene.joueur1.setMarche(false);
			Fenetre.scene.setDxJ1(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
