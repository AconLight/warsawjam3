package com.redartedgames.ball.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.redartedgames.ball.settings.GameVars;

public class PhysicSpriteObject extends SpriteObject{
	public Fixture fixture;
	public Body body;
	protected World world;
	
	public PhysicSpriteObject(World world, GameObject parent, float x, float y) {
		super(x, y, parent, 0);
		this.world = world;
	}
	
	public void transform(float x, float y) {
		super.transform(x, y);
		if (body != null) {
			body.setTransform(x/GameVars.box2dScale + x, y/GameVars.box2dScale + y, body.getAngle()); // bugi
		}
	}
	
	public void setPosition (float x, float y) {
		position.set(x, y);
		if (body != null) {
			body.setTransform(x/GameVars.box2dScale, y/GameVars.box2dScale, body.getAngle());
		}
	}
	
	
	public BodyDef createBodyDef(float x, float y) {
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		bodyDef.position.set(x/GameVars.box2dScale, y/GameVars.box2dScale);
		return bodyDef;
	}
	
	public FixtureDef setAsBall(float r) {

		// Create a circle shape and set its radius to 6
		CircleShape circle = new CircleShape();
		circle.setRadius(r/GameVars.box2dScale);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit
		// Create our fixture and attach it to the body
		return fixtureDef;
		
	}
	
	public FixtureDef setAsBall(float r, float density, float friction, float restitution) {

		// Create a circle shape and set its radius to 6
		CircleShape circle = new CircleShape();
		circle.setRadius(r/GameVars.box2dScale);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = density;
		fixtureDef.friction = friction;
		fixtureDef.restitution = restitution; // Make it bounce a little bit
		// Create our fixture and attach it to the body
		return fixtureDef;
		
	}
	
	public void updateBefore (float delta, float vx, float vy) {
		super.updateBefore(delta, vx, vy);
		position.set(body.getPosition().scl(GameVars.box2dScale));
		Gdx.app.log("update", "" + body.getPosition().y);
	}
	
	public boolean isClicked(float x, float y) {
		return (Math.sqrt(((body.getPosition().scl(GameVars.box2dScale).x - x)*(body.getPosition().scl(GameVars.box2dScale).x - x) +
		(body.getPosition().scl(GameVars.box2dScale).y - y)*(body.getPosition().scl(GameVars.box2dScale).y - y))) < 30);
	}

}
