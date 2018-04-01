package fr.lomateo.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import fr.lomateo.main.Fenetre;
import fr.lomateo.structures.Structures;


public class Joueur2 extends Personnages {

	//image J2
	private ImageIcon icoPersonnage2;
	private Image Imagepersonnage2;
	
	public Joueur2(int x , int y){
		super(x , y , 79 ,100);
		
		icoPersonnage2 = new ImageIcon(getClass().getResource("/personnageJ2ArretGauche.png"));
		this.Imagepersonnage2 = this.icoPersonnage2.getImage();
		
	}
	
	//Getter
	public Image getImageJ2(){
		return Imagepersonnage2;
	}
	
	//methode contact
	public void contact(Structures structure) {
		if ((super.contactAvant(structure) == true && this.isVersDroite() == true)
				|| (super.contactArriere(structure) == true && this.isVersDroite() == false)) {

			Fenetre.scene.setDxJ2(0);
			this.setMarche(false);
		}

		if (super.contactDessous(structure) == true && this.isSaut() == true) {
			Fenetre.scene.setYsol(10);
			System.out.println(Fenetre.scene.getYsol());
		} else if (super.contactDessous(structure) == false) {
			Fenetre.scene.setYsol(592);
			if (this.isSaut() == false) {
				this.setY(592);
			}
		}
		
		if(super.contactDessus(structure) == true){
			Fenetre.scene.setHauteurPlafond(structure.getY() + structure.getHauteur());
			System.out.println(Fenetre.scene.getHauteurPlafond());
		}else if(super.contactDessus(structure) == false && this.isSaut() == false){
			Fenetre.scene.setHauteurPlafond(0);
		}
	}
}
