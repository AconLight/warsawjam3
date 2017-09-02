package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Player extends TimeObject{

	private PlayerSprite playerSprite;
	private ArrayList<Bullet> bullets;
	
	public Player(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		playerSprite = new PlayerSprite(x, y, parent, id);
		addSprite(playerSprite);
	}
	
	public void addXAxis(float x) {
		playerSprite.addXAxis(x);
	}
	
	public void tryJump() {
		if (playerSprite.tryJump()) {
			jump();
		}
	}
	
	public void jump() {
		
	}
	
	public void tryShoot() {
		//TODO
	}
	
	public void shoot() {
		
	}
	


}
