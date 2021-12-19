package com.weather.webservice.domain;

import java.util.List;
import java.util.Map;

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
public class CurrentForecast {
    public Double lat;
    public Double lon;
    public String timezone;
    public Integer timezone_offset;
    public CurrentData current;
    public List<Minute> minutely;
    public List<Hour> hourly;
    public List<Day> daily;
    public List<Alert> alerts;

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class CurrentData extends WeatherBase {
        public Map<String, Double> rain;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Minute {
        public Integer dt;
        public Double precipitation;
    }

    @Data
    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class Hour extends WeatherBase {
        public Double wind_gust;
        public Integer pop;
    }

}

