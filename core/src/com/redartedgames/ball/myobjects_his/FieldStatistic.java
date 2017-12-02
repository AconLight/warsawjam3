package com.redartedgames.ball.myobjects_his;

import java.util.Random;

public class FieldStatistic {
	private FieldType fieldType;
	private float base_mig_mult;
	private float base_cult_mult;
	private float base_mig_speed;
	public float population;
	private float area_size;
	private Field parent;

	public float getbase_mig_mult(){
		return base_mig_mult;
	}
	public float getbase_cult_mult(){
		return base_cult_mult;
	}
	public float getbase_mig_speed(){
		return base_mig_speed;
	}
	public float getpopulation(){
		return population;
	}
	public float getarea_size(){
		return area_size;
	}
	public FieldStatistic(FieldType fieldType,Field parent){
		this.parent=parent;
		switch(fieldType){
		case city:
			base_mig_mult = randomfromto(3,9,true);
			base_cult_mult = randomfromto(4,30,true);
			base_mig_speed = 1;
			population = randomfromto(12000,1735000,false);
			area_size  = randomfromto(40,300,false);
			break;
		case village:
			base_mig_mult = randomfromto(10,30,true);
			base_cult_mult = randomfromto(0,5,true);
			base_mig_speed = 0.7f;
			population = randomfromto(20,100,false);
			area_size  = randomfromto(4,10,false);
			break;
		case hill:
			base_mig_mult = randomfromto(90,100,true);
			base_cult_mult = randomfromto(0,1,true);
			base_mig_speed = 0.5f;
			population = randomfromto(0,1,false);
			area_size  = randomfromto(40,300,false);
			break;
		case meadow:
			base_mig_mult = randomfromto(80,100,true);
			base_cult_mult = randomfromto(0,1,true);
			base_mig_speed = 0.8f;
			population = randomfromto(0,1,false);
			area_size  = randomfromto(40,300,false);
			break;
		case mountain:
			base_mig_mult = randomfromto(95,100,true);
			base_cult_mult = randomfromto(0,0,true);
			base_mig_speed = 0.2f;
			population = randomfromto(0,1,false);
			area_size  = randomfromto(40,300,false);
			break;
		default://to nigdy nie powinno wyst¹piæ
			base_mig_mult = randomfromto(100,101,true);
			base_cult_mult = randomfromto(0,1,true);
			base_mig_speed = 1f;
			population = randomfromto(0,1,false);
			area_size  = randomfromto(40,300,false);
			break;	
				
		}
	}
	private float randomfromto(int min, int max, boolean procent){
		Random my_random = new Random();
		float wyniczek = my_random.nextInt(max-min)+min;
		if(procent){
			wyniczek = wyniczek/100.0f;
			return wyniczek;
		}
		else
			return wyniczek;
			
	}
	public void updateBefore(float delta, float vx, float vy) {
		float migration = ((population-population*base_cult_mult)*base_mig_mult)*(delta*base_mig_speed);
		System.out.println("Populacja przed migracja " + population + " migracja = " + migration);
		population = population - migration;
		for(int i=0; i<parent.fields.size();i++){
		parent.fields.get(1).statistic.population += migration/parent.fields.size();
		}
		System.out.println("Populacja po migracja " + population + " migracja = " + migration);
	}

}

