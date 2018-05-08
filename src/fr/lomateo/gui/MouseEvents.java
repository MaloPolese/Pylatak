package fr.lomateo.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.lomateo.main.Fenetre;
import fr.lomateo.main.JeuStart;
import fr.lomateo.main.Scene;



public class MouseEvents implements MouseListener {

	private Scene scene = new Scene();
	private Menu menu;
	private Boutons bouton;
	

	public MouseEvents(Menu menu, Boutons bouton) {
		this.menu = menu;
		this.bouton = bouton;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (bouton.onBouton(e)) {
			bouton.setOnCliqued(true);
			if(bouton.getNom().equals("Start")){
				System.out.println("Start");
			}else if(bouton.getNom().equals("Quit")){
				System.out.println("Quit");
			}
			System.out.println("Clique sur bouton " + bouton.getOnCliqued() + " " + bouton.getNom());
			
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (bouton.onBouton(e)) {
			bouton.setOnCliqued(false);
			if(bouton.getNom().equals("Start")){
				System.out.println("Start");
				JeuStart.fenetre.setContentPane(scene);
				scene.revalidate();
			}else if(bouton.getNom().equals("Quit")){
				JeuStart.fenetre.dispose();
				System.out.println("Quit");
			}
			System.out.println("Clique sur bouton " + bouton.getOnCliqued()+ " " + bouton.getNom());
			
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
