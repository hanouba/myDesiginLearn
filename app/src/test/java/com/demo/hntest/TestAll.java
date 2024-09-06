package com.demo.hntest;

import com.demo.hntest.Designpatterns.java.factory.CumFactory;
import com.demo.hntest.Designpatterns.java.factory.CumputerFactory;

import org.junit.Test;

public class TestAll {

    @Test
    public  void testFractory() {
        CumFactory cf = CumputerFactory.getInstance("PC", "16G", "i7", "1T");
        CumFactory sf = CumputerFactory.getInstance("Server", "32G", "i9", "2T");
        System.out.println(cf.getCPU());
        System.out.println(cf.getHDD());
        System.out.println(cf.getRAM());
        System.out.println("ServerCumputer  " + sf);
        System.out.println("PC Cumputer  " + cf);
    }
}
