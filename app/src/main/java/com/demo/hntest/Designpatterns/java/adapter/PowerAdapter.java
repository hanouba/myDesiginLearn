package com.demo.hntest.Designpatterns.java.adapter;

/**
 * 适配器 实现 系统代码中的接口
 * 将不适配的功能 实例化 传入接口
 */
public class PowerAdapter implements PowerOutlet{
    private SpecialPowerOutlet specialPowerOutlet;
    public PowerAdapter(SpecialPowerOutlet specialPowerOutlet)
    {
        this.specialPowerOutlet=specialPowerOutlet;
    }

    @Override
    public int getVoltage() {
        return specialPowerOutlet.outSpecialVoltage();
    }
}
