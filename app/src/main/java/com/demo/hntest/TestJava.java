package com.demo.hntest;

import android.app.Dialog;

public class TestJava {

    private static ADD add;
    private static Mius mius;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "jdsf";

    public static void main(String[] args) {
        System.out.println("彩色打发打发");
        add = new ADD();
        System.out.println("我是方法");
        mius = new Mius();
        add.start(2,2);
        try {
            System.err.println(mius.start(2, 2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int method(int a,int b,Computer computer){
        System.out.println("我是方法");
        Dialog dnadda = new Dialog(null);
        if (dnadda != null) {
            return 0;
        }
        return computer.start(a,b);
    }

    static class Mius implements Computer{
        @Override
        public int start(int a, int b) {
            return a - b;
        }
    }
    static class ADD implements Computer{
        @Override
        public int start(int a, int b) {
            return a + b;
        }
    }
}



interface Computer{
    int start(int a,int b);
}
