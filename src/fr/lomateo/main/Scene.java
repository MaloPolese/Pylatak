package fr.lomateo.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	
	// variable de déplacement x des joueurs
	private int dxJ1;
	private int dxJ2;

	// structures
	private PetitePlateformes petitePlateformeDroite;
	private PetitePlateformes petitePlateformeGauche;
	private GrandePlateformes grandePlateforme1;
	private Mur murGauche;
	private Mur murDroite;

	// position du sol & du plafond
	private int ysol;
	private int hauteurPlafond;

	// tableau pour stocker les structures
	private ArrayList<Structures> structures;

	public Scene() {

		this.ysol = 692;// 592
		this.hauteurPlafond = 0;
		this.dxJ1 = 0;
		this.dxJ2 = 0;

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Controls(this));

		icoFond = new ImageIcon(getClass().getResource("/BackGroundBeta.png"));
		imgFond = icoFond.getImage();

		joueur1 = new Joueur(70, 592, this);
		joueur2 = new Joueur(1045, 592, this);
		joueur1.setVersDroite(true);
		joueur2.setVersDroite(false);

		petitePlateformeDroite = new PetitePlateformes("PetitePlateformeDroite", 899, 320);
		petitePlateformeGauche = new PetitePlateformes("PetitePlateformeGauche", 31, 320);
		grandePlateforme1 = new GrandePlateformes("GrandePlateforme1", 370, 500);
		murGauche = new Mur("murDroite", 0, 0);
		murDroite = new Mur("murGauche", 1167, 0);

		structures = new ArrayList<Structures>();

		this.structures.add(this.petitePlateformeDroite);
		this.structures.add(this.petitePlateformeGauche);
		this.structures.add(this.grandePlateforme1);
		this.structures.add(this.murGauche);
		this.structures.add(this.murDroite);


	}

	// methode de deplacement des joueurs
	public void deplacementJ() {

		this.joueur1.setX(this.joueur1.getX() + this.dxJ1);
		this.joueur2.setX(this.joueur2.getX() + this.dxJ2);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Boucle parcourant le tableau de structures
		for (Structures structures : structures) {
			// detection des contacts
			if (this.joueur1.proche(structures)) {
				this.joueur1.contact(structures);
			}
			if (this.joueur2.proche(structures)) {
				this.joueur2.contact(structures);
			}
		}
		// deplacements des Joueurs
		this.deplacementJ();

		// affichage du fond
		g2.drawImage(imgFond, 0, 0, this.getWidth(), this.getHeight(), this);

		// affichage des Joueurs
		if (this.joueur1.isSaut()) {
			g2.drawImage(this.joueur1.saut("personnageJ1"), this.joueur1.getX(), this.joueur1.getY(), null);
		} else if (this.joueur1.isFrappe() && !this.joueur1.isMarche()) {
			g2.drawImage(this.joueur1.coup("personnageJ1"), this.joueur1.getX(), this.joueur1.getY(), null);
		} else {
			g2.drawImage(this.joueur1.marche("personnageJ1", 30), this.joueur1.getX(), this.joueur1.getY(), null);
		}

		if (this.joueur2.isSaut()) {
			g2.drawImage(this.joueur2.saut("personnageJ2"), this.joueur2.getX(), this.joueur2.getY(), null);
		} else if (this.joueur2.isFrappe() && !this.joueur2.isMarche()) {
			g2.drawImage(this.joueur2.coup("personnageJ2"), this.joueur2.getX(), this.joueur2.getY(), null);
		} else {
			g2.drawImage(this.joueur2.marche("personnageJ2", 30), this.joueur2.getX(), this.joueur2.getY(), null);
		}

		// affichage des structures
		for (Structures structures : structures) {
			structures.paint(g2);
		}

	}

	// ****Getter && Setter******

	public void setDxJ1(int dx) {
		this.dxJ1 = dx;
	}

	public int getDxJ1() {
		return this.dxJ1;
	}

	public void setDxJ2(int dx) {
		this.dxJ2 = dx;
	}

	public int getDxJ2() {
		return this.dxJ2;
	}

	public int getYsol() {
		return ysol;
	}

	public int getHauteurPlafond() {
		return hauteurPlafond;
	}

	public void setYsol(int ysol) {
		this.ysol = ysol;
	}

	public void setHauteurPlafond(int hauteurPlafond) {
		this.hauteurPlafond = hauteurPlafond;
	}

}