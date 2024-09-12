package com.demo.hntest.Designpatterns.java.composite;

public class Circle implements Shape{
    @Override
    public void draw(String color) {
        System.out.println("画圆");
    }
}
