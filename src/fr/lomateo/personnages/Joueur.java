package fr.lomateo.personnages;

import fr.lomateo.main.Scene;
import fr.lomateo.structures.Structures;


public class Joueur extends Personnages {

	//image J2
    private final Scene scene;
	
	public Joueur(int x , int y , Scene scene){
		super(x , y , 79 ,100, scene);
		
		this.scene = scene;
	}
	
	//methode contact
	public void contact(Structures structure) {
		if ((super.contactAvant(structure) == true && this.isVersDroite() == true)
				|| (super.contactArriere(structure) == true && this.isVersDroite() == false)) {

			setDxJ(0);
			this.setMarche(false);
		}
		if (super.contactDessous(structure) == true && this.isSaut() == true) {
			this.scene.setYsol(10);
			System.out.println(this.scene.getYsol());
		} else if (super.contactDessous(structure) == false) {
			this.scene.setYsol(592);
			if (this.isSaut() == false) {
				this.setY(592);
			}
		}
		if(super.contactDessus(structure) == true){
			this.scene.setHauteurPlafond(structure.getY() + structure.getHauteur());
			System.out.println(this.scene.getHauteurPlafond());
		}else if(super.contactDessus(structure) == false && this.isSaut() == false){
			this.scene.setHauteurPlafond(0);
		}
	}
}
