package com.demo.hntest.base;

public class Teacher extends People{
    public Teacher(String name, int age) {
        super(name, age);
    }
    public void teach(){
        System.out.println("teach");
    }
    public void eat(){
        System.out.println("老师eat老师");
    }
}
