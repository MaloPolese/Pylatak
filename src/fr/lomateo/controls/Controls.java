package fr.lomateo.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

	private final ControllablePersonnage joueur;
	private final int gauche;
	private final int droite;
	private final int saut;
	private final int coup;
	private final int bloque;

	public Controls(ControllablePersonnage joueur, int saut, int gauche, int droite, int coup, int bloque) {
		this.joueur = joueur;
		this.gauche = gauche;
		this.droite = droite;
		this.saut = saut;
		this.coup = coup;
		this.bloque = bloque;
	}

	// Quand une touche du clavier est utilisé

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == this.saut) {
			this.joueur.setSaut(true);
		} else if (e.getKeyCode() == this.gauche) {
			System.out.println("Gauche");
			this.joueur.setMarche(true);
			this.joueur.setVersDroite(false);
			this.joueur.setDxJ(-1);
		} else if (e.getKeyCode() == this.droite) {
			this.joueur.setMarche(true);
			this.joueur.setVersDroite(true);
			this.joueur.setDxJ(1);
		} else if (e.getKeyCode() == this.coup) {
			this.joueur.setFrappe(true);
			this.joueur.setMarche(false);
			this.joueur.setDxJ(0);
		}else if(e.getKeyCode() == this.bloque){
			this.joueur.setMarche(false);
			this.joueur.setDxJ(0);
			this.joueur.setBloque(true);			
		}

	}

	// Quand une touche du clavier est relaché
	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == this.droite) {
			this.joueur.setMarche(false);
			this.joueur.setDxJ(0);
		} else if (e.getKeyCode() == this.gauche) {
			this.joueur.setMarche(false);
			this.joueur.setDxJ(0);
		}else if(e.getKeyCode() == this.coup){
			this.joueur.setFrappe(false);
		}else if(e.getKeyCode() == this.bloque){
			this.joueur.setBloque(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
