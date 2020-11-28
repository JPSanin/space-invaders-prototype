package controller;

import exceptions.LoseException;
import exceptions.WinException;
import model.Logic;
import processing.core.PApplet;

public class Controller {
	
	private Logic logic;
	
	public Controller(PApplet app) {
		logic= new Logic(app);
	}

	public void checkHit() {
		logic.checkHit();
	}
	
	public void drawElements() {
	logic.drawElements();
		
	}
	
	public void shoot() {
		logic.shoot();
	}
	
	public void checkGameOver() throws LoseException, WinException {
		logic.checkGameOver();
	}

	public Logic getLogic() {
		return logic;
	}


}
