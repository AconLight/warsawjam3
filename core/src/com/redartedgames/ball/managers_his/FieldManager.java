package com.redartedgames.ball.managers_his;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.redartedgames.ball.myobjects_his.Field;
import com.redartedgames.ball.myobjects_his.FieldType;
import com.redartedgames.ball.myobjects_his.LittleField;



public class FieldManager {
	public Field currentField;
	public Vector2 cam;
	private ArrayList<Field> fields;
	private float fieldR = 150;
	public float camVelX, camVelY; 
	static int i2 = 0;
	int id;
	
	public FieldManager() {
		i2 += 1;
		id = i2;
		cam = new Vector2(0, 0);
		fields = new ArrayList<Field>();
		generateLand(2, 2);
	}
	int k;
	private void generateLand(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				
			} 
		}
		k = 15;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				fields.add(new Field((i-k/2)*200, (j-k/2)*200, i*k + j, null));
			}
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if(i>0)
				fields.get(i*k + j).addField(fields.get((i-1)*k + j));
				if(i < k-1)
				fields.get(i*k + j).addField(fields.get((i+1)*k + j));
				if(i > 0 && j > 0)
				fields.get(i*k + j).addField(fields.get((i-1)*k + j-1));
				if(j > 0)
				fields.get(i*k + j).addField(fields.get((i)*k + j-1));
				if(i < k-1 && j > 0)
				fields.get(i*k + j).addField(fields.get((i+1)*k + j-1));
				if(i > 0 && j < k-1)
				fields.get(i*k + j).addField(fields.get((i-1)*k + j+1));
				if(j < k-1)
				fields.get(i*k + j).addField(fields.get((i)*k + j+1));
				if(i < k-1 && j < k-1)
				fields.get(i*k + j).addField(fields.get((i+1)*k + j+1));
			
			}
		}
		
		fields.get(k*k/2+k).statistic.affiliation = 100;
		

		for(int i=0;i<fields.size();i++){
			for(int j=0;j<fields.size();j++){
				if(j!=i && j - i < 1 && i - j > -1);
				//fields.get(i).addField(fields.get(j));
			}
		}

	}
	
	public void checkMouse(int x, int y) {

		float posX = x + cam.x;
		float posY = -y + cam.y+1080;
		//System.out.println("posX: " + posX + "posY: " + posY);
		for (Field field : fields) {
			if (field.checkMouse((int) posX, (int) posY, 50)) {
				currentField = field;
				//System.out.println("a");
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
		fields.get(k*k/2).statistic.affiliation = 100;
		if(!(((camVelX>1)&&(camVelX<-1))&&(camVelY>1)&&(camVelY<-1)))cam.set(cam.x + 0.000003f*camVelX*camVelX*camVelX*delta, cam.y - 0.000003f*camVelY*camVelY*camVelY*delta);
		if(cam.x<-1480)cam.x = -1480;
		if(cam.x>300)cam.x = 300;
		if(cam.y<-1480)cam.y = -1480;
		if(cam.y>160)cam.y = 160;
		for (Field field : fields) {
			field.updateBefore(0 ,0, delta);
			field.updateAfter(0 ,0, delta);

		}
	}
	
	public ArrayList<Field> getFields(){
		return fields;
	}

}
