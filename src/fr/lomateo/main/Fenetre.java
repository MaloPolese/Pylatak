package fr.lomateo.main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.lomateo.gui.Menu;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	private Menu menu;
	private Scene scene;
	
	public CardLayout cl = new CardLayout();
	public JPanel content = new JPanel();

	public Fenetre() {
		scene = new Scene(menu , this);
		
		// rafraichissement de l'écran
		Rafraichissement chrono = new Rafraichissement(scene);
		chrono.start();
		
		menu = new Menu(scene,this);
		

		this.setTitle("Pylatak");
		this.setSize(1200, 750);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		content.setLayout(cl);
		content.add(menu, "Menu");
		content.add(scene, "Scene");
		
		this.getContentPane().add(content);

		this.setVisible(true);

	}
}