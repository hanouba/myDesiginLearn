package com.demo.hntest.Designpatterns.java.decorator;

public class ConcreateDecorator2 extends Decorator{
    public ConcreateDecorator2(Component component) {
        super(component);

    }

    @Override
    public void operation() {
        System.out.println("具体装饰类2操作前");
        component.operation();
        System.out.println("具体装饰类2操作后");
    }
}
