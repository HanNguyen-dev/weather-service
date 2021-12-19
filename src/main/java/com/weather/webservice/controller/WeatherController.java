package com.weather.webservice.controller;

import com.weather.webservice.service.WeatherService;
import com.weather.webservice.domain.CityForecasts;
import com.weather.webservice.error.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@CrossOrigin("${app.cors}")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    public WeatherController() { }

    @GetMapping("/weather")
    public ResponseEntity<CityForecasts> getForecasts(@RequestParam(value = "city", required = true) String city) {
        CityForecasts cityForecasts = weatherService.getTheWeather(city);
        if (cityForecasts == null || cityForecasts.location.city == null) {
            throw new CityNotFoundException();
        }
        ResponseEntity<CityForecasts> responseCityForecasts = new ResponseEntity<>(cityForecasts, HttpStatus.OK);

        return responseCityForecasts;
    }

}
