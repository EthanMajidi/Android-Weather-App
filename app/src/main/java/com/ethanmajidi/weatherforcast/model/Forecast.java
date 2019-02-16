package com.ethanmajidi.weatherforcast.model;

import java.io.Serializable;

public class Forecast implements Serializable {
    private String city;
    private String country;
    private String region;

    //under condition object
    private String date;
    private String currentTemperature;
    private String CurrentWeatherDescription;

    //under forecast object
    private String forecastDate;
    private String forecastDay;
    private String forecastHighTemp;
    private String forecastLowTemp;
    private String forecastWeatherDescription;

    //description html
    private String descriptionHtml;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getCurrentWeatherDescription() {
        return CurrentWeatherDescription;
    }

    public void setCurrentWeatherDescription(String currentWeatherDescription) {
        CurrentWeatherDescription = currentWeatherDescription;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    public String getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(String forecastDay) {
        this.forecastDay = forecastDay;
    }

    public String getForecastHighTemp() {
        return forecastHighTemp;
    }

    public void setForecastHighTemp(String forecastHighTemp) {
        this.forecastHighTemp = forecastHighTemp;
    }

    public String getForecastLowTemp() {
        return forecastLowTemp;
    }

    public void setForecastLowTemp(String forecastLowTemp) {
        this.forecastLowTemp = forecastLowTemp;
    }

    public String getForecastWeatherDescription() {
        return forecastWeatherDescription;
    }

    public void setForecastWeatherDescription(String forecastWeatherDescription) {
        this.forecastWeatherDescription = forecastWeatherDescription;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }
}
