package com.enes_08.inputhandler;

import com.badlogic.gdx.InputProcessor;
import com.enes_08.handler.BirdBuyHandler;
import com.enes_08.handler.BirdSelectHandler;
import com.enes_08.handler.ElmasScoreHandler;
import com.enes_08.imageloder.ImageLoder;
import com.enes_08.states.BirdShopState;
import com.enes_08.states.MenuState;

/**
 * Created by lenovo on 04.09.2018.
 */

public class BirdShopStateInput implements InputProcessor {

    BirdShopState birdShopState;
    int i=0;
    public BirdShopStateInput(BirdShopState birdShopState) {

        this.birdShopState=birdShopState;

        i=BirdSelectHandler.getHighScore();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if(birdShopState.getBtnBuy().getBtnRectangle().contains(screenX,screenY)){


            if( birdShopState.getFiyat(BirdSelectHandler.getBirdSelectOyun()) <= ElmasScoreHandler.getHighScore()){
           System.out.println("Satın Alındı");

                BirdBuyHandler.setHighScore(1,BirdSelectHandler.getBirdSelectOyun());
                ElmasScoreHandler.setHighScore( ElmasScoreHandler.getHighScore()-birdShopState.getFiyat(BirdSelectHandler.getBirdSelectOyun()));

            }

        }



            if(birdShopState.getBtnHome().getBtnRectangle().contains(screenX,screenY)){

            birdShopState.getSm().popState();

            birdShopState.getSm().pushState(new MenuState(birdShopState.getSm()));

        }

        if(birdShopState.getBtnNext().getBtnRectangle().contains(screenX,screenY)){
            if(i<13){

                if(i==12){
                    i=-1;
                }

                ImageLoder.loadBird(++i);


                BirdSelectHandler.setBirdSelectOyun(i);

                if(BirdBuyHandler.getHighScore(BirdSelectHandler.getBirdSelectOyun())==1){

                    BirdSelectHandler.setHighScore(i);
                }



                birdShopState.getBird().setTextureRegion(ImageLoder.playerAnimation);




            }

        }

        if(birdShopState.getBtnBack().getBtnRectangle().contains(screenX,screenY)){

            if(i>=0){
                System.out.println("Girdi");
                if(i==0){
                    i=13;
                }
                ImageLoder.loadBird(--i);

                BirdSelectHandler.setBirdSelectOyun(i);

                if(BirdBuyHandler.getHighScore(BirdSelectHandler.getBirdSelectOyun())==1){

                    BirdSelectHandler.setHighScore(i);
                }



                birdShopState.getBird().setTextureRegion(ImageLoder.playerAnimation);


            }

        }





        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
