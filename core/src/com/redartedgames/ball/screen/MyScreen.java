package com.redartedgames.ball.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyScreen {
	
	private Viewport viewport;
	
	public MyWorld getWorld() {
		return world;
	}

	protected OrthographicCamera camera;
	
	protected ScreenRenderer screenRenderer;
	
	protected MyWorld world;
	
	public MyScreen(int width, int height) {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);
		viewport = new ScreenViewport();
		viewport.setWorldSize(width, height);
		viewport.setCamera(camera);
		viewport.setScreenSize(width, height);
		
		world = new MyWorld(camera);
		screenRenderer = new ScreenRenderer(world, null);

	}
	
	public void render() {
		screenRenderer.render();
	}
	
	public void update(float delta) {
		world.update(delta);
		camera.translate(new Vector2(0, 200));
		camera.update();
	}

	public OrthographicCamera getCamera() {
		return camera;
	}


	
}
