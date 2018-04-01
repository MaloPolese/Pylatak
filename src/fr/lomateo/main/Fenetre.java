package fr.lomateo.main;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	public static Scene scene;

	public Fenetre() {
		super();
		
		this.setTitle("JeuISN");
		this.setSize(1200, 750);
		this.setLocationRelativeTo(null);
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(scene = new Scene());

		this.setVisible(true);

	}
}