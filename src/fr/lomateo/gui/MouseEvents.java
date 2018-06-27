package fr.lomateo.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.lomateo.main.Fenetre;
import fr.lomateo.main.JeuStart;
import fr.lomateo.main.Scene;

public class MouseEvents implements MouseListener {


	private Boutons bouton;
	private Scene scene;
	private Fenetre fenetre;
	public MouseEvents(Boutons bouton, Scene scene, Fenetre fenetre) {

		this.fenetre= fenetre;
		this.bouton = bouton;
		this.scene = scene;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (bouton.onBouton(e)) {
			bouton.setOnCliqued(true);
			if (bouton.getNom().equals("Start")) {
				System.out.println("Start");
			} else if (bouton.getNom().equals("Quit")) {
				System.out.println("Quit");
			}
			System.out.println("Clique sur bouton " + bouton.getOnCliqued() + " " + bouton.getNom());

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (bouton.onBouton(e)) {
			bouton.setOnCliqued(false);
			if (bouton.getNom().equals("Start")) {
				System.out.println("Start");
				
				fenetre.cl.next(fenetre.content);
				scene.focus();


			} else if (bouton.getNom().equals("Quit")) {

				System.exit(0);
				System.out.println("Quit");
			}
			System.out.println("Clique sur bouton " + bouton.getOnCliqued() + " " + bouton.getNom());

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
