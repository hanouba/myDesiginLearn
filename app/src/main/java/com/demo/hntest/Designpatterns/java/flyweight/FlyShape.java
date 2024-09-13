package com.demo.hntest.Designpatterns.java.flyweight;

import android.graphics.Color;

/**
 * 抽象享元角色
 */
public interface FlyShape {
    public void draw(
             int x, int y, int width, int height, Color color
    );
}
