package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Text;

public class StatRenderer extends RenderManager {
	
	private ArrayList<Text> stats;
	private SpriteBatch batch;
	private String Mwartosc="0";
	private String Pwartosc="0";
	private String Cwartosc="0";
	private String wartosc4="0";
	private String wartosc5="0";
	
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
	private Text Stat5Text;
	private Text Stat5ValueBase;
		
	public StatRenderer(GameWorld_his gameworld) {
		super(gameworld);
		stats = new ArrayList<Text>();
		batch = new SpriteBatch();
		
		
		FieldName = new Text(1535,370,null,0,1,"NawzaPola");
		StatName = new Text(1480,320,null,1,0,"Statystyka:");
		StatBase = new Text(1675,320,null,2,0,"Mno¿nik:");
		MigrationText = new Text(1440,280,null,3,0,"Migracja");
		MigrationValueBase = new Text(1685,280,null,4,0,"wartosc");
		PrzynaleznoscText = new Text(1440,245,null,5,0,"Przynale¿noœæ");
		PrzynaleznoscBase = new Text(1685,245,null,6,0,"123");
		CultureText = new Text(1440,210,null,7,0,"Kultura");
		CultureValueBase = new Text(1685,210,null,8,0,"123");
		Stat4Text = new Text(1440,175,null,9,0,"Stat4");
		Stat4ValueBase = new Text(1685,175,null,10,0,"123");
		Stat5Text = new Text(1440,140,null,11,0,"Stat5");
		Stat5ValueBase = new Text(1685,140,null,12,0,"123");
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
		stats.add(Stat5Text);
		stats.add(Stat5ValueBase);
		
	}

	public void render() {
		batch.begin();
		for(Text t : stats)
			t.render(batch, 1, 0, 0);
		batch.end();
	}
	
	public void update(float delta) {
		super.update(delta);
		
		if (gameworld.fieldManager.currentField != null) {
			 Mwartosc = Float.toString(gameworld.fieldManager.currentField.statistic.getbase_mig_mult());
			} else Mwartosc = "";
		stats.get(4).txt = Mwartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			Pwartosc = Float.toString(gameworld.fieldManager.currentField.statistic.getbase_mig_mult());
			} else Pwartosc = "";
		stats.get(6).txt = Pwartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			Cwartosc = Float.toString(gameworld.fieldManager.currentField.statistic.getbase_cult_mult());
			} else Cwartosc = "";
		stats.get(8).txt = Cwartosc;
		
		if (gameworld.fieldManager.currentField != null) {
			wartosc4 = Float.toString(gameworld.fieldManager.currentField.statistic.getbase_mig_mult());
			} else wartosc4 = "";
		stats.get(10).txt = wartosc4;
		
		if (gameworld.fieldManager.currentField != null) {
			wartosc5 = Float.toString(gameworld.fieldManager.currentField.statistic.getbase_mig_mult());
			} else wartosc5 = "";
		stats.get(12).txt = wartosc5;
	}

}
