package com.redartedgames.ball.managers_his;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.redartedgames.ball.myobjects_his.Field;
import com.redartedgames.ball.myobjects_his.FieldType;



public class FieldManager {
	public Field currentField;
	public OrthographicCamera cam;
	private ArrayList<Field> fields;
	private float fieldR = 150;
	public float camVelX, camVelY; 
	static int i2 = 0;
	int id;
	
	public FieldManager() {
		i2 += 1;
		id = i2;
		cam = new OrthographicCamera(1920, 1080);
		fields = new ArrayList<Field>();
		generateLand(2, 2);
	}
	
	private void generateLand(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				
			}
		}
		fields.add(new Field(0, 0, 0, null, FieldType.city));
		fields.add(new Field(80, 0, 1, null, FieldType.village));
		fields.add(new Field(80, 80, 2, null, FieldType.village));
		fields.add(new Field(160, 80, 2, null, FieldType.city));
	}
	
	public void checkMouse(int x, int y) {
		float posX = x + (cam.position.x - 1920/2);
		float posY = y - (cam.position.y + 1080/2);
		System.out.println(posX + ", " + posY);
		System.out.println(fields.get(0).getPosition());
		for (Field field : fields) {
			if (field.checkMouse((int) posX, (int) posY, fieldR)) {
				currentField = field;
				System.out.println("a");
				return;
			}
		}
		currentField = null;
	}
	public void setCamVel(float x, float y) {
		camVelX = x;
		camVelY = y;
		int k = 430;
		if (camVelX > k) camVelX = k;
		if (camVelX < -k) camVelX = -k;
		if (camVelY > k) camVelY = k;
		if (camVelY < -k) camVelY = -k;
	}
	
	public void update(float delta) {
		cam.position.set(new Vector3(cam.position.x + 0.000003f*camVelX*camVelX*camVelX*delta, cam.position.y - 0.000003f*camVelY*camVelY*camVelY*delta, cam.position.z));
		cam.update();
		for (Field field : fields) {
			field.updateBefore(0 ,0, delta);
		}
	}
	
	public ArrayList<Field> getFields(){
		return fields;
	}

}
