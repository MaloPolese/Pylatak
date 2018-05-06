package fr.lomateo.main;


public class Rafra�chissement extends Thread{

	private final Scene scene;
	public Rafra�chissement(Scene scene){
		this.scene = scene;
	}

	@Override
	public void run() {
		
		while(true){
			this.scene.repaint();//repaint de la scene
			try {
				Thread.sleep(4); //temps de rafraichissement de l'�crant
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
