package com.redartedgames.ball.myobjects;

import java.util.ArrayList;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.TimeObject;

public class Enemy extends TimeObject{

	public ArrayList<Bullet> bullets;
	public EnemySprite enemySprite;
	
	public Enemy(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		// TODO Auto-generated constructor stub
	}
	public void shoot(){
		bullets.add(new Bullet(enemySprite.getPosition().x, enemySprite.getPosition().y, 0, this));
	}
}
