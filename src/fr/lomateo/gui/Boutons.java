package fr.lomateo.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;


public class Boutons {

	private int x;
	private int y;
	private int largeur;
	private int hauteur;
	private String nom;
	private Image image;
	boolean OnCliqued;

	public Boutons(int x, int y, int largeur, int hauteur, String nom) {
		this(x, y, largeur, hauteur, new ImageIcon(Boutons.class.getResource("/bouton" + nom + ".png")));
		this.nom = nom;
	}

	public Boutons(int x, int y, int largeur, int hauteur, ImageIcon image) {

		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.image = image.getImage();
	}

	public void draw(Graphics2D g2) {
		g2.drawImage(this.image, this.x, this.y, this.largeur, this.hauteur, null);
	}

	public boolean onBouton(MouseEvent e) {
		if(e.getX() > this.x && e.getX() < this.x + this.largeur && e.getY() > this.y && e.getY() < this.y + this.hauteur){
			return true;
		}

		return false;
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

	public String getNom() {
		return nom;
	}

	public Image getImage() {
		return image;
	}

	public void setOnCliqued(boolean onCliqued) {
		OnCliqued = onCliqued;
	}

	public boolean getOnCliqued() {
		return OnCliqued;
	}
}
