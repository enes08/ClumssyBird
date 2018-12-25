package com.enes_08.gameobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by lenovo on 29.08.2018.
 */

public interface GameObject {

    public void render(SpriteBatch sb);
    public  void update(float delta);
}
