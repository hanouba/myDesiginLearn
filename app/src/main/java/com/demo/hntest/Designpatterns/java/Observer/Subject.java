package com.demo.hntest.Designpatterns.java.Observer;
//目标接口
public interface Subject {
    //注册监听
    void registerObserver(Observer o);
    // 移除监听
    void removeObserver(Observer o);
    //更新观察者
    void notifyObservers();
}
