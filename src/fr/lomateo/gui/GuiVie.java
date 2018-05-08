package fr.lomateo.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import fr.lomateo.main.Scene;

public class GuiVie {
	
	Font f = new Font("DejaVu Sans", Font.BOLD, 25);
	private final Scene scene;
	public GuiVie(Scene scene){
		this.scene = scene;
	}
	

	public void Heal(Graphics2D g2){
		
		//GUI du joueur 1
		g2.setColor(new Color(253,75,27));
		g2.setFont(f);
		g2.drawString("Joueur 1", 50, 40);
		g2.setColor(Color.RED);
		g2.fillRect(50, 50, 200, 15);
		g2.setColor(Color.GREEN);
		g2.fillRect(50, 50, this.scene.joueur1.getVie(), 15);

		
		//GUI du joueur 2
		g2.setColor(new Color(77,246,57));
		g2.setFont(f);
		g2.drawString("Joueur 2", 950, 40);
		g2.setColor(Color.RED);
		g2.fillRect(950, 50, 200, 15);
		g2.setColor(Color.GREEN);
		g2.fillRect(950, 50, this.scene.joueur2.getVie(), 15);
		
	}
}
