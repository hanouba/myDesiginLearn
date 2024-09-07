package com.demo.hntest.Designpatterns.java.bridge;

public class Pentagon extends Shape{
    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.println("Pentagon filled with color");
        color.applyColor();
    }
}
