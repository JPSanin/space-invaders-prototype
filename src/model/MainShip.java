package model;

import processing.core.PApplet;

public class MainShip extends Ship{
	
	private boolean shooting;
	private char key;

	public MainShip(int posX, int posY, PApplet app) {
		super(posX, posY, app);
		shooting= false;
		key=0;
	}

	
	public void run() {
		move();
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void move() {
		
		if(key=='A' || key=='a') {
			if(getPosX()>getSize()) {
				setPosX(getPosX()-getSpeed());
			}
		}
		
		if(key=='D' || key=='d') {
			if(getPosX()<800-getSize()) {
				setPosX(getPosX()+getSpeed());
			}
		}
		
	}

	@Override
	public void draw() {
		getApp().fill(0,255,0);
		getApp().triangle(getPosX()-getSize()/2, getPosY()+getSize()/2, getPosX(), getPosY()-getSize()/2, getPosX()+getSize()/2, getPosY()+getSize()/2);
	}


	public boolean isShooting() {
		return shooting;
	}


	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}


	public char getKey() {
		return key;
	}


	public void setKey(char key) {
		this.key = key;
	}
	
	
	

}
