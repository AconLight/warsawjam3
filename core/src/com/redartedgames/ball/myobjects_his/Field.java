package com.redartedgames.ball.myobjects_his;

import java.util.ArrayList;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class Field extends SpriteObject{

	public ArrayList<Field> fields;
	
	public Field(float x, float y, int id, GameObject parent) {
		super(y, y, parent, id);
		
		//grafika Field
	}
	
	public GameObject addField(Field field) {
		fields.add(field);
		return this;
	}
	
	public void updateBefore(float delta, float vx, float vy) {
		super.updateBefore(delta, vx, vy);
		
		
		// mechanika
	}
	
	

}
