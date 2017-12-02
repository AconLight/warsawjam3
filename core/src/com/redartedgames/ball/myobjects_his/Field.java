package com.redartedgames.ball.myobjects_his;

import java.util.ArrayList;

import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class Field extends GameObject{

	public ArrayList<Field> fields;
	public FieldStatistic statistic;
	
	public Field(float x, float y, int id, GameObject parent) {
		super(y, y, id, parent);
		statistic = new FieldStatistic();
		//grafika Field
		addSprite(new FieldSprite(x, y, this, id, statistic));
	}
	
	public GameObject addField(Field field) {
		fields.add(field);
		return this;
	}
	
	public void updateBefore(float delta, float vx, float vy) {
		super.updateBefore(delta, vx, vy);
		statistic.updateBefore(delta, vx, vy);
		
		// mechanika
	}
	
	

}
