package com.redartedgames.ball.managers_his;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.redartedgames.ball.myobjects_his.Field;
import com.redartedgames.ball.myobjects_his.FieldType;



public class FieldManager {
	public OrthographicCamera cam;
	private ArrayList<Field> fields;
	private float fieldR = 50;
	
	public FieldManager() {
		cam = new OrthographicCamera(1920, 1080);
		fields = new ArrayList<Field>();
		generateLand(2, 2);
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
			field.checkMouse(x, y, fieldR);
		}
	}
	
	public void update(float delta) {
		cam.position.set(new Vector3(cam.position.x + delta*100, cam.position.y, cam.position.z));
		cam.update();
		for (Field field : fields) {
			field.updateBefore(0 ,0, delta);
		}
	}
	
	public ArrayList<Field> getFields(){
		return fields;
	}

}
