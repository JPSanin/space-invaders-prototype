package view;


import controller.Controller;
import exceptions.LoseException;
import exceptions.WinException;
import processing.core.PApplet;
import processing.core.PConstants;

public class Main extends PApplet {

	
	private Controller controller;
	private boolean gameOver;
	private String message;
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(800,600);

	}

	public void setup() {
		restart();
	}

	public void draw() {
	background(0);
	

	if(gameOver==false) {
		controller.drawElements();
		controller.checkHit();
	
		try {
			controller.checkGameOver();
		} catch (LoseException | WinException e) {
			if(e instanceof LoseException) {
				message= e.getMessage();
				gameOver=true;
			}
			if(e instanceof WinException) {
				message= e.getMessage();
				gameOver=true;
			}
	
		}
	
	}
	
	
	if(gameOver==true) {
		textAlign(PConstants.CENTER);
		fill(255);
		textSize(32);
		text(message, 400, 300);
		textSize(16);
		text("Press P to play again", 400, 325);
	}

	fill(255);
	textSize(16);
	text("Enemies Eliminated: "+ controller.getLogic().getScore(), 25, 20);
	fill(255);
	//text(mouseX+ ","+mouseY, mouseX,mouseY);
	
	}
	
	
	public void keyPressed() {
		
		if(gameOver==false) {
		controller.getLogic().getMainShip().setKey(key);
		new Thread(controller.getLogic().getMainShip()).start();
		
		if(key==32) {
			controller.shoot();
		}
		}
		
		if(gameOver==true) {
			if(key=='p' || key=='P') {
				restart();
			}
		}
		
	}

	private void restart() {
		controller= new Controller(this);
		gameOver=false;
		message="";
	}

}
