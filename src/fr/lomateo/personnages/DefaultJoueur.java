package fr.lomateo.personnages;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import fr.lomateo.controls.ControllablePersonnage;
import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;

public class DefaultJoueur extends DefaultPersonnage implements Joueur {

	private final Scene scene;
	private final String nom;

	// Variables pour la physique du saut et de la chute
	private double vitesseSaut = 5.8;
	private double vitesseStautActuelle = vitesseSaut;
	private double vitesseDeChuteMax = 4;
	private double vitesseDeChuteActuelle = 0.1;

	// Variable pour définir le sol d'un joueur
	private int ySolJoueurs;

	public DefaultJoueur(Scene scene, int x, int y, String nom, boolean versDroite) {
		super(x, y, 50, 86, nom);

		this.scene = scene;
		this.nom = nom;
		this.ySolJoueurs = 692;
		this.versDroite = versDroite;
	}

	// Deplacement du joueur
	public void deplacement(Graphics2D g2) {
		if (!contact()) {
			if (this.frappe) {
				if (this.versDroite) {
					this.x += 5;
					this.paint(g2);
				} else {
					this.x += -5;
					this.paint(g2);
				}
			} else {
				this.x += this.dxJ;
				this.paint(g2);
			}

		} else if (contact()) {
			this.x += 0;
			this.marche = false;
			this.paint(g2);

		}

		if (this.frappe) {
			GestionVie();
		}
	}

	// Méthode qui vérifie les contacts avec les structures
	private boolean contact() {

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

			} else if ((!this.saut && this.y + this.hauteur != scene.getYsol())) {
				if (this.y + this.hauteur == this.ySolJoueurs) {
					if (this.proche(structure)) {
						if (!contactDessous(structure)) {
							this.chute = true;
						}
					}
				}
			}

			if (contactDessus(structure)) {
				this.saut = false;
				this.vitesseStautActuelle = this.vitesseSaut;
				this.chute = true;
			}

		}
		return false;
	}

	// methode contactProche
	private boolean proche(Structures structure) {
		if ((structure == this.scene.murDroite) || (structure == this.scene.murGauche)) {
			return false;
		}
		if ((this.x >= structure.getX() + structure.getLargeur() + 20)
				|| (this.x + this.largeur <= structure.getX() - 20)
				|| (this.y >= structure.getY() + structure.getHauteur())
				|| (this.y + this.hauteur <= structure.getY() - 20)) {
			return false;
		} else {
			return true;
		}
	}

	// methode qui gère le colision entre joueurs
	private boolean ColisionJoueur() {

		for (DefaultJoueur joueur : this.scene.joueurs) {

			if (joueur != this) {
				if ((this.x >= joueur.x + joueur.largeur) || (this.x + this.largeur <= joueur.x)
						|| (this.y >= joueur.y + joueur.hauteur) || (this.y + this.hauteur <= joueur.y)) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	// methode qui gère la vie du joueur
	private boolean GestionVie() {

		for (DefaultJoueur joueur : scene.joueurs) {

			if (joueur != this) {
				if (ColisionJoueur()) {

					if (joueur.vie > 0) {
						System.out.println(joueur.vie);
						joueur.vie--;
					} else {
						System.out.println(joueur.nom + " a perdu");
					}

				}

			}

		}

		return false;
	}

	// methode pour peindre les joueurs
	private void paint(Graphics2D g2) {
		if (this.saut || this.chute) {
			g2.drawImage(this.saut("personnage" + nom), this.x, this.y, null);
		} else if (this.frappe) {
			g2.drawImage(this.coup("personnage" + nom), this.x, this.y, null);

		} else if (this.bloque && !this.marche) {
			g2.drawImage(this.Bloque("personnage" + nom), this.x, this.y, null);
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

		if (this.frappe) {
			if (compteurFrape != 30) {
				if (this.versDroite) {
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
				compteurFrape = 0;
				this.frappe = false;

			}
		}

		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	// methode pour les contres
	private Image Bloque(String nom) {
		String str = null;
		ImageIcon ico;
		Image img;

		if (this.bloque) {
			if (this.versDroite) {
				str = "/" + nom + "BloqueDroite.png";
			} else {
				str = "/" + nom + "BloqueGauche.png";
			}
		}

		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

}
