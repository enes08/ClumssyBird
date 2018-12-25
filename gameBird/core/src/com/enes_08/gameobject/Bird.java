package com.enes_08.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.enes_08.game.BirdGame;
import com.enes_08.imageloder.ImageLoder;

/**
 * Created by lenovo on 29.08.2018.
 */

public class Bird implements GameObject {

    Vector2 pozition;
    Vector2 speed;
    Vector2 size;
    Animation TextureRegion;

   // Sound sound;

    int skor=0,alinanElmas=0;

    Rectangle rectangleBird;
    private static long deadID;
    public Bird(float xKord, float yKord, float width, float height, Animation TextureRegion) {

          pozition=new Vector2(xKord,yKord);
          speed=new Vector2();
          size=new Vector2(width,height);
        this.TextureRegion=TextureRegion;

        rectangleBird=new Rectangle(xKord,yKord,width,height);
        //sound = Gdx.audio.newSound(Gdx.files.internal("fly.mp3"));

        //
        // deadID=sound.play(0);
         speed.x=20;
         speed.y=15;

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw((TextureRegion) TextureRegion.getKeyFrame(BirdGame.elapsed,true), pozition.x, pozition.y, size.x,size.y);

        sb.end();

    }

    @Override
    public void update(float delta) {


        if(Gdx.input.isTouched()){

            //sound.stop(deadID);
            //deadID = sound.play(1f);
            if(pozition.y>0){

                pozition.y-=size.x/(15);
            }



        }
        else{

            pozition.y+=size.x/13;



        }




         pozition.x+=size.x/speed.x;


        rectangleBird.x=pozition.x;
        rectangleBird.y=pozition.y;
        rectangleBird.width=size.x;
        rectangleBird.height=size.y;

    }


    public Vector2 getPozition() {
        return pozition;
    }

    public void setPozition(Vector2 pozition) {
        this.pozition = pozition;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public Rectangle getRectangleBird() {
        return rectangleBird;
    }

    public void setRectangleBird(Rectangle rectangleBird) {
        this.rectangleBird = rectangleBird;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    public int getAlinanElmas() {
        return alinanElmas;
    }

    public void setAlinanElmas(int alinanElmas) {
        this.alinanElmas = alinanElmas;
    }


    public Animation getTextureRegion() {
        return TextureRegion;
    }

    public void setTextureRegion(Animation textureRegion) {
        TextureRegion = textureRegion;
    }
}
