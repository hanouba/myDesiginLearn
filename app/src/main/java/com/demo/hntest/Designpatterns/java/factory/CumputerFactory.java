package com.demo.hntest.Designpatterns.java.factory;

/**
 * 消费者类，为客户端创建子类提供入口
 */
public class CumputerFactory {
//    public static Cumputer getInstance(String type, String ram, String cpu, String hdd)
//    {
//        if("PC".equalsIgnoreCase(type))
//        {
//            return new PC(ram,cpu,hdd);
//        }
//        else if("Server".equalsIgnoreCase(type))
//        {
//            return new Server(ram,cpu,hdd);
//        }
//        return null;
//    }
    public static Cumputer getCumputer(CumputerAbstractFractory fractory) {
        return fractory.createComputer();
    }
}
