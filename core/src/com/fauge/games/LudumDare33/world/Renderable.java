package com.fauge.games.LudumDare33.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderable {

	protected Texture t;
	protected Sprite spr;
	protected float x;
	protected float y;
	
	public Renderable(float x, float y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		spr.setPosition(x, y);
		spr.draw(batch);
	}

}
