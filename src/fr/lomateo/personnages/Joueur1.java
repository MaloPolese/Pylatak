package fr.lomateo.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import fr.lomateo.main.Fenetre;
import fr.lomateo.structures.Structures;

public class Joueur1 extends Personnages {

	//image J1
	private ImageIcon icoPersonnage1;
	private Image Imagepersonnage1;

	public Joueur1(int x, int y) {
		super(x, y, 38, 100);

		icoPersonnage1 = new ImageIcon(getClass().getResource("/personnageJ1ArretDroit.png"));
		this.Imagepersonnage1 = this.icoPersonnage1.getImage();
	}

	//Getter
	public Image getImageJ1() {
		return Imagepersonnage1;
	}

	//methode contact
	public void contact(Structures structure) {

		if ((super.contactAvant(structure) == true && this.isVersDroite() == true)
				|| (super.contactArriere(structure) == true && this.isVersDroite() == false)) {

			Fenetre.scene.setDxJ1(0);
			this.setMarche(false);
		}

		if (super.contactDessous(structure) == true && this.isSaut() == true) {
			Fenetre.scene.setYsol(structure.getY());
			//System.out.println("YSol= " + Fenetre.scene.getYsol());
		} else if (super.contactDessous(structure) == false) {
			Fenetre.scene.setYsol(692);
			
			if (this.isSaut() == false) {
				while(this.getY() != Fenetre.scene.getYsol()){
					this.setY(this.getY() + 1);
				}
				//this.setY(592);
			}
		}

		if (super.contactDessus(structure) == true) {
			Fenetre.scene.setHauteurPlafond(structure.getY() + structure.getHauteur());
			//System.out.println(Fenetre.scene.getHauteurPlafond());
		} else if (super.contactDessus(structure) == false && this.isSaut() == false) {
			Fenetre.scene.setHauteurPlafond(0);
		}
	}

}
