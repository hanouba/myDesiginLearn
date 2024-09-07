package com.demo.hntest.Designpatterns.java.adapter;

/**
 * 特殊的电源插头
 * 需要适配到现有项目中的 由于接口不匹配 不能直接使用到项目中 需要适配器
 */
public class SpecialPowerOutlet {
    int outSpecialVoltage() {
        return 220;
    }
}
