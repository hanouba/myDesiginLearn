package com.demo.hntest.Designpatterns.java.decorator;

/**
 * 具体的装饰类
 */
public class ConcreateDecorator1 extends Decorator{
    public ConcreateDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("具体装饰类1操作前");
        component.operation();
        System.out.println("具体装饰类1操作后");
    }
}
