package com.redartedgames.ball.game_his.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.ball.game_his.GameWorld_his;
import com.redartedgames.ball.game_his.RenderManager;
import com.redartedgames.ball.myobjects_his.Text;

public class StatRenderer extends RenderManager {
	
	private ArrayList<Text> stats;
	private SpriteBatch batch;
	//tymczasowe
	private Text FieldName;
	private Text MigrationText;
	private Text MigrationValue;
	private Text MigrationSpeedText;
	private Text MigrationSpeedValue;
	private Text CultureText;
	private Text CultureValue;
	
		
	public StatRenderer(GameWorld_his gameworld) {
		super(gameworld);
		stats = new ArrayList<Text>();
		batch = new SpriteBatch();
		FieldName = new Text(1535,370,null,0,1,"NawzaKarty");
		MigrationText = new Text(1500,350,null,1,0,"Migracja");
		MigrationValue = new Text(1550,350,null,2,0,"123");
		MigrationSpeedText = new Text(1500,340,null,3,0,"Prędkość migracyji");
		MigrationSpeedValue = new Text(1550,340,null,4,0,"123");
		CultureText = new Text(1500,330,null,5,0,"Kultura");
		CultureValue = new Text(1550,330,null,6,0,"123");
		stats.add(FieldName);
		stats.add(MigrationText);
		stats.add(MigrationValue);
		stats.add(MigrationSpeedText);
		stats.add(MigrationSpeedValue);
		stats.add(CultureText);
		stats.add(CultureValue);
	}

	public void render() {
		batch.begin();
		for(Text t : stats)
			t.render(batch, 1, 0, 0);
		batch.end();
	}

}
