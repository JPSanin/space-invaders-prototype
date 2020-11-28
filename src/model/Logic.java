package model;

import processing.core.PApplet;

public class Logic {
	
	private MainShip mainShip;
	private Shot shot;
	
	
	public Logic(PApplet app) {
		mainShip= new MainShip(400,550,50,app);
		shot= new Shot(400,550,app);
	}


	
	public void shoot() {
		if(mainShip.isShooting()==false) {
			shot.setPosX(mainShip.getPosX());
			shot.setPosY(mainShip.getPosY());
			shot.setDraw(true);
			
			mainShip.setShooting(true);
		}
		
	}

	public void drawElements() {
		if(shot.isDraw()) {
			shot.draw();
			new Thread(shot).start();
		}else {
			mainShip.setShooting(false);
		}
		mainShip.draw();
		
		
	}
	
	public MainShip getMainShip() {
		return mainShip;
	}
	

}
