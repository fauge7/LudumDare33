package com.fauge.games.LudumDare33.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fauge.games.LudumDare33.LudumDare33;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 512;
		config.width = 512;
		new LwjglApplication(new LudumDare33(), config);
	}
}
