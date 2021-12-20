package com.weather.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.weather.webservice.component.WeatherComponent;
import com.weather.webservice.component.WeatherMapperComponent;
import com.weather.webservice.component.OpenWeatherComponent;
import com.weather.webservice.domain.CityForecasts;
import com.weather.webservice.domain.CurrentForecast;
import com.weather.webservice.domain.CurrentWeather;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherComponent weatherComponent;

    @Autowired
    private OpenWeatherComponent openWeatherComponent;

    @Autowired
    private WeatherMapperComponent mapper;

    public WeatherService() { }

    // public CityForecasts getTheWeather(String city) {
    //     return weatherComponent.getTheWeather(city);
    // }

    public CityForecasts getTheWeather(String city) {
        CurrentWeather weather = openWeatherComponent.getCurrentWeather(city);
        CurrentForecast forecasts = openWeatherComponent.getForecast(weather.coord.lon, weather.coord.lat);

        return mapper.parseForecast(weather, forecasts);
    }

}
