package com.example.myweather;

public class WeatherData {
    private double temp;

    public WeatherData() {
        this.temp = Math.random() * 50;
    }

    public WeatherData(double temp) {
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

}
