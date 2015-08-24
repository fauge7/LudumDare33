package com.fauge.games.LudumDare33.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.fauge.games.LudumDare33.world.Renderable;



public class Entity extends Renderable{
	public int ID;
	public int Damage;
	public int health;
	public boolean shouldRemove = false;
	public Entity(int id, float x, float y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.ID = id;
		if(ID == 0)
			t = new Texture("Road.png");
		if(ID == 1)
			t = new Texture("Bricks.png");
		if(ID == 2)
			t = new Texture("Dark_Grass.png");
		if(ID == 3)
			t = new Texture("Light_Grass.png");
		if(ID == 4)
			t = new Texture("Soldier.png");
		if(ID == 5)
			t = new Texture("Soldier_player.png");
		if(ID == 6)
			t = new Texture("Player.png");
		if(ID == 7)
			t = new Texture("Bullet.png");
		spr = new Sprite(t);
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public Rectangle getBoundingRectangle() {
		// TODO Auto-generated method stub
		return spr.getBoundingRectangle();
	}
}
