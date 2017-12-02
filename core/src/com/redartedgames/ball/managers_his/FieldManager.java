package com.redartedgames.ball.managers_his;

import java.util.ArrayList;

import com.redartedgames.ball.myobjects_his.Field;
import com.redartedgames.ball.myobjects_his.FieldType;



public class FieldManager {
	private ArrayList<Field> fields;
	private float fieldR = 50;
	
	public FieldManager() {
		fields = new ArrayList<Field>();
		generateLand(50, 50);
	}
	
	private void generateLand(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				fields.add(new Field(j*80, i*80, 0, null, FieldType.city));
			}
		}
	}
	
	public void checkMouse(int x, int y) {
		for (Field field : fields) {
			//field.
		}
	}
	
	public void update(float delta) {
		for (Field field : fields) {
			field.updateBefore(0 ,0, delta);
		}
	}
	
	public ArrayList<Field> getFields(){
		return fields;
	}

}
