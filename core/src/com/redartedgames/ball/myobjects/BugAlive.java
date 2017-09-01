package com.redartedgames.ball.myobjects;

import java.math.BigDecimal;

import com.badlogic.gdx.graphics.glutils.FileTextureArrayData;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.ColSpriteObject;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Hitbox;
import com.redartedgames.ball.objects.Hitbox.BehaviorMode;
import com.redartedgames.ball.objects.SpriteObject;
import com.redartedgames.ball.settings.GameVars;

public class BugAlive extends SpriteObject {
	

	public BugAlive (float x, float y, int id){
		super(x,y,null,id);
		setHitbox(new Hitbox(new BigDecimal(""+x), new BigDecimal(""+y), GameVars.bugRadius, BehaviorMode.kinematic));
		
		setFrameTime(0.8f);
		addTexture("bug.png");
		addTexture("bug2.png");
		setStoped(false);
		
	}
	/*@Override
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		
	}*/
	
}
