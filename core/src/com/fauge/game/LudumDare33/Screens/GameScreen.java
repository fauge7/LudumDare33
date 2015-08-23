package com.fauge.game.LudumDare33.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fauge.games.LudumDare33.world.GameWorld;

public class GameScreen implements Screen {

	Game game;
	SpriteBatch batch;
	GameWorld gameWorld;
	public GameScreen(Game game, SpriteBatch batch) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.batch = batch;
		gameWorld = new GameWorld(0);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		gameWorld.InitializeWorld();
		gameWorld.printWorld();
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		gameWorld.step();
		batch.begin();
		gameWorld.render(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
