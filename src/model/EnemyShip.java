package model;

import processing.core.PApplet;

public class EnemyShip extends Ship{
	/*
	 * 1 Right
	 * 2 Left
	 * */
	private int movement;

	public EnemyShip(int posX, int posY, int size, PApplet app) {
		super(posX, posY, size, app);
		movement=2;
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
		if(movement==1) {
			setPosX(getPosX()+1);
		}
		if(movement==2) {
			setPosX(getPosX()-1);
		}
		
		
	}

	@Override
	public void draw() {
		getApp().fill(255,0,0);
		getApp().rect(getPosX(),getPosY(),getSize(),getSize());
		
	}


	public int getMovement() {
		return movement;
	}


	public void setMovement(int movement) {
		this.movement = movement;
	}

}
