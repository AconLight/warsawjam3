package com.redartedgames.ball.myobjects_his;

import java.util.Random;

public class FieldStatistic {
	private FieldType fieldType;
	private float base_mig_mult;
	private float base_cult_mult;
	private float base_mig_speed;
	private float population;
	private float area_size;
	private Field parent;

	
	public FieldStatistic(FieldType fieldType,Field parent){
		this.parent=parent;
		switch(fieldType){
		case city:
			base_mig_mult = randomfromto(3,9);
			base_cult_mult = randomfromto(4,30);
			base_mig_speed = 1;
			population = randomfromto(12000,1735000);
			area_size  = randomfromto(40,300);
			break;
		case village:
			base_mig_mult = randomfromto(10,30);
			base_cult_mult = randomfromto(0,5);
			base_mig_speed = 0.7f;
			population = randomfromto(20,100);
			area_size  = randomfromto(4,10);
			break;
		case hill:
			base_mig_mult = randomfromto(90,100);
			base_cult_mult = randomfromto(0,1);
			base_mig_speed = 0.5f;
			population = randomfromto(0,1);
			area_size  = randomfromto(40,300);
			break;
		case meadow:
			base_mig_mult = randomfromto(80,100);
			base_cult_mult = randomfromto(0,0);
			base_mig_speed = 0.8f;
			population = randomfromto(0,1);
			area_size  = randomfromto(40,300);
			break;
		case mountain:
			base_mig_mult = randomfromto(95,100);
			base_cult_mult = randomfromto(0,0);
			base_mig_speed = 0.2f;
			population = randomfromto(0,1);
			area_size  = randomfromto(40,300);
			break;
		default://to nigdy nie powinno wyst¹piæ
			base_mig_mult = randomfromto(100,100);
			base_cult_mult = randomfromto(0,0);
			base_mig_speed = 1f;
			population = randomfromto(0,1);
			area_size  = randomfromto(40,300);
			break;	
				
		}
	}
	private float randomfromto(int min, int max){
		Random my_random = new Random();
		float wyniczek = my_random.nextInt(max-min)+min;
		wyniczek = wyniczek/100.0f;
		return wyniczek;
		
	}
	public void updateBefore(float delta, float vx, float vy) {
		
		float migration = ((population-population*base_cult_mult)*base_mig_mult)*(delta*base_mig_speed);
		for(int i=0; i<parent.fields.size();i++){
		parent.fields.get(i).statistic.population += migration/parent.fields.size();}
		
	}
}
