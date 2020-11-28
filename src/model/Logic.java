package model;

import processing.core.PApplet;

public class Logic {
	
	private MainShip mainShip;
	
	
	public Logic(PApplet app) {
		mainShip= new MainShip(400,550,app);
	}


	


	public void drawElements() {
		mainShip.draw();
		
	}
	
	public MainShip getMainShip() {
		return mainShip;
	}
	

}
