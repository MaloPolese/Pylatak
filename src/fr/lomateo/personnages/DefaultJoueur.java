package fr.lomateo.personnages;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;

public class DefaultJoueur extends DefaultPersonnage implements Joueur {

	private final Scene scene;
	private final String nom;

	// Variables pour la physique du saut et de la chute
	private double vitesseSaut = 6.5;
	private double vitesseStautActuelle = vitesseSaut;
	private double vitesseDeChuteMax = 4;
	private double vitesseDeChuteActuelle = 0.1;

	// Variable pour définir le sol d'un joueur
	private int ySolJoueurs;

	public DefaultJoueur(Scene scene, int x, int y, String nom, boolean versDroite) {
		super(x, y, 38, 100, nom);

		this.scene = scene;
		this.nom = nom;
		this.ySolJoueurs = 692;
		this.versDroite = versDroite;
	}

	// Deplacement du joueur
	public void deplacement(Graphics2D g2) {
		if (!contact(g2)) {
			this.x += this.dxJ;
			this.paint(g2);
		} else if (contact(g2)) {
			this.x += 0;
			this.marche = false;
			this.paint(g2);
		}

	}

	// Méthode qui vérifie les contacts avec les structures
	private boolean contact(Graphics2D g2) {

		for (Structures structure : this.scene.structures) {

			// contact horizontal
			if ((this.contactArriere(structure) && !this.versDroite || (this.contactAvant(structure)))) {
				return true;
			}

			// contatc vertical
			if (contactDessous(structure) && this.chute) {
				this.chute = false;
				this.y = structure.getY() - this.hauteur;
				this.ySolJoueurs = structure.getY();
				System.out.println("contact dessous");

			} else if ((!this.saut && this.y + this.hauteur != scene.getYsol())) {
				if (this.y + this.hauteur == this.ySolJoueurs) {

					if (!contactDessous(this.scene.grandePlateforme1)) {
						this.chute = true;
					}
				}
			}
			if (contactDessus(structure)) {
				this.saut = false;
				this.chute = true;
			}

		}
		return false;
	}

	// methode pour peindre les joueurs
	private void paint(Graphics2D g2) {
		if (this.saut || this.chute) {
			g2.drawImage(this.saut("personnage" + nom), this.x, this.y, null);
		} else if (this.frappe && !this.marche) {
			g2.drawImage(this.coup("personnage" + nom), this.x, this.y, null);
		} else {
			g2.drawImage(this.marche("personnage" + nom, 30), this.x, this.y, null);
		}
	}

	// methode pour la marche
	private Image marche(String nom, int frequencePas) {
		String str;
		ImageIcon ico;
		Image img;

		if (this.marche == false) {
			if (this.versDroite == true) {
				str = "/" + nom + "ArretDroit.png";
			} else {
				str = "/" + nom + "ArretGauche.png";
			}
		} else {
			this.compteur++;

			if (this.compteur / frequencePas == 0) {
				if (this.versDroite == true) {
					str = "/" + nom + "CoursDroite2.png";
				} else {
					str = "/" + nom + "CoursGauche2.png";
				}
			} else {
				if (this.versDroite == true) {
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

	// methode pour le saut
	private Image saut(String nom) {
		ImageIcon ico;
		Image img;
		String str = null;

		if (this.saut && !this.chute) {
			this.y -= this.vitesseStautActuelle;
			this.vitesseStautActuelle -= .1;

			if (this.versDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}

			if (vitesseStautActuelle <= 0) {
				this.vitesseStautActuelle = this.vitesseSaut;
				this.saut = false;
				this.chute = true;
			}
		}

		if (this.chute) {
			this.y += this.vitesseDeChuteActuelle;

			if (this.versDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}

			if (this.vitesseDeChuteActuelle < this.vitesseDeChuteMax) {
				this.vitesseDeChuteActuelle += .1;
			}

			else if (this.y + this.hauteur >= this.scene.getYsol()) {
				this.chute = false;
				this.y = this.scene.getYsol() - this.hauteur;
			}
		}

		if (!this.chute) {
			vitesseDeChuteActuelle = .1;
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	// methode pour les coups
	private Image coup(String nom) {
		String str = null;
		ImageIcon ico;
		Image img;

		compteurFrape++;
		if (compteurFrape != 30) {
			if (this.versDroite == true) {
				str = "/" + nom + "CoupDroite.png";
			} else {
				str = "/" + nom + "CoupGauche.png";
			}
		} else {
			if (this.versDroite == true) {
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

}
