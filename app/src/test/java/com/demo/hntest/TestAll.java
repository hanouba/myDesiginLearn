package com.demo.hntest;

import com.demo.hntest.Designpatterns.java.factory.Cumputer;
import com.demo.hntest.Designpatterns.java.factory.CumputerFactory;
import com.demo.hntest.Designpatterns.java.factory.PCFractory;
import com.demo.hntest.Designpatterns.java.factory.ServerFractory;

import org.junit.Test;

public class TestAll {

    @Test
    public  void testFractory() {
        //测试工厂模式
//        Cumputer cf = CumputerFactory.getInstance("PC", "16G", "i7", "1T");
//        Cumputer sf = CumputerFactory.getInstance("Server", "32G", "i9", "2T");
//        System.out.println(cf.getCPU());
//        System.out.println(cf.getHDD());
//        System.out.println(cf.getRAM());
//        System.out.println("ServerCumputer  " + sf);
//        System.out.println("PC Cumputer  " + cf);
        //测试抽象工厂模式
        Cumputer pc = CumputerFactory.getCumputer(new PCFractory("16G", "i7", "1T"));
        System.out.println("个人电脑 "+pc);
        Cumputer server = CumputerFactory.getCumputer(new ServerFractory("32G", "i9", "2T"));
        System.out.println("服务器 "+server);
    }
}
