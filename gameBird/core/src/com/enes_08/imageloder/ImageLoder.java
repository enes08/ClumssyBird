package com.enes_08.imageloder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by lenovo on 29.08.2018.
 */

public class ImageLoder {







    public static  TextureRegion texRegPdiamond ;
    public static  TextureRegion texRegBdiamond ;
    public static  TextureRegion texRegGdiamond ;

    public static  TextureRegion texRegElmas1 ;
    public static  TextureRegion texRegElmas2 ;
    public static  TextureRegion texRegElmas3 ;
    public static  TextureRegion texRegElmas4 ;
    public static  TextureRegion texRegElmas5 ;
    public static  TextureRegion texRegElmas6 ;



    public static  Texture bg1;
    public static  Texture bg2;
    public static  Texture bg3;
    public static  Texture bg4;
    public static  Texture bg5;
    public static  Texture bg6;

    public static  Texture boruD1;
    public static  Texture boruD2;
    public static  Texture boruD3;
    public static  Texture boruD4;
    public static  Texture boruD5;
    public static  Texture boruD6;

    public static  Texture boruT1;
    public static  Texture boruT2;
    public static  Texture boruT3;
    public static  Texture boruT4;
    public static  Texture boruT5;
    public static  Texture boruT6;

    public static  TextureRegion texRegbg1 ;
    public static  TextureRegion texRegbg2 ;
    public static  TextureRegion texRegbg3 ;
    public static  TextureRegion texRegbg4 ;
    public static  TextureRegion texRegbg5 ;
    public static  TextureRegion texRegbg6 ;


    public static  TextureRegion texRegboruT1 ;
    public static  TextureRegion texRegboruT2 ;
    public static  TextureRegion texRegboruT3 ;
    public static  TextureRegion texRegboruT4 ;
    public static  TextureRegion texRegboruT5 ;
    public static  TextureRegion texRegboruT6 ;

    public static  TextureRegion texRegboruD1 ;
    public static  TextureRegion texRegboruD2 ;
    public static  TextureRegion texRegboruD3 ;
    public static  TextureRegion texRegboruD4 ;
    public static  TextureRegion texRegboruD5 ;
    public static  TextureRegion texRegboruD6 ;

    public static  Texture bgGO;
    public static  TextureRegion tRegbgGO;



    public static  Texture texElmas1 ;
    public static  Texture texElmas2 ;
    public static  Texture texElmas3 ;
    public static  Texture texElmas4 ;
    public static  Texture texElmas5 ;
    public static  Texture texElmas6 ;

    public static  Texture TexbtnPlay;
    public static  TextureRegion tRegbtnPlay;

    public static  Texture TextLogoKuslar;
    public static  TextureRegion tRegLogoKuslar;

    public static BitmapFont font;
    public static Texture fontTexture;

    public static Animation playerAnimation,playerAnimation2;

    public static  Texture texKus1 ;
    public static  Texture texKus2 ;

    public static  TextureRegion tRegKusFrame1;
    public static  TextureRegion tRegKusFrame2;

    public static  Texture TexbtnNext;
    public static  Texture TexbtnBack;
    public static  Texture TexbtnHome;
    public static  Texture TexbtnShop;

    public static  Texture TexbtnBuy;
    public static  TextureRegion TexRegbtnBuy;

    public static  TextureRegion TexRegbtnNext;
    public static  TextureRegion TexRegbtnBack;
    public static  TextureRegion TexRegbtnHome;
    public static  TextureRegion TexRegbtnShop;

    public static String [][]kusFileName=
            {{"kus1_1.png","kus1_2.png"},{"kus2_1.png","kus2_2.png"},{"kus3_1.png","kus3_2.png"},
            {"kus4_1.png","kus4_2.png"},{"kus5_1.png","kus5_2.png"},{"kus6_1.png","kus6_2.png"},
            {"kus7_1.png","kus7_2.png"},{"kus8_1.png","kus8_2.png"},{"kus9_1.png","kus9_2.png"},
            {"kus10_1.png","kus10_2.png"},{"kus11_1.png","kus11_2.png"},{"kus12_1.png","kus12_2.png"},{"kus13_1.png","kus13_2.png"}};
    public static void  loadBird(int kus){

        texKus1=new Texture(kusFileName[kus][0]);
        texKus2=new Texture(kusFileName[kus][1]);


        tRegKusFrame1 = new TextureRegion(texKus1);
        tRegKusFrame1.flip(false,true);

        tRegKusFrame2 = new TextureRegion(texKus2);
        tRegKusFrame2.flip(false,true);


        playerAnimation2=new Animation(0.1f, tRegKusFrame1, tRegKusFrame2);
        playerAnimation=playerAnimation2;
    }


