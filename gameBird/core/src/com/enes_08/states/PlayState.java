package com.enes_08.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.enes_08.collision.Collision;
import com.enes_08.gameobject.Bird;
import com.enes_08.gameobject.Boru;
import com.enes_08.gameobject.Elmas;
import com.enes_08.handler.Bghandler;
import com.enes_08.handler.BirdSelectHandler;
import com.enes_08.handler.ElmasScoreHandler;
import com.enes_08.handler.HighScoreHandler;
import com.enes_08.imageloder.ImageLoder;
import com.enes_08.inputhandler.MenuStateInput;
import com.enes_08.inputhandler.PlayStateInput;

/**
 * Created by lenovo on 29.08.2018.
 */

public class PlayState extends State {


    StateManager sm;

    Bird bird;
    Bghandler bghandler;

    Boru boru;

    Boru boru2;
    Boru boru3;

    Boru boru4;
    Sound sound;

    Elmas elmas1,elmas2,elmas3,elmas4;
    Music playMusic;
    private static long deadID;

    public PlayState(StateManager sm) {
        super(sm);
        sound = Gdx.audio.newSound(Gdx.files.internal("death.mp3"));
        playMusic = Gdx.audio.newMusic(Gdx.files.internal("menuMusic.mp3"));

        Gdx.input.setInputProcessor(new PlayStateInput(this));

        deadID=sound.play(0);

        this.sm=sm;
        ImageLoder.loadBird(BirdSelectHandler.getHighScore());
        bird=new Bird(0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth()/20,Gdx.graphics.getWidth()/20, ImageLoder.playerAnimation);

        bghandler=new Bghandler(bird);

        boru=new Boru(Gdx.graphics.getWidth()/3,bird);

        boru2=new Boru(Gdx.graphics.getWidth()/3+boru.getCollicionBoruTop().x,bird);

        boru3=new Boru(Gdx.graphics.getWidth()/3+boru2.getCollicionBoruTop().x,bird);

        boru4=new Boru(Gdx.graphics.getWidth()/3+boru3.getCollicionBoruTop().x,bird);

        elmas1=new Elmas(boru.getCollicionBoruTop().x+boru.getBosluk()/5,boru.getCollicionBoruTop().height+boru.getBosluk()/3,boru.getBosluk()/3,boru.getBosluk()/3,boru);
        elmas2=new Elmas(boru2.getCollicionBoruTop().x+boru2.getBosluk()/5,boru2.getCollicionBoruTop().height+boru2.getBosluk()/3,boru2.getBosluk()/3,boru2.getBosluk()/3,boru2);

        elmas3=new Elmas(boru3.getCollicionBoruTop().x+boru3.getBosluk()/5,boru3.getCollicionBoruTop().height+boru3.getBosluk()/3,boru3.getBosluk()/3,boru3.getBosluk()/3,boru3);
        elmas4=new Elmas(boru4.getCollicionBoruTop().x+boru4.getBosluk()/5,boru4.getCollicionBoruTop().height+boru4.getBosluk()/3,boru4.getBosluk()/3,boru4.getBosluk()/3,boru4);



    }

    @Override
    public void render(SpriteBatch sb) {





        sb.setProjectionMatrix(camera.combined);

        bghandler.render(sb);
        bird.render(sb);
        boru.render(sb);
        boru2.render(sb);
        boru3.render(sb);

        boru4.render(sb);

        elmas1.render(sb);
        elmas2.render(sb);
        elmas3.render(sb);
        elmas4.render(sb);

        sb.begin();



        sb.draw(boru.getBoruD(),camera.position.x, bird.getSize().y/3,elmas1.getRectangleElmas().width,elmas1.getRectangleElmas().height);

        ImageLoder.font.draw(sb, String.valueOf(bird.getSkor()), camera.position.x+bird.getSize().x, bird.getSize().y/3);

        sb.draw(ImageLoder.texRegElmas6,camera.position.x+Gdx.graphics.getWidth()/6, bird.getSize().y/3,elmas1.getRectangleElmas().width,elmas1.getRectangleElmas().height);

        ImageLoder.font.draw(sb, String.valueOf(ElmasScoreHandler.getHighScore()), camera.position.x+Gdx.graphics.getWidth()/6+bird.getSize().x, bird.getSize().y/3);
        sb.end();



    }

