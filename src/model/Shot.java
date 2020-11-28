package model;

import processing.core.PApplet;

public class Shot extends Thread{
	
	private int posX;
	private int posY;
	private int speed;
	private int size;
	private boolean draw;
	
	private PApplet app;
	
	
	public Shot(int posX, int posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		speed = 5;
		size = 10;
		this.app = app;
		draw=false;
	}
	
	public void run() {
		move();
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
	
	public void move() {
		posY-=speed;
		if(posY<-5) {
			draw=false;
		}
	}
	
	public void draw() {
		app.fill(0,229,238);
		app.ellipse(posX, posY, size, size);
	}

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

	public boolean isDraw() {
		return draw;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	
	
}
