package com.fauge.games.LudumDare33.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.fauge.games.LudumDare33.Entities.Entity;

public class Player extends Entity{

	TextureRegion foottex;
	final Texture stillfeet = new Texture("feet_still.png");
	Sprite feet;
	float foottime = 0;
	Animation anim;
	float degrees = 0;
	boolean forward = true;
	float speed = 0;
	public Player(int id,float startX,float startY) {
		super(id, startX, startY);
		foottex = new TextureRegion(stillfeet);
		feet = new Sprite(foottex);
		Array<TextureRegion> regions = new Array<TextureRegion>();
		for (int i = 10; i < 29; i++) {
			regions.add(new TextureRegion(new Texture("feet_" + i + ".png")));
		}
		anim = new Animation(.04f, regions);
		anim.setPlayMode(PlayMode.LOOP_PINGPONG);
	}
	public void render(SpriteBatch batch){
		boolean w = Gdx.input.isKeyPressed(Keys.W);
		boolean a = Gdx.input.isKeyPressed(Keys.A);
		boolean s = Gdx.input.isKeyPressed(Keys.S);
		boolean d = Gdx.input.isKeyPressed(Keys.D);
		if(w && a){
			degrees = 45;
		}
		else if(w && d){
			degrees = 315;
		}
		else if(s && a){
			degrees = 135;
		}
		else if(s && d){
			degrees = 225;
		}
		else if(w){
			degrees = 0;
		}
		else if(a){
			degrees = 90;
		}
		else if(s){
			degrees = 180;
		}
		else if(d){
			degrees = 270;
		}
		else{
			foottime = 0;
			speed = 0;
		}
		if(w || a || s || d){
			foottime+=Gdx.graphics.getDeltaTime();
			foottex = anim.getKeyFrame(foottime);
			feet.setRegion(foottex);
			speed = 1;
		}
		float dx = 150 * Gdx.graphics.getDeltaTime() * MathUtils.cosDeg(90+degrees) * speed;
		float dy = 150 * Gdx.graphics.getDeltaTime() * MathUtils.sinDeg(90+degrees) * speed;
		x += dx;
		y += dy;
		feet.setRotation(degrees);
		float xx = 18 * MathUtils.cosDeg(90+degrees);
		float yy = 18 * MathUtils.sinDeg(90+degrees);
		feet.setPosition(x + xx, y + yy);
		feet.draw(batch);
		super.render(batch);
		
	}
	public void update(){
		//yay fun math!!!

	}
}
