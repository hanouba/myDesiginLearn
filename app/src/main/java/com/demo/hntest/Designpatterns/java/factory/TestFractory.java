package com.demo.hntest.Designpatterns.java.factory;

public class TestFractory {
    public static void main(String[] args) {
        CumFactory cf = CumputerFactory.getInstance("PC", "16G", "i7", "1T");
        CumFactory sf = CumputerFactory.getInstance("Server", "32G", "i9", "2T");
        System.out.println(cf.getCPU());
        System.out.println(cf.getHDD());
        System.out.println(cf.getRAM());
        System.out.println("ServerCumputer  " + sf);
        System.out.println("PC Cumputer  " + cf);
    }
}
