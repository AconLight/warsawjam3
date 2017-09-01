package com.redartedgames.ball.myobjects;

import com.badlogic.gdx.Gdx;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.Movement;
import com.redartedgames.ball.objects.ReversableMovement;
import com.redartedgames.ball.objects.ReversableObject;

public class Imp extends Player{
	
	protected boolean isSpawned;
	
	public static int type;
	
	public static int STATIC_TYPE = 1;
	
	public static int ACTIVE_TYPE = 2;
	
	public Imp(float x, float y, float m, GameObject parent, int id) {
		super(x, y, 1, parent, id);
		isSpawned = false;
		type = 0;
	} 
	
	public void spawn(Movement movement) {
		((ReversableMovement)this.movement).set((ReversableMovement) movement);
		this.movement.getPosition().set(((ReversableMovement)this.movement).getPositionX().floatValue(), 
				((ReversableMovement)this.movement).getPositionY().floatValue());
		//Gdx.app.log("Imp", message);
		isSpawned = true;
	}
	
	public void activate() {
		
	}
	
	public void deactivate() {
		
	}	
	
	@Override
	public void collide(GameObject obj) {
		if (isSpawned) super.collide(obj);
	}

}
