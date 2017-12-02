package com.redartedgames.ball.myobjects_his;

import java.util.Random;

public class FieldStatistic {
	private FieldType fieldType;
	private float base_mig_mult;
	private float base_cult_mult;
	public float population;
	private Field parent;
	private float migration;
	private float affiliation;//przynale¿noœæ
	private float birthrate = 0.05f;

	public float getbase_mig_mult(){
		return base_mig_mult;
	}
	public float getbase_cult_mult(){
		return base_cult_mult;
	}
	public float getpopulation(){
		return population;
	}
	public float getmigration(){
		return migration;
	}
	public FieldStatistic(FieldType fieldType,Field parent){
		this.parent=parent;
		switch(fieldType){
		case city:
			base_mig_mult = randomfromto(10,20,true);
			base_cult_mult = randomfromto(4,30,true);
			population = randomfromto(1000,5000,false);
			break;
		case village:
			base_mig_mult = randomfromto(20,50,true);
			base_cult_mult = randomfromto(0,5,true);
			population = randomfromto(20,100,false);
			break;
		case hill:
			base_mig_mult = randomfromto(90,100,true);
			base_cult_mult = randomfromto(0,1,true);
			population = randomfromto(0,1,false);
			break;
		case meadow:
			base_mig_mult = randomfromto(80,100,true);
			base_cult_mult = randomfromto(0,1,true);
			population = randomfromto(0,1,false);
			break;
		case mountain:
			base_mig_mult = randomfromto(95,100,true);
			base_cult_mult = randomfromto(0,1,true);
			population = randomfromto(0,1,false);
			break;
		default://to nigdy nie powinno wyst¹piæ
			base_mig_mult = randomfromto(100,101,true);
			base_cult_mult = randomfromto(0,1,true);
			population = randomfromto(0,1,false);
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
	public void mod_base_mig()
	{
		
	}
	public void updateBefore(float delta, float vx, float vy) {
		delta /=100;
		population += (population*birthrate*delta);
		migration = ((population-population*base_cult_mult)*base_mig_mult*(population/100))*(delta);
		System.out.println("Populacja przed migracja " + population + " migracja = " + migration);
		population = population - migration;
		for(int i=0; i<parent.fields.size();i++){
		parent.fields.get(i).statistic.population += migration/parent.fields.size();
		}
		System.out.println("Populacja po migracja " + population + " migracja = " + migration);
		System.out.println("----------------------------------------------------------------");
	}

}

