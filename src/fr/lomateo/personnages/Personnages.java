package fr.lomateo.personnages;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;

public class Personnages {

	private final Scene scene;
	// variable
	private int largeur, hauteur;
	private int x;
	private int y;
	private boolean marche, VersDroite, saut, chute , frappe;
	public int compteur, compteurSaut, compteurFrape;
	private int dxJ;
	
	private double vitesseSaut = 6.5;
	private double vitesseStautActuelle = vitesseSaut;
	
	private double vitesseDeChuteMax = 4;
	private double vitesseDeChuteActuelle = 0.1;
	
	protected ImageIcon ico;
	protected Image image;

	public Personnages(int x, int y, int largeur, int hauteur, Scene scene) {
		this(x, y, largeur, hauteur, scene, new ImageIcon(Personnages.class.getResource("/personnageJ1ArretGauche.png")));
	}
	
	public Personnages(int x, int y, int largeur, int hauteur, Scene scene, ImageIcon ico) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.marche = false;
		this.VersDroite = true;
		this.saut = false;
		this.chute = false;
		this.compteur = 0;
		this.compteurSaut = 0;
		this.scene = scene;
		this.dxJ = 0;
		
		this.ico = ico;
		this.image = ico.getImage();
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
		String str = null;
		
		if(this.saut && !this.chute){
			this.y -= vitesseStautActuelle;
			vitesseStautActuelle -= .1;

			if (this.VersDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}
			
			if(vitesseStautActuelle <= 0){
				vitesseStautActuelle = vitesseSaut;
				this.saut = false;
				this.chute = true;
			}
		}
		
		if(this.chute){
			this.y += vitesseDeChuteActuelle;
			
			if (this.VersDroite == true) {
				str = "/" + nom + "SautDroite.png";
			} else {
				str = "/" + nom + "SautGauche.png";
			}
			
			if(vitesseDeChuteActuelle < vitesseDeChuteMax){
				vitesseDeChuteActuelle += .1;
			}else if(this.y + this.hauteur >= this.scene.getYsol()){
				this.chute = false;
				System.out.println(this.y);
			}
		}
		
		if(!this.chute){
			vitesseDeChuteActuelle = .1;
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
		
		return false;
	}

	protected boolean contactArriere(Structures structure) {
		
		return true;
	}

	protected boolean contactDessous(Structures structure) {
		
		return true;
	}

	protected boolean contactDessus(Structures structure) {
		
		return true;
	}

	//methode qui return true si un joueur est proche d'une structure
	public boolean proche(Structures structure) {
		
		return false;
	}
	public void paint(Graphics2D g2) {
		if(this.saut || this.chute){
			g2.drawImage(this.saut("personnageJ1"), this.x, this.y, null);
		}else if (this.isFrappe() && !this.isMarche()) {
			g2.drawImage(this.coup("personnageJ1"), this.x, this.y, null);
		} else {
			g2.drawImage(this.marche("personnageJ1", 30), this.x, this.y, null);
		}
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
	public int getDxJ() {
		return dxJ;
	}

	public void setDxJ(int dxJ) {
		this.dxJ = dxJ;
	}

	public boolean isChute() {
		return chute;
	}

	public void setChute(boolean chute) {
		this.chute = chute;
	}
	

}