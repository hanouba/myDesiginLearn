package com.demo.hntest.Designpatterns.java.factory;

/**
 * 个人电脑
 */
public class PC extends Cumputer {
    private String ram;
    private String cpu;
    private String hdd;

    public PC(String ram, String cpu, String hdd) {
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
