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
			randomGround(rand.nextInt(3));
			randomPlatforms(rand.nextInt(2));
	}
	
	private void randomGround(int type) {
		switch(type) {
			default:
			case 0:
				Ground g0 = new Ground(x, y+rand.nextFloat()*40, rand.nextInt(2)+2, false, null, 0);
				gameObjects.add(g0);
				player.playerSprite.collidableObjects.addAll(g0.plist);
				player.bulletObstacles.addAll(g0.plist);
				if(rand.nextInt(4)==0)randomClock(x + 20 + rand.nextFloat()*(g0.changeX-x), g0.getMovement().getPosition().y+270+rand.nextFloat()*30);
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
				break;
		}
	}
	
	private void randomPlatforms(int type) {
		switch(type) {
			default:
				break;
			case 0:
				if(rand.nextInt(2) == 0) {
					int pom = rand.nextInt(2)+6;
					Platform p0 = new Platform(x + rand.nextFloat()*50, 300 + rand.nextFloat()*100, pom, null, 0);
					if((p0.getMovement().getPosition().x < distanceX-marginX || p0.getMovement().getPosition().x > distanceX+50*pom+marginX) || (p0.getMovement().getPosition().y < distanceY-marginY || p0.getMovement().getPosition().y > distanceY+marginY)) {
						distanceX = p0.getMovement().getPosition().x;
						distanceY = p0.getMovement().getPosition().y;
						gameObjects.add(p0);
						randomEnemy(p0.getMovement().getPosition().x, p0.getMovement().getPosition().y,0);
						player.playerSprite.collidableObjects.addAll(p0.plist);
						player.bulletObstacles.addAll(p0.plist);
					}
				}
				else if(rand.nextInt(6) == 0) {
					int pom = rand.nextInt(1)+2;
					Platform p0 = new Platform(x + rand.nextFloat()*50, 300 + rand.nextFloat()*100, pom, null, 0);
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
					Platform p0 = new Platform(x + rand.nextFloat()*50, 300 + rand.nextFloat()*100, pom, null, 0);
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
		if(type == 0) e = new Enemy(x+120, y+230, 1, null, type, player);
		else e = new Enemy(x, y+rand.nextInt(200), 1, null, type, player);
		gameObjects.add(e);
		//todo dodaæ kolizje
	}
	
	private void randomObstacle(float x, float y) {
		Kolce k;
		if(rand.nextBoolean()) k = new Kolce(x, y, null, 0, 0, player);
		else k = new Kolce(x, y-30, null, 0, 1, player);
		gameObjects.add(k);
	}
	
	private void randomClock(float x, float y) {
		Clock c;
		c = new Clock(x, y, null, 1, rand.nextInt(3), player, bar);
		gameObjects.add(c);
	}
}
