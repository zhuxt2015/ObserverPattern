package com.zhuxt.observable;

import com.zhuxt.test.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2015/11/15.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }

    }

    @Override
    public void display() {
        System.out.println("t:" + temperature + " h: " + humidity);
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay cc = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80,70,60);
//        cc.update(weatherData,null);
    }
}
