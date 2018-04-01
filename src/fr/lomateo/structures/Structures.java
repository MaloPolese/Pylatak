package fr.lomateo.structures;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Structures {

	private int x, y ;
	private int largeur , hauteur;
	
	protected Image images;
	
	public Structures(int x, int y , int largeur , int hauteur, ImageIcon ico) {
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.images = ico.getImage();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public Image getImagesStructures() {
		return images;
	}
	
	
}
