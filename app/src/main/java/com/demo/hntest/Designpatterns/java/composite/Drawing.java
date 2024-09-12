package com.demo.hntest.Designpatterns.java.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 复合构件 ：可以增加，删除，增加新的叶子构件，
 */
public class Drawing implements Shape{
    private List<Shape> shapes = new ArrayList<>();



    public void add(Shape shape){
        this.shapes.add(shape);
    }

    public void remove(Shape shape){
        this.shapes.remove(shape);
    }
    @Override
    public void draw(String color) {
        for (Shape sh:
             shapes) {
            sh.draw(color);
        }
    }
    public void clear() {
        System.out.println("清空所有图形");
        this.shapes.clear();
    }
}
