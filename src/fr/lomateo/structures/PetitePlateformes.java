package fr.lomateo.structures;

import javax.swing.ImageIcon;

public class PetitePlateformes extends Structures{

	
	public PetitePlateformes(String nom , int x ,int y){
		super(x, y, 267, 12);
		
		super.ico = new ImageIcon(getClass().getResource("/" + nom + ".png"));
		super.images = ico.getImage();
	}
}
