package com.demo.hntest.Designpatterns.java.BuiderDesign;
//具体建造者
public class ConcreateBuilder implements Builder{
    //构建产品
    Product product = new Product();
    @Override
    public void buildPartA() {
        System.out.println("构建部分A");
        product.setPartA("构建部分A");
    }

    @Override
    public void buildPartB() {
        System.out.println("构建部分B");
        product.setPartB("构建部分B");
    }

    @Override
    public void buildPartC() {
        System.out.println("构建部分C");
        product.setPartC("构建部分C");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
