package com.fauge.games.LudumDare33.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.fauge.games.LudumDare33.Entities.Entity;
import com.fauge.games.LudumDare33.world.GameWorld;

public class Enemy extends Entity{

	TextureRegion foottex;
	final Texture stillfeet = new Texture("feet_still.png");
	Sprite feet;
	float foottime = 0;
	Animation anim;
	float degrees = 0;
	boolean forward = true;
	float speed;
	Entity target = null;
	float updateTargetTime = 5f;
	float updateTargetTimer = 4f;
	public Enemy(int id,float startX,float startY) {
		super(id, startX, startY);
		foottex = new TextureRegion(stillfeet);
		feet = new Sprite(foottex);
		Array<TextureRegion> regions = new Array<TextureRegion>();
		for (int i = 10; i < 29; i++) {
			regions.add(new TextureRegion(new Texture("feet_" + i + ".png")));
		}
		anim = new Animation(.04f, regions);
		anim.setPlayMode(PlayMode.LOOP_PINGPONG);
		setTarget();
	}
	public void render(SpriteBatch batch){
		//do ai logic in here
		if(updateTargetTime > updateTargetTimer){
			updateTargetTime = 0;
			while(target == null){
				setTarget();
			}
		}
		else{
			updateTargetTime+=Gdx.graphics.getDeltaTime();
		}
		degrees = (float) Math.atan2(target.getY() - getY(), target.getX() - getX());
		
		speed = 1;
		
		degrees = degrees * MathUtils.radDeg;
		float dx = 75 * Gdx.graphics.getDeltaTime() * MathUtils.cosDeg(degrees) * speed;
		float dy = 75 * Gdx.graphics.getDeltaTime() * MathUtils.sinDeg(degrees) * speed;
		x += dx;
		y += dy;
		spr.setPosition(x, y);
		for(Rectangle rect : GameWorld.RectList){
			if(spr.getBoundingRectangle().overlaps(rect)){
				x-=dx;
				y-=dy;
				break;
			}
		}
		feet.setRotation(90+degrees);
		float xx = 18 * MathUtils.cosDeg(degrees);
		float yy = 18 * MathUtils.sinDeg(degrees);
		feet.setPosition(x + xx, y + yy);
		feet.draw(batch);
		super.render(batch);
		
	}
	public void update(){
		//yay fun ai stuff!!!
		
	}
	public void setTarget(){
		for(Entity e : GameWorld.CharacterList){
			if(e.ID != ID){
				if(null == target){
					int chance = MathUtils.random(0, GameWorld.CharacterList.size()-1);
					if(chance == 0)
							target = e;
					continue;
				}
			}
		}
	}
}
