package com.demo.hntest.Designpatterns.java.BuiderDesign;

/**
 * 具体的产品
 * 比如一个dialog
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }
    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("产品展示");
    }
}
