package com.demo.hntest.Designpatterns.java;

/**
 * 单例模式
 * //线程安全单例
 */
public class SingelPatterns {
    private static SingelPatterns singelPatterns;
    private SingelPatterns(){

    }

    /**
     * 线程安全
     * 同步方法
     * 降低性能
     * 双重检查锁
     * @return
     */
    public static SingelPatterns getInstance(){
        if(singelPatterns==null){
            synchronized (SingelPatterns.class){
                if(singelPatterns==null){
                    singelPatterns=new SingelPatterns();
                }
            }
        }
        return singelPatterns;
    }
}

//Bill Pugh Singleton
class Singleton{
    private Singleton(){

    }
    private static class SingletonHolder{
        private static final Singleton INSTANCE=new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
