package com.enes_08.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.enes_08.collision.Collision;
import com.enes_08.handler.ElmasScoreHandler;
import com.enes_08.imageloder.ImageLoder;

import java.util.Random;


/**
 * Created by lenovo on 01.09.2018.
 */

public class Elmas implements GameObject {

    float xKord,yKord,width,height;

    Boru boru;
  Rectangle rectangleElmas;

    Sound sound;

   public enum  elmasType  {elmas1,elmas2,elmas3,elmas4,elmas5,elmas6};

    public elmasType type;

    private static long deadID;
    public Elmas(float xKord, float yKord, float width, float height,Boru boru) {
        this.boru=boru;
        this.xKord = xKord;
        this.yKord = yKord;
        this.width = width;
        this.height = height;

        type=elmasType.elmas1;

        rectangleElmas=new Rectangle(xKord,yKord,width,height);
        sound = Gdx.audio.newSound(Gdx.files.internal("elmas.mp3"));
        deadID=sound.play(0);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();

        if( type==elmasType.elmas1){
            sb.draw(ImageLoder.texRegElmas1,xKord,yKord,width,height);

        }
        else if( type==elmasType.elmas2){
            sb.draw(ImageLoder.texRegElmas2,xKord,yKord,width,height);

        }
       else if( type==elmasType.elmas3){
            sb.draw(ImageLoder.texRegElmas3,xKord,yKord,width,height);

        }
        else if( type==elmasType.elmas4){
            sb.draw(ImageLoder.texRegElmas4,xKord,yKord,width,height);

        }
        else if( type==elmasType.elmas5){
            sb.draw(ImageLoder.texRegElmas5,xKord,yKord,width,height);

        }

        else if( type==elmasType.elmas6){
            sb.draw(ImageLoder.texRegElmas6,xKord,yKord,width,height);

        }




        sb.end();

    }

    public void  disposeElmas(){

        xKord= boru.getCollicionBoruTop().x+boru.getBosluk()/5;
        yKord=  boru.getCollicionBoruTop().height+boru.getBosluk()/3;

        rectangleElmas.x=xKord;
        rectangleElmas.y=yKord;


    }

    @Override
    public void update(float delta) {


        if(Collision.iscollisionElmas(boru.getBird(),this)){

            sound.stop(deadID);
            deadID = sound.play(1f);

            System.out.println("1. Elmas alınd");
            Random r=new Random();

            boru.setDefHeigt(r.nextInt((int) (2*Gdx.graphics.getHeight()/3-boru.getBosluk())));

            xKord= boru.getCollicionBoruTop().x+boru.getBosluk()/5+4*Gdx.graphics.getWidth()/3;
            yKord=  boru.getDefHeigt()+boru.getBosluk()/3;

            rectangleElmas.x=xKord;
            rectangleElmas.y=yKord;

            System.out.println("Elmas x= "+xKord);

            if( type==elmasType.elmas1){
                boru.getBird().setAlinanElmas( boru.getBird().getAlinanElmas()+1);
                ElmasScoreHandler.setHighScore(ElmasScoreHandler.getHighScore()+1);

            }
            else if( type==elmasType.elmas2){
                boru.getBird().setAlinanElmas( boru.getBird().getAlinanElmas()+2);
                ElmasScoreHandler.setHighScore(ElmasScoreHandler.getHighScore()+2);

            }
            else if( type==elmasType.elmas3){
                boru.getBird().setAlinanElmas( boru.getBird().getAlinanElmas()+3);
                ElmasScoreHandler.setHighScore(ElmasScoreHandler.getHighScore()+3);

            }
            else if( type==elmasType.elmas4){
                boru.getBird().setAlinanElmas( boru.getBird().getAlinanElmas()+5);
                ElmasScoreHandler.setHighScore(ElmasScoreHandler.getHighScore()+5);

            }
            else if( type==elmasType.elmas5){
                boru.getBird().setAlinanElmas( boru.getBird().getAlinanElmas()+7);
                ElmasScoreHandler.setHighScore(ElmasScoreHandler.getHighScore()+7);

            }

            else if( type==elmasType.elmas6){
                boru.getBird().setAlinanElmas( boru.getBird().getAlinanElmas()+10);
                ElmasScoreHandler.setHighScore(ElmasScoreHandler.getHighScore()+10);

            }



        }


    }

    public Rectangle getRectangleElmas() {
        return rectangleElmas;
    }

    public void setRectangleElmas(Rectangle rectangleElmas) {
        this.rectangleElmas = rectangleElmas;
    }

    public elmasType getType() {
        return type;
    }

    public void setType(elmasType type) {
        this.type = type;
    }
}
