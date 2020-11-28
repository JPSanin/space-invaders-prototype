package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private MainShip mainShip;
	private ArrayList<EnemyShip> enemyShips;
	private Shot shot;
	
	
	public Logic(PApplet app) {
		mainShip= new MainShip(400,550,50,app);
		shot= new Shot(400,550,app);
		enemyShips= new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			enemyShips.add(new EnemyShip(35+(i*75), 20, 50, app));
		}
		
		for (int i=0; i<10; i++) {
			enemyShips.add(new EnemyShip(35+(i*75), 100, 50, app));
		}
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
		
		for (int i = 0; i < enemyShips.size(); i++) {
			enemyShips.get(i).draw();
		}
		enemyMove();
		
	}
	
	
	private void enemyMove() {
		int border=enemyShips.get(0).getPosX();
		if(enemyShips.get(0).getMovement()==1) {
		for (int i = 0; i < enemyShips.size(); i++) {
			if(enemyShips.get(i).getPosX()>border) {
				border=enemyShips.get(i).getPosX();
			}	
		}
		
		if(border>800 -enemyShips.get(0).getSize()) {
			for (int i = 0; i < enemyShips.size(); i++) {
				enemyShips.get(i).setPosY(enemyShips.get(i).getPosY()+10);
				enemyShips.get(i).setMovement(2);
			}
		}
		}else {
			for (int i = 0; i < enemyShips.size(); i++) {
				if(enemyShips.get(i).getPosX()<border) {
					border=enemyShips.get(i).getPosX();
				}	
			}
			
			if(border<=0) {
				for (int i = 0; i < enemyShips.size(); i++) {
					enemyShips.get(i).setPosY(enemyShips.get(i).getPosY()+10);
					enemyShips.get(i).setMovement(1);
				}
			
		}
			
		
		}
		
		for (int i = 0; i < enemyShips.size(); i++) {
			new Thread(enemyShips.get(i)).start();
		}
		
	}
	
	public MainShip getMainShip() {
		return mainShip;
	}
	

}
