package com.redartedgames.ball.myobjects_his;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.ball.objects.GameObject;
import com.redartedgames.ball.objects.SpriteObject;

public class Field extends GameObject{

	public ArrayList<Field> fields;
	public FieldStatistic statistic;
	public FieldType fieldType;
	
	public Field(float x, float y, int id, GameObject parent,FieldType fieldType) {
		super(y, y, id, parent);
		fields = new ArrayList<Field>();
		this.fieldType = fieldType;
		statistic = new FieldStatistic(fieldType,this);
		//grafika Field
		addSprite(new FieldSprite(x, y, this, id, statistic));
	}
	
	public Field(float x, float y, int id, GameObject parent) {
		super(y, y, id, parent);
		fields = new ArrayList<Field>();
		Random r = new Random();
		fieldType = FieldType.city;
		switch(r.nextInt(5)) {
		case 0: fieldType = FieldType.city; break;
		case 1: fieldType = FieldType.meadow; break;
		case 2: fieldType = FieldType.village; break;
		case 3: fieldType = FieldType.hill; break;
		case 4: fieldType = FieldType.mountain; break;
		}
		statistic = new FieldStatistic(fieldType,this);
		//grafika Field
		addSprite(new FieldSprite(x, y, this, id, statistic));

	}
	
	public Field addField(Field field) {
		fields.add(field);
		return this;
	}
	
	public boolean checkMouse(int x, int y, float r) {
		return (x > getGameObjects().get(0).getPosition().x - r && x < getGameObjects().get(0).getPosition().x + r && 
				y > getGameObjects().get(0).getPosition().y - r && y < getGameObjects().get(0).getPosition().y + r);
	}
	
	public void updateBefore(float delta, float vx, float vy) {
		super.updateBefore(delta, vx, vy);
		statistic.updateBefore(delta, vx, vy);
		// mechanika
	}
	
	public void render(SpriteBatch batch, int priority, float dx, float dy) {
		((SpriteObject)gameObjects.get(0)).setRenderIsNormal(false);
			((FieldSprite)gameObjects.get(0)).render(batch, priority, -dx, -dy);
			
	}
	
	

}
