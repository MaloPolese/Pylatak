package fr.lomateo.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
	
	private final Scene scene;
	public Controls(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void keyPressed(KeyEvent e) {//quand la touche est utilisée

		// Joueur1
		// mouvements
		if (e.getKeyCode() == KeyEvent.VK_Z) { // saut
			this.scene.joueur1.setSaut(true);
		} else if (e.getKeyCode() == KeyEvent.VK_Q) { // gauche
			this.scene.joueur1.setMarche(true);
			this.scene.joueur1.setVersDroite(false);
			this.scene.setDxJ1(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {// droite
			this.scene.joueur1.setMarche(true);
			this.scene.joueur1.setVersDroite(true);
			this.scene.setDxJ1(1);
			// attack
		} else if (e.getKeyCode() == KeyEvent.VK_E) { // coup de point
			this.scene.joueur1.setFrappe(true);
		}

		// Joueur2
		// mouvements
		if (e.getKeyCode() == KeyEvent.VK_UP) { // saut
			this.scene.joueur2.setSaut(true);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // gauche
			this.scene.joueur2.setMarche(true);
			this.scene.joueur2.setVersDroite(false);
			this.scene.setDxJ2(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // droite
			this.scene.joueur2.setMarche(true);
			this.scene.joueur2.setVersDroite(true);
			this.scene.setDxJ2(1);
			// attack
		} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) { // coup de poind
			this.scene.joueur2.setFrappe(true);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {//quand la touche est relâchée

		//joueur 2
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.scene.joueur2.setMarche(false);
			this.scene.setDxJ2(0);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.scene.joueur2.setMarche(false);
			this.scene.setDxJ2(0);
		}
		
		//joueur 1
		if (e.getKeyCode() == KeyEvent.VK_D) {
			this.scene.joueur1.setMarche(false);
			this.scene.setDxJ1(0);
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			this.scene.joueur1.setMarche(false);
			this.scene.setDxJ1(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
