package com.enes_08.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.enes_08.game.BirdGame;
import com.enes_08.handler.AdHandler;

public class DesktopLauncher   {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= (int) (BirdGame.HEIGT);
		config.height= (int) (BirdGame.WIDTH);

		new LwjglApplication(new BirdGame(new AdHandler() {
			@Override
			public void showAds(boolean show) {

			}
		}), config);
	}


}
