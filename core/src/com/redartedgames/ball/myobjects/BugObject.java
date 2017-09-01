package com.redartedgames.ball.myobjects;

import com.redartedgames.ball.objects.GameObject;

public class BugObject extends GameObject{
	
	BugAlive bugalive;
	
	
	public BugObject(float x, float y, int id, GameObject parent) {
		super(x, y, id, parent);
		bugalive = new BugAlive(x, y, id);
		// TODO Auto-generated constructor stub
	}

	
	
}
