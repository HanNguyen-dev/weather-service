package com.weather.webservice.component;

import java.util.ArrayList;
import java.util.List;

import com.weather.webservice.domain.CityForecasts;
import com.weather.webservice.domain.CurrentForecast;
import com.weather.webservice.domain.CurrentObservation;
import com.weather.webservice.domain.CurrentWeather;
import com.weather.webservice.domain.Day;
import com.weather.webservice.domain.Forecast;
import com.weather.webservice.domain.Location;
import com.weather.webservice.domain.CurrentObservation.Astronomy;
import com.weather.webservice.domain.CurrentObservation.Atmosphere;
import com.weather.webservice.domain.CurrentObservation.Condition;
import com.weather.webservice.domain.CurrentObservation.Wind;

import org.springframework.stereotype.Component;

@Component
public class WeatherMapperComponent {
    public CityForecasts parseForecast(CurrentWeather weather, CurrentForecast forecasts) {
        Location location =
            Location.builder()
                    .city(weather.name)
                    .country(weather.sys.country)
                    .build();
        Wind wind =
            Wind.builder()
                .direction(weather.wind.deg)
                .speed(weather.wind.speed.longValue())
                .build();

        Atmosphere atmosphere =
            Atmosphere.builder()
                      .humidity(weather.main.humidity.intValue())
                      .visibility(weather.visibility.doubleValue())
                      .pressure(weather.main.pressure.doubleValue())
                      .build();
        Astronomy astronomy =
            Astronomy.builder()
                     .sunrise(weather.sys.sunrise.toString())
                     .sunset(weather.sys.sunset.toString())
                     .build();
        Condition condition =
            Condition.builder()
                     .text(weather.weather.get(0).description)
                     .temperature(weather.main.temp.intValue())
                     .build();
        CurrentObservation currentObservation = 
            CurrentObservation.builder()
                              .wind(wind)
                              .atmosphere(atmosphere)
                              .astronomy(astronomy)
                              .condition(condition)
                              .build();
        List<Forecast> resultForecasts = new ArrayList();
        for (Day day : forecasts.daily) {
            resultForecasts.add(Forecast.builder()
                                        .day(day.dt.toString())
                                        .low(day.temp.min.intValue())
                                        .high(day.temp.max.intValue())
                                        .text(day.weather.get(0).description)
                                        .build());
        }
        CityForecasts cityForecasts
            = CityForecasts.builder()
                           .location(location)
                           .current_observation(currentObservation)
                           .forecasts(resultForecasts)
                           .build();

        return cityForecasts;
    }
}
