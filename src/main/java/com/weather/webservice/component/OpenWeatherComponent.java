package com.weather.webservice.component;

import com.weather.webservice.domain.CurrentForecast;
import com.weather.webservice.domain.CurrentWeather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherComponent {
    final RestTemplate restTemplate;

    @Value("${app.apiKey}")
    private String apiKey;
    @Value("${app.baseUrl}")
    private String baseUrl;

    private String units = "imperial";

    public OpenWeatherComponent() {
        this.restTemplate = new RestTemplate();
    }

    public CurrentWeather getCurrentWeather(String city) {
        String url = baseUrl + "weather?q=" + city + "&appid=" + apiKey + "&units=" + units;
        CurrentWeather currentWeather = restTemplate.getForEntity(url, CurrentWeather.class).getBody();
        return currentWeather;
    }

    public CurrentForecast getForecast(Double longitude, Double latitude) {
        String url = baseUrl + "onecall?lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey + "&units=" + units;
        CurrentForecast currentForecast = restTemplate.getForEntity(url, CurrentForecast.class).getBody();
        return currentForecast;
    }
}
