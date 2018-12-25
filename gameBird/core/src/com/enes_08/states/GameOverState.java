package com.enes_08.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.enes_08.gameobject.Bird;
import com.enes_08.handler.ElmasScoreHandler;
import com.enes_08.handler.HighScoreHandler;
import com.enes_08.imageloder.ImageLoder;

/**
 * Created by lenovo on 02.09.2018.
 */

public class GameOverState extends State {

    StateManager sm;
    int skor,alinanElmas;
    Bird bird;
    Music gameOverMusic;

    public GameOverState(StateManager sm,int skor,int alinanElmas) {
        super(sm);

        this.sm=sm;
        this.skor=skor;

        this.alinanElmas=alinanElmas;

        bird=new Bird((float) ((Gdx.graphics.getWidth()/2)*0.9),2*Gdx.graphics.getHeight()/6,Gdx.graphics.getWidth()/20,Gdx.graphics.getWidth()/20, ImageLoder.playerAnimation);


        gameOverMusic=Gdx.audio.newMusic(Gdx.files.internal("gameOverMusic.mp3"));
        gameOverMusic.setLooping(false);

        gameOverMusic.play();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(ImageLoder.tRegbgGO,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        sb.end();

        bird.render(sb);
        sb.begin();

        ImageLoder.font.setColor(Color.WHITE);

        ImageLoder.font.getData().setScale(1);
        ImageLoder.font.draw(sb, "Game Over", Gdx.graphics.getWidth()/4, 1*Gdx.graphics.getHeight()/6);






        if(skor==HighScoreHandler.getHighScore()){
            ImageLoder.font.getData().setScale((float) 0.5);
            ImageLoder.font.draw(sb, "New Hight Score "+String.valueOf(HighScoreHandler.getHighScore()), Gdx.graphics.getWidth()/3, 3*Gdx.graphics.getHeight()/6);

            sb.draw(ImageLoder.texRegElmas6,(float) ((Gdx.graphics.getWidth()/2)*0.9), 4*Gdx.graphics.getHeight()/6,bird.getSize().x,bird.getSize().y);


            ImageLoder.font.draw(sb, String.valueOf(alinanElmas), (float) ((Gdx.graphics.getWidth()/2)+bird.getSize().x/3), 4*Gdx.graphics.getHeight()/6);

            //ImageLoder.font.draw(sb, "Toplam Elmas "+ElmasScoreHandler.getHighScore(), Gdx.graphics.getWidth()/3, 10);

        }
        else{
            ImageLoder.font.getData().setScale((float) 0.5);
            ImageLoder.font.draw(sb, "Now Score "+String.valueOf(skor), Gdx.graphics.getWidth()/3, 3*Gdx.graphics.getHeight()/6);
            ImageLoder.font.draw(sb, "Hight Score "+String.valueOf(HighScoreHandler.getHighScore()), Gdx.graphics.getWidth()/3, 4*Gdx.graphics.getHeight()/6);


            sb.draw(ImageLoder.texRegElmas1,(float) ((Gdx.graphics.getWidth()/2)*0.9), 5*Gdx.graphics.getHeight()/6,bird.getSize().x,bird.getSize().y);


            ImageLoder.font.draw(sb, String.valueOf(alinanElmas), (float) ((Gdx.graphics.getWidth()/2))+bird.getSize().x/3, 5*Gdx.graphics.getHeight()/6);

            //ImageLoder.font.draw(sb, "Toplam Elmas "+ElmasScoreHandler.getHighScore(), Gdx.graphics.getWidth()/3, 10);

        }


        sb.end();

    }

    @Override
    public void update(float delta) {




      if(  Gdx.input.isTouched()){
            sm.popState();
            sm.pushState(new MenuState(sm));
        gameOverMusic.dispose();
        }

    }

    public StateManager getSm() {
        return sm;
    }

    public void setSm(StateManager sm) {
        this.sm = sm;
    }
}
