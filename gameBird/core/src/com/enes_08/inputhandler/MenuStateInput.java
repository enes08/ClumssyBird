package com.enes_08.inputhandler;

import com.badlogic.gdx.InputProcessor;
import com.enes_08.imageloder.ImageLoder;
import com.enes_08.states.BirdShopState;
import com.enes_08.states.MenuState;
import com.enes_08.states.PlayState;

/**
 * Created by lenovo on 02.09.2018.
 */

public class MenuStateInput implements InputProcessor {

    MenuState menuState;
    public MenuStateInput(MenuState menuState) {
        this.menuState=menuState;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        if(menuState.getBtnPlay().getBtnRectangle().contains(screenX,screenY)){

            menuState.getSm().popState();

            menuState.getSm().pushState(new PlayState(menuState.getSm()));

            System.out.println("Play State Push oldu");
            menuState.getSound().dispose();

            menuState.getSm().getStatesCount();
        }

        if(menuState.getBtnShop().getBtnRectangle().contains(screenX,screenY)){

            menuState.getSm().popState();

            menuState.getSm().pushState(new BirdShopState(menuState.getSm()));

            menuState.getSound().dispose();


        }


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
