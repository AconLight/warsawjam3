package com.redartedgames.ball.managers_his;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects_his.Field;



public class FieldManager {
	private ArrayList<Field> land;
	
	
	public FieldManager() {
		land = new ArrayList<Field>();
		generateLand(50, 50);
	}
	
	private void generateLand(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				land.add(new Field(j*50, i*50, 0, null));
			}
		}
	}
	
	
	public void update(float delta) {
		for (Field field : land) {
			field.updateBefore(0 ,0, delta);
		}
	}

}
