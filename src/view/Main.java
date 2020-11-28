package view;


import controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet {

	
	private Controller controller;
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(800,600);

	}

	public void setup() {
		controller= new Controller(this);
	}

	public void draw() {
	background(0);
	
	controller.drawElements();
	
	}
	
	
	public void keyPressed() {
		controller.getLogic().getMainShip().setKey(key);
		new Thread(controller.getLogic().getMainShip()).start();
		
	}

}
