package com.demo.hntest.Designpatterns.java.decorator;

/**
 * 抽象装饰类
 *
 */
public class Decorator implements Component{
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void operation() {
        System.out.println("具体装饰类操作");
    }
}