    public static void  load(){
        font = new BitmapFont(Gdx.files.internal("font.fnt"),true);
        font.getData().setScale((float) 0.7);
        fontTexture = new Texture(Gdx.files.internal("font.png"));
        fontTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


        TexbtnBuy=new Texture("buyBtn.png");


        bgGO=new Texture("sehir3GO.png");

        TextLogoKuslar=new Texture("logoKuslar.png");
       // bg=new Texture("bg.png");

        bg1=new Texture("bg1.jpg");
        bg2=new Texture("bg2.png");
        bg3=new Texture("bg3.png");
        bg4=new Texture("bg4.png");
        bg5=new Texture("bg5.png");
        bg6=new Texture("bg6.png");


        boruD1=new Texture("boruD1.png");
        boruD2=new Texture("boruD2.png");
        boruD3=new Texture("boruD3.png");
        boruD4=new Texture("boruD4.png");
        boruD5=new Texture("boruD5.png");
        boruD6=new Texture("boruD6.png");

        boruT1=new Texture("boruT1.png");
        boruT2=new Texture("boruT2.png");
        boruT3=new Texture("boruT3.png");
        boruT4=new Texture("boruT4.png");
        boruT5=new Texture("boruT5.png");
        boruT6=new Texture("boruT6.png");

        texElmas1=new Texture("elmas1.png");
        texElmas2=new Texture("elmas2.png");
        texElmas3=new Texture("elmas3.png");
        texElmas4=new Texture("elmas4.png");
        texElmas5=new Texture("elmas5.png");
        texElmas6=new Texture("elmas6.png");


        TexbtnPlay=new Texture("playBtn.png");
        TexbtnNext=new Texture("nextBtn.png");
        TexbtnBack=new Texture("backBtn.png");
        TexbtnHome=new Texture("homeBtn.png");

        TexbtnShop=new Texture("shopBtn.png");

        TexRegbtnShop= new TextureRegion(TexbtnShop);
        TexRegbtnShop.flip(false,true);

        TexRegbtnNext= new TextureRegion(TexbtnNext);
        TexRegbtnNext.flip(false,true);

        TexRegbtnBack= new TextureRegion(TexbtnBack);
        TexRegbtnBack.flip(false,true);


        TexRegbtnHome= new TextureRegion(TexbtnHome);
        TexRegbtnHome.flip(false,true);



        texRegboruD1 = new TextureRegion(boruD1);
        texRegboruD1.flip(false,true);

        texRegboruD2 = new TextureRegion(boruD2);
        texRegboruD2.flip(false,true);

        texRegboruD3 = new TextureRegion(boruD3);
        texRegboruD3.flip(false,true);

        texRegboruD4 = new TextureRegion(boruD4);
        texRegboruD4.flip(false,true);

        texRegboruD5 = new TextureRegion(boruD5);
        texRegboruD5.flip(false,true);

        texRegboruD6 = new TextureRegion(boruD6);
        texRegboruD6.flip(false,true);


        texRegboruT1 = new TextureRegion(boruT1);
        texRegboruT1.flip(false,true);

        texRegboruT2 = new TextureRegion(boruT2);
        texRegboruT2.flip(false,true);

        texRegboruT3 = new TextureRegion(boruT3);
        texRegboruT3.flip(false,true);

        texRegboruT4 = new TextureRegion(boruT4);
        texRegboruT4.flip(false,true);

        texRegboruT5 = new TextureRegion(boruT5);
        texRegboruT5.flip(false,true);

        texRegboruT6 = new TextureRegion(boruT6);
        texRegboruT6.flip(false,true);

        TexRegbtnBuy = new TextureRegion(TexbtnBuy);
        TexRegbtnBuy.flip(false,true);










        texRegbg1 = new TextureRegion(bg1);
        texRegbg1.flip(false,true);

        texRegbg2 = new TextureRegion(bg2);
        texRegbg2.flip(false,true);

        texRegbg3 = new TextureRegion(bg3);
        texRegbg3.flip(false,true);

        texRegbg4 = new TextureRegion(bg4);
        texRegbg4.flip(false,true);


        texRegbg5 = new TextureRegion(bg5);
        texRegbg5.flip(false,true);

        texRegbg6 = new TextureRegion(bg6);
        texRegbg6.flip(false,true);

        tRegbgGO = new TextureRegion(bgGO);
        tRegbgGO.flip(false,true);

        tRegLogoKuslar= new TextureRegion(TextLogoKuslar);
        tRegLogoKuslar.flip(false,true);


        tRegbtnPlay= new TextureRegion(TexbtnPlay);
        tRegbtnPlay.flip(false,true);


        texRegElmas1 = new TextureRegion(texElmas1);
        texRegElmas1.flip(false,true);

        texRegElmas2 = new TextureRegion(texElmas2);
        texRegElmas2.flip(false,true);

        texRegElmas3 = new TextureRegion(texElmas3);
        texRegElmas3.flip(false,true);

        texRegElmas4 = new TextureRegion(texElmas4);
        texRegElmas4.flip(false,true);

        texRegElmas5 = new TextureRegion(texElmas5);
        texRegElmas5.flip(false,true);

        texRegElmas6 = new TextureRegion(texElmas6);
        texRegElmas6.flip(false,true);



    }

    public static void dispose(){


        font.dispose();
        fontTexture.dispose();

        texKus1.dispose();
        texKus2.dispose();

        texElmas1.dispose();
        texElmas2.dispose();
        texElmas3.dispose();
        texElmas4.dispose();
        texElmas5.dispose();
        texElmas6.dispose();

        bg1.dispose();
        bg2.dispose();
        bg3.dispose();
        bg4.dispose();
        bg5.dispose();
        bg6.dispose();



    }
}
