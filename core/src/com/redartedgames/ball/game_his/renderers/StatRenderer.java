package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Text;

public class StatRenderer extends RenderManager {
	
	private ArrayList<Text> stats;
	private SpriteBatch batch;
	
	private Text FieldName;
	private Text StatName;
	private Text StatBase;
	private Text StatCurrent;
	private Text MigrationText;
	private Text MigrationValueBase;
	private Text MigrationValueCurrent;
	private Text MigrationSpeedText;
	private Text MigrationSpeedValueBase;
	private Text MigrationSpeedValueCurrent;
	private Text CultureText;
	private Text CultureValueBase;
	private Text CultureValueCurrent;
	private Text Stat4Text;
	private Text Stat4ValueBase;
	private Text Stat4ValueCurrent;
	private Text Stat5Text;
	private Text Stat5ValueBase;
	private Text Stat5ValueCurrent;
		
	public StatRenderer(GameWorld_his gameworld) {
		super(gameworld);
		stats = new ArrayList<Text>();
		batch = new SpriteBatch();
		FieldName = new Text(1535,370,null,0,1,"NawzaKarty");
		StatName = new Text(1480,320,null,1,0,"Statystyka:");
		StatBase = new Text(1675,320,null,2,0,"Baza:");
		StatCurrent = new Text(1755,320,null,3,0,"Aktualne:");
		MigrationText = new Text(1440,280,null,4,0,"Migracja");
		MigrationValueBase = new Text(1685,280,null,5,0,"123");
		MigrationValueCurrent = new Text(1785,280,null,6,0,"321");
		MigrationSpeedText = new Text(1440,245,null,7,0,"Prędkość migracyji");
		MigrationSpeedValueBase = new Text(1685,245,null,8,0,"123");
		MigrationSpeedValueCurrent = new Text(1785,245,null,9,0,"321");
		CultureText = new Text(1440,210,null,10,0,"Kultura");
		CultureValueBase = new Text(1685,210,null,11,0,"123");
		CultureValueCurrent = new Text(1785,210,null,12,0,"321");
		Stat4Text = new Text(1440,175,null,13,0,"Stat4");
		Stat4ValueBase = new Text(1685,175,null,14,0,"123");
		Stat4ValueCurrent = new Text(1785,175,null,15,0,"321");
		Stat5Text = new Text(1440,140,null,16,0,"Stat5");
		Stat5ValueBase = new Text(1685,140,null,17,0,"123");
		Stat5ValueCurrent = new Text(1785,140,null,18,0,"321");
		stats.add(FieldName);
		stats.add(StatName);
		stats.add(StatBase);
		stats.add(StatCurrent);
		stats.add(MigrationText);
		stats.add(MigrationValueBase);
		stats.add(MigrationValueCurrent);
		stats.add(MigrationSpeedText);
		stats.add(MigrationSpeedValueBase);
		stats.add(MigrationSpeedValueCurrent);
		stats.add(CultureText);
		stats.add(CultureValueBase);
		stats.add(CultureValueCurrent);
		stats.add(Stat4Text);
		stats.add(Stat4ValueBase);
		stats.add(Stat4ValueCurrent);
		stats.add(Stat5Text);
		stats.add(Stat5ValueBase);
		stats.add(Stat5ValueCurrent);
	}

	public void render() {
		batch.begin();
		for(Text t : stats)
			t.render(batch, 1, 0, 0);
		batch.end();
	}

}
