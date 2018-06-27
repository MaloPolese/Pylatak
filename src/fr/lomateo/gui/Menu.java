package fr.lomateo.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.lomateo.main.Fenetre;
import fr.lomateo.main.Scene;

public class Menu extends JPanel {
	
	private static final long serialVersionUID = -3495173779153373276L;
	
	private ImageIcon icoBacground;
	private Image imgBackgound;
	private MouseEvents mouseEvents;

	private Boutons boutonStart;
	private Boutons boutonQuit;

	public Menu(Scene scene, Fenetre fenetre) {

		this.icoBacground = new ImageIcon(getClass().getResource("/menu.png"));
		this.imgBackgound = this.icoBacground.getImage();

		boutonStart = new Boutons(700, 500, 300, 50, "Start");
		boutonQuit = new Boutons(200, 500, 300, 50, "Quit");

		this.addMouseListener(this.mouseEvents = new MouseEvents( boutonStart, scene, fenetre));
		this.addMouseListener(this.mouseEvents = new MouseEvents( boutonQuit, scene, fenetre));

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(imgBackgound, 0, 0, this.getWidth(), this.getHeight(), null);

		boutonStart.draw(g2);
		boutonQuit.draw(g2);

	}
	
	public void focus(){
		this.requestFocus();
		this.revalidate();
	}
}
