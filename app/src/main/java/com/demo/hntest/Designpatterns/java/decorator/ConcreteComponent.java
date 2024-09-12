package com.demo.hntest.Designpatterns.java.decorator;

/**
 * 具体组件
 * 实现组件的具体功能
 */
public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("具体功能");
    }
}
