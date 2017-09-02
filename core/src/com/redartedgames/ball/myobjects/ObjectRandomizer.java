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
	
	public ObjectRandomizer(ArrayList<GameObject> gameObjects, Player player){
		this.gameObjects = gameObjects;
		this.player = player;
		randomize();
		randomize();
		randomize();
	}
	
	public void randomize() {
		//for(int i = 0; i<50; i++) {
			randomGround(rand.nextInt(3));
			randomPlatforms(rand.nextInt(2));
		//}
	}
	
	private void randomGround(int type) {
		switch(type) {
			default:
			case 0:
				Ground g0 = new Ground(x, y+rand.nextFloat()*80, rand.nextInt(2)+2, false, null, 0);
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
				Ground g2 = new Ground(x, y+rand.nextFloat()*80, rand.nextInt(5)+3, false, null, 0);
				gameObjects.add(g2);
				player.playerSprite.collidableObjects.addAll(g2.plist);
				player.bulletObstacles.addAll(g2.plist);
				x = g2.changeX;
				break;
			case 3:
				Ground g3 = new Ground(x, y, 5, false, null, 0);
				gameObjects.add(g3);
				player.playerSprite.collidableObjects.addAll(g3.plist);
				player.bulletObstacles.addAll(g3.plist);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
		}
	}
	
	private void randomPlatforms(int type) {
		switch(type) {
			default:
			case 0:
				if(rand.nextInt(16) == 0) {					
					Platform p0 = new Platform(x + rand.nextFloat()*150 + 100, 300 + rand.nextFloat()*100, rand.nextInt(2)+6, null, 0);
					gameObjects.add(p0);
					randomEnemy(p0.getMovement().getPosition().x, p0.getMovement().getPosition().y,0);
					player.playerSprite.collidableObjects.addAll(p0.plist);
					player.bulletObstacles.addAll(p0.plist);
				}
				else if(rand.nextInt(16) == 0) {					
					Platform p0 = new Platform(x + rand.nextFloat()*200-50 + 100, 300 + rand.nextFloat()*100, rand.nextInt(1)+2, null, 0);
					gameObjects.add(p0);
					randomEnemy(p0.getMovement().getPosition().x, p0.getMovement().getPosition().y,1);
					player.playerSprite.collidableObjects.addAll(p0.plist);
					player.bulletObstacles.addAll(p0.plist);
				}
				else {
					Platform p0 = new Platform(x + rand.nextFloat()*100 + 100, 300 + rand.nextFloat()*100, rand.nextInt(4)+2, null, 0);
					gameObjects.add(p0);
					player.playerSprite.collidableObjects.addAll(p0.plist);
					player.bulletObstacles.addAll(p0.plist);
				}
				break;
			case 1:
				Platform p1 = new Platform(x + rand.nextFloat()*100 + 100, 500 + rand.nextFloat()*100, rand.nextInt(2)+2, null, 0);
				gameObjects.add(p1);
				player.playerSprite.collidableObjects.addAll(p1.plist);
				player.bulletObstacles.addAll(p1.plist);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
	}
	}
	
	private void randomEnemy(float x, float y, int type) {
		Enemy e;
		if(type == 0) e = new Enemy(x+120, y+130, 1, null, type);
		else e = new Enemy(x, y, 1, null, type);
		gameObjects.add(e);
	}
	
	private void randomObstacle(float x, float y) {
		
	}
	
	private void randomClock(float x, float y) {
		
	}
}
