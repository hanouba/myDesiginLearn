package com.demo.hntest.Designpatterns.java.factory;

public class PCFractory implements CumputerAbstractFractory{
    private String ram;
    private String cpu;
    private String hdd;

    public PCFractory(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }
    @Override
    public Cumputer createComputer() {
        return new PC(ram,cpu,hdd);
    }
}
