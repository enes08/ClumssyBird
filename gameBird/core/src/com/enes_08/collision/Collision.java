package com.enes_08.collision;

import com.enes_08.gameobject.Bird;
import com.enes_08.gameobject.Boru;
import com.enes_08.gameobject.Elmas;
import com.enes_08.handler.HighScoreHandler;
import com.sun.org.apache.regexp.internal.RE;

import java.awt.Rectangle;

/**
 * Created by lenovo on 30.08.2018.
 */

public class Collision {

    public static boolean iscollisionElmas(Bird bird, Elmas elmas){


        if(bird.getRectangleBird().overlaps(elmas.getRectangleElmas())){
          /*  System.out.println("-----------------ÇARPIŞMA VAR -------------------");
            System.out.println("bird.x"+bird.getRectangleBird().x);
            System.out.println("bird.y"+bird.getRectangleBird().y);
            System.out.println("bird.w"+bird.getRectangleBird().width);
            System.out.println("bird.h"+bird.getRectangleBird().height);

            System.out.println("Tboru.x"+boru.getCollicionBoruTop().x);
            System.out.println("Tboru.y"+boru.getCollicionBoruTop().y);
            System.out.println("Tboru.w"+boru.getCollicionBoruTop().width);
            System.out.println("Tboru.h"+boru.getCollicionBoruTop().height);

            System.out.println("------------------------------------");*/

            return true;
        }

        return false;
    }

    public static boolean iscollision(Bird bird, Boru boru){


        if(bird.getRectangleBird().overlaps(boru.getCollicionBoruBot())||bird.getRectangleBird().overlaps(boru.getCollicionBoruTop())){
          /*  System.out.println("-----------------ÇARPIŞMA VAR -------------------");
            System.out.println("bird.x"+bird.getRectangleBird().x);
            System.out.println("bird.y"+bird.getRectangleBird().y);
            System.out.println("bird.w"+bird.getRectangleBird().width);
            System.out.println("bird.h"+bird.getRectangleBird().height);

            System.out.println("Tboru.x"+boru.getCollicionBoruTop().x);
            System.out.println("Tboru.y"+boru.getCollicionBoruTop().y);
            System.out.println("Tboru.w"+boru.getCollicionBoruTop().width);
            System.out.println("Tboru.h"+boru.getCollicionBoruTop().height);

            System.out.println("------------------------------------");*/




            return true;
        }

        return false;
    }
}
