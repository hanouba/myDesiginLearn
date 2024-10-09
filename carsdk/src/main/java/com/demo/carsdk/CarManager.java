package com.demo.carsdk;

public class CarManager {
    private static CarManager instance;

    public static CarManager getInstance() {
        if (instance == null) {
            synchronized (CarManager.class) {
                if (instance == null) {
                    instance = new CarManager();
                }
            }
        }
        return instance;
    }

    public void start() {
        System.out.println("start car");
        System.out.println(Thread.currentThread().getName());
    }
}
