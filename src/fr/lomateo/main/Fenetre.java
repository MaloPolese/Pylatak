package fr.lomateo.main;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {


	public Fenetre() {
		
		this.setTitle("Pylatak");
		this.setSize(1200, 750);
		this.setLocationRelativeTo(null);
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		Scene scene = new Scene();
		this.setContentPane(scene);

		this.setVisible(true);

	}
}