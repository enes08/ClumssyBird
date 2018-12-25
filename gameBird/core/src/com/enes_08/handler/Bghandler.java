package com.enes_08.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.enes_08.gameobject.Bird;
import com.enes_08.gameobject.GameObject;
import com.enes_08.imageloder.ImageLoder;

/**
 * Created by lenovo on 29.08.2018.
 */

public class Bghandler implements GameObject {

    TextureRegion bg1,bg2,bg3;

    float bg1bas,bg1son,bg2bas,bg2son,bg3bas,bg3son;

    Bird bird;
    public Bghandler(Bird bird) {


        this.bird=bird;
        bg1=ImageLoder.texRegbg1;
        bg1bas=0;
        bg1son= Gdx.graphics.getWidth();

        bg2bas=bg1son;
        bg2son=bg2bas+Gdx.graphics.getWidth();

        bg3bas=bg2son;
        bg3son=bg3bas+Gdx.graphics.getWidth();




    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw( bg1,bg1bas,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw( bg1,bg2bas,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw( bg1,bg3bas,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());






        sb.end();


    }

    @Override
    public void update(float delta) {

        if(bird.getSkor()==0){
            bg1=ImageLoder.texRegbg1;
        }

        if(bird.getSkor()==40){

            bg1=ImageLoder.texRegbg2;
        }

        else if(bird.getSkor()==120){
            bg1=ImageLoder.texRegbg3;
        }

        else if(bird.getSkor()==250){
            bg1=ImageLoder.texRegbg4;
        }

        else if(bird.getSkor()==400){

            bg1=ImageLoder.texRegbg5;
        }

        else if(bird.getSkor()==600){
            bg1=ImageLoder.texRegbg6;
        }


        if(bird.getPozition().x>bg3bas){

          System.out.println("girdi");

            bg1bas=bg3bas+Gdx.graphics.getWidth();

            bg3bas=bg1bas;
            bg2bas=bg3bas-Gdx.graphics.getWidth();

            bg1bas=bg2bas-Gdx.graphics.getWidth();











           /* bg1bas=bg2bas;
            bg1son=bg1bas+Gdx.graphics.getWidth();

            bg2bas=bg3bas;
            bg2son=bg2bas+Gdx.graphics.getWidth();

            bg3bas= bg2son;
            bg2son=bg3bas+Gdx.graphics.getWidth();*/



        }

    }
}
