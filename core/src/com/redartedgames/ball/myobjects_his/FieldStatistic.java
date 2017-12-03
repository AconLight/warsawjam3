package com.redartedgames.ball.myobjects_his;

import java.util.Random;

public class FieldStatistic {
	private FieldType fieldType;
	public float base_mig_mult;
	public float base_cult_mult;
	public float population;
	public Field parent;
	public float migration;
	public float affiliation = 10;//przynale�no��
	public float birthrate = 0.05f;
	public float wealth;

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
			base_cult_mult = randomfromto(0,5,true);
			population = randomfromto(0,1,false);
			break;
		default://to nigdy nie powinno wyst�pi�
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
	public void updateBefore(float delta, float vx, float vy) {
		delta /=100;
		population += birthrate*population*delta;
		if (population < 10) population = 10;
		wealth += ((population-1000)*population/10 - 1)*delta;
		if (wealth > 1000) wealth = 1000;
		birthrate += (-wealth + 100)*delta;
		population += 10/(population/10+1)*delta;
		birthrate += 100/(population/10+1)*delta;
		if (birthrate < -10) birthrate = -10;
		migration = (population-(population*base_cult_mult))*base_mig_mult*delta;
		System.out.println(parent.fields.size());
		for(int i=0; i<parent.fields.size();i++){
			
			parent.fields.get(i).statistic.wealth = (parent.fields.get(i).statistic.population*parent.fields.get(i).statistic.wealth + 
					migration*wealth)/(parent.fields.get(i).statistic.population+migration+1);
			
			parent.fields.get(i).statistic.birthrate = (parent.fields.get(i).statistic.population*parent.fields.get(i).statistic.birthrate + 
					migration*birthrate)/(parent.fields.get(i).statistic.population+migration+1);
			parent.fields.get(i).statistic.affiliation = ((parent.fields.get(i).statistic.population + 0.1f)*parent.fields.get(i).statistic.affiliation + 
					migration*affiliation)/(parent.fields.get(i).statistic.population+migration + 0.1f);
			
			
			
			parent.fields.get(i).statistic.population += migration/parent.fields.size();
		}
		
		if (affiliation > 80) affiliation += 50*delta;
		else affiliation -= 5*delta;
		
		if (affiliation > 100) affiliation = 100;
		
	}

}

