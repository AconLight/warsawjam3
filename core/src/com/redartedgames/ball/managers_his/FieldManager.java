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
		int k = 5;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				fields.add(new Field(i*200, j*200, i*5 + j, null));
			}
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if(i>0)
				fields.get(i*5 + j).addField(fields.get((i-1)*k + j));
				if(i < k-1)
				fields.get(i*5 + j).addField(fields.get((i+1)*k + j));
				if(i > 0 && j > 0)
				fields.get(i*5 + j).addField(fields.get((i-1)*k + j-1));
				if(j > 0)
				fields.get(i*5 + j).addField(fields.get((i)*k + j-1));
				if(i < k-1 && j > 0)
				fields.get(i*5 + j).addField(fields.get((i+1)*k + j-1));
				if(i > 0 && j < k-1)
				fields.get(i*5 + j).addField(fields.get((i-1)*k + j+1));
				if(j < k-1)
				fields.get(i*5 + j).addField(fields.get((i)*k + j+1));
				if(i < k-1 && j < k-1)
				fields.get(i*5 + j).addField(fields.get((i+1)*k + j+1));
			
			}
		}
		
		

		for(int i=0;i<fields.size();i++){
			for(int j=0;j<fields.size();j++){
				if(j!=i && j - i < 1 && i - j > -1)
				fields.get(i).addField(fields.get(j));
			}
		}

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
