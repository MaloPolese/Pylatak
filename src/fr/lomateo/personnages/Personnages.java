package fr.lomateo.personnages;

import java.awt.Image;
import javax.swing.ImageIcon;

import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;

public class Personnages {

	private final Scene scene;
	// variable
	private int largeur, hauteur;
	private int x, y;
	private boolean marche, VersDroite, saut, frappe;
	public int compteur, compteurSaut, compteurFrape;

	public Personnages(int x, int y, int largeur, int hauteur, Scene scene) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.marche = false;
		this.VersDroite = true;
		this.saut = false;
		this.compteur = 0;
		this.compteurSaut = 0;
		this.scene = scene;
	}
	
	//methodes des personnages
	
	//methode marche
	public Image marche(String nom, int frequencePas) {
		String str;
		ImageIcon ico;
		Image img;

		if (this.marche == false) {
			if (this.VersDroite == true) {
				str = "/" + nom + "ArretDroit.png";
			} else {
				str = "/" + nom + "ArretGauche.png";
			}
		} else {
			this.compteur++;

			if (this.compteur / frequencePas == 0) {
				if (this.VersDroite == true) {
					str = "/" + nom + "CoursDroite2.png";
				} else {
					str = "/" + nom + "CoursGauche2.png";
				}
			} else {
				if (this.VersDroite == true) {
					str = "/" + nom + "CoursDroite1.png";
				} else {
					str = "/" + nom + "CoursGauche1.png";
				}
			}
			if (this.compteur == 2 * frequencePas) {
				this.compteur = 0;
			}
		}

		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	//methode saut
	public Image saut(String nom) {
		ImageIcon ico;
		Image img;
		String str;

		this.compteurSaut++;
		// Montée
		if (this.compteurSaut <= 70) {
			if (this.getY() > this.scene.getHauteurPlafond()) {
				this.setY(this.getY() - 4);
			} else {
				this.compteurSaut = 71;
			}
			if (this.VersDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}
			// dessante
		} else if (this.getY() + this.getHauteur() < this.scene.getYsol()) {
			this.setY(this.getY() + 3);

			if (this.VersDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}
			// saut terminé
		} else {
			if (this.VersDroite == true) {
				str = "/" + nom + "ArretDroit.png";
			} else {
				str = "/" + nom + "ArretGauche.png";
			}
			this.saut = false;
			this.compteurSaut = 0;
		}

		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	//methode coup
	public Image coup(String nom) {
		String str = null;
		ImageIcon ico;
		Image img;

		compteurFrape++;
		if (compteurFrape != 30) {
			if (this.VersDroite == true) {
				str = "/" + nom + "CoupDroite.png";
			} else {
				str = "/" + nom + "CoupGauche.png";
			}
		} else {
			if (this.VersDroite == true) {
				str = "/" + nom + "ArretDroit.png";
			} else {
				str = "/" + nom + "ArretGauche.png";
			}
			this.frappe = false;
			compteurFrape = 0;
		}

		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
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
				|| (this.y + this.hauteur < structure.getY()) || (this.y + this.hauteur > structure.getY() + 5)) {
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

	//methode qui return true si un joueur est proche d'une structure
	public boolean proche(Structures structure) {
		if (((this.x > structure.getX() - 10) && (this.x < structure.getX() + structure.getLargeur() + 10))
				|| ((this.x + this.largeur > structure.getX() - 10)
						&& (this.x + this.largeur < structure.getX() + structure.getLargeur() + 10))) {
			return true;
		}
		return false;
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
		return VersDroite;
	}

	public void setVersDroite(boolean versDroite) {
		VersDroite = versDroite;
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

}