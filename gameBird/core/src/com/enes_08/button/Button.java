package com.enes_08.button;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.enes_08.gameobject.GameObject;

/**
 * Created by lenovo on 02.09.2018.
 */

public class Button implements GameObject {

    float xKord,ykord,with,height;

    Rectangle btnRectangle;

TextureRegion btnTextureRegion;
    public Button(float xKord, float ykord, float with, float height, TextureRegion btnTextureReg) {
        this.xKord = xKord;
        this.ykord = ykord;
        this.with = with;
        this.height = height;
        this.btnTextureRegion=btnTextureReg;
        btnRectangle=new Rectangle(xKord,ykord,with,height);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(btnTextureRegion,xKord,ykord,with,height);
        sb.end();

    }

    @Override
    public void update(float delta) {

    }

    public Rectangle getBtnRectangle() {
        return btnRectangle;
    }

    public void setBtnRectangle(Rectangle btnRectangle) {
        this.btnRectangle = btnRectangle;
    }
}
