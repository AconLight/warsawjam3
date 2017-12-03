package com.redartedgames.ball.game_his;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.ball.managers_his.CardsManager;
import com.redartedgames.ball.managers_his.FieldManager;
import com.redartedgames.ball.screen.MyWorld;

public class GameWorld_his extends MyWorld{
	
	public CardsManager cardsManager; 
	public FieldManager fieldManager;
	public boolean  isgameover;
	public boolean isRestart;
	Music m = Gdx.audio.newMusic(Gdx.files.internal("data_his/audio/game1.mp3"));
	Music m2 = Gdx.audio.newMusic(Gdx.files.internal("data_his/audio/game2.mp3"));
	Music m3 = Gdx.audio.newMusic(Gdx.files.internal("data_his/audio/game2.mp3"));
	public GameWorld_his(OrthographicCamera cam) {
		super(cam);
		m.setVolume(0.1f);
		m.play();
		isRestart = false;
		isgameover = false;
	    cardsManager = new CardsManager(this); 
	    fieldManager = new FieldManager(); 
	}
	
	public void update(float delta) {
		if (!m3.isPlaying()) {
			m2.setVolume(0.5f);
			m2.play();

		}
		if (!m2.isPlaying()) {
			m3.setVolume(0.5f);
			m3.play();

		}
	}
}

