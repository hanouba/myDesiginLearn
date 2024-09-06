package com.demo.hntest.Designpatterns.java.factory;

public class Server extends Cumputer {
    private String ram;
    private String cpu;
    private String hdd;
    public Server(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }
}
