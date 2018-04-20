package fr.lomateo.main;


public class Chrono extends Thread{

	private final Scene scene;
	public Chrono(Scene scene){
		this.scene = scene;
	}

	@Override
	public void run() {
		
		while(true){
			this.scene.repaint();//repaint de la scene
			try {
				Thread.sleep(4); //temps de rafraichissement de l'écrant
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
