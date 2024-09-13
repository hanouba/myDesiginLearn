package com.demo.hntest.Designpatterns.java.flyweight;

import android.graphics.Color;

public class Ovl implements FlyShape{
    public Ovl(){
        System.out.println("Ovl init");
    }
    @Override
    public void draw(int x, int y, int width, int height, Color color) {
        System.out.println("Ovl draw");
    }
}
