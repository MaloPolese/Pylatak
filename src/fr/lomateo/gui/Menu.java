package fr.lomateo.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Menu extends JPanel{

	private ImageIcon icoBacground;
	private  Image imgBackgound;
	private MouseEvents mouseEvents;

	private Boutons boutonStart;
	private Boutons boutonQuit;
	
	ArrayList<Boutons> boutons;
	
	public Menu() {
		
		this.icoBacground = new ImageIcon(getClass().getResource("/menu.png"));
		this.imgBackgound = this.icoBacground.getImage();
		
		
		boutonStart = new Boutons(700, 500, 300, 50, "Start");
		boutonQuit = new Boutons(200, 500, 300, 50, "Quit");
		
		boutons = new ArrayList<Boutons>();
		boutons.add(boutonQuit);
		boutons.add(boutonStart);
		
		for(Boutons bouton : boutons){
			this.addMouseListener(this.mouseEvents = new MouseEvents(this, bouton)); 
		}
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(imgBackgound, 0, 0, this.getWidth(), this.getHeight(), null);	
		
		boutonStart.draw(g2);	
		boutonQuit.draw(g2);
		
	}
}
