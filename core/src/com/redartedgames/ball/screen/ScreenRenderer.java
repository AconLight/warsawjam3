package com.redartedgames.ball.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.redartedgames.ball.objects.GameObject;

public class ScreenRenderer {
	
	private MyWorld world;
	public MyWorld getWorld() {
		return world;
	}

	private SpriteBatch batch;
	private ShapeRenderer sr;
	private OrthographicCamera camera;
	
	public ScreenRenderer(MyWorld world, OrthographicCamera camera) {
		this.world = world;
		this.camera = camera;
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		sr = new ShapeRenderer();
		sr.setProjectionMatrix(camera.combined);
	}
	
	public void render() {
		batch.begin();
		sr.begin(ShapeType.Filled);
		for (int i = 0; i < GameObject.priorities; i++) {
			for (int j = 0; j < world.getGameObjects().size(); j++) {
				world.getGameObjects().get(j).render(batch, i);
				world.getGameObjects().get(j).render(sr, i);
			}
		}
		batch.end();
		sr.end();
	}
}
