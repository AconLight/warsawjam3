package com.redartedgames.ball.myobjects;

import java.util.ArrayList;
import java.util.Random;

import com.redartedgames.ball.objects.GameObject;

public class ObjectRandomizer {

	private ArrayList<GameObject> gameObjects; 
	public  float x = 0;
	private float y = 0;
	private Random rand = new Random();
	private Player player;
	private TimeBar bar;
	private float distanceX;
	private float distanceY;
	private float marginX = 200f;
	private float marginY = 200f;
	
	public ObjectRandomizer(ArrayList<GameObject> gameObjects, Player player, TimeBar bar){
		this.gameObjects = gameObjects;
		this.player = player;
		this.bar = bar;
		randomize();
		randomize();
		randomize();
	}
	
	public void randomize() {
			randomGround(rand.nextInt(4));
			randomPlatforms(rand.nextInt(2));
			randomClock(rand.nextInt(2));
	}
	
	private void randomGround(int type) {
		switch(type) {
			default:
			case 0:
				Ground g0 = new Ground(x, y+rand.nextFloat()*40, rand.nextInt(2)+2, false, null, 0);
				gameObjects.add(g0);
				player.playerSprite.collidableObjects.addAll(g0.plist);
				player.bulletObstacles.addAll(g0.plist);
				x = g0.changeX;
				break;
			case 1:
				Ground g1 = new Ground(x, y, 2, true, null, 0);
				gameObjects.add(g1);
				player.playerSprite.collidableObjects.addAll(g1.plist);
				player.bulletObstacles.addAll(g1.plist);
				x = g1.changeX;
				break;
			case 2:
				Ground g2 = new Ground(x, y+rand.nextFloat()*40, rand.nextInt(5)+3, false, null, 0);
				gameObjects.add(g2);
				player.playerSprite.collidableObjects.addAll(g2.plist);
				player.bulletObstacles.addAll(g2.plist);
				if(rand.nextInt(4)==0)randomObstacle(x + 20 + rand.nextFloat()*(g2.changeX-x), g2.getMovement().getPosition().y+245);
				x = g2.changeX;
				break;
			case 3:
				Ground g3 = new Ground(x, y, 5, false, null, 0);
				gameObjects.add(g3);
				player.playerSprite.collidableObjects.addAll(g3.plist);
				player.bulletObstacles.addAll(g3.plist);
				if(rand.nextInt(3)==0)randomEnemy(x+80, y, 2);
				x = g3.changeX;
				break;
		}
	}
	
	private void randomPlatforms(int type) {
		switch(type) {
			default:
				break;
			case 0:
				if(rand.nextInt(6) == 0) {
					int pom = rand.nextInt(2)+6;
					Platform p0 = new Platform(x + rand.nextFloat()*50, 200 + rand.nextFloat()*100, pom, null, 0);
					if((p0.getMovement().getPosition().x < distanceX-marginX || p0.getMovement().getPosition().x > distanceX+50*pom+marginX) || (p0.getMovement().getPosition().y < distanceY-marginY || p0.getMovement().getPosition().y > distanceY+marginY)) {
						distanceX = p0.getMovement().getPosition().x;
						distanceY = p0.getMovement().getPosition().y;
						gameObjects.add(p0);
						randomEnemy(p0.getMovement().getPosition().x, p0.getMovement().getPosition().y,0);
						player.playerSprite.collidableObjects.addAll(p0.plist);
						player.bulletObstacles.addAll(p0.plist);
					}
				}
				else if(rand.nextInt(5) == 0) {
					int pom = rand.nextInt(1)+2;
					Platform p0 = new Platform(x + rand.nextFloat()*50, 350 + rand.nextFloat()*100, pom, null, 0);
					if((p0.getMovement().getPosition().x < distanceX-marginX || p0.getMovement().getPosition().x > distanceX+50*pom+marginX) || (p0.getMovement().getPosition().y < distanceY-marginY || p0.getMovement().getPosition().y > distanceY+marginY)) {
						distanceX = p0.getMovement().getPosition().x;
						distanceY = p0.getMovement().getPosition().y;
						gameObjects.add(p0);
						randomEnemy(p0.getMovement().getPosition().x, p0.getMovement().getPosition().y,1);
						player.playerSprite.collidableObjects.addAll(p0.plist);
						player.bulletObstacles.addAll(p0.plist);
					}
				}
				else {
					int pom = rand.nextInt(4)+2;
					Platform p0 = new Platform(x + rand.nextFloat()*50, 370 + rand.nextFloat()*100, pom, null, 0);
					if((p0.getMovement().getPosition().x < distanceX-marginX || p0.getMovement().getPosition().x > distanceX+50*pom+marginX) || (p0.getMovement().getPosition().y < distanceY-marginY || p0.getMovement().getPosition().y > distanceY+marginY)) {
						distanceX = p0.getMovement().getPosition().x;
						distanceY = p0.getMovement().getPosition().y;
						gameObjects.add(p0);
						player.playerSprite.collidableObjects.addAll(p0.plist);
						player.bulletObstacles.addAll(p0.plist);
						}
				}
				break;
			case 1:
				int pom = rand.nextInt(2)+2;
				Platform p1 = new Platform(x + rand.nextFloat()*50, 500 + rand.nextFloat()*100, pom, null, 0);
				if((p1.getMovement().getPosition().x < distanceX-marginX || p1.getMovement().getPosition().x > distanceX+50*pom+marginX) || (p1.getMovement().getPosition().y < distanceY-marginY || p1.getMovement().getPosition().y > distanceY+marginY)) {
					distanceX = p1.getMovement().getPosition().x;
					distanceY = p1.getMovement().getPosition().y;
					gameObjects.add(p1);
					player.playerSprite.collidableObjects.addAll(p1.plist);
					player.bulletObstacles.addAll(p1.plist);
				}
		}
	}
	
