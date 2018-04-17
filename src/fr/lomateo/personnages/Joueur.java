package fr.lomateo.personnages;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;


public class Joueur extends Personnages {

	//image J2
    private final Scene scene;
    private final String nom;
    
    private double vitesseSaut = 6.5;
    private double vitesseStautActuelle = vitesseSaut;

    private double vitesseDeChuteMax = 4;
    private double vitesseDeChuteActuelle = 0.1;
    

	
	public Joueur(int x , int y , String nom ,Scene scene){
		super(x , y , 38 ,100, nom ,scene);
		
		this.scene = scene;
		this.nom = nom;

	}
	
	public void deplacementJ(Graphics2D g2) {
		this.x += this.dxJ;
		this.paint(g2);
				
	}
	
	public void contact(Structures structure, Graphics2D g2){		
	}

	public void paint(Graphics2D g2) {
		if (this.saut || this.chute) {
			g2.drawImage(this.saut("personnage" + nom), this.x, this.y, null);
		} else if (this.isFrappe() && !this.isMarche()) {
			g2.drawImage(this.coup("personnage" + nom ), this.x, this.y, null);
		} else {
			g2.drawImage(this.marche("personnage" + nom, 30), this.x, this.y, null);
		}
	}
	
	public Image marche(String nom, int frequencePas) {
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
	
	public Image saut(String nom) {
		ImageIcon ico;
		Image img;
		String str = null;

		if (this.saut && !this.chute) {
			this.y -= vitesseStautActuelle;
			vitesseStautActuelle -= .1;

			if (this.versDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}

			if (vitesseStautActuelle <= 0) {
				vitesseStautActuelle = vitesseSaut;
				this.saut = false;
				this.chute = true;
			}
		}

		if (this.chute) {
			this.y += vitesseDeChuteActuelle;

			if (this.versDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}

			if (vitesseDeChuteActuelle < vitesseDeChuteMax) {
				vitesseDeChuteActuelle += .1;
			} else if (this.y + this.hauteur >= this.scene.getJsol() - 2) {
				this.chute = false;
				System.out.println(this.y);
			}
		}

		if (!this.chute) {
			vitesseDeChuteActuelle = .1;
		}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	// methode coup
	public Image coup(String nom) {
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
