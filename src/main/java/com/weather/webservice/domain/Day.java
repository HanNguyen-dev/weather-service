package com.weather.webservice.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    public Integer dt;
    public Integer sunrise;
    public Integer sunset;
    public Integer moonrise;
    public Integer moonset;
    public Double moon_phase;
    public Temp temp;
    public FeelsLike feels_like;
    public Integer pressure;
    public Integer humidity;
    public Double dew_point;
    public Double wind_speed;
    public Integer wind_deg;
    public List<WeatherDescription> weather;
    public Integer clouds;
    public Double pop;
    public Double rain;
    public Double uvi;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class Temp extends FeelsLike {
        public Double min;
        public Double max;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FeelsLike {
        public Double day;
        public Double night;
        public Double eve;
        public Double morn;
    }
}
