package com.weather.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.weather.webservice.component.WeatherComponent;
import com.weather.webservice.domain.CityForecasts;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherComponent weatherComponent;

    public WeatherService() { }

    public CityForecasts getTheWeather(String city) {
        return weatherComponent.getTheWeather(city);
    }
}
