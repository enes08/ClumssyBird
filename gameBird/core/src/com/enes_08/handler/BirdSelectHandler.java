package com.enes_08.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by lenovo on 31.08.2018.
 */

public class BirdSelectHandler {

    public static Preferences pref;

    public static void load()
    {
        pref = Gdx.app.getPreferences("Oyun");

        if(!pref.contains("BirdSelect"))
        {
            pref.putInteger("BirdSelect", 0);
            pref.putInteger("BirdSelectOyun", 0);
        }
    }

    public static void setBirdSelectOyun(int highScore)
    {
        pref.putInteger("BirdSelectOyun", highScore);
        pref.flush();
    }

    public static int getBirdSelectOyun()
    {
        return pref.getInteger("BirdSelectOyun");
    }


    public static void setHighScore(int highScore)
    {
        pref.putInteger("BirdSelect", highScore);
        pref.flush();
    }

    public static int getHighScore()
    {
        return pref.getInteger("BirdSelect");
    }
}
