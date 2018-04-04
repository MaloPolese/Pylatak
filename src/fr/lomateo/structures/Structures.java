package fr.lomateo.structures;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Structures {

	private int x, y;
	private int largeur, hauteur;

	protected ImageIcon ico;
	protected Image images;

	public Structures(int x, int y, int largeur, int hauteur, String nom) {
		this(x, y, largeur, hauteur, new ImageIcon(Structures.class.getResource("/" + nom + ".png")));
	}

	public Structures(int x, int y, int largeur, int hauteur, ImageIcon ico) {
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.ico = ico;
		this.images = ico.getImage();
	}

	public void paint(Graphics2D g2) {
		g2.drawImage(this.images, this.x, this.y, null);

	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
}
