package fr.lomateo.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.lomateo.controls.Controls;
import fr.lomateo.gui.GuiVie;
import fr.lomateo.gui.Menu;
import fr.lomateo.personnages.DefaultJoueur;
import fr.lomateo.structures.GrandePlateformes;
import fr.lomateo.structures.Mur;
import fr.lomateo.structures.PetitePlateformes;
import fr.lomateo.structures.Structures;

public class Scene extends JPanel {

	private static final long serialVersionUID = -1578970639764868768L;
	// backGround images
	private final ImageIcon icoFond;
	private final Image imgFond;

	private final GuiVie gui;

	public DefaultJoueur joueur1;
	public DefaultJoueur joueur2;

	// structures
	public final PetitePlateformes petitePlateformeDroite;
	public final PetitePlateformes petitePlateformeGauche;
	public final GrandePlateformes grandePlateforme1;
	public final GrandePlateformes grandePlateforme2;
	public final GrandePlateformes grandePlateforme3;
	public final Mur murGauche;
	public final Mur murDroite;

	// position du sol & du plafond
	private int ysol;
	private int hauteurPlafond;

	// ArrayList pour stocker les structures && Joueurs
	public ArrayList<Structures> structures;
	public ArrayList<DefaultJoueur> joueurs;

	public Scene(Menu menu, Fenetre fenetre) {

		this.ysol = 689;// 692
		this.hauteurPlafond = 0;

		this.gui = new GuiVie(this);

		// Création des joueurs
		joueur1 = new DefaultJoueur(this, 70, 603, "J1", true);
		joueur2 = new DefaultJoueur(this, 1045, 603, "J2", false);

		// Création des controls

		this.addKeyListener(new Controls(joueur1, 0x5A, 0x51, 0x44, 0x45, 0x53, menu, fenetre));
		this.addKeyListener(new Controls(joueur2, 0x26, 0x25, 0x27, 0x61, 0x28 , menu, fenetre));

		// Création du fond
		icoFond = new ImageIcon(getClass().getResource("/BackGroundBeta.png"));
		imgFond = icoFond.getImage();

		// Création de plateformes
		petitePlateformeDroite = new PetitePlateformes("Plateforme3", 908, 410);
		petitePlateformeGauche = new PetitePlateformes("Plateforme4", 0, 412);
		grandePlateforme1 = new GrandePlateformes("Plateforme5", 375, 552);// 500
		grandePlateforme2 = new GrandePlateformes("Plateforme2", 228, 262);// 500
		grandePlateforme3 = new GrandePlateformes("Plateforme1", 663, 120);// 500

		murGauche = new Mur("murDroite", 0, -58);
		murDroite = new Mur("murGauche", 1167, -58);

		// ArrayList
		structures = new ArrayList<Structures>();
		this.structures.add(this.petitePlateformeDroite);
		this.structures.add(this.petitePlateformeGauche);
		this.structures.add(this.grandePlateforme1);
		this.structures.add(this.grandePlateforme2);
		this.structures.add(this.grandePlateforme3);
		//this.structures.add(this.murGauche);
		//this.structures.add(this.murDroite);

		joueurs = new ArrayList<DefaultJoueur>();
		this.joueurs.add(joueur1);
		this.joueurs.add(joueur2);

	}

	@Override
	// methode pour peindre l'écran
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// affichage du fond
		g2.drawImage(imgFond, 0, 0, this.getWidth(), this.getHeight(), this);

		gui.Heal(g2);

		// affichage des Joueurs
		for (DefaultJoueur joueur : this.joueurs) {
			joueur.deplacement(g2);
		}

		// affichage des Structures
		for (Structures structure : this.structures) {
			structure.paint(g2);
		}

	}
	
	public void focus(){
		this.requestFocus();
		this.revalidate();
	}

	// ****Getter && Setter******

	public int getYsol() {
		return ysol;
	}

	public int getHauteurPlafond() {
		return hauteurPlafond;
	}

	public void setYsol(int ysol) {
		this.ysol = ysol;
	}
}