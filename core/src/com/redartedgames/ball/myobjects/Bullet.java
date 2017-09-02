package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.TimeObject;
import com.redartedgames.ball.sprites.BublleBulletSprite;

public class Bullet extends TimeObject{
	
	public ColSpriteObject sprite;
	
	public Bullet(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		setAsBubbleBullet();
	}
	
	public void setAsBubbleBullet() {
		type =  ObjectType.BUBBLE_BULLET;
		sprite = new BublleBulletSprite(-1000, 0, this, 0);
	}
	
	public void explode() {
		//TODO
	}
	
	public void shoot(float x, float y, float vx, float vy) {
		sprite.getMovement().setPosition(new Vector2(x, y));
		sprite.getMovement().setVelocity(new Vector2(vx, vy));
		addSprite(sprite);
	}

}
