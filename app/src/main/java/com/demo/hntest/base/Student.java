package com.demo.hntest.base;

public class Student extends People{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("学生吃学生");
    }

    public void study(){
        System.out.println("学生 study");
    }
}
