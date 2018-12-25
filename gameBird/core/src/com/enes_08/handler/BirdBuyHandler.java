package com.enes_08.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by lenovo on 31.08.2018.
 */

public class BirdBuyHandler {

    public static Preferences pref;

    public static void load()
    {
        pref = Gdx.app.getPreferences("Oyun");

        if(!pref.contains("BirdBuy0"))
        {
            pref.putInteger("BirdBuy0", 0);
            pref.putInteger("BirdBuy1", 0);
            pref.putInteger("BirdBuy2", 0);
            pref.putInteger("BirdBuy3", 0);
            pref.putInteger("BirdBuy4", 0);
            pref.putInteger("BirdBuy5", 0);
            pref.putInteger("BirdBuy6", 0);
            pref.putInteger("BirdBuy7", 0);
            pref.putInteger("BirdBuy8", 0);
            pref.putInteger("BirdBuy9", 0);
            pref.putInteger("BirdBuy10", 0);
            pref.putInteger("BirdBuy11", 0);
            pref.putInteger("BirdBuy12", 0);


        }
    }

    public static void setHighScore(int highScore,int Kus)
    {
        pref.putInteger("BirdBuy"+Kus, highScore);
        pref.flush();
    }

    public static int getHighScore(int Kus)
    {

        return pref.getInteger("BirdBuy"+Kus);
    }
}
