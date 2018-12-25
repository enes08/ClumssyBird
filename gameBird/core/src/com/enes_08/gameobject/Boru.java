package com.enes_08.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.enes_08.imageloder.ImageLoder;

import java.util.Random;

/**
 * Created by lenovo on 29.08.2018.
 */

public class Boru implements GameObject
{


    Vector2 Tboru;
    Vector2 Bboru;



    float Bosluk=120;

    float TboruHeight;
    float BboruHeight;

    boolean gecildi=true;

    Random r;

    Bird bird;

    Rectangle collicionBoruTop;
    Rectangle collicionBoruBot;

    float defHeigt;

    TextureRegion boruD,boruT;

    public Boru(float xKord,Bird bird){
        r=new Random();
     this.bird=bird;



        Bosluk= (float) (2.5*bird.getSize().y);
        TboruHeight=r.nextInt((int) (3*Gdx.graphics.getHeight()/5-Bosluk));
        BboruHeight=Gdx.graphics.getHeight()-(TboruHeight+Bosluk);

        Tboru=new Vector2(xKord,0);

        Bboru=new Vector2(xKord,Gdx.graphics.getHeight()-BboruHeight);

        //System.out.println("TboruHeight"+TboruHeight+"BboruHeight"+BboruHeight);

        collicionBoruTop=new Rectangle(Tboru.x,Tboru.y,5*bird.size.x/3,TboruHeight-10);
        collicionBoruBot=new Rectangle(Bboru.x,Bboru.y+10,5*bird.size.x/3,BboruHeight);

        boruD=ImageLoder.texRegboruD1;
        boruT=ImageLoder.texRegboruT1;

    }


    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        if(bird.getSkor()==0){
            boruD=ImageLoder.texRegboruD1;
            boruT=ImageLoder.texRegboruT1;        }

        if(bird.getSkor()==40){

            boruD=ImageLoder.texRegboruD2;
            boruT=ImageLoder.texRegboruT2;        }

        else if(bird.getSkor()==120){
            boruD=ImageLoder.texRegboruD3;
            boruT=ImageLoder.texRegboruT3;
        }

        else if(bird.getSkor()==250){
            boruD=ImageLoder.texRegboruD4;
            boruT=ImageLoder.texRegboruT4;
        }

        else if(bird.getSkor()==400){

            boruD=ImageLoder.texRegboruD5;
            boruT=ImageLoder.texRegboruT5;
        }

        else if(bird.getSkor()==600){
            boruD=ImageLoder.texRegboruD6;
            boruT=ImageLoder.texRegboruT6;
        }


        sb.draw(boruD,Bboru.x,Bboru.y,5*bird.size.x/3,BboruHeight);
        sb.draw(boruT,Tboru.x,Tboru.y,5*bird.size.x/3,TboruHeight);

        sb.end();

    }

    @Override
    public void update(float delta) {




        if(bird.getPozition().x>Bboru.x+Gdx.graphics.getWidth()/3){

            TboruHeight=defHeigt;
            BboruHeight=Gdx.graphics.getHeight()-(TboruHeight+Bosluk);

            Tboru.x=bird.getPozition().x+Gdx.graphics.getWidth();
            Tboru.y=0;

            Bboru.x= Tboru.x;
            Bboru.y=Gdx.graphics.getHeight()-BboruHeight;


            collicionBoruTop.x= Tboru.x;
            collicionBoruTop.y=  Tboru.y;
            collicionBoruTop.width=5*bird.size.x/3;
            collicionBoruTop.height=TboruHeight-10;

            collicionBoruBot.x= Bboru.x;
            collicionBoruBot.y=Bboru.y+10;
            collicionBoruBot.width=5*bird.size.x/3;
            collicionBoruBot.height=BboruHeight;





            gecildi=true;

        }
        if(bird.getPozition().x>Bboru.x){

            if(gecildi){
                gecildi=false;
                bird.setSkor(bird.getSkor()+1);


                System.out.println("=========================>>>>>>>>>>>>>>>>>>>"+ bird.getSkor());

            }
        }

    }



    public Rectangle getCollicionBoruTop() {
        return collicionBoruTop;
    }

    public void setCollicionBoruTop(Rectangle collicionBoruTop) {
        this.collicionBoruTop = collicionBoruTop;
    }

    public Rectangle getCollicionBoruBot() {
        return collicionBoruBot;
    }

    public void setCollicionBoruBot(Rectangle collicionBoruBot) {
        this.collicionBoruBot = collicionBoruBot;
    }

    public float getBosluk() {
        return Bosluk;
    }

    public void setBosluk(float bosluk) {
        Bosluk = bosluk;
    }

    public boolean isGecildi() {
        return gecildi;
    }

    public void setGecildi(boolean gecildi) {
        this.gecildi = gecildi;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }


    public float getDefHeigt() {
        return defHeigt;
    }

    public void setDefHeigt(float defHeigt) {
        this.defHeigt = defHeigt;
    }

    public TextureRegion getBoruD() {
        return boruD;
    }

    public void setBoruD(TextureRegion boruD) {
        this.boruD = boruD;
    }
}
