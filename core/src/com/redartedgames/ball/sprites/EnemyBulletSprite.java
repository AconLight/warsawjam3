package com.redartedgames.ball.sprites;

import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;

public class EnemyBulletSprite extends ColSpriteObject{

	public EnemyBulletSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		addTexture("data/bubbles/bubble_enemy.png");
		// TODO Auto-generated constructor stub
	}

}
