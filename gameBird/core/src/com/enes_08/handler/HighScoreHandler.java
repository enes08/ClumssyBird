package com.enes_08.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by lenovo on 31.08.2018.
 */

public class HighScoreHandler {

    public static Preferences pref;

    public static void load()
    {
        pref = Gdx.app.getPreferences("Oyun");

        if(!pref.contains("HighScore"))
        {
            pref.putInteger("HighScore", 0);
        }
    }

    public static void setHighScore(int highScore)
    {
        pref.putInteger("HighScore", highScore);
        pref.flush();
    }

    public static int getHighScore()
    {
        return pref.getInteger("HighScore");
    }
}