	private void randomEnemy(float x, float y, int type) {
		Enemy e;
		if(type == 0) e = new Enemy(x+120, y+131, 1, null, type, player);
		else if (type == 1) e = new Enemy(x, y+rand.nextInt(200), 1, null, type, player);
		else e = new Enemy(x, y+235, 0, null, 2, player);
		gameObjects.add(e);
	}
	
	private void randomObstacle(float x, float y) {
		Kolce k;
		if(rand.nextBoolean()) k = new Kolce(x, y, null, 0, 0, player);
		else k = new Kolce(x, y-30, null, 0, 1, player);
		gameObjects.add(k);
	}
	
	private float lastBigClockX=0;
	private float lastBigClockY=0;
	private float lastMediumClockX=0;
	private float lastMediumClockY=0;
	private float lastSmallClockX=0;
	private float lastSmallClockY=0;
	
	private float lastClockX=0;
	private float lastClockY=0;
	
	private double nowBigDistance=1500;
	private double nowMediumDistance=1500;
	private double nowSmallDistance=1500;
	private double nowClockDistance=1500;
	
	private float nowX=0;
	private float nowY=0;
	
	private float renderMini=600;
	private float renderBigDistance=6000;
	private float renderMediumDistance=3000;
	private float renderSmallDistance=1000;
	
	private float dst1;
	private float dst2;
	
	private void randomClock(int type) {

		switch (type) {
		case 0:
			//duzy
			nowX=x+rand.nextFloat()*50;
			nowY=y+300+(rand.nextFloat()*700);
			dst1=(((lastBigClockX-nowX)*(lastBigClockX-nowX))+((lastBigClockY-nowY)*(lastBigClockY-nowY)));
			nowBigDistance=(Math.sqrt((double)dst1));
			dst2=(((lastClockX-nowX)*(lastClockX-nowX))+((lastClockY-nowY)*(lastClockY-nowY)));
			nowClockDistance=(Math.sqrt((double)dst2));
			if (nowBigDistance >= renderBigDistance && nowClockDistance >= renderMini){
				
				Clock BC;
				BC = new Clock(nowX,nowY,null,0,0,player,bar);
				gameObjects.add(BC);
				lastBigClockX=nowX;
				lastBigClockY=nowY;
				lastClockX=nowX;
				lastClockY=nowY;
			}
			break;
		case 1:
			//sredni
			nowX=x+rand.nextFloat()*50;
			nowY=y+300+rand.nextFloat()*700;
			dst1=(((lastMediumClockX-nowX)*(lastMediumClockX-nowX))+((lastMediumClockY-nowY)*(lastMediumClockY-nowY)));
			nowMediumDistance=(Math.sqrt((double)dst1));
			dst2=(((lastClockX-nowX)*(lastClockX-nowX))+((lastClockY-nowY)*(lastClockY-nowY)));
			nowClockDistance=(Math.sqrt((double)dst2));
			if (nowMediumDistance >= renderMediumDistance && nowClockDistance >= renderMini){
				Clock MC;
				MC = new Clock(nowX,nowY,null,0,1,player,bar);
				gameObjects.add(MC);
				lastMediumClockX=nowX;
				lastMediumClockY=nowY;
				lastClockX=nowX;
				lastClockY=nowY;
			}
			break;
		case 2:
			//maly
			nowX=x+rand.nextFloat()*50;
			nowY=y+300+rand.nextFloat()*700;
			dst1=(((lastSmallClockX-nowX)*(lastSmallClockX-nowX))+((lastSmallClockY-nowY)*(lastSmallClockY-nowY)));
			nowSmallDistance=(Math.sqrt((double)dst1));
			dst2=(((lastClockX-nowX)*(lastClockX-nowX))+((lastClockY-nowY)*(lastClockY-nowY)));
			nowClockDistance=(Math.sqrt((double)dst2));
			if (nowSmallDistance >= renderSmallDistance && nowClockDistance >= renderMini){
				Clock SC;
				SC = new Clock(nowX,nowY,null,0,2,player,bar);
				gameObjects.add(SC);
				lastSmallClockX=nowX;
				lastSmallClockY=nowY;
				lastClockX=nowX;
				lastClockY=nowY;
			}
			break;
			
		default:
			break;
		}
	}
}
