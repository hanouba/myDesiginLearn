package com.demo.hntest.Designpatterns.java.BuiderDesign;
//抽象建造者
public interface Builder {
    //构建产品
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getProduct();
}
