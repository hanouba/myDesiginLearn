package com.demo.hntest.Designpatterns.java.factory;

/**
 * 定义工厂类
 */
public class CumputerFactory {
    public static CumFactory getInstance(String type, String ram, String cpu, String hdd)
    {
        if("PC".equalsIgnoreCase(type))
        {
            return new PC(ram,cpu,hdd);
        }
        else if("Server".equalsIgnoreCase(type))
        {
            return new Server(ram,cpu,hdd);
        }
        return null;
    }
}
