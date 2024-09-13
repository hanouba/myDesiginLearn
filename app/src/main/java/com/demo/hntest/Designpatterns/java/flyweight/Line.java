package com.demo.hntest.Designpatterns.java.flyweight;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 享元角色
 */
public class Line implements FlyShape {

    private Paint paint;

    public Line() {
        System.out.println("Line");
    }




    @Override
    public void draw(int x, int y, int width, int height, Color color) {
        System.out.println("Line draw");
    }
}
