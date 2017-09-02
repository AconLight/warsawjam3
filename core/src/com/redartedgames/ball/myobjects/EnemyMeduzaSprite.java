package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;

public class EnemyMeduzaSprite extends ColSpriteObject{

	
	
	public EnemyMeduzaSprite(float x, float y, GameObject parent, int id){
		super(x, y, parent, id);
		setFrameTime(0.2f);
		regionList.clear();
		addTexture("data/enemy/meduza/meduza1.png");
		addTexture("data/enemy/meduza/meduza2.png");
		addTexture("data/enemy/meduza/meduza3.png");
	}
	
	public void mov (float spedx, float spedy) {
		getMovement().setVelocity(new Vector2(spedx,spedy));
	}
}
