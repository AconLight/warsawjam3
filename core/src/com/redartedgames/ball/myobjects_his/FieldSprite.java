package com.redartedgames.ball.myobjects_his;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class FieldSprite extends SpriteObject{

	public FieldSprite(float x, float y, GameObject parent, int id) {
		super(x, y, parent, id);
		////////
		//grafika Field
		addTexture("data_his/fieldsprite.png");
		
		
		
		////////
		renderIsNormal = true;
	}
	
	public void updateBefore(float delta, float vx, float vy) { 
		this.position.set(parent.getPosition());
	}
}
