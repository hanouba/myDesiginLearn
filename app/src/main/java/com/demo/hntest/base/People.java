package com.demo.hntest.base;

public class People {
    private String name;
    private int age;
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("人吃人");
    }
}
