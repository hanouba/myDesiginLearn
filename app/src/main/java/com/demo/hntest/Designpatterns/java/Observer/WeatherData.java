package com.demo.hntest.Designpatterns.java.Observer;

import java.util.List;


//具体目标类
public class WeatherData implements Subject{
//    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
//        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
//        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
//        int i = observers.indexOf(o);
//        if (i>=0){
//            observers.remove(i);
//        }
    }

    @Override
    public void notifyObservers() {
//        for (Observer observer :
//                observers) {
//            observer.update(temperature,humidity,pressure);
//        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
