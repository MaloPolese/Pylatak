package fr.lomateo.personnages;

import fr.lomateo.controls.ControllablePersonnage;
import fr.lomateo.structures.Structures;
import java.awt.Image;
import javax.swing.ImageIcon;

public class DefaultPersonnage implements ControllablePersonnage {

	// variable des personnages
	private int largeur;
	protected int hauteur;
	protected int x;
	protected int y;
	protected boolean marche, versDroite;
	protected boolean saut;
	protected boolean chute;
	protected boolean frappe;
	protected int compteur, compteurSaut, compteurFrape;
	protected int dxJ;

	protected ImageIcon ico;
	protected Image image;

	public DefaultPersonnage(int x, int y, int largeur, int hauteur, String nom) {
		this(x, y, largeur, hauteur,
				new ImageIcon(DefaultPersonnage.class.getResource("/personnage" + nom + "ArretGauche.png")));
	}

	public DefaultPersonnage(int x, int y, int largeur, int hauteur, ImageIcon ico) {
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
		this.dxJ = 0;

		this.ico = ico;
		this.image = ico.getImage();
	}

	// Contacts des personnages avec les structures
	protected boolean contactAvant(Structures structure) {
		if (this.versDroite) {
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

	@Override
	public void setMarche(boolean marche) {
		this.marche = marche;
	}

	@Override
	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}

	@Override
	public void setSaut(boolean saut) {
		this.saut = saut;
	}

	@Override
	public void setFrappe(boolean frappe) {
		this.frappe = frappe;
	}

	@Override
	public void setDxJ(int dxJ) {
		this.dxJ = dxJ;
	}
}
