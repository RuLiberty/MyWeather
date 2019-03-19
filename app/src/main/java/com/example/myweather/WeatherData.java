package com.example.myweather;

import java.io.Serializable;

public final class WeatherData implements Serializable {
    private static WeatherData instance = null;

    private double temp;
    private String typeWeather;
    private String city;
    private boolean isShow = false;

    //default
    private WeatherData(){
        temp = Math.random() * 50;
        typeWeather = "Rain";
    }

    public static synchronized WeatherData getInstance(){
        if (instance == null) {
            return instance = new WeatherData();
        } else return instance;
    }


    public double getTemp() { return temp; }

    public String getType() { return typeWeather; }

    public String getCity() { return city; }

    public boolean getIsShow() { return isShow; }

    public void setCity(String city) { this.city = city; }

    public void setIsShow(boolean isShow) { this.isShow = isShow; }


}
