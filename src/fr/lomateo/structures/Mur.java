package fr.lomateo.structures;


import javax.swing.ImageIcon;

public class Mur extends Structures{


	
	public Mur(String nom , int x , int y){
		
		super(x, y , 37 , 750);
		
		super.icoStructures = new ImageIcon(getClass().getResource("/" + nom + ".png"));
		super.imagesStructures = icoStructures.getImage();
	}

}
