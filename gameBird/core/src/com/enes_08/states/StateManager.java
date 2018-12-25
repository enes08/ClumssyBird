package com.enes_08.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.enes_08.imageloder.ImageLoder;

import java.util.Stack;

/**
 * Created by lenovo on 29.08.2018.
 */

public class StateManager {

    Stack <State> states;

    public StateManager() {

        states=new Stack<State>();
    }

    public void render(SpriteBatch sb){

        states.peek().render(sb);

    }

    public  void update(float delta){
        states.peek().update(delta);

    }


    public void pushState(State state){

        states.push(state);

    }

    public void popState(){

        //ImageLoder.dispose();

        states.pop();

       // ImageLoder.load();

    }

    public void getStatesCount(){

        System.out.println("states.size()"+states.size());
    }
}