    @Override
    public void update(float delta) {

        bghandler.update(delta);
        bird.update(delta);
     // System.out.println("boruGecilen"+bird.getSkor());
        updateCamera();
        boru.update(delta);
        boru2.update(delta);
        boru3.update(delta);



        boru4.update(delta);

        elmas1.update(delta);
        elmas2.update(delta);
        elmas3.update(delta);
        elmas4.update(delta);

        playMusic.setLooping(true);
         playMusic.play();

        int skor=HighScoreHandler.getHighScore();

        if(skor<bird.getSkor()){
            HighScoreHandler.setHighScore(bird.getSkor());

        }

        if(bird.getSkor()==25){

            bird.setSpeed(new Vector2(19,15));



            System.out.println("Hıazlandı");
        }
        if(bird.getSkor()==40){

            bird.setSpeed(new Vector2(18,15));

            System.out.println("Hıazlandı");

            elmas1.setType(Elmas.elmasType.elmas2);
            elmas2.setType(Elmas.elmasType.elmas2);
            elmas3.setType(Elmas.elmasType.elmas2);
            elmas4.setType(Elmas.elmasType.elmas2);

        }

        if(bird.getSkor()==75){

            bird.setSpeed(new Vector2(17,15));

            System.out.println("Hıazlandı");
        }


        if(bird.getSkor()==120){

            bird.setSpeed(new Vector2(16,15));

            elmas1.setType(Elmas.elmasType.elmas3);
            elmas2.setType(Elmas.elmasType.elmas3);
            elmas3.setType(Elmas.elmasType.elmas3);
            elmas4.setType(Elmas.elmasType.elmas3);

            System.out.println("Hıazlandı");
        }


        if(bird.getSkor()==150){

            bird.setSpeed(new Vector2(15,15));

            System.out.println("Hıazlandı");


        }


        if(bird.getSkor()==200){

            bird.setSpeed(new Vector2(14,15));

            System.out.println("Hıazlandı");
        }


        if(bird.getSkor()==250){

            bird.setSpeed(new Vector2(13,15));

            System.out.println("Hıazlandı");

            elmas1.setType(Elmas.elmasType.elmas4);
            elmas2.setType(Elmas.elmasType.elmas4);
            elmas3.setType(Elmas.elmasType.elmas4);
            elmas4.setType(Elmas.elmasType.elmas4);
        }


        if(bird.getSkor()==300){

            bird.setSpeed(new Vector2(13,15));

            System.out.println("Hıazlandı");



        }

        if(bird.getSkor()==350){

            bird.setSpeed(new Vector2(13,15));

            System.out.println("Hıazlandı");
        }

        if(bird.getSkor()==400){

            bird.setSpeed(new Vector2(13,15));

            System.out.println("Hıazlandı");

            elmas1.setType(Elmas.elmasType.elmas5);
            elmas2.setType(Elmas.elmasType.elmas5);
            elmas3.setType(Elmas.elmasType.elmas5);
            elmas4.setType(Elmas.elmasType.elmas5);
        }

        if(bird.getSkor()==450){

            bird.setSpeed(new Vector2(13,15));


            System.out.println("Hıazlandı");
        }

        if(bird.getSkor()==500){

            bird.setSpeed(new Vector2(13,15));



            System.out.println("Hıazlandı");
        }

        if(bird.getSkor()==600){

            bird.setSpeed(new Vector2(13,15));

            System.out.println("Hıazlandı");

            elmas1.setType(Elmas.elmasType.elmas6);
            elmas2.setType(Elmas.elmasType.elmas6);
            elmas3.setType(Elmas.elmasType.elmas6);
            elmas4.setType(Elmas.elmasType.elmas6);
        }

        if(bird.getSkor()==700){

            bird.setSpeed(new Vector2(13,15));

            System.out.println("Hıazlandı");


        }







       /* if(Collision.iscollisionElmas(bird,elmas1)){

            System.out.println("1. Elmas alınd");


        }
        if(Collision.iscollisionElmas(bird,elmas2)){

            System.out.println("2. Elmas alınd");
            elmas2.update(delta);

        }


        if(Collision.iscollisionElmas(bird,elmas3)){

            System.out.println("3. Elmas alınd");
            elmas3.update(delta);

        }

        if(Collision.iscollisionElmas(bird,elmas4)){

            System.out.println("4. Elmas alınd");
            elmas4.update(delta);

        }

*/



        if(Collision.iscollision(bird,boru)||bird.getPozition().y>Gdx.graphics.getHeight()){
            sound.stop(deadID);
            deadID = sound.play(1f);
            sm.popState();
            sm.pushState(new GameOverState(sm,bird.getSkor(),bird.getAlinanElmas()));

             playMusic.dispose();

        }
        else if(Collision.iscollision(bird,boru2)||bird.getPozition().y>Gdx.graphics.getHeight()){
            sound.stop(deadID);
            deadID = sound.play(1f);
            sm.popState();

            sm.pushState(new GameOverState(sm,bird.getSkor(),bird.getAlinanElmas()));
            playMusic.dispose();

        }

        else  if(Collision.iscollision(bird,boru3)||bird.getPozition().y>Gdx.graphics.getHeight()){
            sound.stop(deadID);
            deadID = sound.play(1f);
            sm.popState();
            sm.pushState(new GameOverState(sm,bird.getSkor(),bird.getAlinanElmas()));
            playMusic.dispose();

        }

        else if(Collision.iscollision(bird,boru4)||bird.getPozition().y>Gdx.graphics.getHeight()){
            sound.stop(deadID);
            deadID = sound.play(1f);
            sm.popState();
            sm.pushState(new GameOverState(sm,bird.getSkor(),bird.getAlinanElmas()));
            playMusic.dispose();

        }




    }

    public void  updateCamera(){

        if(bird.getPozition().x>Gdx.graphics.getWidth()/6){

            camera.position.x+=bird.getSize().x/bird.getSpeed().x;

        }

        camera.update();

    }
}
