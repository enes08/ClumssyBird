package com.enes_08.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.enes_08.handler.AdHandler;
import com.enes_08.handler.BirdBuyHandler;
import com.enes_08.handler.BirdSelectHandler;
import com.enes_08.handler.ElmasScoreHandler;
import com.enes_08.handler.HighScoreHandler;
import com.enes_08.imageloder.ImageLoder;
import com.enes_08.states.BirdShopState;
import com.enes_08.states.MenuState;
import com.enes_08.states.PlayState;
import com.enes_08.states.StateManager;

public class BirdGame extends Game {


	public static float WIDTH=480;
	public static float HEIGT=820;
	AdHandler handler;

	StateManager sm;
	SpriteBatch sb;
	boolean toggle;

	public  static float elapsed;

	public BirdGame(AdHandler handler) {
		this.handler = handler;

	}

	@Override
	public void create () {


		Gdx.gl.glClearColor(1, 0, 0, 1);
		ImageLoder.load();
		HighScoreHandler.load();
		ElmasScoreHandler.load();
		BirdSelectHandler.load();
		BirdBuyHandler.load();
		BirdBuyHandler.setHighScore(1,0);
		sm=new StateManager();
		sm.pushState(new MenuState(sm));
		sb=new SpriteBatch();




	}

	@Override
	public void render () {

		elapsed += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sm.render(sb);
		sm.update(elapsed);


	}






	
	@Override
	public void dispose () {

		ImageLoder.dispose();

	}
}
