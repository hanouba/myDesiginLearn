package com.demo.hntest.Designpatterns.java.factory;

import androidx.annotation.NonNull;

/**
 * 工厂模式超类
 */
public abstract class Cumputer {
    public abstract String getRAM();
    public abstract String getCPU();
    public abstract String getHDD();

    @NonNull
    @Override
    public String toString() {
        return "RAM:"+getRAM()+" CPU:"+getCPU()+" HDD:"+getHDD();
    }


}
