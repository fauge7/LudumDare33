package com.fauge.game.LudumDare33.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.fauge.games.LudumDare33.world.GameWorld;

public class GameScreen implements Screen {

	Game game;
	SpriteBatch batch;
	GameWorld gameWorld;
	OrthographicCamera cam;
	public static StretchViewport view;
	public GameScreen(Game game, SpriteBatch batch) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.batch = batch;
		cam = new OrthographicCamera(512,512);
		cam.position.set(256, 256, 0);
		cam.update();
		view = new StretchViewport(512, 512, cam);
		batch.setProjectionMatrix(cam.combined);
		gameWorld = new GameWorld(-1);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		gameWorld.InitializeWorld();
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
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
