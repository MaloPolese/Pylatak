package fr.lomateo.main;


public class Chrono extends Thread{

	
	private final int pause = 4; //temps de draw ecrant
	@Override
	public void run() {
		
		while(true){
			Fenetre.scene.repaint();//Rafraichissement des images
			try {
				Thread.sleep(pause);//pause de 4 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
