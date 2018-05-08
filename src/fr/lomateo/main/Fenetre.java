package fr.lomateo.main;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {


	private final JPanel scene;
	
	public Fenetre(JPanel scene) {
		
		this.setTitle("Pylatak");
		this.setSize(1200, 750);
		this.setLocationRelativeTo(null);
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.scene = scene;
		this.setContentPane(scene);
		this.setVisible(true);

	}
}