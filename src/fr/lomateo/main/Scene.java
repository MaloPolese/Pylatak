package fr.lomateo.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.lomateo.personnages.Joueur;
import fr.lomateo.structures.GrandePlateformes;
import fr.lomateo.structures.Mur;
import fr.lomateo.structures.PetitePlateformes;
import fr.lomateo.structures.Structures;

public class Scene extends JPanel {

	private static final long serialVersionUID = -1578970639764868768L;

	// backGround images
	private final ImageIcon icoFond;
	private final Image imgFond;

	// Personnages
	public Joueur joueur1;
	public Joueur joueur2;

	//Control
	public Controls ControlJ1;
	public Controls ControlJ2;

	// structures
	private final PetitePlateformes petitePlateformeDroite;
	private final PetitePlateformes petitePlateformeGauche;
	private final GrandePlateformes grandePlateforme1;
	private final Mur murGauche;
	private final Mur murDroite;

	// position du sol & du plafond
	private int ysol;
	private int hauteurPlafond;

	// ArrayList pour stocker les structures && Joueurs
	public ArrayList<Structures> structures;
	private ArrayList<Joueur> joueurs;

	public Scene() {

		this.ysol = 692;// 592
		this.hauteurPlafond = 0;

		//Création des joueurs
		joueur1 = new Joueur(70, 592, "J1", this);
		joueur2 = new Joueur(1045, 592, "J2", this);// 1045
		joueur1.setVersDroite(true);
		joueur2.setVersDroite(false);

		//Création des controls
		this.setFocusable(true);
		this.requestFocusInWindow();
		ControlJ1 = new Controls(joueur1, 0x5A, 0x51, 0x44, 0x45); // (joueur , saut , gauche , droite , coup)
		ControlJ2 = new Controls(joueur2, 0x26, 0x25, 0x27, 0x61); // (joueur , saut , gauche , droite , coup)
		this.addKeyListener(ControlJ1);
		this.addKeyListener(ControlJ2);

		//Création du fond
		icoFond = new ImageIcon(getClass().getResource("/BackGroundBeta.png"));
		imgFond = icoFond.getImage();

		//Création de plateformes
		petitePlateformeDroite = new PetitePlateformes("PetitePlateformeDroite", 899, 320);
		petitePlateformeGauche = new PetitePlateformes("PetitePlateformeGauche", 31, 320);
		grandePlateforme1 = new GrandePlateformes("GrandePlateforme1", 370, 500);// 500
		murGauche = new Mur("murDroite", 0, 0);
		murDroite = new Mur("murGauche", 1167, 0);
	
		
		//ArrayList
		structures = new ArrayList<Structures>();
		this.structures.add(this.petitePlateformeDroite);
		this.structures.add(this.petitePlateformeGauche);
		this.structures.add(this.grandePlateforme1);
		this.structures.add(this.murGauche);
		this.structures.add(this.murDroite);
		
		joueurs = new ArrayList<Joueur>();
		this.joueurs.add(joueur1);
		this.joueurs.add(joueur2);
	}

	@Override
	//methode pour peindre l'écran
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// affichage du fond
		g2.drawImage(imgFond, 0, 0, this.getWidth(), this.getHeight(), this);

		// affichage des Joueurs
		for(Joueur joueur : this.joueurs){
			joueur.deplacementJ(g2);
		}
		
		//affichage des Structures 
		for(Structures structure : this.structures){
			structure.paint(g2);
		}
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