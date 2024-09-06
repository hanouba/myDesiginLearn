package com.demo.hntest.Designpatterns.java.BuiderDesign;
//建造者模式 设计师
public class Director {
    private Builder builder;
    public Director(Builder builder)
    {
        this.builder = builder;
    }
    public void construct()
    {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
