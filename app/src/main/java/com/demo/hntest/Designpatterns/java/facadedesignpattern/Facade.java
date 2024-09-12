package com.demo.hntest.Designpatterns.java.facadedesignpattern;

/**
 * 外观模式
 */
public class Facade {
    private SystemA systemA = new SystemA();
    private SystemB systemB = new SystemB();
    public void facadeMethod() {
        systemA.doSomething();
        systemB.methodB();
    }
}
