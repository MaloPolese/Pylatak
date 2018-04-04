package fr.lomateo.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.lomateo.personnages.Joueur;

public class Controls implements KeyListener {
	
	private final Joueur joueur;
	private final int gauche;
	private final int droite;
	private final int saut;
	private final int coup;
	
	public Controls(Joueur joueur, int saut, int gauche, int droite , int coup) {
		this.joueur = joueur;
		this.gauche = gauche;
		this.droite = droite;
		this.saut = saut;
		this.coup = coup;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == this.saut) {
			this.joueur.setSaut(true);
		} else if (e.getKeyCode() == this.gauche) {
			this.joueur.setMarche(true);
			this.joueur.setVersDroite(false);
			this.joueur.setDxJ(-1);
		} else if (e.getKeyCode() == this.droite) {
			this.joueur.setMarche(true);
			this.joueur.setVersDroite(true);
			this.joueur.setDxJ(1);
			// attack
		} else if (e.getKeyCode() == this.coup) {
			this.joueur.setFrappe(true);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == this.droite) {
			this.joueur.setMarche(false);
			this.joueur.setDxJ(0);
		} else if (e.getKeyCode() == this.gauche) {
			this.joueur.setMarche(false);
			this.joueur.setDxJ(0);
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

}
