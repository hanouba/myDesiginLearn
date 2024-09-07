package com.demo.hntest.Designpatterns.java.bridge;

public class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}
