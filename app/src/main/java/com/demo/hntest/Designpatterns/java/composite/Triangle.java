package com.demo.hntest.Designpatterns.java.composite;

/**
 * Leaf
 *
 */
public class Triangle implements Shape{
    @Override
    public void draw(String color) {
        System.out.println("画"+color+"颜色的三角形");
    }
}
