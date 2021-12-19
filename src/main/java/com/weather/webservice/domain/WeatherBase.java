package com.weather.webservice.domain;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherBase {
    public Integer dt;
    public Integer sunrise;
    public Integer sunset;
    public Double temp;
    public Double feels_like;
    public Integer pressure;
    public Integer humidity;
    public Double dew_point;
    public Double uvi;
    public Integer clouds;
    public Integer visibility;
    public Double wind_speed;
    public Integer wind_deg;
    public List<WeatherDescription> weather;
    public Map<String, Double> rain;
}