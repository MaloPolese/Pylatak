package fr.lomateo.personnages;

import java.awt.Image;
import javax.swing.ImageIcon;


import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;

public class Personnages {

	private final Scene scene;
	
	// variable des personnages
	private int largeur;
	protected int hauteur;
	protected int x;
	protected int y;
	protected boolean marche, versDroite;
	protected boolean saut;
	protected boolean chute;
	protected boolean frappe;
	public int compteur, compteurSaut, compteurFrape;
	protected int dxJ;

	protected ImageIcon ico;
	protected Image image;

	public Personnages(int x, int y, int largeur, int hauteur, String nom ,Scene scene) {
		this(x, y, largeur, hauteur, scene,
				new ImageIcon(Personnages.class.getResource("/personnage" + nom +"ArretGauche.png")));
	}

	public Personnages(int x, int y, int largeur, int hauteur, Scene scene, ImageIcon ico) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.marche = false;
		this.versDroite = true;
		
		this.saut = false;
		this.chute = false;
		this.compteur = 0;
		this.compteurSaut = 0;
		this.scene = scene;
		this.dxJ = 0;

		this.ico = ico;
		this.image = ico.getImage();
	}
	
	//Contacts des personnages avec les structures
		protected boolean contactAvant(Structures structure) {
			if (isVersDroite()) {
				if ((this.x + this.largeur < structure.getX()) || (this.x + this.largeur > structure.getX() + 5)
						|| (this.y + this.hauteur <= structure.getY())
						|| (this.y >= structure.getY() + structure.getHauteur())) {
					return false;
				}
				return true;
			}
			return false;
		}

		protected boolean contactArriere(Structures structure) {
			if ((this.x > structure.getX() + structure.getLargeur())
					|| (this.x + this.largeur < structure.getX() + structure.getLargeur() - 5)
					|| (this.y + this.hauteur <= structure.getY())
					|| (this.y >= structure.getY() + structure.getHauteur())) {
				return false;
			}
			return true;
		}

		protected boolean contactDessous(Structures structure) {
			if ((this.x + this.largeur < structure.getX() + 5) || (this.x > structure.getX() + structure.getLargeur() - 5)
					|| (this.y + this.hauteur < structure.getY() - 10) || (this.y + this.hauteur > structure.getY() + 5)) {
				return false;
			}
			return true;
		}

		protected boolean contactDessus(Structures structure) {
			if ((this.x + this.largeur < structure.getX() + 5) || (this.x > structure.getX() + structure.getLargeur() - 5)
					|| (this.y < structure.getY() + structure.getHauteur())
					|| (this.y > structure.getY() + structure.getHauteur() + 5)) {
				return false;
			}
			return true;
		}

	// ****Getter && Setter******

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isMarche() {
		return marche;
	}

	public void setMarche(boolean marche) {
		this.marche = marche;
	}

	public boolean isVersDroite() {
		return versDroite;
	}

	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}

	public boolean isSaut() {
		return saut;
	}

	public void setSaut(boolean saut) {
		this.saut = saut;
	}

	public boolean isFrappe() {
		return frappe;
	}

	public void setFrappe(boolean frappe) {
		this.frappe = frappe;
	}

	public int getDxJ() {
		return dxJ;
	}

	public void setDxJ(int dxJ) {
		this.dxJ = dxJ;
	}

}