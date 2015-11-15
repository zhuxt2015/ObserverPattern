package com.zhuxt.test;

/**
 * Created by Administrator on 2015/11/15.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("t:" + temperature + "h:" +  humidity );
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();

    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay cc = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80.1f, 70.2f, 60.3f);
    }
}
