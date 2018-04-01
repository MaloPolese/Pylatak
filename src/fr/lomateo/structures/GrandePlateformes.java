package fr.lomateo.structures;

import javax.swing.ImageIcon;

public class GrandePlateformes extends Structures{
	

	public GrandePlateformes(String nom , int x, int y) {
		super(x , y , 430, 12, new ImageIcon(getClass().getResource("/" + nom + ".png")));
		
		//super.ico = new ImageIcon(getClass().getResource("/" + nom + ".png"));
		
	}
	

}
