package com.demo.hntest.Designpatterns.java.factory;

public class ServerFractory implements CumputerAbstractFractory{
    private String ram;
    private String cpu;
    private String hdd;
    public ServerFractory(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
}
    @Override
    public Cumputer createComputer() {
        return new Server(ram,cpu,hdd);
    }
}
