package fr.lomateo.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.lomateo.personnages.Joueur1;
import fr.lomateo.personnages.Joueur2;
import fr.lomateo.structures.GrandePlateformes;
import fr.lomateo.structures.Mur;
import fr.lomateo.structures.PetitePlateformes;
import fr.lomateo.structures.Structures;

public class Scene extends JPanel {

	private static final long serialVersionUID = -1578970639764868768L;
	
	// backGround images
	private ImageIcon icoFond;
	private Image imgFond;

	// Personnages
	public Joueur1 joueur1;
	public Joueur2 joueur2;
	// variable de déplacement x des joueurs
	private int dxJ1;
	private int dxJ2;

	// structures
	public PetitePlateformes petitePlateformeDroite;
	public PetitePlateformes petitePlateformeGauche;
	public GrandePlateformes grandePlateforme1;
	public Mur murGauche;
	public Mur murDroite;

	// position du sol & du plafond
	private int ysol;
	private int hauteurPlafond;

	// tableau pour stocker les structures
	public ArrayList<Structures> tableauStructures;

	public Scene() {
		super();

		this.ysol = 692;// 592
		this.hauteurPlafond = 0;
		this.dxJ1 = 0;
		this.dxJ2 = 0;

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Controls());

		icoFond = new ImageIcon(getClass().getResource("/BackGroundBeta.png"));
		imgFond = icoFond.getImage();

		joueur1 = new Joueur1(70, 592);
		joueur2 = new Joueur2(1045, 592);
		joueur1.setVersDroite(true);
		joueur2.setVersDroite(false);

		petitePlateformeDroite = new PetitePlateformes("PetitePlateformeDroite", 899, 320);
		petitePlateformeGauche = new PetitePlateformes("PetitePlateformeGauche", 31, 320);
		grandePlateforme1 = new GrandePlateformes("GrandePlateforme1", 370, 500);
		murGauche = new Mur("murDroite", 0, 0);
		murDroite = new Mur("murGauche", 1167, 0);

		tableauStructures = new ArrayList<Structures>();

		this.tableauStructures.add(this.petitePlateformeDroite);
		this.tableauStructures.add(this.petitePlateformeGauche);
		this.tableauStructures.add(this.grandePlateforme1);
		this.tableauStructures.add(this.murGauche);
		this.tableauStructures.add(this.murDroite);

		// Démarre un chrono pour rafraichir l’écran
		Chrono chronoEcrant = new Chrono();
		chronoEcrant.start();

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
		for (int i = 0; i < tableauStructures.size(); i++) {
			// detection des contacts
			if (this.joueur1.proche(tableauStructures.get(i))) {
				this.joueur1.contact(this.tableauStructures.get(i));
			}
			if (this.joueur2.proche(tableauStructures.get(i))) {
				this.joueur2.contact(this.tableauStructures.get(i));
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

		
		//affichage des structures
		for (int i = 0; i < tableauStructures.size(); i++) {
			g2.drawImage(this.tableauStructures.get(i).getImagesStructures(), this.tableauStructures.get(i).getX(),
					this.tableauStructures.get(i).getY(), null);
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