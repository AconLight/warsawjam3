package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Text;

public class StatRenderer extends RenderManager {
	
	private ArrayList<Text> stats;
	private SpriteBatch batch;
	private String PopulacjaWartosc="";
	private String PopulacjaWartosc2="";
	private String PrzyrostWartosc="";
	private String PrzyrostWartosc2="";
	private String ZamoznoscWartosc="";
	private String ZamoznoscWartosc2="";
	private String PrzynaleznoscWartosc="";
	private String PrzynaleznoscWartosc2="";
	private String Migracjawartosc="";
	private String Migracjawartosc2="";
	private String NameString="";
	
	private Text Money;
	private Text AmountMoney;
	private Text FieldName;
	private Text StatName;
	private Text StatBase;
	private Text PopulationText;
	private Text PopulationValue;
	private Text BirthrateText;
	private Text BirthrateValue;
	private Text WealthText;
	private Text WealthValue;
	private Text AffiliationText;
	private Text AffiliationValue;
	private Text MigrationText;
	private Text MigrationValue;
		
	public StatRenderer(GameWorld_his gameworld) {
		super(gameworld);
		stats = new ArrayList<Text>();
		batch = new SpriteBatch();
		
		Money = new Text(1450,510,null,0,2,"Pieni�dze:");
		FieldName = new Text(1575,365,null,1,1,"NawzaPola");
		StatName = new Text(1460,310,null,2,1,"Statystyka:");
		StatBase = new Text(1705,310,null,3,1,"Warto��:");
		PopulationText = new Text(1460,250,null,4,0,"Populacja");
		PopulationValue = new Text(1705,250,null,5,0,"123");
		BirthrateText = new Text(1460,210,null,6,0,"Przyrost");
		BirthrateValue = new Text(1705,210,null,7,0,"123");
		WealthText = new Text(1460,170,null,8,0,"Zamo�no��");
		WealthValue = new Text(1705,170,null,9,0,"123");
		AffiliationText = new Text(1460,130,null,10,0,"Przynale�no��");
		AffiliationValue = new Text(1705,130,null,11,0,"123");
		AmountMoney = new Text(1740,510,null,12,2,"123");
		MigrationText = new Text(1460,90,null,13,0,"Migracja");
		MigrationValue = new Text(1705,90,null,14,0,"123");
		stats.add(Money);
		stats.add(FieldName);
		stats.add(StatName);
		stats.add(StatBase);
		stats.add(PopulationText);
		stats.add(PopulationValue);
		stats.add(BirthrateText);
		stats.add(BirthrateValue); 
		stats.add(WealthText);
		stats.add(WealthValue);
		stats.add(AffiliationText);
		stats.add(AffiliationValue);
		stats.add(AmountMoney);
		stats.add(MigrationText);
		stats.add(MigrationValue);
	}

	public void render() {
		batch.begin();
		for(Text t : stats)
			t.render(batch, 1, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		super.update(delta);
		PopulacjaWartosc2="";
		PrzyrostWartosc2="";
		ZamoznoscWartosc2="";
		PrzynaleznoscWartosc2="";
		Migracjawartosc2="";
		stats.get(12).txt = Integer.toString((int) gameworld.cardsManager.money2);
		if (gameworld.fieldManager.currentField != null) {
			PopulacjaWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.population);
			for (int dupa=0;dupa<6 && dupa<PopulacjaWartosc.length();dupa++) PopulacjaWartosc2+=PopulacjaWartosc.charAt(dupa);
			} else PopulacjaWartosc2 = "";
		stats.get(5).txt = PopulacjaWartosc2;
		
		if (gameworld.fieldManager.currentField != null) {
			PrzyrostWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.birthrate);
			for (int i=0;i<5 && i<PrzyrostWartosc.length();i++) PrzyrostWartosc2+=PrzyrostWartosc.charAt(i);
			} else PrzyrostWartosc2 = "";
		stats.get(7).txt = PrzyrostWartosc2;
		
		if (gameworld.fieldManager.currentField != null) {
			ZamoznoscWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.wealth);
			for (int i=0;i<5 && i<ZamoznoscWartosc.length();i++) ZamoznoscWartosc2+=ZamoznoscWartosc.charAt(i);
			} else ZamoznoscWartosc2 = "";
		stats.get(9).txt = ZamoznoscWartosc2;
		
		if (gameworld.fieldManager.currentField != null) {
			PrzynaleznoscWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.affiliation);
			for (int i=0;i<3 && i<PrzynaleznoscWartosc.length();i++) PrzynaleznoscWartosc2+=PrzynaleznoscWartosc.charAt(i);
			} else PrzynaleznoscWartosc2 = "";
		stats.get(11).txt = PrzynaleznoscWartosc2;
		
		if (gameworld.fieldManager.currentField != null) {
			Migracjawartosc = Float.toString(gameworld.fieldManager.currentField.statistic.migration);
			for (int i=0;i<5 && i<Migracjawartosc.length();i++) Migracjawartosc2+=Migracjawartosc.charAt(i);
			} else Migracjawartosc2 = "";
		stats.get(14).txt = Migracjawartosc2;
		
		if (gameworld.fieldManager.currentField != null) {
			 switch(gameworld.fieldManager.currentField.fieldType){
			 	case city:
			 		NameString = "Miasto";
			 		break;
			 	case village:
			 		NameString = "Wie�";
			 		break;
			 	case hill:
			 		NameString = "Wzg�rze";
			 		break;
			 	case mountain:
			 		NameString = "G�ra";
			 		break;
			 	case meadow:
			 		NameString = "��ka";
			 		break;	
			 	default:
			 		NameString = "";
			 		break;
			 }
			stats.get(1).txt = NameString;
		} else stats.get(1).txt = "";
	}

}
