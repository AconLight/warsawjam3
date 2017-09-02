package com.redartedgames.ball.myobjects;

import java.util.ArrayList;
import java.util.Random;

import com.redartedgames.ball.objects.GameObject;

public class ObjectRandomizer {

	private ArrayList<GameObject> gameObjects; 
	private float x = 0;
	private float y = 0;
	private Random rand = new Random();
	private Player player;
	
	public ObjectRandomizer(ArrayList<GameObject> gameObjects, Player player){
		this.gameObjects = gameObjects;
		this.player = player;
		randomize();
	}
	
	private void randomize() {
		for(int i = 0; i<20; i++)
			randomGround(rand.nextInt(3));
	}
	
	private void randomGround(int type) {
		switch(type) {
			default:
			case 0:
				Ground g0 = new Ground(x, y+rand.nextFloat()*80, 3, false, null, 0);
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
				Ground g2 = new Ground(x, y+rand.nextFloat()*80, 5, false, null, 0);
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
				gameObjects.add(new Platform(x + rand.nextFloat()*100 + 100, 300 + rand.nextFloat()*100, rand.nextInt(3)+2, null, 0));
				break;
			case 1:
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
	
	private void enemies() {
		
	}
	
	private void obstacles() {
		
	}
}
