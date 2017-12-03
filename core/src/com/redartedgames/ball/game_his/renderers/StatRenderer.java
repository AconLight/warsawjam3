package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Text;

public class StatRenderer extends RenderManager {
	
	private ArrayList<Text> stats;
	private SpriteBatch batch;
	private String PopulacjaWartosc="0";
	private String MigracjaWartosc="0";
	private String PrzynaleznoscWartosc="0";
	private String KulturaWartosc="0";
	private String wartosc5="0";
	private String NameString="";
	
	private Text Money;
	private Text AmountMoney;
	private Text FieldName;
	private Text StatName;
	private Text StatBase;
	private Text MigrationText;
	private Text MigrationValueBase;
	private Text PrzynaleznoscText;
	private Text PrzynaleznoscBase;
	private Text CultureText;
	private Text CultureValueBase;
	private Text Stat4Text;
	private Text Stat4ValueBase;
		
	public StatRenderer(GameWorld_his gameworld) {
		super(gameworld);
		stats = new ArrayList<Text>();
		batch = new SpriteBatch();
		
		Money = new Text(1450,510,null,0,2,"Pieni¹dze:");
		FieldName = new Text(1575,350,null,1,2,"NawzaPola");
		StatName = new Text(1460,260,null,2,1,"Statystyka:");
		StatBase = new Text(1705,260,null,3,1,"Mno¿nik:");
		MigrationText = new Text(1460,200,null,4,0,"Populacja");
		MigrationValueBase = new Text(1705,200,null,5,0,"wartosc");
		PrzynaleznoscText = new Text(1460,160,null,6,0,"Migracja");
		PrzynaleznoscBase = new Text(1705,160,null,7,0,"123");
		CultureText = new Text(1460,120,null,8,0,"Przynale¿noœæ");
		CultureValueBase = new Text(1705,120,null,9,0,"123");
		Stat4Text = new Text(1460,80,null,10,0,"Kultura_multiper");
		Stat4ValueBase = new Text(1705,80,null,11,0,"123");
		AmountMoney = new Text(1750,510,null,12,2,"123");
		stats.add(Money);
		stats.add(FieldName);
		stats.add(StatName);
		stats.add(StatBase);
		stats.add(MigrationText);
		stats.add(MigrationValueBase);
		stats.add(PrzynaleznoscText);
		stats.add(PrzynaleznoscBase);
		stats.add(CultureText);
		stats.add(CultureValueBase);
		stats.add(Stat4Text);
		stats.add(Stat4ValueBase);
		stats.add(AmountMoney);
		
	}

	public void render() {
		batch.begin();
		for(Text t : stats)
			t.render(batch, 1, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		super.update(delta);
		stats.get(12).txt = Integer.toString(gameworld.cardsManager.money);
		if (gameworld.fieldManager.currentField != null) {
			PopulacjaWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.population);
			} else PopulacjaWartosc = "";
		stats.get(5).txt = PopulacjaWartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			MigracjaWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.migration);
			} else MigracjaWartosc = "";
		stats.get(7).txt = MigracjaWartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			PrzynaleznoscWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.affiliation);
			} else PrzynaleznoscWartosc = "";
		stats.get(9).txt = PrzynaleznoscWartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			KulturaWartosc = Float.toString(gameworld.fieldManager.currentField.statistic.getbase_cult_mult());
			} else KulturaWartosc = "";
		stats.get(11).txt = KulturaWartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			 switch(gameworld.fieldManager.currentField.fieldType){
			 	case city:
			 		NameString = "Miasto";
			 		break;
			 	case village:
			 		NameString = "Wieœ›";
			 		break;
			 	case hill:
			 		NameString = "Wzgórek";
			 		break;
			 	case mountain:
			 		NameString = "Góra";
			 		break;
			 	case meadow:
			 		NameString = "Trawnik";
			 		break;	
			 	default:
			 		NameString = "";
			 		break;
			 }
			stats.get(1).txt = NameString;
		} else stats.get(1).txt = "";
	}

}
