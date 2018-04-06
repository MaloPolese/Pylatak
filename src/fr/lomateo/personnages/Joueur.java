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
	/*
	 * public void contact(Structures structure) {
		if ((super.contactAvant(structure) && this.isVersDroite())
				|| (super.contactArriere(structure) && this.isVersDroite())) {

			setDxJ(0);
			this.setMarche(false);
		}
		if (super.contactDessous(structure)&& this.isSaut()) {
			this.scene.setYsol(10);
			System.out.println(this.scene.getYsol());
		} else if (super.contactDessous(structure)) {
			this.scene.setYsol(592);
			if (this.isSaut()) {
				this.setY(592);
			}
		}
		if(super.contactDessus(structure)){
			this.scene.setHauteurPlafond(structure.getY() + structure.getHauteur());
			System.out.println(this.scene.getHauteurPlafond());
		}else if(super.contactDessus(structure) && this.isSaut()){
			this.scene.setHauteurPlafond(0);
		}
	}
	*
	*/
	
}
