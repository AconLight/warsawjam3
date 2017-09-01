package com.redartedgames.ball.helpers;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.redartedgames.ball.settings.GameVars;

public class Box2dHelp {
	public static BodyDef createBodyDef(float x, float y) {
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		bodyDef.position.set(x/GameVars.box2dScale, y/GameVars.box2dScale);
		return bodyDef;
	}
	
	public static FixtureDef setAsBall(float r) {

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
}
