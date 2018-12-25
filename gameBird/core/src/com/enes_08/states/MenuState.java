package com.enes_08.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.enes_08.button.Button;
import com.enes_08.imageloder.ImageLoder;
import com.enes_08.inputhandler.MenuStateInput;

/**
 * Created by lenovo on 30.08.2018.
 */

public class MenuState extends State {

    StateManager sm;



    Button btnPlay,btnShop;

       Music sound;

    private static long deadID;
    public MenuState(StateManager sm) {
        super(sm);

        this.sm=sm;
        Gdx.input.setInputProcessor(new MenuStateInput(this));
        sound = Gdx.audio.newMusic(Gdx.files.internal("menugame.mp3"));

        btnPlay=new Button(Gdx.graphics.getWidth()/2-50,Gdx.graphics.getHeight()/2-50,Gdx.graphics.getHeight()/5,Gdx.graphics.getHeight()/5,ImageLoder.tRegbtnPlay);
        btnShop=new Button(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/5,Gdx.graphics.getHeight()/3,Gdx.graphics.getHeight()/5,Gdx.graphics.getHeight()/5,ImageLoder.TexRegbtnShop);

        System.out.println("MENU STATE OLUŞTURULDU");

       // Gdx.input.setOnscreenKeyboardVisible(true);

    }

    @Override
    public void render(SpriteBatch sb) {


        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(ImageLoder.tRegLogoKuslar,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/20,Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/3);
        sb.end();
        btnPlay.render(sb);
        btnShop.render(sb);


    }

    @Override
    public void update(float delta) {


        sound.setLooping(true);

        sound.play();
        btnPlay.update(delta);
        btnShop.update(delta);


    }

    public Button getBtnPlay() {
        return btnPlay;
    }

    public void setBtnPlay(Button btnPlay) {
        this.btnPlay = btnPlay;
    }

    public StateManager getSm() {
        return sm;
    }

    public void setSm(StateManager sm) {
        this.sm = sm;
    }

    public Music getSound() {
        return sound;
    }

    public void setSound(Music sound) {
        this.sound = sound;
    }

    public Button getBtnShop() {
        return btnShop;
    }

    public void setBtnShop(Button btnShop) {
        this.btnShop = btnShop;
    }
}
