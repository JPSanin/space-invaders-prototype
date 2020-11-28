package model;

import processing.core.PApplet;

public abstract class Ship extends Thread {
	
	private int posX;
	private int posY;
	private int speed;
	private int size;
	
	private PApplet app;

	public Ship(int posX, int posY,int size, PApplet app) {
		super();
		this.posX = posX;
		this.posY = posY;
		speed = 10;
		this.size = size;
		this.app = app;
	}
	
	
	public abstract void move();
	public abstract void draw();


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}
	

}
