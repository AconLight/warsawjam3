package com.redartedgames.ball.screen;

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
	
	public ScreenRenderer(MyWorld world, OrthographicCamera camera423432423) {
		this.world = world;
		this.camera = world.cam123;
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		sr = new ShapeRenderer();
		sr.setProjectionMatrix(camera.combined);
	}
	
	public void render() {
		batch.setProjectionMatrix(world.cam123.combined);
		batch.begin();
		sr.begin(ShapeType.Filled);
		for (int i = 0; i < GameObject.priorities; i++) {
			for (int j = 0; j < world.getGameObjects().size(); j++) {
				world.getGameObjects().get(j).render(batch, i, 0, 0);
				world.getGameObjects().get(j).render(sr, i, 0, 0);
			}
		}
		batch.end();
		sr.end();
	}
}
