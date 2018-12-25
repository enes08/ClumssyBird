package com.enes_08.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.enes_08.button.Button;
import com.enes_08.gameobject.Bird;
import com.enes_08.handler.BirdBuyHandler;
import com.enes_08.handler.BirdSelectHandler;
import com.enes_08.handler.ElmasScoreHandler;
import com.enes_08.imageloder.ImageLoder;
import com.enes_08.inputhandler.BirdShopStateInput;

/**
 * Created by lenovo on 04.09.2018.
 */

public class BirdShopState extends State {

    StateManager sm;

    Bird bird;
    int i=0;
    int fiyat[]={250,500,1500,2000,4000,6000,8000,10000,12000,15000,20000,35000,50000};

    Button btnHome,btnNext,btnBack,btnBuy;
    public BirdShopState(StateManager sm) {
        super(sm);
        Gdx.input.setInputProcessor(new BirdShopStateInput(this));

        this.sm=sm;
        i= BirdSelectHandler.getHighScore();

        BirdSelectHandler.setBirdSelectOyun(i);
        ImageLoder.loadBird(i);


        bird=new Bird(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/3,Gdx.graphics.getWidth()/5,Gdx.graphics.getWidth()/5, ImageLoder.playerAnimation);
        btnBuy=new Button(bird.getPozition().x+bird.getSize().x/4,bird.getPozition().y+bird.getSize().y,Gdx.graphics.getHeight()/5,Gdx.graphics.getHeight()/7,ImageLoder.TexRegbtnBuy);
        btnHome=new Button(Gdx.graphics.getHeight()/5,Gdx.graphics.getHeight()/10,Gdx.graphics.getHeight()/5,Gdx.graphics.getHeight()/5,ImageLoder.TexRegbtnHome);

        btnBack=new Button(bird.getPozition().x-bird.getSize().x/2,bird.getPozition().y+bird.getSize().y/3,Gdx.graphics.getHeight()/7,Gdx.graphics.getHeight()/7,ImageLoder.TexRegbtnBack);
        btnNext=new Button(bird.getPozition().x+bird.getSize().x,bird.getPozition().y+bird.getSize().y/3,Gdx.graphics.getHeight()/7,Gdx.graphics.getHeight()/7,ImageLoder.TexRegbtnNext);

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);

        bird.render(sb);
        btnHome.render(sb);
        btnBack.render(sb);
        btnNext.render(sb);




         sb.begin();
        sb.draw(ImageLoder.texRegElmas6, bird.getPozition().x+bird.getSize().x/3, bird.getPozition().y-2*bird.getSize().x/3,bird.getSize().x/3,bird.getSize().y/3);

        ImageLoder.font.draw(sb, String.valueOf(fiyat[BirdSelectHandler.getBirdSelectOyun()]), bird.getPozition().x+bird.getSize().x/5, bird.getPozition().y-bird.getSize().x/3);


        sb.draw(ImageLoder.texRegElmas6, 2*Gdx.graphics.getWidth()/3, bird.getPozition().y-2*bird.getSize().x/3,bird.getSize().x/3,bird.getSize().y/3);

        ImageLoder.font.draw(sb, String.valueOf(ElmasScoreHandler.getHighScore()), 2*Gdx.graphics.getWidth()/3+bird.getSize().x/3, bird.getPozition().y-2*bird.getSize().x/3);


        sb.end();



        //System.out.println("BirdBuyHandler.getHighScore("+BirdSelectHandler.getHighScore()+")="+BirdBuyHandler.getHighScore(BirdSelectHandler.getHighScore()));

        //System.out.println("BirdBuyHandler.getHighScore(BirdSelectHandler.getBirdSelectOyun())=="+BirdBuyHandler.getHighScore(BirdSelectHandler.getBirdSelectOyun()));


        if(BirdBuyHandler.getHighScore(BirdSelectHandler.getBirdSelectOyun())==0){
            System.out.println("Kus Alınmamış "+BirdBuyHandler.getHighScore(BirdSelectHandler.getBirdSelectOyun()));
            btnBuy.render(sb);
        }

    }

    @Override
    public void update(float delta) {



    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Button getBtnHome() {
        return btnHome;
    }

    public void setBtnHome(Button btnHome) {
        this.btnHome = btnHome;
    }

    public StateManager getSm() {
        return sm;
    }

    public void setSm(StateManager sm) {
        this.sm = sm;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }

    public void setBtnBuy(Button btnBuy) {
        this.btnBuy = btnBuy;
    }

    public int getFiyat(int i) {
        return fiyat[i];
    }


}
